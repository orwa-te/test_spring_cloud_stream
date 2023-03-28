package com.example.loggingconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootApplication
public class LoggingConsumerApplication {

    private static int counter = 1;

	public static void main(String[] args) {
		SpringApplication.run(LoggingConsumerApplication.class, args);
	}

	@Bean
	public Consumer<String> log() {
		return person -> {
			System.out.println("Received: " + person);
		};
	}


    @Bean
    public Function<String,String> process(){
        return (value -> {
            System.out.println("processing value-> ");

            return value;
        });

    }


    @Bean
    public Supplier<String> supply(){
        return () ->{
            var c = counter++;
            System.out.println("supplying ...-> "+c);
            Person person = new Person("person_name",System.currentTimeMillis());
            return "person-> c";
        };
    }

}
