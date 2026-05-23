# Virtual Store - Design Patterns

## Descripción del problema

El proyecto consiste en la implementación de una tienda virtual desarrollada en Java.

La tienda permite:
- Registrar productos
- Agregar productos al carrito de compras
- Aplicar descuentos
- Procesar pagos
- Confirmar órdenes
- Notificar automáticamente diferentes componentes del sistema

El objetivo principal es aplicar patrones de diseño en un problema real orientado a objetos.


# Patrones de Diseño Implementados

## Strategy Pattern

El patrón Strategy fue utilizado para implementar diferentes estrategias de descuento sin modificar la clase Cart.

Se implementaron las siguientes estrategias:
- NoDiscountStrategy
- PercentageDiscountStrategy
- FixedAmountDiscountStrategy

Esto permite cambiar dinámicamente el algoritmo de descuento durante la ejecución del sistema.


## Adapter Pattern

El patrón Adapter fue utilizado para integrar un servicio externo de PayPal con el sistema de pagos de la tienda.

La clase PayPalAdapter adapta la interfaz del servicio externo ExternalPayPalService a la interfaz PaymentProcessor utilizada por el sistema.

Esto permite integrar sistemas incompatibles sin modificar el código existente.


## Observer Pattern

El patrón Observer fue utilizado para notificar automáticamente diferentes componentes cuando una compra es confirmada.

Los observers implementados son:
- EmailNotificationObserver
- InventoryObserver
- AdminNotificationObserver

Cuando la orden es confirmada, todos los observers son notificados automáticamente.


# Ejemplo de salida en consola

```text
===== TIENDA VIRTUAL =====
--------------------------

PRODUCTOS EN CARRITO:
Laptop - S/ 2500.0
Mouse - S/ 80.0

--------------------------
Descuento aplicado: 10%

Total: S/ 2322.0

Pago realizado por PayPal: PEN 2322.0

Compra confirmada por S/ 2322.0

Enviamos correo al cliente...
Actualizando inventario...
Notificando al administrador...