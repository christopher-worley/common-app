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
package core.test.commonapp.server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class ContextUtil
{
    private static volatile ContextUtil instance;

    private static String configFilename;

    //TODO: get from environment
    private static final String DEFAULT_CONFIG = "commonapp-server-test-context.xml";

    /**
     * @return
     */
    public static ContextUtil getInstance()
    {
        if (configFilename == null)
        {
            configFilename = DEFAULT_CONFIG;
        }
        return getInstance(configFilename);
    }

    /**
     * @param configFilename
     * @return
     */
    public static ContextUtil getInstance(String configFilename)
    {
        if (instance == null || ContextUtil.configFilename != configFilename)
        {
            ContextUtil.configFilename = configFilename;
            synchronized (ContextUtil.class)
            {
                if (instance == null)
                {
                    instance = new ContextUtil(configFilename);
                }
            }
        }
        return instance;
    }

    private ApplicationContext applicationContext;

    /**
     * 
     */
    private ContextUtil()
    {
        this(DEFAULT_CONFIG);
    }

    /**
     * @param contextFilename
     */
    private ContextUtil(String contextFilename)
    {
        applicationContext = new ClassPathXmlApplicationContext(contextFilename);
    }

    /**
     * @return the applicationContext
     */
    public ApplicationContext getApplicationContext()
    {
        return applicationContext;
    }

    /**
     * @return
     */
    public JdbcTemplate getJdbcTemplate()
    {
        return (JdbcTemplate) getApplicationContext().getBean("jdbcTemplate");
    }
}
