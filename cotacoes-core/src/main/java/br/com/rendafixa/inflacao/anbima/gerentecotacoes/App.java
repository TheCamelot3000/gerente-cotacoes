package br.com.rendafixa.inflacao.anbima.gerentecotacoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackages = {"br.com.rendafixa.inflacao.anbima.gerentecotacoes.business.models"})
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
