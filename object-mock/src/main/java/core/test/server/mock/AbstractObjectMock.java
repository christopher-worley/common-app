package core.test.server.mock;

import core.commonapp.domain.InformationContext;
import core.data.cache.KeyedCache;

/**
 * @author worleyc
 * 
 */
public class AbstractObjectMock
{
    private InformationContext context;

    private KeyedCache keyedCache;

    public AbstractObjectMock(InformationContext context)
    {
        super();
        this.context = context;
    }

    /**
     * @return
     */
    public InformationContext getInformationContext()
    {
        return context;
    }

    /**
     * @return
     */
    public KeyedCache getKeyedCache()
    {
        if (keyedCache == null)
        {
            keyedCache = (KeyedCache) getInformationContext().getBean(KeyedCache.class);
        }
        return keyedCache;
    }

}
