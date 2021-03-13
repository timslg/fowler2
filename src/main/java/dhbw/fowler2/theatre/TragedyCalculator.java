package dhbw.fowler2.theatre;

public class TragedyCalculator extends PerformanceCalculator {

    public TragedyCalculator(Performance aPerformance) {
        super(aPerformance);
    }

    @Override
    public int getAmount() {
        int result = 40000;
        if (super.aPerformance.audience > 30) {
            result += 1000 * (aPerformance.audience - 30);
        }
        return result;
    }

}
