package steps;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.Before;

import static com.codeborne.selenide.Selenide.open;

public class Hooks {
    @Before
    public void openUrl() throws InterruptedException {
        //Configuration.timeout = 6000;
        Thread.sleep(6000);
        open("https://fizcult.by/");
    }
}
