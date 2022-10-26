package com.issues.demo;

import com.issues.jpa.UserRepository;
import com.issues.models.UserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserRepository repository) {
		return args -> {
			repository.save(new UserModel("Jack", ""));
			repository.save(new UserModel("Chloe", ""));
			repository.save(new UserModel("Kim", ""));
			repository.save(new UserModel("David", ""));
			repository.save(new UserModel("Michelle", ""));

			// fetch all users
			log.info("Users found with findAll():");
			log.info("-------------------------------");
			for (UserModel user : repository.findAll()) {
				log.info(user.toString());
			}
			log.info("");
			// fetch an individual user by ID
			UserModel user = repository.findById(1L);
			log.info("User found with findById(1L):");
			log.info("--------------------------------");
			log.info(user.toString());
			log.info("");

			// fetch users by name
			log.info("User found with findName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			// for (UserModel bauer : repository.findByLastName("Bauer")) {
			//  log.info(bauer.toString());
			// }
			log.info("");
//			System.out.println("Let's inspect the beans provided by Spring Boot:");

//			String[] beanNames = ctx.getBeanDefinitionNames();
//			Arrays.sort(beanNames);
//			for (String beanName : beanNames) {
//				System.out.println(beanName);
//			}

		};
	}

}