package dhbw.fowler2.theatre;

import java.text.NumberFormat;
import java.util.Locale;

public class StatementPrinter {

    public String print(Invoice invoice) {
        var totalAmount = 0;
        var volumeCredits = 0;
        var result = String.format("Statement for %s\n", invoice.customer);

        for (var aPerformance : invoice.performances) {
            var aPlay = aPerformance.getPlay();
            var thisAmount = getAmountFor(aPerformance);

            volumeCredits += getVolumeCreditsFor(aPerformance);

            // print line for this order
            result += String.format("  %s: %s (%s seats)\n", aPlay.name, usd(thisAmount / 100), aPerformance.audience);
            totalAmount += thisAmount;
        }
        result += String.format("Amount owed is %s\n", usd(totalAmount / 100));
        result += String.format("You earned %s credits\n", volumeCredits);
        return result;
    }

    private int getAmountFor(Performance aPerformance){
        var result = 0;

        switch (aPerformance.getPlay().type) {
            case "tragedy":
                result = 40000;
                if (aPerformance.audience > 30) {
                    result += 1000 * (aPerformance.audience - 30);
                }
                break;
            case "comedy":
                result = 30000;
                if (aPerformance.audience > 20) {
                    result += 10000 + 500 * (aPerformance.audience - 20);
                }
                result += 300 * aPerformance.audience;
                break;
            default:
                throw new Error("unknown type: ${play.type}");
        }

        return result;
    }

    private double getVolumeCreditsFor(Performance aPerformance){
        var result = 0;
        // add volume credits
        result += Math.max(aPerformance.audience - 30, 0);
        // add extra credit for every ten comedy attendees
        if ("comedy" == aPerformance.getPlay().type) result += Math.floor(aPerformance.audience / 5);
        return result;
    }

    private String usd(long aNumber){
        return NumberFormat.getCurrencyInstance(Locale.US).format(aNumber);
    }
}
