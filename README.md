# GTA Radio Native Android App

Aplicación Android 100% nativa en Kotlin con Jetpack Compose y AndroidX Media3 (ExoPlayer), diseñada bajo **Clean Architecture** y principios **SOLID**.

## Características
- **5 Generaciones de Grand Theft Auto:** GTA III, Vice City, San Andreas, GTA IV y GTA V (60 emisoras oficiales).
- **Offline-First:** Detección automática de pistas locales en `/sdcard/GTA_Radio/` o streaming en línea.
- **Reloj de Emisión Virtual (`RadioClock`):** Sintonización en vivo continua calculada en tiempo real según el reloj del sistema.
- **Controles de Radio Clásica:** Salto de pista (⏮ / ⏭), reproducción en segundo plano (`MediaSessionService`) y controles en pantalla de bloqueo / notificaciones.
- **Código Limpio:** Arquitectura desacoplada, sin dependencias circulares ni archivos mayores a 250 líneas.

## Estructura del Almacenamiento Local (Offline)
Para reproducir sin conexión, coloca tus archivos de audio en:
```
Memoria interna/GTA_Radio/
  ├── GTA_III/
  ├── GTA_Vice_City/
  ├── GTA_San_Andreas/
  ├── GTA_IV/
  └── GTA_V/
```

## Requisitos de Compilación
- JDK 17+
- Android SDK (API 34 / Build Tools 34.0.0)
- Gradle 8.7
