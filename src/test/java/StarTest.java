import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import settings.TestBase;

import static com.codeborne.selenide.Selenide.open;


public class StarTest extends TestBase {
    @Test
    @DisplayName("UI.Поиск.Расположения элемента.Positive")
    void findElementPositive() {
        open("/en");
        findElements.searchElements();
    }
    @Test
    @Disabled
    @DisplayName("UI.Поиск.Расположения элемента.Negative")
    void findElementNegative() {
        open("/");
        searchNegative.searchElementsNegative();
    }

}
