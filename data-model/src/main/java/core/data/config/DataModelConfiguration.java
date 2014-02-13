package core.data.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan({ "core.data.hibernate" })
public class DataModelConfiguration {

}
