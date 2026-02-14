# Datahandler
Detta projekt är byggt genom att använda
- Java 21
- Maven
- Spring Boot

Instruktionerna nedan är skrivna för att bygga och köra API-et på Windows då jag endast byggt och kört applikationen i den miljön.
Mac/Linux-användare kan behöva andra kommandon för att bygga och köra applikationen. 

## Bygg applikationen

### Bygg och paketera utan IDE
1. Öppna kommandotolken
2. Börja med att klona ner repot från GitHub genom att köra kommandot `git clone https://github.com/eemretsson/datahandler.git`
3. Använd kommandot `.\mvnw.cmd clean package` för att bygga och paketera projektet
4. En körbar .jar fil skapas här -> `target/datahandler-0.0.1-SNAPSHOT.jar`

### Bygg och paketera med IDE (Instruktioner för IntelliJ)
1. Starta IntelliJ
2. Börja med att klona ner repot från GitHub `https://github.com/eemretsson/datahandler.git`
2. Om inte projektet öppnas automatiskt efter kloning, öppna projektet genom att i menyn längst uppe till vänster välja File -> Open och gå sedan till root-foldern för projektet i utforskaren och välj Select Folder
3. Till höger i IntelliJ finns en meny med en ikon som ser ut som ett "_m_", klicka på den ikonen
4. Expandera "datahandler" och även "Lifecycle"
5. Dubbelklicka på package, detta bygger och paketerar projektet till en körbar .jar fil

## Kör applikationen lokalt

### Kör applikationen lokalt utan IDE
1. I kommandotolken, navigera till projektets rootmapp om du inte redan står där
2. Använd kommando `java -jar target\datahandler-0.0.1-SNAPSHOT.jar` för att starta applikationen 
3. Applikationen startar på http://localhost:8080
4. Öppna en ny terminal för att kunna köra nedan API-anrop mot servern

- Hämta alla personer  -> `curl http://localhost:8080/api/data`
- Limitera data till fem rader -> `curl http://localhost:8080/api/data?limit=5`
- Negativt heltal (returnerar 400 Bad Request) -> `curl http://localhost:8080/api/data?limit=-7`
- Ogiltigt värde (returnerar 400 Bad Request) -> `curl http://localhost:8080/api/data?limit=abc`

### Kör applikationen lokalt med IDE
1. I IntelliJ, klicka på den gröna play-knappen uppe i högra hörnet
2. Applikationen startar på http://localhost:8080
3. Öppna filen `test.http` som ligger i projektet under `src/test.http`
4. I denna fil så finns färdiga api-anrop som går att köra genom den gröna play-knappen till vänster om respektive "GET"
5. Det går även att köra dessa anrop i en webbläsare:

- Hämta alla personer  -> `http://localhost:8080/api/data`
- Limitera data till fem rader -> `http://localhost:8080/api/data?limit=5`
- Negativt heltal (returnerar 400 Bad Request) -> `http://localhost:8080/api/data?limit=-7`
- Ogiltigt värde (returnerar 400 Bad Request) -> `http://localhost:8080/api/data?limit=abc`

## Datakälla (CSV-fil och format)

Detta projekt används för att hämta och presentera data från en csv-fil. Just nu läses data in från en fil.
Filen går att hitta i projektet under `src/main/resources/data/data.csv`
Strukturen i csv-filen ser ut som nedan, observera att inga headers finns i filen. Datat följer denna struktur:

`id;name;age;email`

Exempeldata <br>
`1;Liam;29;liam.andersson@example.com` <br> 
`2;Noah;34;noah.lindberg@example.com` <br>
`3;Ella;22;ella.svensson@example.com` <br>
`4;Alma;27;alma.nilsson@example.com` <br>
`5;Hugo;31;hugo.eriksson@example.com`
