package com.qsn.common;

import com.qsn.common.util.JavaListUtil;
import com.qsn.common.util.ThreadPoolUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;


/**
 * 测试新添加的工具类
 *
 * @author qiusn
 * @date 2020-01-19
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
class ThreadPoolTests {


    public static void main(String[] args) {
        System.out.println("--------------------------------优雅的分割线--------------------------------");
        System.currentTimeMillis();
    }

    @Test
    void ThreadPoolTest() throws Exception {
        log.info("组装的入参");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(String.valueOf(i));
        }
        List<List<String>> result = JavaListUtil.listByListAndGroupNum(list, 200);
        log.info("执行线程池测试");
        testCachedThreadSubmit(result);
    }

    /**
     * 缓存线程池--Submit
     *
     * @param result
     */
    public void testCachedThreadSubmit(List<List<String>> result) throws Exception {
        System.out.println("-------------------调用开始-------------------");
        long startTime = System.currentTimeMillis();
        // 外面是异步的（只要创建了线程， 那么就把他看作是是一个单独的程序， 他的进度就与此时的方法或者接口无关了）
        ExecutorService ex = ThreadPoolUtils.getThreadPool();
        // 收集结果
        List<Future<List<String>>> futureList = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            List<String> strList = result.get(i);
//            // 单线程处理（ 由于设置阻塞线程， 时常>5秒）
//            new CallableSubmitTest(strList).call();
            // 使用线程池， 耗时>1秒，<5秒
            Future<List<String>> future = ex.submit(new CallableSubmitTest(strList));
            futureList.add(future);
            log.info("到这里其实代码已经执行完了， 但是其他五个线程还在执行。");
            log.info("之所以把线程放在下面执行。 是因为线程都是异步的。 而 future 是获取所有结果的。 想让五个线程都执行完才执行的话， 只能把计算时间的放在 future 的下面");
        }


        System.out.println("--------------------结果开始-----------------------");
        // 处理结果
        for (Future<List<String>> future : futureList) {
            List<String> strList = future.get();
            System.out.println("处理的结果:【" + Arrays.toString(strList.toArray()) + "】");
        }
        System.out.println("--------------------结果结束-----------------------");


        long endTime = System.currentTimeMillis();
        System.out.println("-------------------调用结束-------------------, 耗时为:" + String.valueOf(endTime - startTime));

    }

    public static class CallableSubmitTest implements Callable<List<String>> {
        Integer i;
        List<String> strList;

        public CallableSubmitTest(Integer i) {
            super();
            this.i = i;
        }

        public CallableSubmitTest(List<String> strList) {
            super();
            System.out.println("--------------------组开始--------------------");

            for (String str : strList) {
                System.out.println(str);
            }
            this.strList = strList;
            System.out.println("--------------------组结束--------------------");
        }

        @Override
        public List<String> call() throws Exception {
            // 模拟线程阻塞， 五组如果是并行的, 一定小于等于5秒, 大于1秒
            Thread.sleep(1000);
            System.out.println("callable线程调用, 模拟线程阻塞,  五组如果是并行的, 一定小于等于5秒【" + Arrays.toString(strList.toArray()) + "】");
            return strList;
        }
    }


}
