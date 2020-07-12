package com.hss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class IndexService {

	@Autowired
	private UserService userService;

	public IndexService() {
		System.out.println("init IndexService");
	}

	@PostConstruct
	public void afterIndexService(){
		System.out.println("init");
	}

	public void getService(){
		System.out.println("IndexService -- getService");
	}
}
