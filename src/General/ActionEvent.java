package General;

import java.awt.event.ActionListener;

public enum ActionEvent {
	Action;
	public ActionListener getEvent(ActionEvent condition, EventCode code) {
		return new ActionListener(){
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				code.execute(e);
			}
		};
	}
}
