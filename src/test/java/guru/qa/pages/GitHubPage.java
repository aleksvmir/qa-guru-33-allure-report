package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class GitHubPage {

    private final String repositoryName = "aleksvmir/qa-guru-33-allure-report";
    private final String issueTitle = "Test Issue";

    private final SelenideElement
            searchButton = $(".header-search-button"),
            searchInput = $("#query-builder-test"),
            issuesTab = $("#issues-tab");

    public GitHubPage openMainPage() {
        open("");
        return this;
    }

    public GitHubPage clickSearchButton() {
        searchButton.shouldBe(visible, interactable).click();
        return this;
    }

    public GitHubPage setSearchValueAndSubmit() {
        searchInput.shouldBe(visible, interactable).setValue(repositoryName).pressEnter();
        return this;
    }

    public GitHubPage clickRepositoryLink() {
        $(".search-match").shouldHave(text(repositoryName)).click();
        return this;
    }

    public GitHubPage clickIssuesTab() {
        issuesTab.shouldBe(visible, interactable).click();
        return this;
    }

    public void checkIssueTitleExists() {
        $$("a[data-testid='issue-pr-title-link']")
                .filterBy(visible)
                .shouldHave(itemWithText(issueTitle));
    }
}