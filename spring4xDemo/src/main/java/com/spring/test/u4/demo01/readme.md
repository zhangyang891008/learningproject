# BeanFactory中Bean的生命周期监测
# 1.Car类
bean实体类
# 2.MainTest主测试类
默认使用DefaultListableBeanFactory。
# 3.MyBeanPostProcessor
在Factory中，注册一个BeanPostProcessor，监测FactoryBean初始化一个Bean对象的过程。
# 4.MyInstantiationAwareBeanPostProcessor
通过继承Adapter，重写安装前，安装后，属性设置时方法。监测Factory初始化一个Bean对象的过程。
