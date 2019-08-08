public class Student extends Human {

    private double luckyFactor = 0.0;
    private boolean lastExamResultPositive = false;

    public double getLuckyFactor() {
        return luckyFactor;
    }

    public void setLuckyFactor(double luckyCoef) {
        this.luckyFactor = luckyCoef;
    }

    public boolean isLastExamResultPositive() {
        return lastExamResultPositive;
    }

    public void setLastExamResultPositive(boolean lastExamResult) {
        this.lastExamResultPositive = lastExamResult;
    }
}
