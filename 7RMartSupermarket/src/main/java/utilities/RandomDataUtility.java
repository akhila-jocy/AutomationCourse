package utilities;

import com.github.javafaker.Faker;

public class RandomDataUtility {

	Faker faker = new Faker();
	
	public String createRandomUsername() {
		return faker.name().username();
	}
	
	public String createRandomPassword() {
		return faker.internet().password();
	}
	
	public String createRandomPhoneNumber() {
		return faker.phoneNumber().phoneNumber();
	}
	
	public String createRandomCategoryNames() {
		return faker.book().title();
		
	}
}
