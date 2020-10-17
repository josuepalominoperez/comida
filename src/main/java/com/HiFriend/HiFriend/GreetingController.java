package com.HiFriend.HiFriend;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GreetingController {
	
	
	private List<String> teamList1 = Arrays.asList("Arroz chaufa", "Brócoli", "Pollo al horno", "Ensalada rusa", "Lentejitas" , 
			"Pollo a la naranja","Tallarin rojo","Tallarin verde","Lomo saltado",
				"Ceviche de pollo","Picante de carne","Ají de gallina","Causa","Cau cau",
				"Escabeche de pollo","Seco de carne","Estofado","Caigua rellena","Olluquito");
	
	public static List<String> pickNRandom(List<String> lst, int n) {
	    List<String> copy = new LinkedList<String>(lst);
	    Collections.shuffle(copy);
	    return copy.subList(0, n);
	}
	
	@GetMapping("/")
	public String getSingleFood(Model model) {
		String delim = ",";
		String developer = "Josué Palomino";
		String version ="Version 1.0.2";
		String res1 = String.join(delim, pickNRandom(teamList1, 1));
		model.addAttribute("res1", res1);
		model.addAttribute("version", version);
		model.addAttribute("developer", developer);
		return "comida";
	}

	
	@GetMapping("/mommy")
	public String getMultipleFood(Model model) {
		String delim = ",";
		String developer = "Josué Palomino";
		String version ="Version 1.0.2";
		String res7 = String.join(delim, pickNRandom(teamList1, 7));
		model.addAttribute("res7", res7);
		model.addAttribute("version", version);
		model.addAttribute("developer", developer);
		return "comida2";
	}
	
	@GetMapping("/hora")
	public String preguntar(Model model) {
		return "dato";
	}
	
	@GetMapping("/saluditope")
	public String greeting() {
		return "indexz";
	}
	
	@GetMapping("/losangeles")
	public String greeting2() {
		return "losangelesz";
	}
	
	@GetMapping("/meniuprincipale")
	public String greeting3() {
		return "mainz";
	}

	@GetMapping("/courses/fundamentos")
	public String greeting4() {
		return "fundamentosz";
	}
}
