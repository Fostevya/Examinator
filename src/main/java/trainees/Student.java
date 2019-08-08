package trainees;

import abstraction.AbstractHuman;

public class Student extends AbstractHuman {

    private double luckyFactor;
    private short iq = 0;

    public double getIq() {
        return iq;
    }

    public void setIq(short iq) {
        this.iq = iq;
    }

    public void setIq(String iq) {
        this.iq = Short.parseShort(iq);
    }

    public double getLuckyFactor() {
        return luckyFactor;
    }

    public void setLuckyFactor(double luckyCoef) {
        this.luckyFactor = luckyCoef;
    }

}
