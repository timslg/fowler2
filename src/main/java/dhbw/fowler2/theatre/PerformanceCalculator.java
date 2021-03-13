package dhbw.fowler2.theatre;

public class PerformanceCalculator {

    protected Performance aPerformance;

    protected PerformanceCalculator(Performance aPerformance){
        super();
        this.aPerformance = aPerformance;
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
