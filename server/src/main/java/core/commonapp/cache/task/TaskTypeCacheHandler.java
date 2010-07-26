package core.commonapp.cache.task;

import java.util.List;

import core.commonapp.cache.AbstractCacheHandler;
import core.commonapp.client.service.task.TaskService;
import core.data.cache.KeyedCacheException;
import core.data.cache.KeyedCacheHandler;
import core.data.model.Keyable;
import core.data.model.task.TaskType;
import core.service.result.ServiceResult;

public class TaskTypeCacheHandler extends AbstractCacheHandler implements KeyedCacheHandler
{

    @Override
    public Class getDataClass()
    {
        return TaskType.class;
    }

    @Override
    public Object getKey(Keyable keyableObject)
    {
        return keyableObject.getKey();
    }

    @Override
    public List getObjects()
    {
        TaskService taskService = (TaskService) getInformationContext().createService(TaskService.class);
        ServiceResult result = taskService.findAllTaskTypes();
        if (!result.isSuccess())
        {
            throw new KeyedCacheException("Failed to successfully get objects for archive: " + result.getMessage());
        }
        return (List) result.getPayload();
    }

}
