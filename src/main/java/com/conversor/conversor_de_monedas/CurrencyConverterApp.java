package com.conversor.conversor_de_monedas;

import com.conversor.conversor_de_monedas.service.ExchangeRateService;
import java.util.Scanner;

public class CurrencyConverterApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExchangeRateService exchangeRateService = new ExchangeRateService();

        System.out.println("Bienvenido al conversor de monedas!");

        while (true) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Convertir monedas");
            System.out.println("2. Salir");
            System.out.print("Opción: ");
            int option = scanner.nextInt();

            if (option == 2) {
                break;
            }

            if (option == 1) {
                // Solicitar moneda base, objetivo y cantidad
                System.out.print("Ingrese la moneda base (ejemplo: USD): ");
                String baseCurrency = scanner.next();
                System.out.print("Ingrese la moneda objetivo (ejemplo: ARS): ");
                String targetCurrency = scanner.next();
                System.out.print("Ingrese la cantidad a convertir: ");
                double amount = scanner.nextDouble();

                // Llamar a convertCurrency para obtener el resultado
                double convertedAmount = exchangeRateService.convertCurrency(baseCurrency, targetCurrency, amount);

                if (convertedAmount != 0) {
                    // Convertir el valor a String antes de mostrarlo
                    System.out.println(amount + " " + baseCurrency + " es igual a " + String.valueOf(convertedAmount) + " " + targetCurrency);
                }
            }
        }

        scanner.close();
    }
}
