# Changelog
Formato basado en [Keep a Changelog](https://keepachangelog.com/en/1.0.0/)  
y en [SemVer](https://semver.org/).

## [0.1.0] - 2025-08-11
### Added
- Endpoint público `GET /` que renderiza la vista `home.jsp`.
- Servido de recursos estáticos en `/resources/**`.
- Configuración MVC sin `web.xml` (`AppConfig` y `MyWebAppInitializer`).
- Estilo inicial `style_home.css` para `home.jsp`.
- Tests:
  - Unitario: `Controller_Home` devuelve `"home"`.
  - Integración: arranque de `WebApplicationContext` y existencia de bean `viewResolver`.
  - Integración (MockMvc): `GET /` → 200, vista lógica `"home"`, forward a `/WEB-INF/views/home.jsp`.

