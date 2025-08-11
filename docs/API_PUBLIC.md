# API Público — PueyoAbogadosApp2
**Versión:** v0.1.0

> Lo declarado aquí es **contrato estable**. Cambiarlo rompiendo compatibilidad implica subir versión (en 0.y → MINOR; ≥1.0 → MAJOR).

## 1. Qué entra en el contrato hoy
- **Rutas HTTP públicas**
  - **GET /**  
    Renderiza la vista JSP `home.jsp` mediante `InternalResourceViewResolver`  
    Prefijo: `/WEB-INF/views/`  
    Sufijo: `.jsp`

- **Recursos estáticos**
  - Servidos en **/resources/**\*\*

## 2. Qué NO es contrato
- Nombres de clases, paquetes o beans internos.
- Contenido de `home.jsp` salvo que se especifique en este documento.
- Endpoints no listados en esta sección.
- Configuraciones internas de Spring o Tomcat no expuestas como parte pública.

## 3. Cambios y compatibilidad
- **Compatible (MINOR/PATCH)**:
  - Añadir nuevos endpoints públicos sin eliminar los existentes.
  - Mejoras internas sin cambiar el comportamiento de `/`.
- **Incompatible (MAJOR a partir de 1.0 / MINOR en 0.y)**:
  - Eliminar o cambiar la ruta `/`.
  - Cambiar el mecanismo de resolución de vistas de forma que `/` deje de renderizar `home.jsp`.

## 4. Notas de implementación (informativas)
- `DispatcherServlet` mapeado a `/`.
- `InternalResourceViewResolver` con prefijo `/WEB-INF/views/` y sufijo `.jsp`.
- Controlador `Controller_Home` maneja `GET /` devolviendo `"home"`.
