package com.conversor.conversor_de_monedas.service;

import org.springframework.stereotype.Service;
import java.net.http.HttpClient;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class ExchangeRateService {

    private final HttpClient httpClient;
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/709fa345698bfe40ab56ebf0/latest";  // Asegúrate de poner tu clave API aquí

    public ExchangeRateService() {
        // Inicializamos el cliente HTTP
        this.httpClient = HttpClient.newHttpClient();
    }

    public String getExchangeRates(String baseCurrency) {
        try {
            // Construyendo la solicitud
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL + "/" + baseCurrency))
                    .GET()
                    .build();

            // Enviando la solicitud y obteniendo la respuesta
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // Verificar la respuesta antes de procesarla
            System.out.println("Respuesta de la API: " + response.body());

            // Retornando el cuerpo de la respuesta
            return response.body();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public double convertCurrency(String baseCurrency, String targetCurrency, double amount) {
        // Obtenemos los datos de las tasas de cambio
        String response = getExchangeRates(baseCurrency);

        if (response == null) {
            System.out.println("No se pudo obtener la tasa de cambio.");
            return 0;
        }

        // Parseamos el JSON
        JsonObject jsonObject = JsonParser.parseString(response).getAsJsonObject();
        JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

        // Verificamos si las monedas están disponibles
        if (!conversionRates.has(targetCurrency)) {
            System.out.println("Moneda objetivo no disponible.");
            return 0;
        }

        // Obtenemos la tasa de conversión
        double exchangeRate = conversionRates.get(targetCurrency).getAsDouble();

        // Realizamos la conversión
        return amount * exchangeRate;
    }
}
