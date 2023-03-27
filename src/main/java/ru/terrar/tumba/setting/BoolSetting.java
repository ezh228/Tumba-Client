package ru.terrar.tumba.setting;

/**
 * @author zTerrarxd_
 * @since 17:34 of 01.02.2023
 */
public class BoolSetting extends Setting {
    boolean val;

    public BoolSetting(String name, boolean val) {
        super(name);
        this.val = val;
    }



    public boolean getVal() {
        return val;
    }

    public void setVal(boolean val) {
        this.val = val;
    }
}
