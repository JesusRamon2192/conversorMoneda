package com.alura.conversorMoneda.principal;

import com.alura.conversorMoneda.calculos.CurrencyConverter;
import com.alura.conversorMoneda.modelos.ExchangeRateResponse;
import com.google.gson.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .setPrettyPrinting()
                .create();

        String direccion = "https://v6.exchangerate-api.com/v6/014a11be7be38d3153cbf811/latest/USD";

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            ExchangeRateResponse exchangeData = gson.fromJson(json, ExchangeRateResponse.class);
            Map<String, Double> tasas = exchangeData.getConversionRates();

            Scanner scanner = new Scanner(System.in);
            boolean continuar = true;

            while (continuar) {
                Conversor.exibirMenu();
                int opcion = scanner.nextInt();
                scanner.nextLine(); // consumir línea

                String monedaOrigen = "";
                String monedaDestino = "";

                switch (opcion) {
                    case 1 -> { monedaOrigen = "USD"; monedaDestino = "ARS"; }
                    case 2 -> { monedaOrigen = "ARS"; monedaDestino = "USD"; }
                    case 3 -> { monedaOrigen = "USD"; monedaDestino = "BRL"; }
                    case 4 -> { monedaOrigen = "BRL"; monedaDestino = "USD"; }
                    case 5 -> { monedaOrigen = "USD"; monedaDestino = "COP"; }
                    case 6 -> { monedaOrigen = "COP"; monedaDestino = "USD"; }
                    case 7 -> {
                        System.out.println("Gracias por usar el conversor. ¡Hasta luego!");
                        continuar = false;
                        continue;
                    }
                    default -> {
                        System.out.println("Opción inválida. Intenta nuevamente.");
                        continue;
                    }
                }

                System.out.print("Ingrese el monto a convertir: ");
                double monto = scanner.nextDouble();

                try {
                    double resultado = CurrencyConverter.convert(monto, monedaOrigen, monedaDestino, tasas);
                    System.out.printf("%.2f %s equivale a %.2f %s\n", monto, monedaOrigen, resultado, monedaDestino);
                } catch (IllegalArgumentException e) {
                    System.out.println("Error en la conversión: " + e.getMessage());
                }
            }

            scanner.close();
        } catch (IOException | InterruptedException e) {
            System.err.println("Error al realizar la solicitud HTTP: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
