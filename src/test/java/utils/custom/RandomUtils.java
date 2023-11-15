package utils.custom;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Locale;

public class RandomUtils {

    Faker faker = new Faker(new Locale("en-US"));
    Faker fakerRu = new Faker(new Locale("ru-RU"));

    public String firstName = randomFirstName(),
            lastName = randomLastName(),
            email = randomEmail(),
            gender = getRandomGender(),
            phoneNumber = getRandomPhoneNumber(),
            day = randomDay(),
            month = randomMonth(),
            year = randomYear(),
            subject1 = getRandomSubject(),
            subject2 = getRandomSubject(),
            hobby = getRandomHobbies(),
            nameImage = getRandomPicture(),
            pathImage = "img/" + nameImage,
            currentAddress = randomCurrentAddress(),
            state = getRandomState(),
            city = getCityByState(state);



    public String randomFirstName() {
        return fakerRu.name().firstName();
    }

    public String randomLastName() {
        return fakerRu.name().lastName();
    }

    public String randomEmail() {
        return faker.internet().emailAddress();
    }

    public String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return faker.options().option(genders);
    }

    public String getRandomPhoneNumber() {
        return "7" + faker.phoneNumber().subscriberNumber(9);
    }

    public String randomCurrentAddress() {
        return faker.address().streetAddress();
    }

    public String randomDay() {
        int day = faker.random().nextInt(1, 28);
        return (day < 10) ? "0" + day : String.valueOf(day);
    }

    public String randomMonth(){
        String[] month = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        return faker.options().option(month);
    }

    public String randomYear(){
        return faker.random().nextInt(1940, 2023).toString();
    }

    public String getRandomSubject() {
        String[] subjects = {"Hindi", "English", "Physics", "Chemistry", "Biology", "Computer Science",
                "Accounting", "Economics", "Social Studies", "History", "Civics"};
        return faker.options().option(subjects);
    }

    public String getRandomHobbies() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return faker.options().option(hobbies);
    }

    public String getRandomPicture() {
        String[] pictures = {"bruce.jpeg", "picture1.jpeg", "picture2.png"};
        return faker.options().option(pictures);
    }

    public String getRandomState() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return faker.options().option(states);
    }

    public String getCityByState(String value) {
        HashMap<String, String> cityAndState = new HashMap<>();
        cityAndState.put("NCR","Delhi");
        cityAndState.put("Uttar Pradesh","Agra");
        cityAndState.put("Haryana","Karnal");
        cityAndState.put("Rajasthan","Jaipur");
        return cityAndState.get(value);
    }
}