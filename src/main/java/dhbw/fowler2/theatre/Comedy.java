package dhbw.fowler2.theatre;

public class Comedy extends Play {

    public Comedy(String name) {
        super(name);
    }

    @Override
    public PerformanceCalculator createPerformanceCalculator(Performance aPerformance) {
        return new ComedyCalculator(aPerformance);
    }

}
