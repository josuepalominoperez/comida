package com.HiFriend.HiFriend;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GreetingController {
	
	
	private String comidas[]={"Arroz chaufa", "Brócoli", "Pollo al horno", "Ensalada rusa", "Lentejitas" , 
			"Pollo a la naranja","Tallarin rojo","Tallarin verde","Lomo saltado",
			"Ceviche de pollo","Picante de carne","Ají de gallina","Causa","Cau cau",
			"Escabeche de pollo","Seco de carne","Estofado","Caigua rellena","Olluquito"};
	
	@GetMapping("/food")
	public String getRandomFood(Model model) {
		int rand = new Random().nextInt(comidas.length);
		String randomFood=comidas[rand];
		model.addAttribute("randomFood", randomFood);
		return "comida";
	}

	@GetMapping("/saluditope")
	public String greeting() {
		return "index";
	}
	
	@GetMapping("/losangeles")
	public String greeting2() {
		return "losangeles";
	}
	
	@GetMapping("/meniuprincipale")
	public String greeting3() {
		return "main";
	}

	@GetMapping("/courses/fundamentos")
	public String greeting4() {
		return "fundamentos";
	}
}
