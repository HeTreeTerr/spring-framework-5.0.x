package com.hss.test;

import com.hss.app.Appconfig;
import com.hss.service.IndexService;
import com.hss.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	@org.junit.Test
	public void beanTest(){
		//初始化spring容器
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Appconfig.class);
		/*
		//设置spring 不支持循环依赖
		ac.setAllowCircularReferences(false);
		//刷新容器，使配置生效
		ac.refresh();
		*/
		IndexService indexService = ac.getBean(IndexService.class);
//		UserService userService = ac.getBean(UserService.class);
		indexService.getService();
	}
}
