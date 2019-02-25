package net.mrgaabriel.currencyconverter

import com.github.kevinsawicki.http.HttpRequest
import com.github.salomonbrys.kotson.double
import com.github.salomonbrys.kotson.obj
import com.google.gson.JsonParser
import java.util.*

object CurrencyConverter {

    /**
     * Converts quantity from a currency to another using Brazil Central Bank API
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
    fun convert(quantity: Double, from: String, to: String): Double {
        val fromCode = CurrencyConverterUtils.getCurrencyCode(from.toUpperCase())
        val toCode = CurrencyConverterUtils.getCurrencyCode(to.toUpperCase())

        if (fromCode == null)
            throw CurrencyConvertException("\"${from.toUpperCase()}\" is not a valid currency code!")

        if (toCode == null)
            throw CurrencyConvertException("\"${to.toUpperCase()}\" is not a valid currency code!")

        val calendar = Calendar.getInstance()

        // Pega a última sexta-feira
        val dayOfMonth = if (calendar[Calendar.DAY_OF_WEEK] == 7) { // Sábado
            calendar[Calendar.DAY_OF_MONTH] - 1
        } else if (calendar[Calendar.DAY_OF_WEEK] == 1) { // Domingo
            calendar[Calendar.DAY_OF_MONTH] - 2
        } else {
            calendar[Calendar.DAY_OF_MONTH]
        }

        val url = "https://www3.bcb.gov.br/bc_moeda/rest/converter/$quantity/1/$fromCode/$toCode/${calendar[Calendar.YEAR]}-${calendar[Calendar.MONTH] + 1}-$dayOfMonth"

        val request = HttpRequest.get(url)
            .accept("application/json")
            .userAgent("Mozilla/5.0 (X11; Linux x86_64; rv:65.0) Gecko/20100101 Firefox/65.0")

        if (!request.ok())
            throw CurrencyConvertException("Request to BCB is not OK! Request body : ${request.body()}")

        val body = request.body()
        val payload = JsonParser().parse(body).obj

        return payload["value"].double
    }

}