# 自动注解功能测试
# 1.Boss类
自动注入bike和cup(通过CupFactory工厂方法注入)
# 2.MainTest主测试类
只有Application才支持自动注入！
# 3.CupFactory
实现了FactoryBean的三个接口方法
# 4.Cup
没有注解，是通过CupFactory注入到Boss中的。 
# 5.Bike
通过Autowired注解注入，默认byType