package com.gegesha.countrycodedemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    /**
     * Ensure client-side paths redirect to index.html because client handles routing. NOTE: Do NOT use @EnableWebMvc or it will break this.
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // Map "/"
        registry.addViewController("/")
                .setViewName("forward:/index.html");
        // Map "/word", "/word/word", and "/word/word/word" - except for anything starting with "/api/..." or ending with
        // a file extension like ".js" - to index.html. By doing this, the client receives and routes the url. It also
        // allows client-side URLs to be bookmarked.
        // Single directory level - no need to exclude "api"
        registry.addViewController("/{x:[\\w\\-]+}")
                .setViewName("forward:/index.html");

        registry.addViewController("/{x:[\\w\\-]+}/")
                .setViewName("forward:/index.html");

    }
}