package com.spring.springboard.service;

import com.spring.springboard.domain.type.SearchType;
import com.spring.springboard.dto.ArticleDto;
import com.spring.springboard.dto.ArticleUpdateDto;
import com.spring.springboard.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    @Transactional(readOnly = true)
    public Page<ArticleDto> searchArticles(SearchType searchType, String searchKeyword) {
        return Page.empty();
    }

    @Transactional(readOnly = true)
    public ArticleDto searchArticle(long l) {
        return null;
    }

    public void saveArticle(ArticleDto dto) {

    }
    public void updateArticle(long articleId,ArticleUpdateDto dto) {

    }

    public void deleteArticle(long articleId) {
    }
}
