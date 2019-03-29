package com.example.demo.es;



import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import com.example.demo.bean.Article;


@Component 
//@Repository
public interface ArticleESRepository extends ElasticsearchRepository<Article, Long> {

	
}
