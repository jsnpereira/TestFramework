package com.test.framework.selenium.base;

import com.test.framework.selenium.manager.LocalDriverHelper;
import org.openqa.selenium.support.PageFactory;

public class Base {

    public <TPage extends BasePage> TPage GetInstance(Class<TPage> page)
    {
        Object object = PageFactory.initElements(LocalDriverHelper.driver(), page);
        return page.cast(object);
    }

}
