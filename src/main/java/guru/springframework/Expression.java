package guru.springframework;

public interface Expression {

    Money reduce(Bank bank, String toCurrency);

    Expression plus(Expression addmend);

    Expression times(int multiplier);
}
