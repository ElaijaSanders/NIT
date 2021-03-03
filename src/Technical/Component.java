package Technical;

import javax.swing.*;

public abstract class Component extends Wrapper<JComponent> {
    @SuppressWarnings("unused")
	private JComponent value;
    public abstract JComponent getRawValue();
}
