package ru.lanit.at.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.lanit.at.utils.web.annotations.Name;
import ru.lanit.at.utils.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$;

@Name(value = "авторизация в системе Helpdesk")
public class HelpdeskLoginPage extends WebPage {

    @Name("поле ввода username")
    private SelenideElement user = $(By.id("username"));

    @Name("поле ввода password")
    private SelenideElement password = $(By.id("password"));

    @Name("кнопка Login")
    private SelenideElement loginButton = $(By.cssSelector("[type='submit']"));
}
