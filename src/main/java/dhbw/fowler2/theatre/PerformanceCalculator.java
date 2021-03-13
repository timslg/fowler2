package dhbw.fowler2.theatre;

public class PerformanceCalculator {

    protected Performance aPerformance;

    public PerformanceCalculator(Performance aPerformance){
        super();
        this.aPerformance = aPerformance;
    }

    public int getAmount(){
        var result = 0;

        switch (this.aPerformance.getPlay().type) {
            case "tragedy":
                result = 40000;
                if (this.aPerformance.audience > 30) {
                    result += 1000 * (this.aPerformance.audience - 30);
                }
                break;
            case "comedy":
                result = 30000;
                if (this.aPerformance.audience > 20) {
                    result += 10000 + 500 * (this.aPerformance.audience - 20);
                }
                result += 300 * this.aPerformance.audience;
                break;
            default:
                throw new Error("unknown type: ${play.type}");
        }

        return result;
    }

    public double getVolumeCredits(){
        var result = 0;
        // add volume credits
        result += Math.max(this.aPerformance.audience - 30, 0);
        // add extra credit for every ten comedy attendees
        if ("comedy" == this.aPerformance.getPlay().type) result += Math.floor(this.aPerformance.audience / 5);
        return result;
    }
}
