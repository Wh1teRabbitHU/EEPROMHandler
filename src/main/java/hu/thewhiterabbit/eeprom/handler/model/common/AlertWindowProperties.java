package hu.thewhiterabbit.eeprom.handler.model.common;

import java.awt.event.MouseEvent;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AlertWindowProperties {

	private String header;
	private String title;
	private String body;
	private String acceptText;
	private String rejectText;
	private boolean hasReject;
	private MouseEvent onClickAccept;
	private MouseEvent onClickReject;

}
