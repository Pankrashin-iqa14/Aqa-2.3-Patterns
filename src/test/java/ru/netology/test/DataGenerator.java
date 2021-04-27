package ru.netology.test;


import com.github.javafaker.Faker;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class DataGenerator {
    private static Faker faker = new Faker(new Locale("ru"));

    private DataGenerator(){};


    public static String  enterCity(){
        return faker.address().cityName();
    }
    public static String enterDate(int date) {
        return LocalDate.now().plusDays(date).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
    public static String enterName (){
        return faker.name().name();
    }

    public static String enterPhone(){
        return faker.phoneNumber().phoneNumber();
    }

}