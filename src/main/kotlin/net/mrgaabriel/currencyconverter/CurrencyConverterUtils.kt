package net.mrgaabriel.currencyconverter

import com.github.kevinsawicki.http.HttpRequest
import com.github.salomonbrys.kotson.obj
import com.github.salomonbrys.kotson.toMap
import com.google.gson.JsonParser

object CurrencyConverterUtils {

    fun getCurrencyCodes(): Set<String> {
        val request = HttpRequest.get("https://api.exchangeratesapi.io/latest")
            .accept("application/json")
            .userAgent("Mozilla/5.0 (X11; Linux x86_64; rv:65.0) Gecko/20100101 Firefox/65.0")

        if (!request.ok())
            throw RuntimeException("Request is not OK! Request body: ${request.body()}")

        val payload = JsonParser().parse(request.body()).obj
        val rates = payload["rates"].obj

        return rates.toMap().keys
    }
}