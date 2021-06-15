package br.edu.ifpe.gus.ads4arq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
public class Ads4ArqApp {

	public static void main(String[] args) {
		SpringApplication.run(Ads4ArqApp.class, args);
		}
}
