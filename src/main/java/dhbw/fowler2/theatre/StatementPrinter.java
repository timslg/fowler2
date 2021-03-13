package dhbw.fowler2.theatre;


public class StatementPrinter {

    public String print(Invoice invoice) {
        return new PlainTextStatement(invoice).value();
    }

    public String printHtml(Invoice invoice) {
        return new HtmlStatement(invoice).value();
    }

}
