package trainee;

import abstraction.AbstractHuman;

public class Student extends AbstractHuman {

    private double luckyFactor;
    private short iq = 0;

    public short getIq() {
        return iq;
    }

    public void setIq(short iq) {
        this.iq = iq;
    }

    public double getLuckyFactor() {
        return luckyFactor;
    }

    public void setLuckyFactor(double luckyCoef) {
        this.luckyFactor = luckyCoef;
    }

}
