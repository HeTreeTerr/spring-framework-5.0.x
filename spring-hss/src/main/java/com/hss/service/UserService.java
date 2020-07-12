package com.hss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class UserService {

	@Autowired
	private IndexService indexService;

	public UserService() {
		System.out.println("init UserService");
	}

	@PostConstruct
	public void afterUserService(){
		System.out.println("init");
	}

	public void getService(){
		System.out.println("UserService -- getService");
	}
}
