package guru.qa.tests;

import guru.qa.commonconfig.TestConfig;
import guru.qa.pages.GitHubPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PureSelenideTest extends TestConfig {

    GitHubPage gitHubPage = new GitHubPage();

    @Test
    @DisplayName("Проверка названия Issue через чистый Selenide с Listener")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("GitHub Issues")
    @Feature("Просмотр Issues")
    @Owner("aleksvmir")
    void issueTitleCorrectTest() {
        gitHubPage.openMainPage()
                .clickSearchButton()
                .setSearchValueAndSubmit()
                .clickRepositoryLink()
                .clickIssuesTab()
                .checkIssueTitleExists();
    }
}
