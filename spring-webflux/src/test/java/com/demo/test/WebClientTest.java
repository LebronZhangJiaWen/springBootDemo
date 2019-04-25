package com.demo.test;

import java.util.Iterator;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import com.demo.bean.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//@RunWith(SpringRunner.class)  //底层用junit  SpringJUnit4ClassRunner
//@SpringBootTest(classes={XdclassApplication.class})//启动整个springboot工程
public class WebClientTest {

	

	@Test
	public void testBase(){
		
		Mono<String> bodyMono = WebClient.create().get()
		.uri("http://localhost:8083/api/v1/user/find?id=1")
		.accept(MediaType.APPLICATION_JSON)
		.retrieve().bodyToMono(String.class);
		
		System.out.println(bodyMono.block());
		
	}
	

	@Test
	public void testBase2(){
		
		Mono<String> bodyMono = WebClient.create().get()
		.uri("http://localhost:8083/api/v1/user/find?id={id}",2)
		.accept(MediaType.APPLICATION_JSON)
		.retrieve().bodyToMono(String.class);
		
		System.out.println(bodyMono.block());
		
	}
	
	
	@Test
	public void testBase3(){
		
		Flux<User> bodyMono = WebClient.create().get()
				.uri("http://localhost:8083/api/v1/user/list")
				.accept(MediaType.APPLICATION_JSON)
				.retrieve().bodyToFlux(User.class);
				
				System.out.println(bodyMono);
		
	}
	
    @Test
    public void webClientTest2() throws InterruptedException {
        WebClient webClient = WebClient.builder().baseUrl("http://localhost:8083").build(); // 1
        webClient
                 .get().uri("/api/v1/user/list2")
                .accept(MediaType.APPLICATION_STREAM_JSON) 
                .exchange() 
                .flatMapMany(response -> response.bodyToFlux(User.class))  
                .doOnNext(System.out::println)  
                .blockLast();   
    }
	
}
