package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.model.TransactionService;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan(basePackages = {"com"})

public class Ex01TransactionApplication {
	
	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext cac =  SpringApplication.run(Ex01TransactionApplication.class, args);
		
//		MyService myService = cac.getBean("myService", MyService.class);
//		myService.doService(100, 20000);
		
		TransactionService transactionService = cac.getBean("tss", TransactionService.class);
		transactionService.moneyTransfer(100,1010,100);
	}
}

//public class SpringTransactioinApplication {
//	@Autowired
//	MyService myService;
//	public static void main(String[] args) throws Exception {
//		ConfigurableApplicationContext cac =  SpringApplication.run(SpringTransactioinApplication.class, args);
//		
////		MyService myService = cac.getBean("myService", MyService.class);
//
//		SpringTransactioinApplication sta = new SpringTransactioinApplication();
//		sta.doFun();
//		
//	}
//	
//	void doFun() {
//		if (myService == null) {
//			System.out.println("Object is null");
//			return;
//		}
//		
//		myService.doService(100, 20000);
//	}
//
//}