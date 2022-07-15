package ru.lanit.at.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.lanit.at.utils.web.annotations.Name;
import ru.lanit.at.utils.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$;


@Name(value = "Страница просмотра карточки тикета (неавторизированный пользователь)")
public class HelpdeskViewPage extends WebPage {

    @Name("элемент страницы, содержащий id")
    private SelenideElement selectQueue = $(By.cssSelector("caption"));

    @Name("кнопка Log In")
    private SelenideElement logInButton = $(By.id("userDropdown"));
}
