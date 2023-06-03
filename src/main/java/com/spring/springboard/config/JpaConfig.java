package com.spring.springboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@EnableJpaAuditing
@Configuration
public class JpaConfig {

    @Bean
    public AuditorAware<String> auditorAware() {
        return () -> Optional.of("mck"); //TODO: 스프링 시큐리티로 인증 기능을 붙이게 될 때, 수정하자 지금은 인증기능이 없기에 생성자에 mck만 넣어줌
    }
}
