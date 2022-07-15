package ru.lanit.at.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.lanit.at.utils.web.annotations.Name;
import ru.lanit.at.utils.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Name(value = "Страница отдельного тикета (авторизированный пользователь)")
public class HelpdeskTicketPage extends WebPage {

    @Name("Title и Queue")
    private SelenideElement titleAndQueue = $x("//th[contains(text(), 'Queue')]");

    @Name("Description")
    private SelenideElement description = $x("//td[@id='ticket-description']/p");

    @Name("Priority")
    private SelenideElement priority = $x("//th[text()='Priority']/following-sibling::td[1]");

    @Name("Email")
    private SelenideElement email = $x("//td[contains(text(), '@')]");

    @Name(value = "кнопка Attach File(s)")
    private SelenideElement attachFileButton = $(By.cssSelector("[id=\"ShowFileUpload\"]"));

    @Name("ввод пути к файлу")
    private SelenideElement inputFile = $(By.cssSelector("input[type=\"file\"]"));

    @Name("ссылка на файл")
    private SelenideElement fileHref = $(By.cssSelector("td>ul>li>a[href^=\"/media/helpdesk/attachments\"]"));

    @Name("кнопка Update This Ticket")
    private SelenideElement updateThisTicketButton = $(By.cssSelector("[class=\"btn btn-primary float-right\"]"));
}
