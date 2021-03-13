package dhbw.fowler2.theatre;

public class Performance {

    public Play play;
    public int audience;

    public Performance(Play play, int audience) {
        this.play = play;
        this.audience = audience;
    }

    public Play getPlay() {
        return play;
    }

    public int getAmount(){
        var result = 0;

        switch (this.getPlay().type) {
            case "tragedy":
                result = 40000;
                if (this.audience > 30) {
                    result += 1000 * (this.audience - 30);
                }
                break;
            case "comedy":
                result = 30000;
                if (this.audience > 20) {
                    result += 10000 + 500 * (this.audience - 20);
                }
                result += 300 * this.audience;
                break;
            default:
                throw new Error("unknown type: ${play.type}");
        }

        return result;
    }

    public double getVolumeCredits(){
        var result = 0;
        // add volume credits
        result += Math.max(this.audience - 30, 0);
        // add extra credit for every ten comedy attendees
        if ("comedy" == this.getPlay().type) result += Math.floor(this.audience / 5);
        return result;
    }
}
