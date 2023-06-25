package com.spring.springboard.repository;

import com.spring.springboard.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ArticleRepository extends
        JpaRepository<Article, Long>,
        QuerydslPredicateExecutor<Article>
//      QuerydslPredicateExecutor<Article>,로 인해 해당 되는 Article Entity에 대한 기본적인 검색기능은 끝남
//        QuerydslBinderCustomizer<QArticle>
{

}