package core.commonapp.cache.status;

import java.util.List;

import core.commonapp.cache.AbstractCacheHandler;
import core.commonapp.client.service.status.StatusService;
import core.data.cache.KeyedCacheException;
import core.data.cache.KeyedCacheHandler;
import core.data.model.Keyable;
import core.data.model.status.Status;
import core.service.result.ServiceResult;

public class StatusCacheHandler extends AbstractCacheHandler implements KeyedCacheHandler
{

    @Override
    public Class getDataClass()
    {
        return Status.class;
    }

    @Override
    public Object getKey(Keyable keyableObject)
    {
        return keyableObject.getKey();
    }

    @Override
    public List getObjects()
    {
        StatusService statusService = (StatusService) getInformationContext().createService(StatusService.class);
        ServiceResult result = statusService.findAll();
        if (!result.isSuccess())
        {
            throw new KeyedCacheException("Failed to successfully get objects for archive: " + result.getMessage());
        }
        return (List) result.getPayload();
    }

}
