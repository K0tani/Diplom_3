package helpers;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDataGenerator {

    private final String email;
    private final String password;
    private final String name;
    public static final Faker FAKER = new Faker();

    @Step("Создаём пользователя с рандомным всеми полями")
    public static UserDataGenerator getRandomDataUser() {

        final String email = FAKER.internet().emailAddress();
        final String password = FAKER.bothify("?#?#?#?#");
        final String name = FAKER.name().username();

        return new UserDataGenerator(email, password, name);
    }
}