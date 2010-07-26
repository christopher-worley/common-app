package core.test.commonapp.server.main;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import core.commonapp.server.data.CreateRequiredData;

public class CreateTestData
{
    public static void main(String args[])
    {
        new CreateRequiredData(new ClassPathXmlApplicationContext("commonapp-server-test-context.xml"))
            .storeData(
                    Arrays.asList(new String[] { }
            ));
    }
}
