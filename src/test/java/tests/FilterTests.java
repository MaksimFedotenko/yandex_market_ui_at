package tests;


import org.testng.annotations.Test;
import pages.FilterPage;
import pages.SearchPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class FilterTests extends BaseTest {
    @Test(description = "Фильтрация смартфонов по Apple")
    public void testAppleFilter() {

        SearchPage searchPage = new SearchPage();
        searchPage.search("смартфоны");

        FilterPage filterPage = new FilterPage();
        filterPage.selectAppleFilter();

        // Проверяем, что все товары — Apple
        filterPage.verifyAppleProducts();
    }
}
