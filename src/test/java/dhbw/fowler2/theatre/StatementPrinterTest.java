package dhbw.fowler2.theatre;

import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StatementPrinterTest {

    List<Play> plays;

    @Before
    public void initialize(){
        plays = List.of(new Play("Hamlet", "tragedy"),
                new Play("As You Like It", "comedy"),
                new Play("Othello", "tragedy"));
    }

    @Test
    public void printsStatements() {

        Invoice invoice = new Invoice("BigCo", List.of(new Performance(plays.get(0), 55),
                new Performance(plays.get(1), 35),
                new Performance(plays.get(2), 40)));

        StatementPrinter statementPrinter = new StatementPrinter();
        var result = statementPrinter.print(invoice);

        Assert.assertEquals("Statement print mismatch", "Statement for BigCo\n" +
                "  Hamlet: $650.00 (55 seats)\n" +
                "  As You Like It: $580.00 (35 seats)\n" +
                "  Othello: $500.00 (40 seats)\n" +
                "Amount owed is $1,730.00\n" +
                "You earned 47 credits\n", result);
    }

    @Test
    public void printsHtmlStatements() {

        Invoice invoice = new Invoice("BigCo", List.of(new Performance(plays.get(0), 55),
                new Performance(plays.get(1), 35),
                new Performance(plays.get(2), 40)));

        StatementPrinter statementPrinter = new StatementPrinter();
        var result = statementPrinter.printHtml(invoice);

        Assert.assertEquals("Statement print mismatch", "<h1>Statement for BigCo</h1>\n" +
                "<table>\n" +
                "  <tr><th>Play</th><th>Seats</th><th>Price</th></tr>\n" +
                "  <tr><td>Hamlet</td><td>55</td><td>$650.00</td></tr>\n" +
                "  <tr><td>As You Like It</td><td>35</td><td>$580.00</td></tr>\n" +
                "  <tr><td>Othello</td><td>40</td><td>$500.00</td></tr>\n" +
                "</table>\n" +
                "<p>Amount owed is <em>$1,730.00</em></p>\n" +
                "<p>You earned <em>47</em> credits</p>\n", result);
    }

}
