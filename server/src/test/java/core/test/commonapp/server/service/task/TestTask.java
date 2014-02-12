package core.test.commonapp.server.service.task;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import core.commonapp.client.service.task.TaskService;
import core.data.cache.task.TaskTypeKey;
import core.data.model.task.TaskType;
import core.service.result.ServiceResult;
import core.tooling.logging.LogFactory;
import core.tooling.logging.Logger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/commonapp-server-test-context.xml")
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
@Transactional
public class TestTask
{
    /** logger for this class */
    private static final Logger logger = LogFactory.getLogger(TestTask.class);
    
    @Autowired
    private TaskService taskService;
    
    @Test
    public void testFindAllTaskTypes()
    {
        ServiceResult<List<TaskType>> result = taskService.findAllTaskTypes();
        Assert.assertTrue(result.isSuccess());
        
        // use counter to verify existence of each key listed in <code>TaskTypeKey</code>
        int count = 1;
        for (TaskType taskType : result.getPayload())
        {
            if (TaskTypeKey.KEY_BASIC.equals(taskType.getKey()))
            {
                count--;
            }
        }
        Assert.assertEquals(count, 0);
    }
}
