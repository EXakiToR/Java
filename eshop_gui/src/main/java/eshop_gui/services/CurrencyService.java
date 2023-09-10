package eshop_gui.services;

import java.util.Map;

import eshop_gui.domain.Currency;

public interface CurrencyService {
    Map<String, Currency> getData();
    String getActiveCurrency();
    void setActiveCurrency(String currency);
}
