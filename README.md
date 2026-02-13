# Datahandler
Detta projekt är byggt genom att använda
- Java 21
- Maven

Instruktionerna nedan är skrivna för att bygga och köra API-et på Windows då jag endast byggt och kört applikationen i den miljön.
Mac/Linux-användare kan behöva andra kommandon för att bygga och köra applikationen. 

## Bygg applikationen

### Bygg och paketera utan IDE
1. Öppna en valfri terminal förslagsvis Windows Powershell eftersom kommandona i "Kör applikationen utan IDE" är powershell-kommandon
2. Börja med att clona ner repot från GitHub genom att köra kommandot `git clone https://github.com/eemretsson/datahandler.git`
3. Använd kommandot `.\mvnw.cmd clean package` för att bygga projektet
4. En körbar .jar fil skapas här -> `target/datahandler-0.0.1-SNAPSHOT.jar`

### Bygg och paketera med IDE (Instruktioner för IntelliJ)
1. Börja med att clona ner repot från GitHub härifrån `https://github.com/eemretsson/datahandler.git`
2. Starta IntelliJ
2. Öppna projektet genom att i menyn längst uppe till vänster välja File -> Open och gå sedan till root-folder i utforskaren och välj Select Folder
3. Till höger i IntelliJ finns en meny där ikonen är ett "_m_", klicka på den ikonen
4. Expandera "datahandler" och även "Lifecycle"
5. Dubbelklicka på package, detta bygger och paketerar projektet till en körbar .jar fil

## Kör applikationen lokalt

### Kör applikationen utan IDE
1. I terminalen, navigera till projektets rootmapp om du inte redan står där
2. Använd kommando `java -jar target\datahandler-0.0.1-SNAPSHOT.jar`
3. Applikationen startar på http://localhost:8080
4. Öppna en ny terminal för att kunna köra nedan API-anrop mot servern

- Hämta alla personer  -> `Invoke-RestMethod http://localhost:8080/api/data`
- Limitera data till fem rader -> `Invoke-RestMethod http://localhost:8080/api/data?limit=5`
- Försök att limitera data med negativt heltal (bör returnera 400 Bad Request) -> `Invoke-RestMethod http://localhost:8080/api/data?limit=-7`
- Försök att limitera data med något annat än ett heltal (bör returnera 400 Bad Request) -> `Invoke-RestMethod http://localhost:8080/api/data?limit=abc`


### Kör applikationen med IDE
1. I IntelliJ, klicka på den gröna play-knappen uppe i högra hörnet
2. Applikationen startar på http://localhost:8080
3. Öppna filen `test.http` som ligger under `src/test.http`
4. I denna fil så finns färdiga api-anrop som går att köra genom den gröna play-knappen till vänster om respektive "GET"