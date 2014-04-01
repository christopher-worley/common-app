package core.commonapp.server.service.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import core.commonapp.client.dao.task.TaskDao;
import core.commonapp.client.dao.task.TaskTypeDao;
import core.commonapp.client.service.task.TaskService;
import core.data.cache.KeyedCache;
import core.data.helper.task.TaskHelper;
import core.data.model.task.Task;
import core.data.model.task.TaskType;
import core.service.result.ServiceResult;

/**
 * Task service implementation for common app framework
 * 
 * @author worleyc
 *
 */
public class TaskServiceImpl implements TaskService
{
    
    @Autowired
    private TaskTypeDao taskTypeDao;
    
    @Autowired
    private TaskDao taskDao;
    
    @Autowired
    private KeyedCache keyedCache;

    @Override
    public ServiceResult<List<TaskType>> findAllTaskTypes()
    {
        return ServiceResult.success("Successfully retreived all TaskType objects.", taskTypeDao.findAll());
    }

    @Override
    public ServiceResult changeStatus(Integer taskId, String statusKey)
    {
        Task task = taskDao.findById(taskId);
        TaskHelper helper = new TaskHelper(keyedCache, task);
        helper.changeTaskStatus(statusKey);
        taskDao.save(task);
        return ServiceResult.success("Changed task status.");
    }

}
