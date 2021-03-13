package dhbw.fowler2.theatre;

public class ComedyCalculator extends PerformanceCalculator {

    public ComedyCalculator(Performance aPerformance) {
        super(aPerformance);
    }

    @Override
    public int getAmount() {
        int result = 30000;
        if (aPerformance.audience > 20) {
            result += 10000 + 500 * (aPerformance.audience - 20);
        }
        result += 300 * aPerformance.audience;
        return result;
    }

    @Override
    public double getVolumeCredits() {
        return super.getVolumeCredits() + Math.floor(aPerformance.audience / 5);
    }

}
