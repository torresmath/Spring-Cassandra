package com.torresmath.springcassandra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@SpringBootApplication
@EnableCassandraRepositories
public class SpringCassandraApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCassandraApplication.class, args);
	}

}
