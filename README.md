**题目：**<br/>
    这个项目架构由自己搭建<br/>
    使用架构为主流的Spring Cloud Alibaba<br/>
    主要用于尝试新技术并进行整合测试，最终用于实践<br/>

**环境:**
    <br/> jdk 1.8
    <br/> maven 3.6.3
    

**工具:**
&nbsp;&nbsp;<br/> idea 2020.3
&nbsp;&nbsp;<br/> git
&nbsp;&nbsp;<br/> postman
&nbsp;&nbsp;<br/> navicat15
&nbsp;&nbsp;<br/> xshell
&nbsp;&nbsp;<br/> mobaxterm
&nbsp;&nbsp;<br/> redis-desktop-manager
&nbsp;&nbsp;<br/> sublime-test
    
**框架：**
    <br/> springcloud 
    <br/> nacos
    <br/> feign
    <br/> mysql 8.0
    <br/> mybatis-plus(代码生成器待实现)
    <br/> gateway
    <br/> redis(单机，待完善集群)
    <br/> rocketMQ（单机，待完善集群）
    <br/> seata(待分布式测试)
    <br/> zookeeper(待完成)
    
**技术：**
    <br/> 多线程-线程池（这里需要做成统一管理的工具类）
    <br/> 代码生成器
    <br/> fastjson
    <br/> lombok
    <br/> ali-durid(连接池滚阿联)
    <br/> commons-lang(StringUtils工具)
    <br/> aop
    <br/> pagehelper
    <br/> mvn插件(打包,压缩等)
    
**工具类:**
    <br/> hutool(包含md5、验证码图片生成等)
    <br/> 获取日期工具类
    <br/> 手机号检验类
    <br/> 地区经纬度工具类
    <br/> 数字工具类(统一生成不重复的数字, 可用于订单编号、第二主键等)
    <br/> 加密工具 Aes、md5
    <br/> 上传工具(阿里上传等)
    
**用于测试模块：**
    <br/> 代码生成器模块
    <br/> 会员模块（用于测用户订单并发等）
    <br/> 订单模块（用于测事务等）
    <br/> 系统模块（优化管理员管理、优化权限系统、优化菜单管理）
    <br/> 地区（标准化省市区数据，用于地区管理）
    
    
