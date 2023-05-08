import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AllureStepsTest extends TestBase {
    private static final String REPOSITORY = "eroshenkoam/allure-example";

    @Test
    @DisplayName("Шаги с аннотацией @Step")
    void searchIssueTest() {

        Steps steps = new Steps();
        steps.searching(REPOSITORY);
        steps.clickLink(REPOSITORY);
        steps.clickIssuesTab();
        steps.issue80ShouldBeVisible();
        steps.attachPageCode();
        steps.attachScreenshot();
    }
}
