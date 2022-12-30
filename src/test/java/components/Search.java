package components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import settings.RandomUtils;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class Search extends RandomUtils {

    public String searchArticle = randomString(2);

    @DisplayName("UI.Поиск.Расположения элемента.TestCase-SBCV-T176")
    public Search searchElements() {
        step("Пользователь переходит на Sber AI", () -> {
            $(".styles_search__IwwuF").shouldBe(Condition.visible);
        });
        step("Пользователь нажимает на кнопку Поиск", () -> {
            $(".styles_search__IwwuF").click();
        });
        step("Пользователь вводит 2 буквы или 2 цифры", () -> {
            $(".styles_input__Ck8OS").setValue(searchArticle);
        });
        step("Поиск текста  Смотреть все результаты", () -> {
            $(".styles_button__mqBSQ.styles_showAllBtn__Yib8f.styles_secondary__WRCJ3").shouldHave(exactTextCaseSensitive("Смотреть все результаты"));

        });
        step("Пользователь нажимает на кнопку Смотреть все результаты и возвращается назад", () -> {
            $(byText("Смотреть все результаты")).click();
            Selenide.back();
            $(".styles_container__lHREI").shouldHave(text("Поиск"));
        });
        return this;
    }

}
