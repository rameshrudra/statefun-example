package com.product.contacts;

import org.apache.flink.statefun.playground.java.greeter.types.UserLogin;
import org.apache.flink.statefun.sdk.java.StatefulFunctions;
import org.apache.flink.statefun.sdk.java.handler.RequestReplyHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ContactsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactsApplication.class, args);
	}
	
	@Bean
    RequestReplyHandler requestReplyHandler(UserLogin user) {
		
//		StatefulFunctions statefulFunctions = new StatefulFunctions();
//        StatefulFunctionSpec accountSpec = StatefulFunctionSpec.builder(Account.TYPE)
//                .withValueSpec(Account.BALANCE)
//                .withSupplier(() -> account)
//                .build();
//        statefulFunctions.withStatefulFunction(accountSpec);
//        return statefulFunctions.requestReplyHandler();
        
        StatefulFunctions statefulFunctions = new StatefulFunctions();
        statefulFunctions.withStatefulFunction(UserFn.SPEC);
        statefulFunctions.withStatefulFunction(GreetingsFn.SPEC);
        return statefulFunctions.requestReplyHandler();
    }

}
