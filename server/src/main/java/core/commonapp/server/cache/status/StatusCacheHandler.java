package core.commonapp.server.cache.status;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import core.commonapp.client.service.status.StatusService;
import core.data.cache.KeyedCacheException;
import core.data.cache.KeyedCacheHandler;
import core.data.model.Keyable;
import core.data.model.status.Status;
import core.service.result.ServiceResult;

@Component
public class StatusCacheHandler implements KeyedCacheHandler
{

	@Autowired
    private StatusService statusService;

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
        ServiceResult result = statusService.findAll();
        if (!result.isSuccess())
        {
            throw new KeyedCacheException("Failed to successfully get objects for archive: " + result.getMessage());
        }
        return (List) result.getPayload();
    }

}
