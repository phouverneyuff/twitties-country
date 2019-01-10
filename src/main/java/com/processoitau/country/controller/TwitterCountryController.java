package com.processoitau.country.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.social.twitter.api.Twitter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.processoitau.country.model.Tweet;
import com.processoitau.country.repository.TweetRepository;

/**
 * TwitterSearchController
 */
@RestController
public class TwitterCountryController {

    private final TweetRepository repository;

    @Inject
    public TwitterCountryController(Twitter twitter, TweetRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/twitter/country")
    public List<Tweet> listByTag() {
        List<Tweet> tweeties = repository.findAll();
        
        return tweeties;
    }

}