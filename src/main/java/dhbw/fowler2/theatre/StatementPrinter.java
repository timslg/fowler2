package dhbw.fowler2.theatre;

import java.text.NumberFormat;
import java.util.Locale;

public class StatementPrinter {

    public String print(Invoice invoice) {
        var result = String.format("Statement for %s\n", invoice.customer);
        for (var aPerformance : invoice.performances) {
            // print line for this order
            result += String.format("  %s: %s (%s seats)\n", aPerformance.getPlay().name, usd(getAmountFor(aPerformance) / 100), aPerformance.audience);
        }
        result += String.format("Amount owed is %s\n", usd(getTotalAmountFor(invoice) / 100));
        result += String.format("You earned %s credits\n", getTotalVolumeCreditsFor(invoice));
        return result;
    }

    private int getAmountFor(Performance aPerformance){
    return aPerformance.getAmount();
    }

    private double getVolumeCreditsFor(Performance aPerformance){
        return aPerformance.getVolumeCredits();
    }

    private int getTotalAmountFor(Invoice invoice){
       return invoice.getTotalAmount();
    }

    private int getTotalVolumeCreditsFor(Invoice invoice){
        return invoice.getTotalVolumeCredits();
    }

    private String usd(long aNumber){
        return NumberFormat.getCurrencyInstance(Locale.US).format(aNumber);
    }
}
