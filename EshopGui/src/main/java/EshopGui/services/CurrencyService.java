package EshopGui.services;

import java.util.Map;

import EshopGui.domain.Currency;

public interface CurrencyService {
    Map<String, Currency> getData();
    String getActiveCurrency();
    void setActiveCurrency(String currency);
}
