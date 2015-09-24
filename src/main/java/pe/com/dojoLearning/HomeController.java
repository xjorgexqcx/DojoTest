package pe.com.dojoLearning;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.dojoLearning.beans.Contact;
import pe.com.dojoLearning.beans.Persona;
import pe.com.dojoLearning.service.ConectaService;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Autowired
	private ConectaService conectaService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/servicioRest", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "index";
	}

	@RequestMapping(value = "/plantilla", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String plantilla(Model model) {
		model.addAttribute("serverTime", "Entro en la segunda");
		return "home";
	}

	@RequestMapping(value = "/", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String servicio() {
		return "restTest";
	}

	@RequestMapping(value = "/index", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String index() {
		return "restTest";
	}

	@RequestMapping(value = "/posiciones", method = { RequestMethod.POST,
			RequestMethod.GET })
	@ResponseBody
	public String getPosiciones() throws JsonGenerationException,
			JsonMappingException, IOException {
		Persona p = new Persona("Jorge", "Quijano", "SA-1");
		List<Persona> ltaPersonas = new ArrayList<Persona>();
		ltaPersonas.add(p);

		p = new Persona("Juan", "Juarez", "SA-1");
		ltaPersonas.add(p);

		p = new Persona("Coco", "Quijano", "SN-2");
		ltaPersonas.add(p);
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(ltaPersonas);
	}

	@RequestMapping(value = "/nuevoCanvas")
	public String getMove() {
		return "nuevoCanvas";
	}

	@RequestMapping(value = "seguridad")
	public String intentoDeCaptcha() {
		return "IntentoCaptcha";
	}

	@RequestMapping(value = "busqueda")
	public String seguridad(Model model,
			@RequestParam("g-recaptcha-response") String captcha,
			@RequestParam("nombre") String nombre) {
		if (captcha.length() <= 0) {
			model.addAttribute("info",
					"Lo sentimos, Verifique el captcha porfavor");
		} else {
			model.addAttribute("info", "Ahora si se hizo click: " + captcha);
		}
		return "IntentoCaptcha";
	}

	@RequestMapping(value = "buscarInfo")
	public String busqueda(Model model, @RequestParam("codigo") String valor) {
		try {
			List<Contact> rpta = conectaService.buscar(valor);
			if (rpta.size() > 0) {
				model.addAttribute("info", rpta);
			} else {
				model.addAttribute("rpta",
						"No se encontró información");
			}
		} catch (NullPointerException e) {
			List<Contact> rpta = conectaService.list();
			if (rpta != null) {
				model.addAttribute("info", rpta);
			} else {
				model.addAttribute("rpta", "No se ha recibido el dato");
			}
		}
		return "busqueda";
	}

	@RequestMapping(value = "listarInfo")
	public String listarInfo(Model model) {
		List<Contact> rpta = conectaService.list();
		if (rpta != null) {
			model.addAttribute("info", rpta);
		} else {
			model.addAttribute("rpta",
					"No llego a conectarse con la implementacion");
		}
		return "busqueda";
	}
}
