package eshop.repositorypattern;

public class Money {
    enum Currency {
        EUR,
        USD,
        MDL
    }

    private Integer amount;
    private Currency currency;

    public Money(Integer amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return " " + amount + " " + currency + "]";
    }

}
