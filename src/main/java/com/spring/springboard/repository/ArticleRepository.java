package com.spring.springboard.repository;

import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.SimpleExpression;
import com.querydsl.core.types.dsl.StringExpression;
import com.spring.springboard.domain.Article;
import com.spring.springboard.domain.QArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ArticleRepository extends
        JpaRepository<Article, Long>,
        QuerydslPredicateExecutor<Article>,
//      QuerydslPredicateExecutor<Article>,로 인해 해당 되는 Article Entity에 대한 기본적인 검색기능은 끝남
        QuerydslBinderCustomizer<QArticle>
//    QuerydslPredicateExecutor로 기본 검색 기능이 되는데 더 상세적인 검색 기능을 위해 추가해주는거임
{
    @Override
    default void customize(QuerydslBindings bindings, QArticle root) {
        bindings.excludeUnlistedProperties(true);
        bindings.including(root.title, root.content ,root.hashtag, root.createdAt, root.createdBy);
        bindings.bind(root.title).first((StringExpression::containsIgnoreCase)); //쿼리 like '%s{v}%'
        bindings.bind(root.content).first((StringExpression::containsIgnoreCase)); //쿼리 like '%s{v}%'
//        bindings.bind(root.title).first((StringExpression::likeIgnoreCase)); //쿼리 생성문이 다름 like '${v}'
        bindings.bind(root.hashtag).first((StringExpression::containsIgnoreCase)); //쿼리 like '%s{v}%'
        bindings.bind(root.createdAt).first((DateTimeExpression::eq));
        bindings.bind(root.createdBy).first((StringExpression::containsIgnoreCase));

    }
}