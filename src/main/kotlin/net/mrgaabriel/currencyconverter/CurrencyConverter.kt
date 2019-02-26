package net.mrgaabriel.currencyconverter

import com.github.kevinsawicki.http.HttpRequest
import com.github.salomonbrys.kotson.double
import com.github.salomonbrys.kotson.obj
import com.github.salomonbrys.kotson.string
import com.google.gson.JsonParser

object CurrencyConverter {

    /**
     * Converts quantity from a currency to another
     *
     * @param quantity = Quantity of FROM currency to be converted
     * @param from = FROM currency
     * @param to = TO currency
     *
     * @sample convert(1.50, "USD". "BRL")
     * @throws CurrencyConvertException if any currency is not valid or if the response code of the API is not OK
     *
     * @return result of the conversion
     */
    fun convert(quantity: Double, from: String, to: String): Double {
        val fromCurrency = CurrencyConverterUtils.getCurrencyCodes().firstOrNull { it == from }
        val toCurrency = CurrencyConverterUtils.getCurrencyCodes().firstOrNull { it == to }

        if (fromCurrency == null)
            throw CurrencyConvertException("\"${from.toUpperCase()}\" is not a valid currency code!")

        if (toCurrency == null)
            throw CurrencyConvertException("\"${to.toUpperCase()}\" is not a valid currency code!")

        val url = "https://api.exchangeratesapi.io/latest?base=$fromCurrency"

        val request = HttpRequest.get(url)
            .accept("application/json")
            .userAgent("Mozilla/5.0 (X11; Linux x86_64; rv:65.0) Gecko/20100101 Firefox/65.0")

        if (!request.ok())
            throw CurrencyConvertException("Request is not OK! Request body : ${request.body()}")

        val body = request.body()
        val payload = JsonParser().parse(body).obj

        val rates = payload["rates"].obj
        val value = rates[toCurrency].double

        return value
    }

    /**
     * Converts quantity from a currency to another
     *
     * @param quantity = Quantity of FROM currency to be converted
     * @param from = FROM currency
     * @param to = TO currency
     *
     * @sample convert(1, "USD". "BRL")
     * @throws CurrencyConvertException if any currency is not valid or if the response code of the API is not OK
     *
     * @return result of the conversion
     */
    fun convert(quantity: Int, from: String, to: String): Double {
        val fromCurrency = CurrencyConverterUtils.getCurrencyCodes().firstOrNull { it == from }
        val toCurrency = CurrencyConverterUtils.getCurrencyCodes().firstOrNull { it == to }

        if (fromCurrency == null)
            throw CurrencyConvertException("\"${from.toUpperCase()}\" is not a valid currency code!")

        if (toCurrency == null)
            throw CurrencyConvertException("\"${to.toUpperCase()}\" is not a valid currency code!")

        val url = "https://api.exchangeratesapi.io/latest?base=$fromCurrency"

        val request = HttpRequest.get(url)
            .accept("application/json")
            .userAgent("Mozilla/5.0 (X11; Linux x86_64; rv:65.0) Gecko/20100101 Firefox/65.0")

        if (!request.ok())
            throw CurrencyConvertException("Request is not OK! Request body : ${request.body()}")

        val body = request.body()
        val payload = JsonParser().parse(body).obj

        val rates = payload["rates"].obj
        val value = rates[toCurrency].double

        return value
    }


}