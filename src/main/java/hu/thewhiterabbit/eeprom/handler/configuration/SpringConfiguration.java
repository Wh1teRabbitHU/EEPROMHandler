package hu.thewhiterabbit.eeprom.handler.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
	AsyncConfiguration.class,
	StateConfiguration.class,
	ServiceConfiguration.class,
	JavaFxConfiguration.class
})
public class SpringConfiguration {

}
