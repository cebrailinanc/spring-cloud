package com.cbrl.spring.cloud.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;
import java.util.Locale;

@Configuration
public class MessageSourceConfig {

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasenames("i18n/messages/api-error-message",
                "i18n/messages/api-fail-message");
        source.setUseCodeAsDefaultMessage(true);
        return source;
    }

    @Bean
    public LocaleResolver localeResolver() {
        FixedLocaleResolver flr = new FixedLocaleResolver();
        flr.setDefaultLocale(Locale.ENGLISH);
        return flr;
    }
}
