import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "feedback")
public class Feedback {

	@Id
	@GeneratedValue
	private int id;
	private String firstname;
	private String lastname;
	private String email;
	private String feedback;
	
	public Feedback() {
		super();
	}

	public Feedback(String firstname, String lastname, String email, String feedback) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.feedback = feedback;
	}

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", feedback=" + feedback + "]";
	}
		
}
