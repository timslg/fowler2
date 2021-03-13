package dhbw.fowler2.theatre;

public class Tragedy extends Play {

    public Tragedy(String name) {
        super(name);
    }

    @Override
    public PerformanceCalculator createPerformanceCalculator(Performance aPerformance) {
        return new TragedyCalculator(aPerformance);
    }

}
