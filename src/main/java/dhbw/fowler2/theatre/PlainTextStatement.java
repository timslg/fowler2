package dhbw.fowler2.theatre;

public class PlainTextStatement extends Statement {

    public PlainTextStatement(Invoice invoice) {
        super(invoice);
    }

    @Override
    protected String header() {
        return String.format("Statement for %s\n", super.invoice.customer);
    }

    @Override
    protected String position(Performance aPerformance) {
        return String.format("  %s: %s (%s seats)\n", aPerformance.getPlay().name, usd(aPerformance.getAmount() / 100), aPerformance.audience);
    }

    @Override
    protected String footer() {
        var result = String.format("Amount owed is %s\n", usd(invoice.getTotalAmount() / 100));
        result += String.format("You earned %s credits\n", invoice.getTotalVolumeCredits());
        return result;
    }

}
