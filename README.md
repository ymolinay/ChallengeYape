# Challenge Yape

Esta es una app que muestra una lista de recetas y su información detallada, incluyendo un mapa con la ubicación de origen de cada platillo.

Está hecha con **Kotlin**, **Jetpack Compose** para las interfaces de usuario, **Hilt** para la inyección de dependencias, **Retrofit** para el consumo de WS API, **Google Maps** para mapas.

---

## Modularización de la app
Aunque se trata de una app pequeña, se decidió modularizar el proyecto con el fin de hacer la app escalable, y también demostrar conocimientos en modularización.

Si la app crece, es más fácil mantener cada parte por separado.
Permitiría reutilizar código en otras apps.
Hace que las pruebas y los cambios sean más ordenados.

`app` → Módulo principal, donde los componentes de UI y se maneja la navegación.
`data` → Donde se maneja la conexión con el API y el mapeo de datos.
`domain` → Contiene la "lógica de negocio", es decir, las reglas que hacen que la app funcione correctamente (Use Case).

---

## Tecnologías y Librerías
| Tecnología | Propósito |
|------------|----------|
| Jetpack Compose | UI declarativa |
| Hilt | Inyección de dependencias |
| Retrofit | Consumo de API REST |
| Gson | Mapeo de JSON a Kotlin |
| Coroutines & Flow | Programación asíncrona y manejo de estados |
| Google Maps | Visualización de mapas y ubicación |