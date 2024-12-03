package br.com.alura.screenmatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.service.ConsumoAPI;
import br.com.alura.screenmatch.service.ConverteDados;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//System.out.println("Primeiro projeto spring sem web");
		ConsumoAPI consumoApi = new ConsumoAPI();
		/*
		 * "https://www.omdbapi.com/?t="
				+ busca + "&apikey=3a651075"
		 */
		var json = consumoApi.obterDados("https://www.omdbapi.com/?t="
				+ "game+of+thrones" + "&apikey=3a651075");
		//System.out.println(json);
		
		//json = consumoApi.obterDados("https://coffee.alexflipnote.dev/random.json");
		System.out.println(json);
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		
		System.out.println(dados);
		
	}//end of run

}
