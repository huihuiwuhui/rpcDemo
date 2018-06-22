package com.xyy.rpc.client;

import java.lang.reflect.Proxy;
import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.xyy.rpc.service.HelloService;

public class RpcClient {
	 
		  
	    public static void main(String args[]){  
	        HelloService helloService = getClient(HelloService.class, "127.0.0.1", 50001);  
	        System.out.println(helloService.sayHello("liyao1"));  
	    }  
	      
	    @SuppressWarnings("unchecked")  
	    public static <T> T getClient(Class<T> clazz, String ip, int port){  
	        return  (T) Proxy.newProxyInstance(RpcClient.class.getClassLoader(), new Class<?>[]{clazz}, new InvocationHandler() {  
	              
	            @Override  
	            public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {  
	                Socket socket = new Socket(ip, port);  
	                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());  
	                out.writeUTF(arg1.getName());  
	                out.writeObject(arg1.getParameterTypes());  
	                out.writeObject(arg2);  
	                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());  
	                return in.readObject();  
	            }  
	        });  
	    }  
	}  
