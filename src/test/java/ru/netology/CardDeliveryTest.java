package ru.netology;


import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardDeliveryTest {
    @BeforeEach
    void setup() {
        open("http://localhost:9999");
    }

    @Test
    public void shouldSuccessfulFormSubmission() {
        DataGenerator.UserData userData = DataGenerator.Registration.generateUser("Ru");

        // заполнение и первоначальная отпрвка формы
        $("[data-test-id=city] input").setValue(userData.getCity());
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.DELETE);
        String scheduledDate = DataGenerator.generateDate(3); // запланированная дата (текущая дата + 5 дней)
        $("[data-test-id=date] input").setValue(scheduledDate);
        $("[data-test-id=name] input").setValue(userData.getName());
        $("[data-test-id=phone] input").setValue(userData.getPhone());
        $("[data-test-id=agreement]").click();
        $(".button").shouldHave(Condition.text("Запланировать")).click();

        // проверка на содержание текста и время загрузки (видимость)
        $("[data-test-id=success-notification]").shouldBe(Condition.visible)
                .shouldHave(Condition.text("Успешно! Встреча успешно запланирована на " + scheduledDate),
                        Duration.ofSeconds(18));

        // изменение первоначальной даты и повторная отправка формы
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.DELETE);
        String rescheduledData = DataGenerator.generateDate(11); // запланированная дата (текущая дата + 11 дней)
        $("[data-test-id=date] input").setValue(rescheduledData);
        $(".button").shouldHave(Condition.text("Запланировать")).click();

        //Взаимодействие с опцией перепланировки, а также проверка на видимость, содержание текста и время загрузки
        $("[data-test-id=replan-notification]").shouldBe(Condition.visible)
                .shouldHave(Condition.text("У вас уже запланирована встреча на другую дату. Перепланировать?"),
                        Duration.ofSeconds(18));
        $("[data-test-id=replan-notification] .button").shouldHave(Condition.text("Перепланировать")).click();

        // итоговая проверка содержания текста и времени загрузки
        $("[data-test-id=success-notification]").shouldBe(Condition.visible)
                .shouldHave(Condition.text("Успешно! Встреча успешно запланирована на " + rescheduledData),
                        Duration.ofSeconds(26));

    }
}
