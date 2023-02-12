package components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.DisplayName;
import settings.RandomUtils;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class SearchNegative extends RandomUtils {
    public String searchArticle = randomString(1);


    @DisplayName("UI.Поиск.Расположения элемента.TestCase-SBCV-T178")
    public SearchNegative searchElementsNegative() {


        step("Пользователь переходит на Sber AI Поиск отображается в header", () -> {
            $(".styles_container__lHREI").shouldHave(text("Поиск"));
        });
        step("Пользователь переходит на Sber AI", () -> {
            $(".styles_search__IwwuF").shouldBe(Condition.visible);
        });
        step("Пользователь нажимает на кнопку Поиск", () -> {
            $(".styles_search__IwwuF").click();
        });
        step("Пользователь вводит 1 буквы или 1 цифры", () -> {
        SelenideElement value = $(".styles_input__Ck8OS").setValue(searchArticle);
        });
return this;
    }
}