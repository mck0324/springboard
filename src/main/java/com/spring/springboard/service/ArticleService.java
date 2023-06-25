package com.spring.springboard.service;

import com.spring.springboard.domain.type.SearchType;
import com.spring.springboard.dto.ArticleDto;
import com.spring.springboard.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
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
    public List<ArticleDto> searchArticles(SearchType searchType, String searchKeyword) {
        return List.of();
    }
}
