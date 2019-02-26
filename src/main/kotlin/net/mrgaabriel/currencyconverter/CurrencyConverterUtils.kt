package net.mrgaabriel.currencyconverter

import java.util.*

object CurrencyConverterUtils {

    fun getCurrencies(): Set<Currency> {
        return Currency.getAvailableCurrencies()
    }

    fun getCurrencyCodes(): List<String> {
        return getCurrencies().map { it.currencyCode }
    }
}