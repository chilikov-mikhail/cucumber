package ru.lanit.at.steps.web.pages;

import io.cucumber.java.ru.И;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.lanit.at.models.HelpdeskDictionaries;
import ru.lanit.at.steps.web.AbstractWebSteps;
import ru.lanit.at.utils.ContextHolder;
import ru.lanit.at.utils.web.pagecontext.PageManager;

import static ru.lanit.at.utils.VariableUtil.replaceVars;

public class HelpdeskStartPageStep extends AbstractWebSteps {

    public HelpdeskStartPageStep(PageManager pageManager) {
        super(pageManager);
    }

    private Logger LOGGER = LogManager.getLogger(this.getClass());

    @И("преобразовать заданное значение Queue = {word} в текст и сохранить его под именем {word}")
    public void getExpectedQueue (String queueInt, String name) {
        queueInt = replaceVars(queueInt, getStorage());
        String queueText = HelpdeskDictionaries.getQueue(Integer.parseInt(queueInt));
        ContextHolder.asMap().put(name, queueText);
    }

    @И("преобразовать заданное значение Priority = {word} в текст и сохранить его под именем {word}")
    public void getExpectedPriority (String priorityInt, String name) {
        priorityInt = replaceVars(priorityInt, getStorage());
        String priorityText = HelpdeskDictionaries.getPriority(Integer.parseInt(priorityInt));
        ContextHolder.asMap().put(name, priorityText);
    }
}
