package helpers;
import rest.RestApi;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Utils extends RestApi {

    private static final String USER_PATH = "/api/auth/";

    @Step("Создать пользователя")
    public ValidatableResponse userCreate(UserDataGenerator userDataGenerator) {
        return given()
                .spec(getBaseSpec())
                .body(userDataGenerator)
                .when()
                .post(USER_PATH + "register")
                .then().log().all();
    }

    @Step("Пользователь логинется")
    public ValidatableResponse loginUser(UserDataGenerator userDataGenerator) {

        HashMap<String,String> dataBody = new HashMap<String,String>();

        dataBody.put("email", userDataGenerator.getEmail());
        dataBody.put("password", userDataGenerator.getPassword());

        return given()
                .spec(getBaseSpec())
                .body(dataBody)
                .when()
                .post(USER_PATH + "login")
                .then();
    }

    @Step("Пользователь удаляется")
    public ValidatableResponse deleteUser(String auth) {
        return given()
                .spec(getBaseSpec())
                .header("Authorization", auth)
                .when()
                .delete(USER_PATH + "user")
                .then();
    }
}