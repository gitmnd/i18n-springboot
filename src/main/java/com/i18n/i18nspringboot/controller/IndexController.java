package com.i18n.i18nspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class IndexController {

    @Autowired
    private MessageSource messageSource;

    ////////////////////////////////////////////////////////////Option 1 ///////////////////////////////////////////////////////////

    /**
     * i18n by passing Accept-Language =  fr in every request. To use this localeResolver() with sessionLocalResolver code piece

        @RequestMapping(value="/index",method= RequestMethod.GET)
        public String getIndexPage(@RequestHeader(name="Accept-Language",required = false) Locale locale){
            return messageSource.getMessage("good.morning.message",null,locale);
        }
     */

    ////////////////////////////////////////////////////////////Option 2 ///////////////////////////////////////////////////////////

    /*
    Without passing locale from request header everytime.
    If you don't pass any Accept-Language as header, the default locale will be picked.
    * */
    @RequestMapping(value="/index2",method= RequestMethod.GET)
    public String getIndexPage2(){
        return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
    }
}
