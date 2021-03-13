package dhbw.fowler2.theatre;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public class StatementPrinter {

    public String print(Invoice invoice) {
        var totalAmount = 0;
        var volumeCredits = 0;
        var result = String.format("Statement for %s\n", invoice.customer);

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);

        for (var aPerformance : invoice.performances) {
            var aPlay = aPerformance.getPlay();
            var thisAmount = 0;

            switch (aPlay.type) {
                case "tragedy":
                    thisAmount = 40000;
                    if (aPerformance.audience > 30) {
                        thisAmount += 1000 * (aPerformance.audience - 30);
                    }
                    break;
                case "comedy":
                    thisAmount = 30000;
                    if (aPerformance.audience > 20) {
                        thisAmount += 10000 + 500 * (aPerformance.audience - 20);
                    }
                    thisAmount += 300 * aPerformance.audience;
                    break;
                default:
                    throw new Error("unknown type: ${play.type}");
            }

            // add volume credits
            volumeCredits += Math.max(aPerformance.audience - 30, 0);
            // add extra credit for every ten comedy attendees
            if ("comedy" == aPlay.type) volumeCredits += Math.floor(aPerformance.audience / 5);

            // print line for this order
            result += String.format("  %s: %s (%s seats)\n", aPlay.name, currencyFormat.format(thisAmount / 100), aPerformance.audience);
            totalAmount += thisAmount;
        }
        result += String.format("Amount owed is %s\n", currencyFormat.format(totalAmount / 100));
        result += String.format("You earned %s credits\n", volumeCredits);
        return result;
    }

}
