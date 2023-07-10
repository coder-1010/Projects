package practiceProject.card3.two;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import practiceProject.card3.two.AppService;

@Controller
public class FeedbackController {

	@Autowired
	private AppService service;
	
	@GetMapping("/feedback")
	public String feedback() {
		return "feedback";
	}
}