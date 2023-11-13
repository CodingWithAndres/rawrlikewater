package org.example;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final BigDecimal USD_TO_EUR_RATE = new BigDecimal("0.85");
    private static final BigDecimal GBP_TO_JPY_RATE = new BigDecimal("150");

    private static final Map<String, BigDecimal> exchangeRates = new HashMap<>();

    static {
        //exchange rates
        exchangeRates.put("USD", BigDecimal.ONE);
        exchangeRates.put("EUR", USD_TO_EUR_RATE);
        exchangeRates.put("GBP", USD_TO_EUR_RATE.divide(new BigDecimal("0.85")).multiply(new BigDecimal("150")));
        exchangeRates.put("JPY", GBP_TO_JPY_RATE);
    }

    public static void main(String[] args) {
        ///different currencies
        BigDecimal amountInUSD = new BigDecimal("100");
        BigDecimal amountInEUR = convertCurrency(amountInUSD, "USD", "EUR");
        BigDecimal amountInGBP = convertCurrency(amountInUSD, "USD", "GBP");
        BigDecimal amountInJPY = convertCurrency(amountInGBP, "GBP", "JPY");

        //results
        displayConversion("USD", amountInUSD, "EUR", amountInEUR);
        displayConversion("USD", amountInUSD, "GBP", amountInGBP);
        displayConversion("GBP", amountInGBP, "JPY", amountInJPY);
    }

    private static BigDecimal convertCurrency(BigDecimal amount, String fromCurrency, String toCurrency) {
        BigDecimal fromRate = exchangeRates.get(fromCurrency);
        BigDecimal toRate = exchangeRates.get(toCurrency);

        if (fromRate == null || toRate == null) {
            throw new IllegalArgumentException("Invalid currency code");
        }

        return amount.multiply(toRate).divide(fromRate, 2, BigDecimal.ROUND_HALF_UP);
    }

    private static void displayConversion(String fromCurrency, BigDecimal fromAmount, String toCurrency, BigDecimal toAmount) {
        System.out.printf("Converted %.2f %s to %.2f %s%n", fromAmount, fromCurrency, toAmount, toCurrency);
    }
}

//  Setup: Create a new Java project and add a main class.
//
//    Defining Constants:
//        Define constants for each currency and its exchange rate.
//
//    Implementing Conversion Logic:
//        Use BigDecimal for all currency amounts and calculations.
//        Create a method to perform the conversion, taking into account the exchange rate.
//
//    Calculations:
//        Perform conversions for the predefined set of amounts.
//
//    Output Results:
//        Print the results of each conversion, showing both the original and converted amounts.
//
//Sample Starter Code:
//    private static final BigDecimal USD_TO_EUR_RATE = new BigDecimal("0.85");
//    private static final BigDecimal GBP_TO_JPY_RATE = new BigDecimal("150");