package com.alura.conversorMoneda.modelos;

import java.util.Map;

public class ExchangeRateResponse {
    private String result;
    private String documentation;
    private String base_code;
    private Map<String, Double> conversion_rates;

    // Getters
    public String getResult() {
        return result;
    }

    public String getDocumentation() {
        return documentation;
    }

    public String getBaseCode() {
        return base_code;
    }

    public Map<String, Double> getConversionRates() {
        return conversion_rates;
    }
}
