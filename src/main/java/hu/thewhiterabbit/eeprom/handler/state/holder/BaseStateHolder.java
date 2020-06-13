package hu.thewhiterabbit.eeprom.handler.state.holder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;

public abstract class BaseStateHolder {

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	protected void publishEvent(ApplicationEvent event) {
		applicationEventPublisher.publishEvent(event);
	}

}
