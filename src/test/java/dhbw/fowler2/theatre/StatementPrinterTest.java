package dhbw.fowler2.theatre;

import dhbw.fowler2.theatre.Play;
import dhbw.fowler2.theatre.Performance;
import dhbw.fowler2.theatre.StatementPrinter;
import dhbw.fowler2.theatre.Invoice;
import java.util.List;
import java.util.Map;
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
}
