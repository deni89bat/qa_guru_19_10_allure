import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class Steps {

    @Step("В поле поиска вводим {str} и нажимаем enter")
    public void searching(String str) {
        $(".header-search-input").setValue(str).pressEnter();
    }

    @Step("Кликаем на линк {str}")
    public void clickLink(String str) {
        $(linkText(str)).click();
    }

    @Step("Кликаем на issues")
    public void clickIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("Проверяем, что есть issue #80")
    public void issue80ShouldBeVisible() {
        $("div[aria-label=Issues]").$(withText("#80")).shouldBe(visible);
    }

    public void attachPageCode() {
        Allure.getLifecycle().addAttachment(
                "Исходники страницы",
                "text/html",
                "html",
                WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8)
        );
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
