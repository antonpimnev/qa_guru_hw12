package guru.qa;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class GithubTests extends TestBase{

    @Test
    void hoverGitHubTest() {

        step("Открываем страницу GitHub", () -> {
            open("https://github.com/");
        });

        step("Ищем раздел главного меню Solutions", () -> {
            $$("li").findBy(text("Solutions")).hover();
        });

        step("Выбираем пункт Enterprise", () -> {
            $$("ul li a").findBy(text("Enterprise")).click();
        });

        step("На открытой странице должен быть заголовок с текстом Build like the best", () -> {
            $(byTagAndText("h1", "Build like the best")).shouldBe(visible, Duration.ofSeconds(10));
        });
    }
}