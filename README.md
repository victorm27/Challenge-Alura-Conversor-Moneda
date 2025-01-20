# Challenge-Alura-Conversor-Moneda
Este es un proyecto simple de conversión de monedas utilizando Java, Spring Boot, y una API externa para obtener tasas de cambio en tiempo real.

## Descripción

El proyecto permite a los usuarios convertir una cantidad de dinero de una moneda base a una moneda objetivo utilizando tasas de cambio actualizadas desde una API externa. El usuario puede elegir entre diferentes opciones del menú para realizar conversiones de divisas.

## Requisitos

- Java 17 o superior
- Maven
- Conexión a internet (para consultar la API externa de tasas de cambio)

## Instalación

1. Clona este repositorio en tu máquina local:

   ```bash
   git clone https://github.com/victorm27/Challenge-Alura-Conversor-Moneda.git

2. Navega a la carpeta del proyecto:
   ```bash
   cd conversor-de-monedas
   
3. Construye el proyecto con Maven:
   ```bash
   mvn clean install

4. Ejecuta la aplicación:
   ```bash
   mvn spring-boot:run
### La aplicación se ejecutará en el puerto 8080 de forma predeterminada.

## Uso
Una vez que la aplicación esté en ejecución, el menú interactivo te permitirá realizar las siguientes acciones:

1. Convertir monedas
2. Salir de la aplicación
   
Al seleccionar la opción de conversión de monedas, se te pedirá que ingreses:

La moneda base (por ejemplo, USD)
La moneda objetivo (por ejemplo, EUR)
La cantidad a convertir
La aplicación usará una API externa para obtener las tasas de cambio y calcular la cantidad equivalente en la moneda objetivo.

### Ejemplo de uso:
Bienvenido al conversor de monedas!

Seleccione una opción:
1. Convertir monedas
2. Salir
Opción: 1
Ingrese la moneda base (ejemplo: USD): USD
Ingrese la moneda objetivo (ejemplo: ARS): COP
Ingrese la cantidad a convertir: 100
Resultado: 100 USD = 400000 COP

## Tecnologías utilizadas
Java 17
Spring Boot
Gson (para manejar el JSON de la respuesta de la API)
HTTPURLConnection (para realizar solicitudes HTTP)


