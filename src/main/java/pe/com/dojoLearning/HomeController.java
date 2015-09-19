package pe.com.dojoLearning;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.dojoLearning.beans.Persona;

import java.io.File;
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

	@RequestMapping(value = "/index", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String servicio() {
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
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(ltaPersonas);
	}
}
