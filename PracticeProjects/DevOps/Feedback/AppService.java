package practiceProject.card3.two;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import practiceProject.card3.two.Feedback;
import practiceProject.card3.two.FeedbackRepo;

@Service
public class AppService {
	
	@Autowired
	private FeedbackRepo myRepo;
	
	public boolean addFeedback(Feedback f) {
		myRepo.save(f);
		return true;
	}
	
}