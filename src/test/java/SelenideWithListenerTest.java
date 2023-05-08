import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.linkText;

//1. Чистый Selenide (с Listener)
public class SelenideWithListenerTest extends TestBase {

    @Test
    @DisplayName("Чистый Selenide (с Listener)")
    void searchIssueTest() {
        $(".header-search-input").setValue("eroshenkoam/allure-example")
                .pressEnter();
        $(linkText("eroshenkoam/allure-example")).click();
        $("#issues-tab").click();
        $("div[aria-label=Issues]").$(withText("#80")).shouldBe(visible);
        new Steps().attachPageCode();
        new Steps().attachScreenshot();
    }

}
