package guru.qa;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class TheInternetHerokuapp extends TestBase {

    SelenideElement rectA = $("#column-a"),
                    rectB = $("#column-b");

    @Test
    @DisplayName("Drag-n-drop test using Selenide")
    @Order(1)
    void dragAndDropSimpleTest() {

        step("Открываем страницу примера с drag and drop", () -> {
            open("https://the-internet.herokuapp.com/drag_and_drop");
        });

        step("Перенос элемента A на место B", () ->
                rectA.dragAndDropTo(rectB)
        );

        step("Текст первого прямоугольника должен быть В", () ->
                $$(".column").first().shouldHave(text("B"))
        );
    }

    @Test
    @DisplayName("Drag-n-drop test using Actions")
    @Order(4)
    public void dragAndDropActionsTest() {

        step("Открываем страницу примера с drag and drop", () -> {
            open("https://the-internet.herokuapp.com/drag_and_drop");
        });

        step("Перенос элемента A на место B", () -> {
            actions().dragAndDrop(rectA, rectB).perform();
        });

        step("Текст первого прямоугольника должен быть В", () ->
                $$(".column").first().shouldHave(text("B"))
        );
    }

    @Test
    @DisplayName("Drag-n-drop test using Actions element offset by coordinates")
    @Order(3)
    public void dragAndDropByOffsetTestMinus() {

        step("Открываем страницу примера с drag and drop", () -> {
            open("https://the-internet.herokuapp.com/drag_and_drop");
        });

        step("Перенос элемента A на место B", () -> {
            actions().dragAndDropBy(rectA, rectB.getRect().getX() - rectA.getRect().getX(), 0);
        });

        step("Текст первого прямоугольника должен быть В", () ->
                $$(".column").first().shouldHave(text("B"))
        );
    }

    @Test
    @DisplayName("Drag-n-drop test using Actions element hard offset")
    @Order(2)
    public void dragAndDropByOffsetTest2() {

        step("Открываем страницу примера с drag and drop", () -> {
            open("https://the-internet.herokuapp.com/drag_and_drop");
        });

        step("Перенос элемента A на место B", () -> {
            actions().moveToElement(rectB).clickAndHold().moveByOffset(225, 0).release().perform();
        });

        step("Текст первого прямоугольника должен быть В", () ->
                $$(".column").first().shouldHave(text("B"))
        );
    }

}
