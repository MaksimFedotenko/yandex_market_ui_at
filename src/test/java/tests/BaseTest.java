package tests;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.testng.annotations.BeforeClass;
import pages.SearchPage;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    @BeforeClass
    public void setUp()
    {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;

        open("https://market.yandex.ru");

    }
}
