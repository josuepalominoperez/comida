package com.HiFriend.HiFriend;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.HiFriend.model.Vacante;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping(value = "/categorias")
//Si usamos este RequestMapping para la clase quedaria asi : localhost:8080/categorias/AnyURL
public class GreetingController {
	
	@Value("${config.horario.apertura}")
	private Integer apertura;
	
	@Value("${config.horario.cierre}")
	private Integer cierre;
	
	
    private List<String> teamList1 = Arrays.asList("Arroz chaufa","Ají de gallina","Arverja verde partida",
     "Brócoli",
     "Carapulcra","Ceviche de pollo","Causa","Cau cau","Caigua rellena","Chanfainita",
     "Escabeche de pollo", "Ensalada rusa","Estofado","Ensalada mixta",
     "Lentejitas","Lomo saltado","Locro",
     "Mondonguito a la italiana",
     "Olluquito",
     "Papa rellena","Pallares con saltado de pollo","Pollo al horno", "Pollo a la naranja","Picante de carne","Pure",
     "Quinua",
     "Seco de carne",
     "Tallarin rojo","Tallarin verde","Tallarinn saltado"
	 );
	
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

    @GetMapping("/comida3")
	public String getSingleFood2(Model model) {
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
		return "comida3";
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
	
	
	@GetMapping("/pathvariable/{texto}/{numero}")
    public String variables(@PathVariable String texto, @PathVariable Integer numero, Model model) {
		model.addAttribute("titulo", "Recibir parámetros de la ruta (@PathVariable)");
		model.addAttribute("resultado", "El texto enviado en la ruta es: " + texto
				+ " y el número enviado en el path es: " + numero);
		return "pathvariable";
	}
	
	@GetMapping("/invitacion")
	public String invitacion() {
		return "invitacion";
    }
    
    @GetMapping("/detalle")
    public String detalle(Model model){
    Vacante vacante= new Vacante();
    vacante.setId(1);
    vacante.setNombre("Josue");
    vacante.setDescripcion("Realizando seteo de atributos desde Controller usando clase + 'Vacante' ");
    vacante.setFecha(new Date());
    vacante.setSalario(350.20);
    model.addAttribute("vacante", vacante);
    return "detalle";
    }

    @GetMapping("/tabla")
    public String mostrarTabla(Model model){
        List<Vacante> lista = getVacantes();
        model.addAttribute("vacantes", lista);
        return "tabla";
    }


    public List<Vacante> getVacantes(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
        List<Vacante> lista = new LinkedList<>();
        try {
            Vacante vacante1= new Vacante();
            vacante1.setId(1);
            vacante1.setNombre("Josue");
            vacante1.setDescripcion("Realizando seteo de atributos desde Controller usando clase + 'Vacante' ");
            vacante1.setFecha(sdf.parse("16-01-2021"));
            vacante1.setSalario(350.20);
            vacante1.setDestacado(1); 

            Vacante vacante2= new Vacante();
            vacante2.setId(2);
            vacante2.setNombre("Valeria");
            vacante2.setDescripcion("La jovencita más linda");
            vacante2.setFecha(sdf.parse("15-01-2021"));
            vacante2.setSalario(351.20); 
            vacante2.setDestacado(1);

            Vacante vacante3= new Vacante();
            vacante3.setId(3);
            vacante3.setNombre("Aracelly");
            vacante3.setDescripcion("La hermana que siempre quise XD");
            vacante3.setFecha(sdf.parse("20-01-2021"));
            vacante3.setSalario(352.20);
            vacante3.setDestacado(0); 

            Vacante vacante4= new Vacante();
            vacante4.setId(2);
            vacante4.setNombre("Renzo");
            vacante4.setDescripcion("Crack en programacion");
            vacante4.setFecha(sdf.parse("21-01-2021"));
            vacante4.setSalario(353.20); 
            vacante4.setDestacado(0);

            lista.add(vacante1);
            lista.add(vacante2);
            lista.add(vacante3);
            lista.add(vacante4);

        } catch (ParseException e) {
            System.out.println("Error" + e.getMessage());
        }

        return lista;
    }
}
