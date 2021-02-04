**题目：**<br/>
    这个项目架构由自己搭建<br/>
    使用架构为主流的Spring Cloud Alibaba<br/>
    主要用于尝试新技术并进行整合测试，最终用于实践<br/>

**环境:**
    <br/>jdk 1.8
    <br/>maven 3.6.3
    

**工具:**
    <br/>idea 2020.3
    <br/>git
    <br/>postman
    <br/>navicat15
    <br/>xshell
    <br/>mobaxterm
    <br/>redis-desktop-manager
    <br/>sublime-test
    
**框架：**
    <br/>springcloud 
    <br/>nacos
    <br/>feign
    <br/>mysql 8.0
    <br/>mybatis-plus(代码生成器待实现)
    <br/>gateway
    <br/>redis(单机，待完善集群)
    <br/>rocketMQ（单机，待完善集群）
    <br/>seata(待分布式测试)
    <br/>zookeeper(待完成)
    
**技术：**
    多线程-线程池（这里需要做成统一管理的工具类）
    代码生成器
    fastjson
    lombok
    ali-durid(连接池滚阿联)
    commons-lang(StringUtils工具)
    aop
    pagehelper
    mvn插件(打包,压缩等)
    
**工具类:**
    hutool(包含md5、验证码图片生成等)
    获取日期工具类
    手机号检验类
    地区经纬度工具类
    数字工具类(统一生成不重复的数字, 可用于订单编号、第二主键等)
    加密工具 Aes、md5
    上传工具(阿里上传等)
    
**用于测试模块：**
    代码生成器模块
    会员模块（用于测用户订单并发等）
    订单模块（用于测事务等）
    系统模块（优化管理员管理、优化权限系统、优化菜单管理）
    地区（标准化省市区数据，用于地区管理）
    
    
