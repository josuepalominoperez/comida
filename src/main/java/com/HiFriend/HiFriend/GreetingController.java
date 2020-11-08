package com.HiFriend.HiFriend;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
	
	@Value("${config.horario.apertura}")
	private Integer apertura;
	
	@Value("${config.horario.cierre}")
	private Integer cierre;
	
	
	private List<String> teamList1 = Arrays.asList("Arroz chaufa", "Brócoli", "Pollo al horno", "Ensalada rusa", "Lentejitas" , 
			"Pollo a la naranja","Tallarin rojo","Tallarin verde","Lomo saltado",
				"Ceviche de pollo","Picante de carne","Ají de gallina","Causa","Cau cau",
				"Escabeche de pollo","Seco de carne","Estofado","Caigua rellena","Olluquito");
	
	public static List<String> pickNRandom(List<String> lst, int n) {
	    List<String> copy = new LinkedList<String>(lst);
	    Collections.shuffle(copy);
	    return copy.subList(0, n);
	}
	
	@GetMapping("/indexmommy")
	public String inicio(Model model) {
		//aqui se visualizará la url localhost/indexmommy pero internamente está yendo a localhost/mommy
		return "forward:/mommy";
	}
	
	
	@GetMapping("/indexmommy2")
	public String inicio2(Model model) {
		//Aquí hace un redirect a mommy page
		return "redirect:/mommy";
	}
	
	@GetMapping("/")
	public String getSingleFood(Model model) {
		String delim = ",";
		String developer = "Josué Palomino";
		String version ="Version 1.0.2";
		String res1 = String.join(delim, pickNRandom(teamList1, 1));
		Date d1 = new Date();
		SimpleDateFormat df = new SimpleDateFormat("dd/mm/YYYY HH:mm:ss");
		String formattedDate = df.format(d1);
		model.addAttribute("res1", res1);
		model.addAttribute("version", version);
		model.addAttribute("developer", developer);
		model.addAttribute("horaserver", formattedDate);
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
	
	@GetMapping("/crear")
	public String crear() {
		return "crear";
	}
	
	@GetMapping("/notepad")
	public String crearNotepad() {
		return "notepad";
	}
	
	@PostMapping("/guardar")
	public String guardar(@RequestParam("nombre") String nombre , @RequestParam("descripcion") String descripcion , Model model) {
		model.addAttribute("nombre", nombre);	
		model.addAttribute("descripcion", descripcion);
		return "guardar";
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
	
	@GetMapping("/cerrado")
	public String cerrado(Model model) {
		
		StringBuilder mensaje = new StringBuilder("Cerrado, por favor visita la página desde las ");
		mensaje.append(apertura);
		mensaje.append(" hasta las ");
		mensaje.append(cierre);
		mensaje.append(" hrs. Gracias.");
		model.addAttribute("titulo", "Fuera del horario de atención");
		model.addAttribute("mensaje", mensaje);
		return "cerrado";
	}
}
