package UI;

import javax.swing.UIDefaults;
import javax.swing.plaf.basic.BasicLookAndFeel;

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
    }
}