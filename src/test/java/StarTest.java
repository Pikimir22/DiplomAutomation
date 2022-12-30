import org.junit.jupiter.api.Test;
import settings.TestBase;

import static com.codeborne.selenide.Selenide.open;


public class StarTest extends TestBase {
    @Test
    void startTest() {
        open("/");
        findElements.searchElements();

    }
}
