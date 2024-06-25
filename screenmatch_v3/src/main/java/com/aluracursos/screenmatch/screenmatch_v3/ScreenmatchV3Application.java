package com.aluracursos.screenmatch.screenmatch_v3;

import com.aluracursos.screenmatch.screenmatch_v3.main.Main;
import com.aluracursos.screenmatch.screenmatch_v3.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchV3Application implements CommandLineRunner {
	@Autowired
	private ShowRepository showRepository;
	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchV3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main(showRepository);
		main.showMenu();
	}
}
