package com.finalProject;

import com.finalProject.dto.PostNewUser;
import com.finalProject.entity.Movie;
import com.finalProject.repository.CustomerRepository;
import com.finalProject.repository.MovieRepository;
import com.finalProject.service.UserCredentialService;
import com.finalProject.service.UserCredentialServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@Slf4j
public class FullStackBackEndApplication implements CommandLineRunner {


	private MovieRepository movieRepository;
	private CustomerRepository customerRepository;
//	private UserCredentialService userCredentialService;

	public FullStackBackEndApplication(MovieRepository movieRepository, CustomerRepository customerRepository){
		this.movieRepository=movieRepository;
		this.customerRepository=customerRepository;
//		this.userCredentialService=userCredentialService;
	}

	public static void main(String[] args) {
		SpringApplication.run(FullStackBackEndApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		userCredentialService.createUser(new PostNewUser("admin@test.com", "String@123", "ADMIN"));
		movieRepository.saveAll(List.of(
				new Movie(0L,"Inception","Multi-Starer Movie", "Thriller", 5.0, 2005, "", "")
		));

	}
}
