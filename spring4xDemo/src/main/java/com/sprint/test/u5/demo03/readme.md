# 自动注解功能测试
# 1.Boss类
@Autowired自动注入一个Cup对象
# 2.MainTest主测试类
启动类
# 3.CupConfig
通过@Configuration成为配置类，提供的Bean通过@Bean注解实现
# 4.Cup
没有注解，是通过CupConfig注入到Boss中的。 