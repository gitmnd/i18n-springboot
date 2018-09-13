package com.i18n.i18nspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;
//For more info : https://www.logicbig.com/tutorials/spring-framework/spring-web-mvc/session-locale-resolver.html
@SpringBootApplication
public class I18nSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(I18nSpringbootApplication.class, args);
	}

	/* Use this below in conjunction with getIndexPage(),If you want to pass Accept-Language=fr in every request.
    SessionLocaleResolver internally populates a custom Locale instance in HttpSession.
    There might be many different scenarios where a Locale instance should be populated in user session. In this tutorial we are going to demonstrate following flow:

        #A user selects a desired language from a dropdown component on the client site.
        #On the server site, a corresponding Locale is constructed and populated in session using SessionLocaleResolver.
        #From that point on the Locale is retrieved from HTTPSession for further interaction till the end of the session.


        @Bean
        public LocaleResolver localeResolver() {
            SessionLocaleResolver localeResolver = new SessionLocaleResolver();
            localeResolver.setDefaultLocale(Locale.US);
            return localeResolver;
        }
    */



	/*
	The LocaleResolver interface has implementations that determine the current locale based on the
	session, cookies, the Accept-Language header, or a fixed value.

	The default implementation is AcceptHeaderLocaleResolver, simply using the request's locale provided by the respective HTTP header.
	* */
    @Bean
    public LocaleResolver localeResolver() {
        AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
        localeResolver.setDefaultLocale(Locale.US);
        return localeResolver;
    }


}
