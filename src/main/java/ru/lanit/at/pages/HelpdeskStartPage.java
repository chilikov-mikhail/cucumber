package ru.lanit.at.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.lanit.at.utils.web.annotations.Name;
import ru.lanit.at.utils.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$;

@Name(value = "стартовая страница Helpdesk")
public class HelpdeskStartPage extends WebPage {

    @Name("поле выбора Queue")
    private SelenideElement selectQueue = $(By.name("queue"));

    @Name("поле ввода Title")
    private SelenideElement inputProblem = $(By.id("id_title"));

    @Name("поле ввода Description")
    private SelenideElement inputDescription = $(By.id("id_body"));

    @Name("поле выбора Priority")
    private SelenideElement selectPriority = $(By.id("id_priority"));

    @Name("поле ввода DueDate")
    private SelenideElement inputDueDate = $(By.id("id_due_date"));

    @Name("поле ввода SubmitterEmail")
    private SelenideElement inputSubmitterEmail = $(By.id("id_submitter_email"));

    @Name("кнопка Submit Ticket")
    private SelenideElement searchButton = $(By.cssSelector("[class='btn btn-primary btn-lg btn-block']"));
}
