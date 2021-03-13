package dhbw.fowler2.theatre;

import java.text.NumberFormat;
import java.util.Locale;

public abstract class Statement {

    protected Invoice invoice;

    protected Statement(Invoice invoice) {
        this.invoice = invoice;
    }

    public String value() {
        String result = header();
        for(Performance aPerformance : invoice.performances) {
            result += position(aPerformance);
        }
        result += footer();

        return result;
    }

    protected abstract String header();

    protected abstract String position(Performance aPerformance);

    protected abstract String footer();

    protected String usd(long aNumber) {
        return NumberFormat.getCurrencyInstance(Locale.US).format(aNumber);
    }

}
