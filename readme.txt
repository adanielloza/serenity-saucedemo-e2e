Proyecto: Serenity BDD - E2E Purchase Flow (SauceDemo)
URL bajo prueba: https://www.saucedemo.com/

1. Descripción
Este repositorio contiene una prueba automatizada E2E (end-to-end) que valida un flujo de compra en SauceDemo:
- Login con standard_user / secret_sauce
- Agregar 2 productos al carrito
- Visualizar carrito
- Completar formulario de checkout
- Finalizar compra y validar confirmación

2. Tecnologías y versiones usadas
- Java: 17 (compilación configurada con maven.compiler.release=17)
- Maven: 3.9.10
- Serenity BDD: 4.2.7
- Cucumber (integración Serenity): Serenity Cucumber (versión alineada a Serenity 4.2.7)
- Selenium (transitivo por Serenity): 4.x
- Navegador: Google Chrome (probado localmente)

Nota: Si tu entorno usa otra versión de Chrome, puede aparecer un WARNING relacionado a CDP; no bloquea la ejecución en este ejercicio.

3. Requisitos previos
- Tener instalado Java 17 y Maven 3.9+
- Tener Google Chrome instalado
- Conexión a internet (la prueba navega a saucedemo.com)

4. Estructura relevante del proyecto
- src/test/resources/features/purchase_flow.feature
- src/test/java/e2e/stepdefinitions/... (Step Definitions)
- src/test/java/e2e/steps/... (Steps Serenity)
- src/test/java/e2e/pages/... (Page Objects)
- serenity.conf
- pom.xml

5. Cómo ejecutar la prueba
Desde la carpeta raíz del proyecto:

1. Descargar dependencias y ejecutar:
   mvn clean verify

2. Resultado esperado:
- Build SUCCESS
- Se genera el reporte Serenity en:
  target/site/serenity/index.html

6. Cómo abrir el reporte Serenity
En macOS:
- open target/site/serenity/index.html

Alternativa (reporte “congelado” incluido en el repo):
- open reports/serenity/index.html

7. Consideraciones
- El directorio "target" se elimina con 'mvn clean'. Por eso el repo incluye un reporte copiado en:
  reports/serenity/
  para facilitar la revisión sin necesidad de ejecutar el proyecto.