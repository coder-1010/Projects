package practiceProject.card3.two;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import practiceProject.card3.two.Feedback;

@Repository
public interface FeedbackRepo extends JpaRepository<Feedback, Integer> {

}