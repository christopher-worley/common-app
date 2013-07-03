package core.commonapp.client.service.task;

import java.util.List;

import core.data.model.task.TaskType;
import core.service.annotation.InformationBean;
import core.service.annotation.Service;
import core.service.result.ServiceResult;

@Service
@InformationBean(beanName="taskService")
public interface TaskService
{
    
    public ServiceResult<List<TaskType>> findAllTaskTypes();
    
    public ServiceResult changeStatus(Integer taskId, String statusKey);

}
