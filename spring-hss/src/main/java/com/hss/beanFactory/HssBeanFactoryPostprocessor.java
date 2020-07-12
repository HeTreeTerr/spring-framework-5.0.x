package com.hss.beanFactory;

import com.hss.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

//BeanFactory自定义扩展
@Component
public class HssBeanFactoryPostprocessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//		GenericBeanDefinition indexService = (GenericBeanDefinition)beanFactory.getBeanDefinition("indexService");
//		indexService.setBeanClass(UserService.class);
	}
}
