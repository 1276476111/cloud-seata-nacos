# 概述
<br/>&nbsp;&nbsp; 这个项目架构由自己搭建
<br/>&nbsp;&nbsp; 使用架构为主流的Spring Cloud Alibaba
<br/>&nbsp;&nbsp; 主要用于尝试新技术并进行整合测试，最终用于实践

## 环境
<br/>&nbsp;&nbsp; jdk 1.8
<br/>&nbsp;&nbsp; maven 3.6.3
    

## 工具
<br/>&nbsp;&nbsp; idea 2020.3
<br/>&nbsp;&nbsp; git
<br/>&nbsp;&nbsp; postman
<br/>&nbsp;&nbsp; navicat15
<br/>&nbsp;&nbsp; xshell
<br/>&nbsp;&nbsp; mobaXterm
<br/>&nbsp;&nbsp; mobaxterm
<br/>&nbsp;&nbsp; redis-desktop-manager
<br/>&nbsp;&nbsp; sublime-test
    
## 框架
<br/>&nbsp;&nbsp; springcloud 
<br/>&nbsp;&nbsp; nacos
<br/>&nbsp;&nbsp; feign
<br/>&nbsp;&nbsp; mysql 8.0
<br/>&nbsp;&nbsp; mybatis-plus(代码生成器待实现)
<br/>&nbsp;&nbsp; gateway
<br/>&nbsp;&nbsp; redis(单机，待完善集群)
<br/>&nbsp;&nbsp; rocketMQ（单机，待完善集群）
<br/>&nbsp;&nbsp; seata(待分布式测试)
<br/>&nbsp;&nbsp; xxl-job(待完成)
<br/>&nbsp;&nbsp; zookeeper(待完成)
    
## 技术
<br/>&nbsp;&nbsp; 多线程-线程池（这里需要做成统一管理的工具类）
<br/>&nbsp;&nbsp; 代码生成器
<br/>&nbsp;&nbsp; fastjson
<br/>&nbsp;&nbsp; lombok
<br/>&nbsp;&nbsp; ali-durid     (阿里连接池)
<br/>&nbsp;&nbsp; commons-lang  (StringUtils工具)
<br/>&nbsp;&nbsp; aop           (切面)
<br/>&nbsp;&nbsp; pagehelper    (分页)
<br/>&nbsp;&nbsp; mvn插件       (打包,压缩等)
    
## 工具类
<br/>&nbsp;&nbsp; hutool(包含md5、验证码图片生成等)
<br/>&nbsp;&nbsp; 获取日期工具类
<br/>&nbsp;&nbsp; 手机号检验类
<br/>&nbsp;&nbsp; 地区经纬度工具类
<br/>&nbsp;&nbsp; 数字工具类(统一生成不重复的数字, 可用于订单编号、第二主键等)
<br/>&nbsp;&nbsp; 加密工具 Aes、md5
<br/>&nbsp;&nbsp; 上传工具(阿里上传等)

## 用于开发的模块
### 首页
- 统计数：用户总量、各类型订单总量
- 浏览页面趋势图、离开页面趋势图
- 支付订单趋势图、退款订单趋势图
- 好评订单趋势图、差评订单趋势图

### 系统管理
- 管理员
- 权限
- 菜单

### 会员管理
- 会员信息
- 收藏记录
- 历史浏览记录

### 商品管理
- 商品信息
- 标签分类

### 订单管理
- 预支付订单
- 正式订单

### 字典管理
- 通用地区

### 财务管理
- 支付流水
- 退款流水

### 日志管理
- 操作日志
- 异常日志

### 客服管理
- 留言板

### 工单管理
- 申请退款
- 审核退款


## 用于测试模块
<br/>&nbsp;&nbsp; 代码生成器模块
<br/>&nbsp;&nbsp; 会员模块（用于测用户订单并发等）
<br/>&nbsp;&nbsp; 订单模块（用于测事务等）
<br/>&nbsp;&nbsp; 系统模块（优化管理员管理、优化权限系统、优化菜单管理）
<br/>&nbsp;&nbsp; 地区（标准化省市区数据，用于地区管理）
    

