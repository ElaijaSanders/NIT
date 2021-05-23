package UI;

import javax.swing.JTextField;
import javax.swing.UIDefaults;
import javax.swing.plaf.basic.BasicLookAndFeel;
import javax.swing.text.DefaultEditorKit;

@SuppressWarnings("serial")
public class NITLaF extends BasicLookAndFeel {
    public String getDescription(){
        return "Basic GUI style for Chime.";
    }
    public String getName(){
        return "Navister's Interfacing Toolkit";
    }
    public String getID(){
        return "NavistersInterfacingToolkit";
    }
    public boolean isNativeLookAndFeel(){
        return false;
    }
    public boolean isSupportedLookAndFeel(){
        return true;
    }
    protected void initClassDefaults(UIDefaults table){
        super.initClassDefaults(table);
        table.put("ButtonUI", NITButtonUI.class.getCanonicalName());
        table.put("LabelUI", NITLabelUI.class.getCanonicalName());
        table.put("TextFieldUI", NITTextFieldUI.class.getCanonicalName());
        table.put("PasswordFieldUI", NITPasswordFieldUI.class.getCanonicalName());
        table.put("ComboBoxUI", NITDropdownUI.class.getCanonicalName());
        table.put("SpinnerUI", NITSpinnerUI.class.getCanonicalName());
        table.put("CheckBoxUI", NITCheckboxUI.class.getCanonicalName());
        table.put("RadioButtonUI", NITRadioButtonUI.class.getCanonicalName());
        table.put("SliderUI", NITSliderUI.class.getCanonicalName());
    }
	@Override
	protected void initComponentDefaults(UIDefaults table) {
		super.initComponentDefaults(table);
		//Referenced from NapkinLookAndFeel.java @ SourceForge
		Object fieldInputMap = new UIDefaults.LazyInputMap(new Object[]{
				"ENTER", JTextField.notifyAction,
				"BACK_SPACE", DefaultEditorKit.deletePrevCharAction,
				"ctrl A", DefaultEditorKit.selectAllAction,
                "ctrl C", DefaultEditorKit.copyAction,
                "ctrl V", DefaultEditorKit.pasteAction,
                "ctrl X", DefaultEditorKit.cutAction,
                "COPY", DefaultEditorKit.copyAction,
                "PASTE", DefaultEditorKit.pasteAction,
                "CUT", DefaultEditorKit.cutAction,
                "RIGHT", DefaultEditorKit.forwardAction,
                "LEFT", DefaultEditorKit.backwardAction,
                "KP_RIGHT", DefaultEditorKit.forwardAction,
                "KP_LEFT", DefaultEditorKit.backwardAction,
                "shift LEFT", DefaultEditorKit.selectionBackwardAction,
                "shift KP_LEFT", DefaultEditorKit.selectionBackwardAction,
                "shift RIGHT", DefaultEditorKit.selectionForwardAction,
                "shift KP_RIGHT", DefaultEditorKit.selectionForwardAction,
                "HOME", DefaultEditorKit.beginLineAction,
                "END", DefaultEditorKit.endLineAction
		}); Object[] actionDefaults = {
				"TextField.focusInputMap", fieldInputMap,
				"PasswordField.focusInputMap", fieldInputMap
		};
		table.putDefaults(actionDefaults);
	}
}