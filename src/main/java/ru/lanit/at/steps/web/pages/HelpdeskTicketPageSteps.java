package ru.lanit.at.steps.web.pages;

import io.cucumber.java.ru.И;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.lanit.at.steps.web.AbstractWebSteps;
import ru.lanit.at.utils.ContextHolder;
import ru.lanit.at.utils.web.pagecontext.PageManager;

import static ru.lanit.at.utils.VariableUtil.replaceVars;

public class HelpdeskTicketPageSteps extends AbstractWebSteps {

    public HelpdeskTicketPageSteps(PageManager pageManager) {
        super(pageManager);
    }

    private Logger LOGGER = LogManager.getLogger(this.getClass());

    @И("прикрепить к тикету файл {string} из папки {string}")
    public void selectFile(String fileName, String dir) {
        fileName = replaceVars(fileName, getStorage());
        dir = replaceVars(dir, getStorage());
        String filePath = dir + fileName;
        pageManager.getCurrentPage().getElement("ввод пути к файлу").sendKeys(filePath);
    }

    @И("извлечь Queue из titleAndQueue = {string} и сохранить его под именем {word}")
    public void extractQueue(String titleAndQueue, String key) {
        titleAndQueue = replaceVars(titleAndQueue, getStorage());
        String queue = titleAndQueue
                .replaceAll(".+\\n?Queue:\\s", "")
                .replaceAll("\\sEdit.+", "");
        ContextHolder.asMap().put(key, queue);
        LOGGER.info("значение Queue = '{}' извлечено из '{}' и сохранено под именем '{}'", queue, titleAndQueue, key);
    }

    @И("извлечь Title из titleAndQueue = {string} и сохранить его под именем {word}")
    public void extractTitle(String titleAndQueue, String key) {
        titleAndQueue = replaceVars(titleAndQueue, getStorage());
        String title = titleAndQueue
                .replaceAll("^.+\\.\\s", "")
                .replaceAll("(\\s\\[.+)?\\n.+", "");
        ContextHolder.asMap().put(key, title);
        LOGGER.info("значение Title = '{}' извлечено из '{}' и сохранено под именем '{}'", title, titleAndQueue, key);
    }
}
