package dhbw.fowler2.theatre;

public abstract class Play {

    public String name;

    public Play(String name) {
        this.name = name;
    }

    public abstract PerformanceCalculator createPerformanceCalculator(Performance aPerformance);

}
