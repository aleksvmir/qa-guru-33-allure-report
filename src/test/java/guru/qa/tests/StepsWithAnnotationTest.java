package guru.qa.tests;

import guru.qa.commonconfig.TestConfig;
import guru.qa.steps.AllureSteps;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StepsWithAnnotationTest extends TestConfig {

    @Test
    @DisplayName("Проверка корректности названия issue через аннотации")
    @Severity(SeverityLevel.NORMAL)
    @Epic("Функционал GitHub")
    @Feature("Вкладка Issue")
    @Owner("aleksvmir")
    public void issueTabNameCorrectAnnotationTest() {
        AllureSteps steps = new AllureSteps();

        steps.mainPageOpen("");
        steps.searchButtonClick();
        steps.searchFieldSet("aleksvmir/qa-guru-33-allure-report");
        steps.choseSearchResults("aleksvmir/qa-guru-33-allure-report");
        steps.tabClick();
        steps.checkTabItem("Test Issue");
    }
}