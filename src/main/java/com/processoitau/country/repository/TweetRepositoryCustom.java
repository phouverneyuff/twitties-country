package com.processoitau.country.repository;

//imports as static
import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import com.processoitau.country.model.Country;
import com.processoitau.country.model.Tweet;

@Repository
public class TweetRepositoryCustom {

	@Autowired
	MongoTemplate mongoTemplate;
	
	public List<Country> getCountryLanguageCount() {
	
		Aggregation agg = newAggregation(
			group("languageCode").count().as("total"),
			project("total").and("languageCode").previousOperation(),
			sort(Sort.Direction.DESC, "total")
				
		);

		//Convert the aggregation result into a List
		AggregationResults<Country> groupResults 
			= mongoTemplate.aggregate(agg, Tweet.class, Country.class);
		List<Country> result = groupResults.getMappedResults();
		
		return result;
		
	}
	
}
