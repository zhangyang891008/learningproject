package com.spring.test.u5.demo04;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class UserServiceFactoryBean implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory bf) throws BeansException {
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) bf;

        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserService.class);
        beanDefinitionBuilder.addPropertyReference("userDao","userDao");
        beanFactory.registerBeanDefinition("userService1",beanDefinitionBuilder.getRawBeanDefinition());
        beanFactory.registerSingleton("userService2",new UserService());
    }
}
