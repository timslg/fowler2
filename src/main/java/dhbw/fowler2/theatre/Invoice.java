package dhbw.fowler2.theatre;

import java.util.List;

public class Invoice {

    public String customer;
    public List<Performance> performances;

    public Invoice(String customer, List<Performance> performances) {
        this.customer = customer;
        this.performances = performances;
    }

    public int getTotalVolumeCredits(){
        var result = 0;
        for (var aPerformance : this.performances) {
            result += aPerformance.getVolumeCredits();
        }
        return result;
    }

    public int getTotalAmount(){
        var result = 0;
        for (var aPerformance : this.performances) {
            result += aPerformance.getAmount();
        }
        return result;
    }
}
