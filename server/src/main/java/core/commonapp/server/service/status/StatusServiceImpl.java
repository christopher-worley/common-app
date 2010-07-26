package core.commonapp.server.service.status;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import core.commonapp.client.dao.status.StatusDAO;
import core.commonapp.client.service.status.StatusService;
import core.data.model.status.Status;
import core.service.result.ServiceResult;

public class StatusServiceImpl implements StatusService
{
    @Autowired
    private StatusDAO statusDAO;

    @Override
    public ServiceResult<List<Status>> findAll()
    {
        return ServiceResult.success("Found all status objects.", statusDAO.findAll());
    }

}
