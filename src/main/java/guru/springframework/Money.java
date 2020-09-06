package guru.springframework;

public class Money implements Expression {

    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    protected String currency() {
        return currency;
    }

    public Money times(int multiplier) {
        return new Money(amount * multiplier, this.currency);
    }

    public static Money dollar (int amount) {
        return new Money(amount, "USD");
    }

    public static Money franc (int amount) {
        return new Money(amount, "CHF");
    }

    public Expression plus(Money addmend) {
        return new Sum(this, addmend);
    }

    public Money reduce(String toCurrency) {
        return this;
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
