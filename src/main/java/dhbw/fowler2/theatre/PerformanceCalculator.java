package dhbw.fowler2.theatre;

public class PerformanceCalculator {

    protected Performance aPerformance;

    protected PerformanceCalculator(Performance aPerformance){
        super();
        this.aPerformance = aPerformance;
    }

    public static PerformanceCalculator createPerformanceCalculator(Performance aPerformance) {
        switch (aPerformance.getPlay().getClass().getSimpleName()) {
            case "Tragedy":
                return new TragedyCalculator(aPerformance);
            case "Comedy":
                return new ComedyCalculator(aPerformance);
            default:
                throw new Error("unknown type: " + aPerformance.getPlay().getClass().getSimpleName());
        }
    }

    public int getAmount(){
        throw new Error("sub-classes responsibility");
    }

    public double getVolumeCredits(){
        var result = 0;

        result += Math.max(this.aPerformance.audience - 30, 0);

        return result;
    }
}
