package utils;

import com.github.javafaker.Faker;

public class User {

    Faker faker = new Faker();
    String name = faker.name().firstName();
    String email = faker.internet().emailAddress();
    String passwordCorrect = faker.internet().password(6,10);
    String passwordIncorrect = faker.internet().password(1,5);

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordCorrect() {
        return passwordCorrect;
    }

    public String getPasswordIncorrect() {
        return passwordIncorrect;
    }
}
