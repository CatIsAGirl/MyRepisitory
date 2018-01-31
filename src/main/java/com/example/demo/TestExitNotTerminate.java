package com.example.demo;

import java.io.IOException;

/**
 * 系统关闭后执行代码
 * @author Mike
 */
public class TestExitNotTerminate {
	public static void main(String[] args) {
		sysoThread sysoThread = new sysoThread();
		Thread thread = new Thread(sysoThread);
		thread.start();
		Runtime.getRuntime().addShutdownHook(new Thread(){
			public void run(){
				System.out.println("系统关闭完毕");
				System.out.println("可添加关闭资源方法");
			}
		});
		System.out.println("press ENTER to call System.exit() and run the shutdown routine.");  
        try {  
            System.in.read();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        System.exit(0);  
	}
}	
class sysoThread implements Runnable {
	@Override
	public void run() {
		int i=0;
		while (true) {
			System.out.println(i);
			i++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}