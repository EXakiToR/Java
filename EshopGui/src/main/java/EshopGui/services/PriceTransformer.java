package EshopGui.services;

import EshopGui.domain.Currency;
import EshopGui.domain.HasPrice;
import EshopGui.domain.Money;

public class PriceTransformer {

    public Money transformPrice(HasPrice item, CurrencyService service) {

        Currency newCurrency = service.getData().get(service.getActiveCurrency());
        //BUG: Product price becomes cheaper when switching USD and EUR currencies back and forth! 
        Money transformedPrice = new Money(
                (int) (item.getPrice().getAmount()
                        * (item.getPrice().getCurrency().getRatio() / newCurrency.getRatio())),
                newCurrency);
        return transformedPrice;
    }

}
