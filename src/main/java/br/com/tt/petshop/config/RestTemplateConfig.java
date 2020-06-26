package br.com.tt.petshop.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate criaRestTemplate(){
        return new RestTemplateBuilder().build();
    }

//    //O RestTemplateBuilder já é um SpringBean!!!!!
//    private final RestTemplateBuilder builder;
//
//    public RestTemplateConfig(RestTemplateBuilder builder) {
//        this.builder = builder;
//    }
//
//    @Bean
//    public RestTemplate criaRestTemplate(){
//        return builder.build();
//    }

}
