package ru.netology.test;


import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DeliveryCardOrderTest {



    @Test
    void shouldCheckForm() {
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue(DataGenerator.enterCity());
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(DataGenerator.enterDate(3));
        $("[data-test-id='name'] input").setValue(DataGenerator.enterName());
        $("[data-test-id='phone'] input").sendKeys(DataGenerator.enterPhone());
        $("[class='checkbox__box']").click();
        $(withText("Запланировать")).click();
        $("[data-test-id='success-notification']").shouldBe(Condition.visible, Duration.ofSeconds(15));
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(DataGenerator.enterDate(4));
        $(withText("Запланировать")).click();
        $(withText("Перепланировать")).click();
        $("[class='notification__title']").shouldBe(Condition.visible, Duration.ofSeconds(5));
        $("[data-test-id='success-notification']").shouldHave(text(DataGenerator.enterDate(4)));




    }
}
