# RabbitMQ + SpringBoot
### Receiver
创建消息订阅，任何基于消息的应用程序都需要创建一个消息订阅来响应消息的发布
### Application
queue()方法创建一个AMQP队列，exchange()方法创建了exchange，binding()方法把
他们两个绑定在一起了，并且定义RabbitTemplate发布给exchange时发生动作
### 启动过程
启动应用main()方法通过创建Spring应用环境来启动进程。这个进程启动了消息监听
容器，会开始监听消息。Runner bean会自动执行:从上下文检索RabbitTemplate并且
往"spring-boot"队列中发送一个Hello from RabbitMQ!的消息，
最后，它关闭Spring应用程序，程序结束。