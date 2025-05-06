# 💱 Conversor de Moneda en Java

Este proyecto es una aplicación de consola escrita en Java que permite convertir entre distintas monedas utilizando tasas de cambio en tiempo real obtenidas desde una API externa. El programa ofrece un **menú interactivo** para que el usuario seleccione monedas, ingrese montos y visualice resultados.

---

## 📌 Características

- Obtiene tasas de cambio en tiempo real desde [ExchangeRate-API](https://www.exchangerate-api.com/)
- Permite convertir entre monedas seleccionadas por el usuario
- Presenta un menú de interacción para múltiples conversiones
- Usa `HttpClient` para llamadas HTTP y `Gson` para parsear el JSON
- Arquitectura modular (separación de lógica, modelo de datos y UI)

---

## 🎬 Ejemplo de Uso

=== Conversor de Monedas ===
Seleccione una opción:

Convertir moneda

Salir
Opción: 1

Ingrese el monto: 1000
Seleccione moneda origen (ej: USD): USD
Seleccione moneda destino (ej: ARS): COP

Resultado: 1000.00 USD equivale a 3960000.00 COP

## 🧰 Tecnologías Usadas

- Java 17+
- API pública: [ExchangeRate-API](https://www.exchangerate-api.com/)
- Gson (parseo JSON)
- IntelliJ IDEA (recomendado para correr el proyecto)

---

## ⚙️ ¿Cómo Ejecutarlo?

### Clona el proyecto

```bash
git clone https://github.com/JesusRamon2192/conversorMoneda.git
cd conversorMoneda