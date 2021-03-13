package dhbw.fowler2.theatre;

public class PerformanceCalculator {

    protected Performance aPerformance;

    protected PerformanceCalculator(Performance aPerformance){
        super();
        this.aPerformance = aPerformance;
    }

    public static PerformanceCalculator createPerformanceCalculator(Performance aPerformance) {
        switch (aPerformance.getPlay().type) {
            case "tragedy":
                return new TragedyCalculator(aPerformance);
            case "comedy":
                return new ComedyCalculator(aPerformance);
            default:
                throw new Error("unknown type: " + aPerformance.getPlay().type);
        }
    }

    public int getAmount(){
        throw new Error("unknown type: " + aPerformance.getPlay().type);
    }

    public double getVolumeCredits(){
        var result = 0;

        result += Math.max(this.aPerformance.audience - 30, 0);

        return result;
    }
}
