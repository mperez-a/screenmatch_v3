package com.aluracursos.screenmatch.screenmatch_v3;

import com.aluracursos.screenmatch.screenmatch_v3.main.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchV3Application implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchV3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main();
		main.showMenu();
	}
}
