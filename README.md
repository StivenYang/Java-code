# Java-面试

## top.hengshare.interviewer.basic java基础

## spring spring、spring组件源码分析

## database 数据库

动态的切换数据源，你会怎么切？读写分离？


## struts 数据结构

## thread 多线程、并发
有关多线程的一些小例子，在《Java编程思想》中可以找到源代码

## io io操作

## socket 网络编程

## jvm java虚拟机

## algorithm 算法

## mybatis 数据持久层框架

## nginx 代理服务器

## redis 分布式redis缓存

1. redis有几种集群模式？搭建过没有？
    - 主从复制：
        - 重点：
            - 主数据库可以进行读写操作，当读写操作导致数据变化时，会自动将数据同步给从数据库
            - 从数据库一般是只读的，并且接收主数据库传送过来的数据
            - 一个master可以拥有多个slave，但是一个slave只能对应一个master
        - 机制：
            - 当slave启动后，主动向master发送SYNC命令。master接收到SYNC命令后，在后台保存快照(RDB持久化)并缓存保存快照这段时间的命令，然后将保存的快照文件和缓存的命令发送给slave。slave接收到快照文件和命令后，加载快照文件和缓存的执行命令。
            复制初始化后，master会在每次接收到写数据的指令后都会同步写命令到slave，保证主从数据的一致性。
    - 哨兵：
        - 重点：
            - 监控主从数据库是否正常运行
            - master出现故障时，自动将slave转换到master
            - 多哨兵配置的时候，哨兵之间也会自动监控
            - 多个哨兵可以监控同一个redis
        - 
redis你只是用来做缓存吗？
对池的一些锁什么的有没有接触过？
用jpa存一百万条数据怎么做？
用POI怎么生成有100w条数据的excel？
一个数据库表有100w条数据，考虑到性能，你该怎么查？
bio和nio怎么区别？
springmvc拦截器你是怎么做的？
spring源码读过吗？讲一讲
jpa的源码看过吗？讲一讲
你有使用过mq（消息队列）吗？讲一讲怎么使用？
你做过weblogic的部署吗？讲一讲
分布式锁有没有什么接触？
你是使用什么来查看数据库sql执行信息的？

## activemq 消息队列

## kafka 消息队列

## elastic-sreach 基于lucene检索引擎

## netty 异步的、事件驱动的开源框架

netty用在哪些业务场景？是怎么使用的？解决了什么问题？
你是怎么保持长连的？有做压测吗？
如果让你做性能调测，你会从哪几个点来进行调测？

## memcached 缓存数据库

## pattern 设计模式

## dubbo 分布式框架

## springcloud 分布式框架

服务降解怎么实现？
网关层想要实现身份认证，你会怎么设计？

## java8 java8新特性
