package com.alura.conversorMoneda.calculos;

import java.util.Map;

public class CurrencyConverter {
    public static double convert(double amount, String fromCurrency, String toCurrency, Map<String, Double> rates) {
        if (!rates.containsKey(fromCurrency) || !rates.containsKey(toCurrency)) {
            throw new IllegalArgumentException("Código de moneda no válido.");
        }

        double rateFromUSD = rates.get(toCurrency);
        double rateToUSD = rates.get(fromCurrency);

        // Convertimos primero a USD (base), luego a moneda destino
        double amountInUSD = amount / rateToUSD;
        return amountInUSD * rateFromUSD;
    }
}
