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

    public int getAmount() {
        return PerformanceCalculator.createPerformanceCalculator(this).getAmount();
    }

    public double getVolumeCredits() {
        return PerformanceCalculator.createPerformanceCalculator(this).getVolumeCredits();
    }
}
