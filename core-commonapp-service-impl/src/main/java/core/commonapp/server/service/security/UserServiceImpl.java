/**
 * Copyright 2009 Core Information Solutions LLC
 *
 * This file is part of Core CommonApp Framework.
 *
 * Core CommonApp Framework is free software: you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Core CommonApp Framework is distributed in the hope that it will be  
 * useful, but WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General 
 * Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along 
 * with Core CommonApp Framework.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package core.commonapp.server.service.security;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import core.commonapp.client.dao.security.UserLoginDao;
import core.commonapp.client.service.security.UserService;
import core.commonapp.domain.InformationContext;
import core.data.model.party.Person;
import core.data.model.security.UserLogin;
import core.service.result.ServiceResult;

@Service
public class UserServiceImpl implements UserService, ApplicationContextAware
{
    /** user dao */
    @Autowired
    private UserLoginDao userLoginDao;
    
    private InformationContext context;

    

    public UserServiceImpl()
    {
        super();
        
    }

    @Override
    @Transactional
    public ServiceResult<UserLogin> createUserLogin(Person person, String username, String password)
    {
    	/// ????: should use spring directory
        UserLogin userLogin = (UserLogin) context.getBean(UserLogin.class);
        userLogin.setParty(person);
        userLogin.setUsername(username);
        userLogin.setPassword(password);
        userLogin.setEnabled(true);
        userLogin.setCreatedDate(new Timestamp(System.currentTimeMillis()));

        return createUserLogin(userLogin);
    }

    @Override
    @Transactional
    public ServiceResult<UserLogin> createUserLogin(UserLogin userLogin)
    {
        if (userLoginDao.existByUsername(userLogin.getUsername()))
        {
            return ServiceResult.error("User login exist with username " + userLogin.getUsername() + ".");
        }
        
        userLoginDao.save(userLogin);
        
        return new ServiceResult(userLogin);
    }

    @Override
    @Transactional
    public ServiceResult<Set<UserLogin>> findAll()
    {
        return ServiceResult.success("Found all user logins.", userLoginDao.findAll()); 
    }

    @Override
    @Transactional
    public ServiceResult<Set<UserLogin>> findAllLikeUsername(UserLogin userLogin, String username)
    {
        List<UserLogin> userLogins = userLoginDao.findAllLikeUsername(username);
        return ServiceResult.success("Found all matching user logins.", userLogins);
    }

    @Override
    @Transactional
    public ServiceResult<UserLogin> findById(Integer id)
    {
        UserLogin userLogin = userLoginDao.findById(id);
        // populate party
        userLogin.getParty();
        return ServiceResult.success("Found user login.", userLogin);
    }

    @Override
    @Transactional
    public ServiceResult<UserLogin> findByUsernameAndPassword(String username, String password)
    {
        UserLogin user = userLoginDao.findByUsernameAndPassword(username, password);
        if (user != null)
        {
            return new ServiceResult(user);
        }
        else
        {
            return new ServiceResult(ServiceResult.ERROR, "Failed to find user.");
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext context)
    {
        this.context = new InformationContext(context);
    }

}
