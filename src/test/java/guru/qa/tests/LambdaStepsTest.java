package guru.qa.tests;

import guru.qa.commonconfig.TestConfig;
import guru.qa.pages.GitHubPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class LambdaStepsTest extends TestConfig {

    GitHubPage gitHubPage = new GitHubPage();

    @Test
    @DisplayName("Проверка названия Issue через лямбда шаги")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("GitHub Issues")
    @Feature("Просмотр Issues")
    @Owner("aleksvmir")
    void issueTitleCorrectLambdaTest() {
        step("Открыть главную страницу GitHub", () ->
                gitHubPage.openMainPage());

        step("Клик на кнопку поиска", () ->
                gitHubPage.clickSearchButton());

        step("Ввод названия репозитория и поиск", () ->
                gitHubPage.setSearchValueAndSubmit());

        step("Выбор репозитория из результатов поиска", () ->
                gitHubPage.clickRepositoryLink());

        step("Переход на вкладку Issues", () ->
                gitHubPage.clickIssuesTab());

        step("Проверка наличия Issue", () ->
                gitHubPage.checkIssueTitleExists());
    }
}