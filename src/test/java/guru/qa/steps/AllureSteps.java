package guru.qa.steps;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class AllureSteps {

    @Step("Открывается главная страница")
    public void mainPageOpen(String path) {
        open(path);
    }

    @Step("Клик на кнопке поиска")
    public void searchButtonClick() {
        $(".header-search-button").shouldBe(visible);
        $(".header-search-button").shouldBe(interactable);
        $(".header-search-button").click();
    }

    @Step("Ввод значения в поле поиска")
    public void searchFieldSet(String text) {
        $("#query-builder-test").shouldBe(visible);
        $("#query-builder-test").shouldBe(interactable);
        $("#query-builder-test").click();
        $("#query-builder-test").setValue(text).pressEnter();
    }

    @Step("Выбор результата поиска")
    public void choseSearchResults(String text) {
        $(".search-match").shouldHave(text(text)).click();
    }

    @Step("Переход во вкладку")
    public void tabClick() {
        $("#issues-tab").click();
    }

    @Step("Проверка названия issue")
    public void checkTabItem(String issueTitle) {
        $$("a[data-testid='issue-pr-title-link']").findBy(text(issueTitle)).should(exist);
    }
}