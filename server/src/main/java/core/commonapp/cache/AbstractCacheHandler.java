package core.commonapp.cache;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import core.commonapp.domain.InformationContext;

public class AbstractCacheHandler implements ApplicationContextAware
{
    private InformationContext context;

    public InformationContext getInformationContext()
    {
        return context;
    }

    @Override
    public void setApplicationContext(ApplicationContext context)
    {
        this.context = new InformationContext(context);
    }

}
