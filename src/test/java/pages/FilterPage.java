package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.*;

public class FilterPage {
    private SelenideElement appleCheckbox = $("[data-filter-value-id=\"153043\"]");
    //private ElementsCollection productTitles = $$("[data-auto*='snippet-title']");

    @Step("Выбор Apple")
    public void selectAppleFilter(){
        $("[data-zone-name='filter']").scrollIntoView(true);
        sleep(1000);
        appleCheckbox.$("label").click();
        String url = WebDriverRunner.getWebDriver().getCurrentUrl();
        //$("h1").shouldHave(text("IPhone")); допиши проверку того, что текст совпадает
        sleep(2000);
        //$("[data-zone-name='filter'][data-zone-data*='Бренд']").shouldBe(visible); тут тоже дописать
    }

    @Step("Все товары — Apple")
    public void verifyAppleProducts() {
        ElementsCollection productTitles = $$("[data-auto*='snippet-title']");
        System.out.println("Найдено товаров Apple: " + productTitles.size());

        for (int i = 0; i < Math.min(3, productTitles.size()); i++) {
            String title = productTitles.get(i).getText();
            System.out.println("Товар " + i + ": " + title);
        }
    }
}
