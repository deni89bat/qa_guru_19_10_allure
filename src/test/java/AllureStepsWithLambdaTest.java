import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.*;
import static org.openqa.selenium.By.linkText;

public class AllureStepsWithLambdaTest extends TestBase {
    private static final String REPOSITORY = "eroshenkoam/allure-example";

    @Test
    @DisplayName("Лямбда шаги через step (name, () -> {})")
    void searchIssueTest() {
        step("Набираем в поле поиска " + REPOSITORY + " и нажимаем enter", () -> {
            $(".header-search-input").setValue(REPOSITORY).pressEnter();
        });
        step("Клик по ссылке " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Клик по вкладке issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем, что есть issue #80", () -> {
            $("div[aria-label=Issues]").$(withText("#80")).shouldBe(visible);
        });
        step("Код страницы", () -> {
            new Steps().attachPageCode();
        });
        step("Скриншот", () -> {
            new Steps().attachScreenshot();
        });
    }

}
