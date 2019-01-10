package com.processoitau.country.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.processoitau.country.model.Tweet;

public interface TweetRepository extends MongoRepository<Tweet, Long> {
	
}
