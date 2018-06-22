package com.xyy.rpc.service.impl;

import com.xyy.rpc.service.HelloService;

public class HelloServiceImpl implements HelloService {

	@Override
	public String sayHello(String name) {
		 
		return "hello " + name;
	}

}
