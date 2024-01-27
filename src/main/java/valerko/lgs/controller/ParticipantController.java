package valerko.lgs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import valerko.lgs.domain.Participant;
import valerko.lgs.service.ParticipantService;


@Controller
public class ParticipantController {
	
	@Autowired
	private ParticipantService participantService;
	
	@GetMapping("/")
	public String init(HttpServletRequest request) {		
		return "index";
	}
	
	@GetMapping("/catalog")
	public String toCatalog(HttpServletRequest request) {
		request.setAttribute("participants", participantService.readAll());
		request.setAttribute("mode", "VIEW");
		return "catalog";
	}

	@GetMapping("/new")
	public String newParticipant(HttpServletRequest request) {
		request.setAttribute("mode", "CREATE");
		return "catalog";
	}

	@PostMapping("/save")
	public String saveParticipant(@ModelAttribute Participant participant, HttpServletRequest request) {
		participantService.update(participant);
		request.setAttribute("participants", participantService.readAll());
		request.setAttribute("mode", "VIEW");
		return "catalog";
	}

	@GetMapping("/update")
	public String updateParticipant(@RequestParam Integer id, HttpServletRequest request) {
		request.setAttribute("participant", participantService.readById(id));
		request.setAttribute("mode", "EDIT");
		return "catalog";
	}

	@GetMapping("/delete")
	public String deleteParticipant(@RequestParam Integer id, HttpServletRequest request) {
		participantService.deleteById(id);
		request.setAttribute("participants", participantService.readAll());
		request.setAttribute("mode", "VIEW");
		return "catalog";
	}

}
