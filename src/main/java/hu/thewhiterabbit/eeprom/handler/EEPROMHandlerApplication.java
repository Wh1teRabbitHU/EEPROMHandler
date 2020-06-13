package hu.thewhiterabbit.eeprom.handler;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hu.thewhiterabbit.eeprom.handler.configuration.AsyncConfiguration;
import hu.thewhiterabbit.eeprom.handler.configuration.SpringConfiguration;
import hu.thewhiterabbit.eeprom.handler.gui.stage.MainStage;
import hu.thewhiterabbit.eeprom.handler.service.common.StateService;
import javafx.application.Application;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EEPROMHandlerApplication extends Application {

	@Override
	public void start(Stage stage) {
		log.info("Starting application!");

		final ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		final MainStage mainStage = ctx.getBean(MainStage.class);
		final StateService stateService = ctx.getBean(StateService.class);
		final AsyncConfiguration asyncConfiguration = ctx.getBean(AsyncConfiguration.class);

		mainStage.show();
		mainStage.setOnCloseRequest(event -> {
			log.info("Closing application...");

			stateService.cleanUpOnClose();
			asyncConfiguration.shutdownExecutor();
		});
	}

	public static void main(String[] args) {
		launch(args);
	}

}
