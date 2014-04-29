package core.commonapp.server.cache.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import core.commonapp.client.service.task.TaskService;
import core.data.cache.KeyedCacheException;
import core.data.cache.KeyedCacheHandler;
import core.data.model.Keyable;
import core.data.model.task.TaskType;
import core.service.result.ServiceResult;

@Component
public class TaskTypeCacheHandler implements KeyedCacheHandler
{

	@Autowired
    private TaskService taskService;

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
        ServiceResult result = taskService.findAllTaskTypes();
        if (!result.isSuccess())
        {
            throw new KeyedCacheException("Failed to successfully get objects for archive: " + result.getMessage());
        }
        return (List) result.getPayload();
    }

}
