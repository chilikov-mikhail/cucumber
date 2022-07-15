package ru.lanit.at.steps.web.pages;

import io.cucumber.java.ru.И;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.lanit.at.steps.web.AbstractWebSteps;
import ru.lanit.at.utils.ContextHolder;
import ru.lanit.at.utils.web.pagecontext.PageManager;

import static ru.lanit.at.utils.VariableUtil.replaceVars;

public class HelpdeskViewPageSteps extends AbstractWebSteps {

    public HelpdeskViewPageSteps(PageManager pageManager) {
        super(pageManager);
    }

    private Logger LOGGER = LogManager.getLogger(this.getClass());

    @И("извлечь id из caption_id = {string} и сохранить его под именем {word}")
    public void extractId(String caption_id, String key) {
        caption_id = replaceVars(caption_id, getStorage());
        String id = caption_id.substring(caption_id.indexOf("-") + 1, caption_id.indexOf("]"));
        ContextHolder.asMap().put(key, id);
        LOGGER.info("значение id = '{}' извлечено из '{}' и сохранено под именем '{}'", id, caption_id, key);
    }
}
