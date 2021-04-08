package General;

import java.awt.event.MouseAdapter;

public enum MouseEvent {
	LMBClick,
	RMBClick,
	ScrollClick;
	public MouseAdapter getEvent(MouseEvent condition, EventCode code) {
		switch(condition){
			case LMBClick:
				return retrieveLMBClick(condition, code);
			case RMBClick:
				return retrieveRMBClick(condition, code);
			case ScrollClick:
				return retrieveScrollClick(condition, code);
			default:
				System.err.println("[Error] MouseEvent is not specified.");
				System.exit(1);
				return null;
		}
	}
	private MouseAdapter retrieveLMBClick(MouseEvent condition, EventCode code) {
		return new MouseAdapter(){
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				if(e.getButton() == java.awt.event.MouseEvent.BUTTON1){
					code.execute(e);
				}
			}
		};
	} private MouseAdapter retrieveRMBClick(MouseEvent condition, EventCode code) {
		return new MouseAdapter(){
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				if(e.getButton() == java.awt.event.MouseEvent.BUTTON2){
					code.execute(e);
				}
			}
		};
	} private MouseAdapter retrieveScrollClick(MouseEvent condition, EventCode code) {
		return new MouseAdapter(){
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				if(e.getButton() == java.awt.event.MouseEvent.BUTTON3){
					code.execute(e);
				}
			}
		};
	}
}
