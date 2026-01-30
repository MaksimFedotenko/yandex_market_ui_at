package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
//import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.SearchPage;

import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertTrue;

public class SearchTests {
    private SearchPage searchPage;

    @BeforeClass
    public void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;

        // AllureSelenide — закомментируй эту строку пока
        // SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        open("https://market.yandex.ru");
        searchPage = new SearchPage();
    }

    @Test(description = "Поиск смартфонов")
    public void testSearchSmartphones() {
        searchPage.search("смартфоны");
        assertTrue(searchPage.resultsVisible(), "Результаты поиска должны отображаться");
    }
}
