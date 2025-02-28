package com.kata.kata;

import org.springframework.boot.SpringApplication;

public class TestKataCandidoApplication {

	public static void main(String[] args) {
		SpringApplication.from(KataCandidoApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
