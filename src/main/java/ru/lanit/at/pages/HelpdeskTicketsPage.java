package ru.lanit.at.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.lanit.at.utils.web.annotations.Name;
import ru.lanit.at.utils.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Name(value = "список тикетов")
public class HelpdeskTicketsPage extends WebPage {

//    @Name("список тикетов")
//    private List<SelenideElement> ticketsHref = $$x("//div[@class='tickettitle']/a");

    @Name("поле ввода для поиска")
    private SelenideElement inputSearch = $x("//input[@id='search_query']");

    @Name("кнопка Go (поиск)")
    private SelenideElement goButton = $x("//nav//button[@type='submit']");

    @Name(value = "поле ввода названия поискового запроса Query Name")
    private SelenideElement inputQueryName = $(By.id("id_title"));

    @Name(value = "кнопка Save Query")
    private SelenideElement saveQueryButton = $(By.cssSelector("[value=\"Save Query\"]"));

    @Name(value = "поле выбора сохраненного поискового запроса")
    private SelenideElement savedQuerySelector = $(By.id("id_query_selector"));

    @Name(value = "кнопка Run Query")
    private SelenideElement runQueryButton = $(By.cssSelector("[value=\"Run Query\"]"));

    @Name(value = "поле с ключевыми словами поиска")
    private SelenideElement keywords = $(By.id("id_query"));
}
