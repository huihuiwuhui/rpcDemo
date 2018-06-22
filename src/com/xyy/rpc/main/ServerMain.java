package com.xyy.rpc.main;

import com.xyy.rpc.server.RpcServer;
import com.xyy.rpc.service.HelloService;
import com.xyy.rpc.service.impl.HelloServiceImpl;

public class ServerMain {
	
	public static void main(String[] args) {
		 HelloService helloService = new HelloServiceImpl();  
         RpcServer server = new RpcServer();  
	     server.register(helloService, 50001);  	
	}
    
}
