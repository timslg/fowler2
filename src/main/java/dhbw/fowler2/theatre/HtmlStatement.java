package dhbw.fowler2.theatre;

public class HtmlStatement extends Statement {

    public HtmlStatement(Invoice invoice) {
        super(invoice);
    }

    @Override
    protected String header() {
        var result = String.format("<h1>Statement for %s</h1>\n", invoice.customer);
        result += "<table>\n";
        result += "  <tr><th>Play</th><th>Seats</th><th>Price</th></tr>\n";
        return result;
    }

    @Override
    protected String position(Performance aPerformance) {
        return String.format("  <tr><td>%s</td><td>%s</td><td>%s</td></tr>\n", aPerformance.getPlay().name, aPerformance.audience, usd(aPerformance.getAmount() / 100));
    }

    @Override
    protected String footer() {
        var result = "</table>\n";
        result += String.format("<p>Amount owed is <em>%s</em></p>\n", usd(invoice.getTotalAmount() / 100));
        result += String.format("<p>You earned <em>%s</em> credits</p>\n", invoice.getTotalVolumeCredits());
        return result;
    }

}
