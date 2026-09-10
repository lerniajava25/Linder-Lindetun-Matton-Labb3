# Reflektion om hur Spring Boot underlättar utvecklingen.
## Generellt
- Spring Boot sköter konvertering av objekt till JSON med Jackson automatiskt, gör koden mer läsbar
- Beans i Spring Boot sköter skapande av objekt och dependency injection automatiskt

## Annotationer
- Förenklar produktionen av kod för kommunikation med servern
- Spring Boot har mycket inbyggd funktionalitet behind-the-scenes för säkerhet som man slipper tänka på själv

# Jämförelse av Java/Spring Boot-plattformen mot Node.js
## Dependencies
- Jämfört med Node.js sköter Spring Boot konfiguration av bibliotek och ramverk som används i projektet automatiskt. I Node krävs det mycket manuell konfiguration i exempelvis `package.json`-filen

## Inbyggda Servrar
- Spring Boot har en inbyggd webbserver via Tomcat som kan köras out-of-the-box, medans man i Node behöver använda något externt bibliotek som exempelvis `express.js`

## Testning
- Med Spring Boot följer testramverket JUnit med och konfigureras automatiskt. I Node behöver man använda ett externt bibliotek för detta också, exempelvis `Jest`
