package hu.thewhiterabbit.eeprom.handler.gui.stage;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import hu.thewhiterabbit.eeprom.handler.gui.container.MainContainer;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class MainStage extends Stage {

	private static final String TITLE = "EEPROM Handler";
	private static final Integer SCENE_WIDTH = 640;
	private static final Integer SCENE_HEIGHT = 640;

	private final MainContainer mainContainer;

	@PostConstruct
	public void init() {
		Scene scene = new Scene(mainContainer, SCENE_WIDTH, SCENE_HEIGHT);

		this.setScene(scene);
		this.setTitle(TITLE);
	}

}
