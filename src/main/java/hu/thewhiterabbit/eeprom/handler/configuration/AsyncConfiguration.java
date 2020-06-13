package hu.thewhiterabbit.eeprom.handler.configuration;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Role;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
@Role(BeanDefinition.ROLE_INFRASTRUCTURE)
public class AsyncConfiguration implements AsyncConfigurer {

	private ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

	@Override
	public ThreadPoolTaskExecutor getAsyncExecutor() {
		executor.setMaxPoolSize(5);
		executor.setThreadNamePrefix("async-");
		executor.initialize();

		return executor;
	}

	public void shutdownExecutor() {
		executor.shutdown();
	}

}
