package core.commonapp.client.service.status;

import java.util.List;

import core.data.model.status.Status;
import core.service.annotation.InformationBean;
import core.service.annotation.Service;
import core.service.result.ServiceResult;

@Service
@InformationBean(beanName="statusService")
public interface StatusService
{

    public ServiceResult<List<Status>> findAll();
}
