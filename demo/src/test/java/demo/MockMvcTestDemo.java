package demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.XdclassApplication;
/***
 * 简介:讲解MockMvc类的使用和模拟Http请求实战
 * @author zhangjiawen
 *
 */
@RunWith(SpringRunner.class) //底层用junit SpringJUnit4ClassRunner
@SpringBootTest(classes={XdclassApplication.class})//启动整个springboot工程
@AutoConfigureMockMvc 
public class MockMvcTestDemo {
	
	/***
	 * 	perform：执行一个RequestBuilder请求
		andExpect：添加ResultMatcher->MockMvcResultMatchers验证规则
		andReturn：最后返回相应的MvcResult->Response
	 */
	 @Autowired
	 private MockMvc mockMvc;
	 @Test
	 public void apiTest() throws Exception {
		 
		 MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.get("/test/home")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		 int status=mvcResult.getResponse().getStatus();
		 System.out.println(status);
		 
	 }

}
