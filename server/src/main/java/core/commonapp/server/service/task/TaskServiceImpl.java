package core.commonapp.server.service.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import core.commonapp.client.dao.GenericDAO;
import core.commonapp.client.dao.task.TaskDAO;
import core.commonapp.client.dao.task.TaskTypeDAO;
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
    private TaskTypeDAO taskTypeDAO;
    
    @Autowired
    private TaskDAO taskDAO;
    
    @Autowired
    private GenericDAO genericDAO;
    
    @Autowired
    private KeyedCache keyedCache;

    @Override
    public ServiceResult<List<TaskType>> findAllTaskTypes()
    {
        return ServiceResult.success("Successfully retreived all TaskType objects.", taskTypeDAO.findAll());
    }

    @Override
    public ServiceResult changeStatus(Integer taskId, String statusKey)
    {
        Task task = taskDAO.findById(taskId);
        TaskHelper helper = new TaskHelper(keyedCache, task);
        helper.changeTaskStatus(statusKey);
        genericDAO.save(task);
        return ServiceResult.success("Changed task status.");
    }

}
