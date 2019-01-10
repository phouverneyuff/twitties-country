package com.processoitau.country.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.processoitau.country.model.Country;
import com.processoitau.country.model.Tweet;
import com.processoitau.country.repository.TweetRepository;
import com.processoitau.country.repository.TweetRepositoryCustom;

/**
 * TwitterSearchController
 */
@RestController
public class TwitterCountryController {

    private final TweetRepositoryCustom repositoryCustom;
    private final TweetRepository repository;

    @Inject
    public TwitterCountryController(TweetRepositoryCustom repositoryCustom, TweetRepository repository) {
        this.repositoryCustom = repositoryCustom;
        this.repository = repository;
    }

    @RequestMapping("/twitter/country")
    public List<Country> listByTag() {
        List<Country> tweeties = repositoryCustom.getCountryLanguageCount();
        
        return tweeties;
    }
    
    @RequestMapping("/twitter/tag")
    public List<Tweet> listAll() {
    	List<Tweet> tweeties = repository.findAll();
        
        return tweeties;
    }

}