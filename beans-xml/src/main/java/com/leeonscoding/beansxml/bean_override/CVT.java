package com.leeonscoding.beansxml.bean_override;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CVT {
    @Bean
    public Engine engine() {
        return new Engine("CVT");
    }
}
