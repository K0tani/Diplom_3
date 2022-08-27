import org.junit.BeforeClass;
import static com.codeborne.selenide.Configuration.*;

public class BaseSettings {

    @BeforeClass
    public static void init() {
        browser = "chrome";
        browserSize = "1920x1080";
        headless = true;
    }

}
