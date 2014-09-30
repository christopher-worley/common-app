package core.commonapp.server.service.status;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import core.commonapp.client.dao.status.StatusDao;
import core.commonapp.client.service.status.StatusService;
import core.data.model.status.Status;
import core.service.result.ServiceResult;

@Service
public class StatusServiceImpl implements StatusService
{
    @Autowired
    private StatusDao statusDao;

    @Override
    public ServiceResult<List<Status>> findAll()
    {
        return ServiceResult.success("Found all status objects.", statusDao.findAll());
    }

}
