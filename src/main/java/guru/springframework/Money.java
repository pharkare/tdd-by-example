package guru.springframework;

public class Money implements Expression {

    protected final int amount;
    protected final String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Money dollar (int amount) {
        return new Money(amount, "USD");
    }

    public static Money franc (int amount) {
        return new Money(amount, "CHF");
    }

    protected String currency() {
        return currency;
    }

    @Override
    public Expression times(int multiplier) {
        return new Money(amount * multiplier, this.currency);
    }

    @Override
    public Expression plus(Expression addmend) {
        return new Sum(this, addmend);
    }

    @Override
    public Money reduce(Bank bank, String toCurrency) {
        return new Money (amount / bank.rate(this.currency, toCurrency), toCurrency);
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj || this.getClass() != obj.getClass()) return false;
        Money money = (Money) obj;
        return amount == money.amount && this.currency.equals(money.currency);
    }

    @Override
    public String toString() {
        return String.format("Money{amount=%s, currency='%s'}", amount, currency);
    }
}
