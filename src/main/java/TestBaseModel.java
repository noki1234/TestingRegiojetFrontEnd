import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestBaseModel {

    private String url = "https://novy.regiojet.cz/sk";

    @BeforeEach
    public void setUp() {
        open(url);
        webdriver().object().manage().window().maximize();
        $(byText("PRIJAŤ VŠETKY")).click();
    }


    @AfterEach
    public void close() throws InterruptedException {
        Thread.sleep(5000);
        webdriver().driver().close();
    }
}
