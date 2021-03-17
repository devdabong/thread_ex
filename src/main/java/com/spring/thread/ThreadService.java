package com.spring.thread;

import java.util.concurrent.Executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

@Service
public class ThreadService {
	
	private static final Logger log = LoggerFactory.getLogger(ThreadService.class);
	
	@Autowired
	@Qualifier("myexecutor")
	private ThreadPoolTaskExecutor executor;
	
	@Autowired
	@Qualifier("tester")
	private ThreadPoolTaskExecutor tester;
	
	@Autowired
	@Qualifier("threadPoolTaskExecutor")
	private Executor threadPoolTaskExecutor;
	
	@Async
	public void test() {
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				//log.info(Thread.currentThread().getName());
				
				try {
					log.info(Thread.currentThread().getName() + " ������ �۾� ����");
					Thread.sleep(2000);
					log.info(Thread.currentThread().getName() + " ������ �۾� ����!");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		Runnable r2 = new Runnable() {
			
			@Override
			public void run() {
				//log.info(Thread.currentThread().getName());
				
				log.info(Thread.currentThread().getName() + " DO IT");
			}
		};
		
		int max = tester.getMaxPoolSize();
		System.out.println(max);
		
		for (int i = 0; i < 10; i++) {
			System.out.println("hello");
			tester.execute(r);
			System.out.println("hi");
		}
		
		System.out.println("humm");
		tester.execute(r2);
//		Thread t1 = executor.createThread(r);
//		String name = t1.getName();
//		System.out.println(name);
		
		
		
//		for (int i = 0; i < 10; i++) {
//			executor.execute(r);
//		}
		
		//System.out.println(Thread.currentThread().getName());
	}
	
	@Async
	public void test2() {
		
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				long result = 0;
				try {
					long beforeTime = System.currentTimeMillis(); //�ڵ� ���� ���� �ð� �޾ƿ���
					log.info(Thread.currentThread().getName() + " ������ �۾� ����");
					Thread.sleep(2000);
					log.info(Thread.currentThread().getName() + " ������ �۾� ����!");
					long afterTime = System.currentTimeMillis(); //�ڵ� ���� �� �ð� �޾ƿ���
					result += afterTime - beforeTime;
					System.out.println(result/1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		try {
				for (int i = 0; i < 10; i++) {
					threadPoolTaskExecutor.execute(r);
				}
				
				System.out.println(Thread.currentThread().getName());
			} catch (Exception e) {
				// TODO: handle exception
		}
		
		
		
	}
}
