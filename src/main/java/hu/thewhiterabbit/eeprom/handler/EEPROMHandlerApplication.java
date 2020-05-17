package hu.thewhiterabbit.eeprom.handler;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hu.thewhiterabbit.eeprom.handler.configuration.SpringConfiguration;
import hu.thewhiterabbit.eeprom.handler.gui.stage.MainStage;
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

		mainStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
