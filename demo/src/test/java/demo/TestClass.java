package demo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.XdclassApplication;

import junit.framework.TestCase;

@RunWith(SpringRunner.class) //底层用junit SpringJUnit4ClassRunner
@SpringBootTest(classes={XdclassApplication.class})//启动整个springboot工程@RunWith(SpringRunner.class) //底层用junit SpringJUnit4ClassRunner
public class TestClass {

	
	@Test
	public void test1() {
		
		System.out.println("hello---------");
		TestCase.assertEquals(1, 1);//断言
		System.out.println("success----------");
		
	}
	@Before
	public void before() {
		System.out.println("before--------");
	}
	@After
	public void after() {
		System.out.println("after--------");
	}
}
