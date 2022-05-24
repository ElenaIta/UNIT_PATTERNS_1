package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGenerator {

    private DataGenerator() {

    }

    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift) //текущая дата + shift дней
                .format(DateTimeFormatter.ofPattern("dd.MM.yyyy")); // формат даты
    }

    public static String generateCity() {
        String[] citiesCenters = new String[]{
                "Абакан", "Анадырь", "Архангельск", "Астрахань", "Белгород", "Брянск",
                "Владимир", "Волгоград", "Воронеж", "Гатчина", "Рязань", "Самара"};
        int city = (int) Math.floor((Math.random() * citiesCenters.length));
        return citiesCenters[city];
    }

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.name().fullName();
    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserData generateUser(String locale) {
            return new UserData(generateCity(), generateName(locale), generatePhone(locale));
        }
    }

    @Value
    public static class UserData {
        String city;
        String name;
        String phone;
    }
}
