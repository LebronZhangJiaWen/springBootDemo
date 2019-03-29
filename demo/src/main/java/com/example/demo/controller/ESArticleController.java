package com.example.demo.controller;


import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Article;
import com.example.demo.es.ArticleESRepository;
import com.example.demo.util.JsonData;


@RestController
@RequestMapping("/es")
public class ESArticleController {

	
	
	@Autowired
	private ArticleESRepository articleRepository;
	
	@GetMapping("save")
	public Object save(long id,String title){
	
		Article article = new Article();
		article.setId(id);
		article.setPv(123);
		article.setContent("springboot整合elasticsearch，这个是新版本 2018年录制");
		article.setTitle(title);
		article.setSummary("搜索框架整合");
		
		articleRepository.save(article);
	
		return JsonData.buildSuccess();
	}
	
	
	
	
	@GetMapping("search")
	public Object search(String title){

		//QueryBuilder queryBuilder = QueryBuilders.matchAllQuery(); //搜索全部文档
		QueryBuilder queryBuilder = QueryBuilders.matchQuery("title", title); 

		Iterable<Article> list =  articleRepository.search(queryBuilder);
		
		return JsonData.buildSuccess(list);
	}
	
	
	
	
}
