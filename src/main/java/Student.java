public class Student extends AbstractHuman {

    private double luckyFactor;
    private short iq = 0;

    protected double getIq() {
        return iq;
    }

    protected void setIq(short iq) {
        this.iq = iq;
    }

    protected void setIq(String iq) {
        this.iq = Short.parseShort(iq);
    }

    public double getLuckyFactor() {
        return luckyFactor;
    }

    public void setLuckyFactor(double luckyCoef) {
        this.luckyFactor = luckyCoef;
    }

}
