package singlefiles;

public class CurrencyExchangeClone {
    public static void main(String[] args) {
        Currency todaysCurrency = new Currency("EUR", "MDL", 17.50f, "2020-01-01");
        Currency tomorrowsCurrency = todaysCurrency.setDate("2020-01-02");
        tomorrowsCurrency = tomorrowsCurrency.setValue(18f);

        System.out.println(todaysCurrency);
        System.out.println(tomorrowsCurrency);
    }
}

final class Currency implements Cloneable {
    private String baseCode;
    private String code;
    private Float value;
    private String date;
    private Currency clonedCurrency;

    public Currency(String baseCode, String code, Float value, String date) {
        this.baseCode = baseCode;
        this.code = code;
        this.value = value;
        this.date = date;
    }

    public String getBaseCode() {
        return baseCode;
    }

    public Currency setBaseCode(String baseCode) {
        clonedCurrency = clone();
        clonedCurrency.baseCode = baseCode;
        return clonedCurrency;
    }

    public String getCode() {
        return code;
    }

    public Currency setCode(String code) {
        clonedCurrency = clone();
        clonedCurrency.code = code;
        return clonedCurrency;
    }

    public Float getValue() {
        return value;
    }

    public Currency setValue(Float value) {
        clonedCurrency = clone();
        clonedCurrency.value = value;
        return clonedCurrency;
    }

    public String getDate() {
        return date;
    }

    public Currency setDate(String date) {
        clonedCurrency = clone();
        clonedCurrency.date = date;
        return clonedCurrency;
    }

    public Currency clone() {
        try {
            return (Currency) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return "Currency [baseCode=" + baseCode + ", code=" + code + ", value=" + value + ", date=" + date + "]";
    }

}
