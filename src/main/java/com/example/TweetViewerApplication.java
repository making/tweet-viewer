package com.example;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TweetViewerApplication {
	private final List<Tweet> tweets = new CopyOnWriteArrayList<>();

	@GetMapping
	public List<Tweet> viewTweets() {
		return this.tweets;
	}

	@Bean
	public Consumer<Tweet> tweetCollector() {
		return this.tweets::add;
	}

	public static void main(String[] args) {
		SpringApplication.run(TweetViewerApplication.class, args);
	}

	record Tweet(String text) {
	}
}
