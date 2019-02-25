package net.mrgaabriel.currencyconverter

object CurrencyConverterUtils {

    private val CURRENCIES = mapOf<String, Int>(
        "AFN" to 5,
        "ZAR" to 785,
        "ALL" to 490,
        "DEM" to 610,
        "EUR" to 978,
        "ADP" to 690,
        "AOA" to 635,
        "XCD" to 215,
        "XCD" to 215,
        "SAR" to 820,
        "DZD" to 95,
        "ARG" to 10,
        "ARS" to 706,
        "AMD" to 275,
        "AWG" to 328,
        "AUD" to 150,
        "ATS" to 940,
        "EUR" to 978,
        "AZN" to 607,
        "BSD" to 155,
        "BHD" to 105,
        "BDT" to 905,
        "BBD" to 175,
        "BYN" to 831,
        "BYR" to 829,
        "BEF" to 360,
        "EUR" to 978,
        "BZD" to 180,
        "XOF" to 372,
        "BMD" to 160,
        "BOB" to 30,
        "BAM" to 612,
        "BWP" to 755,
        "CZ$" to 79,
        "CR$" to 80,
        "CR$" to 83,
        "CR$" to 85,
        "BRL" to 790,
        "NCZ$" to 78,
        "BND" to 185,
        "REP" to 510,
        "XOF" to 372,
        "BIF" to 365,
        "BTN" to 665,
        "CVE" to 295,
        "XAF" to 370,
        "KHR" to 825,
        "CAD" to 165,
        "QAR" to 800,
        "KYD" to 190,
        "KZT" to 913,
        "XAF" to 370,
        "CLF" to 197,
        "CLP" to 715,
        "CLF" to 916,
        "CNY" to 795,
        "CNH" to 796,
        "CYP" to 520,
        "EUR" to 978,
        "SGD" to 195,
        "COP" to 720,
        "KMF" to 368,
        "XAF" to 370,
        "CDF" to 363,
        "ZRN" to 970,
        "ZRN" to 971,
        "NZD" to 245,
        "KPW" to 925,
        "KRW" to 930,
        "BUA" to 995,
        "FUA" to 996,
        "XOF" to 372,
        "CRC" to 40,
        "KWD" to 100,
        "HRK" to 779,
        "CUP" to 725,
        "ANG" to 325,
        "DKK" to 55,
        "DJF" to 390,
        "XCD" to 215,
        "EGP" to 535,
        "SVC" to 45,
        "AED" to 145,
        "ECS" to 895,
        "ERN" to 625,
        "SKK" to 58,
        "EUR" to 978,
        "SIT" to 914,
        "EUR" to 978,
        "EUR" to 978,
        "ESP" to 700,
        "USD" to 220,
        "EEK" to 57,
        "EUR" to 978,
        "ETB" to 9,
        "FKP" to 545,
        "FJD" to 200,
        "PHP" to 735,
        "EUR" to 978,
        "FIM" to 615,
        "TWD" to 640,
        "FRF" to 395,
        "EUR" to 978,
        "XAF" to 370,
        "GMD" to 90,
        "GHS" to 35,
        "GEL" to 482,
        "GIP" to 530,
        "XCD" to 215,
        "GRD" to 270,
        "EUR" to 978,
        "EUR" to 978,
        "GTQ" to 770,
        "GBP" to 540,
        "GYD" to 170,
        "EUR" to 978,
        "GNF" to 398,
        "GWP" to 738,
        "XOF" to 372,
        "XAF" to 370,
        "HTG" to 440,
        "HNL" to 495,
        "HKD" to 205,
        "CNH" to 796,
        "HUF" to 345,
        "YER" to 810,
        "INR" to 860,
        "IDR" to 865,
        "REP" to 815,
        "IQD" to 115,
        "IEP" to 550,
        "EUR" to 978,
        "ISK" to 60,
        "ILS" to 880,
        "ITL" to 595,
        "EUR" to 978,
        "JMD" to 230,
        "JPY" to 470,
        "GBP" to 540,
        "JOD" to 125,
        "REP" to 780,
        "LSL" to 603,
        "LVL" to 485,
        "EUR" to 978,
        "LBP" to 560,
        "LRD" to 235,
        "LYD" to 130,
        "CHF" to 425,
        "LTL" to 601,
        "EUR" to 978,
        "EUR" to 978,
        "LUF" to 400,
        "MOP" to 685,
        "MKD" to 132,
        "MGF" to 405,
        "MGA" to 406,
        "M$" to 240,
        "MYR" to 828,
        "MWK" to 760,
        "MVR" to 870,
        "XOF" to 372,
        "MTL" to 565,
        "EUR" to 978,
        "GBP" to 540,
        "MAD" to 139,
        "USD" to 220,
        "EUR" to 978,
        "MUR" to 840,
        "MRU" to 671,
        "MRO" to 670,
        "MEX$" to 740,
        "MXN" to 741,
        "MMK" to 775,
        "MZM" to 620,
        "MZN" to 622,
        "REP" to 503,
        "EUR" to 978,
        "MNT" to 915,
        "EUR" to 978,
        "XCD" to 215,
        "NAD" to 173,
        "NPR" to 845,
        "NIO" to 51,
        "XOF" to 372,
        "NGN" to 630,
        "NZD" to 245,
        "NOK" to 65,
        "NZD" to 245,
        "OMR" to 805,
        "EUR" to 978,
        "NLG" to 335,
        "PAB" to 20,
        "PGK" to 778,
        "PKR" to 875,
        "PYG" to 450,
        "I" to 480,
        "PEN" to 660,
        "S/." to 890,
        "XPF" to 380,
        "PLN" to 975,
        "USD" to 220,
        "PTE" to 315,
        "EUR" to 978,
        "KES" to 950,
        "KGS" to 892,
        "GBP" to 540,
        "XAF" to 370,
        "DOP" to 730,
        "RON" to 506,
        "ROL" to 505,
        "RWF" to 420,
        "RUB" to 830,
        "ANG" to 325,
        "SBD" to 250,
        "WS$" to 910,
        "WST" to 911,
        "WST" to 912,
        "EUR" to 978,
        "SHP" to 570,
        "XCD" to 215,
        "XCD" to 215,
        "STD" to 148,
        "XCD" to 215,
        "XOF" to 372,
        "SLL" to 500,
        "DIN" to 120,
        "RSD" to 133,
        "YUM" to 637,
        "SCR" to 850,
        "REP" to 575,
        "SOS" to 960,
        "LKR" to 855,
        "SZL" to 585,
        "SDG" to 134,
        "LSD" to 580,
        "SSP" to 136,
        "SEK" to 70,
        "CHF" to 425,
        "SRD" to 255,
        "SRG" to 330,
        "SRD" to 333,
        "TJS" to 835,
        "THB" to 15,
        "TSH" to 945,
        "TZS" to 946,
        "CZK" to 75,
        "TPE" to 320,
        "XOF" to 372,
        "TOP" to 680,
        "TTD" to 210,
        "TND" to 135,
        "TMT" to 608,
        "TRL" to 600,
        "TRY" to 642,
        "UAH" to 460,
        "UGX" to 955,
        "UYU" to 745,
        "UZS" to 893,
        "VUV" to 920,
        "VES" to 27,
        "VEB" to 25,
        "VEF" to 26,
        "VND" to 260,
        "USD" to 220,
        "USD" to 220,
        "ZMW" to 766,
        "ZMK" to 765,
        "ZWL" to 217,
        "ETB" to 8,
        "NIC" to 50,
        "RUR" to 88,
        "SDR" to 138,
        "ETB" to 225,
        "FBF" to 361,
        "BIF" to 385,
        "MF" to 410,
        "IL" to 555,
        "M" to 605,
        "MXN" to 645,
        "MXN" to 646,
        "N$" to 650,
        "ZRN" to 663,
        "UAK" to 776,
        "XEU" to 918,
        "XAG" to 991,
        "XPD" to 993,
        "PLAT" to 994,
        "XAU" to 998,
        "YD" to 110
    )

    fun getCurrencyCodes(): Map<String, Int> {
        return CURRENCIES
    }

    fun getCurrencyCode(code: String): Int? {
        return CURRENCIES[code]
    }
}