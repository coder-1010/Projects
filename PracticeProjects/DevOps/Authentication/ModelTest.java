package practiceProject.card3.three;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import practiceProject.card3.three.UserModel;

public class ModelTest {
	@Test
	public void testgetAndsetPassword() {
		UserModel testModel = new UserModel();
		
		testModel.setPassword("rbk!=2001");
		assertEquals(testModel.getPassword(), "rbk!=2001");
	}
	
	@Test
	public void testgetAndsetEmail() {
		UserModel testModel = new UserModel();
		
		testModel.setEmail("example@gmail.com");
		assertEquals(testModel.getEmail(), "example@gmail.com");
	}
	
	@Test
	public void testgetAndsetLogin() {
		UserModel testModel = new UserModel();
		
		testModel.setLogin("Admin");
		assertEquals(testModel.getLogin(), "Admin");
	}
	
	@Test
	public void testToString() {
		UserModel testModel = new UserModel();
		
		assertNotNull(testModel.toString());
	}
}