package com.spring.springboard.service;

import com.spring.springboard.domain.Article;
import com.spring.springboard.domain.type.SearchType;
import com.spring.springboard.dto.ArticleDto;
import com.spring.springboard.dto.ArticleUpdateDto;
import com.spring.springboard.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;

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
        Page<ArticleDto> articles = sut.searchArticles(SearchType.TITLE, "search keyword"); //제목, 본문, ID, 닉네임, 해시태그
        //Then
        assertThat(articles).isNotNull();
    }
    @DisplayName("게시글 검색시, 게시글 리스트를 반환")
    @Test
    void givenArticleId_whenSearchingArticle_thenReturnArticle() {
        //Given

        //When
        ArticleDto articles = sut.searchArticle(1L); //제목, 본문, ID, 닉네임, 해시태그
        //Then
        assertThat(articles).isNotNull();
    }


    //게시글 페이지 기능

    @DisplayName("게시글 정보를 입력하면, 게시글을 생성")
    @Test
    void givenArticleInfo_whenSavingArticle_thenSavesArticle() {
        //Given
        given(articleRepository.save(any(Article.class))).willReturn(null);
        //When
        sut.saveArticle(ArticleDto.of(LocalDateTime.now(), "MCK", "title", "content", "#java"));
        //Then
        then(articleRepository).should().save(any(Article.class));

    }

    @DisplayName("게시글의 ID와 수정 정보를 입력하면, 게시글을 수정")
    @Test
    void givenArticleIdAndModifiedInfo_whenUpdatingArticle_thenUpdateArticle() {
        //Given
        given(articleRepository.save(any(Article.class))).willReturn(null);
        //When
        sut.updateArticle(1L, ArticleUpdateDto.of("title", "content", "#java"));
        //Then
        then(articleRepository).should().save(any(Article.class));

    }
    @DisplayName("게시글의 ID를 입력하면, 게시글을 삭제")
    @Test
    void givenArticleId_whenDeletingArticle_thenDeleteArticle() {
        //Given
        willDoNothing().given(articleRepository).delete(any(Article.class));
        //When
        sut.deleteArticle(1L);
        //Then
        then(articleRepository).should().delete(any(Article.class));

    }

}