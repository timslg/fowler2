package dhbw.fowler2.theatre;

import java.text.NumberFormat;
import java.util.Locale;

public class StatementPrinter {

    public String print(Invoice invoice) {
        return new PlainTextStatement(invoice).value();
    }

}
