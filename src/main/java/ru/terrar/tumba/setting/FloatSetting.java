package ru.terrar.tumba.setting;

/**
 * @author zTerrarxd_
 * @since 17:30 of 01.03.2023
 */
public class FloatSetting extends Setting{
    float val;
    float min;
    float max;
    public FloatSetting(String name, float min, float max, float val) {
        super(name);
        this.min = min;
        this.max = max;
        this.val = val;
    }

    public float getMax() {
        return max;
    }

    public float getMin() {
        return min;
    }

    public float getVal() {
        return val;
    }

    public void setVal(float val) {
        this.val = val;
    }
}
