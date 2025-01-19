# Ejercicio: Sistema de Logística y Envío de Paquetes

## Descripción del Problema
Una empresa de logística ofrece diferentes métodos de transporte para el envío de paquetes. Dependiendo de las características de cada pedido (peso, tamaño, urgencia, destino internacional o nacional, etc.), el sistema debe decidir qué método de transporte es el adecuado:

- **Transporte Terrestre** (camión o furgoneta)
- **Transporte Aéreo** (avión)
- **Transporte Marítimo** (barco)

Por ejemplo:
- Si el paquete es urgente y ligero, podría enviarse por **avión**.
- Si el paquete es muy pesado, convendría enviarlo por **barco** (aunque tarde más).
- Si el destino está cerca y los tiempos de entrega no son tan estrictos, se envía por **camión**.

Necesitamos una **clase fábrica** que, según ciertos criterios (tipo de carga, urgencia, destino, etc.), **cree el objeto de transporte adecuado** sin que el resto del sistema tenga que preocuparse por instanciar explícitamente las clases concretas.

---

## Objetivos

1. **Diseñar una Interfaz (o Clase Abstracta) “Transporte”**
    - Debe tener al menos un método, por ejemplo: `entregarPaquete(Paquete p)`, que implemente la lógica para simular la entrega.

2. **Crear Clases Concretas**
    - **TransporteTerrestre** (camión, furgoneta)
    - **TransporteAereo** (avión)
    - **TransporteMaritimo** (barco)

3. **Definir una Fábrica de Transporte**
    - Un método (por ejemplo, `crearTransporte(TipoPaquete tipo, bool esUrgente, ...)`) que devuelva el objeto **Transporte** correspondiente.

4. **Implementar la Lógica**
    - Dentro de la fábrica, utiliza la información del paquete (peso, volumen, urgencia, etc.) para decidir si creas un **TransporteTerrestre**, **TransporteAereo** o **TransporteMaritimo**.
    - El resto del sistema solo llamará a la fábrica y recibirá un objeto de tipo **Transporte** para usarlo, sin saber qué clase concreta se instanció.
