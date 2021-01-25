package com.qsn.common.util;

import com.baomidou.mybatisplus.extension.exceptions.ApiException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * java集合工具类
 *
 * @author qiusn
 * @date 2020-12-21
 */
public class JavaListUtil {

    /**
     * 集合分页
     *
     * @param resourceList 要分页的集合
     * @param currentPage  页码
     * @param pageSize     每页条数
     * @return 分页后的集合
     */
    public static List getPageByList(List resourceList, int currentPage, int pageSize) {
        List pageList;
        if (currentPage < 1) {
            currentPage = 1;
        }
        int size = resourceList.size();
        int pageCount = size / pageSize;
        int fromIndex = (currentPage - 1) * pageSize;
        int toIndex = fromIndex + pageSize;
        if (toIndex >= size) {
            toIndex = size;
        }
        if (currentPage > pageCount + 1) {
            fromIndex = 0;
            toIndex = 0;
        }
        pageList = resourceList.subList(fromIndex, toIndex);

        return pageList;
    }


    /**
     * 将集合按照数量分组
     *
     * @param stringList 待分组的集合
     * @param quantity 分多少组
     * @return
     */
    public static List<List<String>> listByListAndGroupNum(List<String> stringList, int quantity) {
        if(stringList==null || stringList.isEmpty()){
            throw new ApiException("该集合为null/空，不需要再进行分组");
        }
        // 以分组数据
        List<List<String>> wrapList = new ArrayList<>();
        int count = 0;
        while (count < stringList.size()) {
            wrapList.add(stringList.subList(count, (count + quantity) > stringList.size() ? stringList.size() : (count + quantity)));
            count += quantity;
        }
        // 数组分组
        System.out.println(Arrays.toString(wrapList.toArray()));

        return wrapList;
    }
}
