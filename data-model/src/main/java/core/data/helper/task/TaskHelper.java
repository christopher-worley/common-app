package core.data.helper.task;

import java.util.ArrayList;
import java.util.Date;

import core.data.cache.KeyedCache;
import core.data.cache.KeyedCacheStore;
import core.data.hibernate.task.TaskRoleHibernateImpl;
import core.data.hibernate.task.TaskStatusHibernateImpl;
import core.data.model.party.Party;
import core.data.model.party.RoleType;
import core.data.model.status.Status;
import core.data.model.task.Task;
import core.data.model.task.TaskRole;
import core.data.model.task.TaskStatus;

public class TaskHelper
{

    /** task being helped out */
    private Task task;

    /** data constant factory */
    private KeyedCache keyedCache;
    
    public TaskHelper(KeyedCache keyedCache, Task task)
    {
        super();
        this.keyedCache = keyedCache;
        this.task = task;
    }

    /**
     * @param party
     * @param roleType
     */
    public void addRole(Party party, RoleType roleType)
    {
        // TODO: do not specify impl
        TaskRole taskRole = new TaskRoleHibernateImpl();
        taskRole.setTask(task);
        taskRole.setParty(party);
        taskRole.setRoleType(roleType);
        // TODO: from date
        taskRole.setFromDate(new Date());
        
        if (task.getTaskRoles() == null) 
        {
            task.setTaskRoles(new ArrayList<TaskRole>());
        }
        task.getTaskRoles().add(taskRole);
    }

    /**
     * @param party
     * @param keyCreatedBy
     */
    public void addRole(Party party, String roleTypeKey)
    {
        KeyedCacheStore<RoleType> store = keyedCache.getCacheStore(RoleType.class);
        addRole(party, store.getObject(roleTypeKey));
    }
    
    /**
     * @param statusKey
     */
    public void changeTaskStatus(String statusKey)
    {
        Date date = new Date();
        TaskStatus activeStatus = getActiveStatus();
        if (activeStatus != null)
        {
            // TODO: thru date
            activeStatus.setThruDate(date);
        }
        // TODO: reference impl
        TaskStatus newStatus = new TaskStatusHibernateImpl();
        newStatus.setTask(task);
        newStatus.setFromDate(date);
        newStatus.setStatus((Status)keyedCache.getCacheStore(Status.class).getObject(statusKey));
        
        if (task.getTaskStatus() == null)
        {
            task.setTaskStatus(new ArrayList<TaskStatus>());
        }
        task.getTaskStatus().add(newStatus);
    }
    
    /**
     * @return
     */
    public TaskStatus getActiveStatus()
    {
        if (task.getTaskStatus() != null)
        {
            for (TaskStatus status : task.getTaskStatus())
            {
                if (status.getThruDate() == null)
                {
                    return status;
                }
            }
        }
        return null;
    }
}
