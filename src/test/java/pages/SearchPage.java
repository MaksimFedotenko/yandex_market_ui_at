package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPage {
    private SelenideElement searchInput = $("#header-search");
    private SelenideElement searchButton = $("[data-auto='search-button']");
    private ElementsCollection results = $$("[data-zone-name=\"search-results-snippet\"]");

    @Step("Ввод запроса: {query}")
    public void search(String query) {
        searchInput.setValue(query);

        searchButton.shouldBe(visible).click();
    }

    @Step("Проверка видимости результатов")
    public boolean resultsVisible() {
        $("h1").shouldHave(text("смартфон"));
        return true;
    }

    @Step("Количество результатов")
    public int getResultsCount() {
        results.should(sizeGreaterThan(0));
        return results.size();
    }
}
