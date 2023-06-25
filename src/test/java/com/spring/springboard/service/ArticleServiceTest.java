package com.spring.springboard.service;

import com.spring.springboard.domain.Article;
import com.spring.springboard.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("비즈니스 로직 - 게시글")
@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {

    @InjectMocks private ArticleService sut;
    @Mock private ArticleRepository articleRepository;

    //테스트 기능 검색,각 게시글 페이지로 이동,페이지네이션, 홈 버튼 -> 게시판 페이지로 리다이렉트, 정렬기능
    @DisplayName("게시글 검색시, 게시글 리스트를 반환")
    @Test
    void givenSearchParameter_whenSearchingArticles_thenReturnArticleList() {
        //Given

        //When
        List<ArticleDTO> articles = sut.searchArticles(SearchType.TITLE, "search keyword"); //제목, 본문, ID, 닉네임, 해시태그
        //Then
        assertThat(articles).isNotNull();
    }

}