# API Intergration

pokemon api

I denna uppgift så har jag använt mig av poke api, picasso biblioteket. Jag har gjort en app där man kan söka efter pokemon och få upp en bild,namn,vilken typ den är och hur den låter. Appen är uppbyggd med en activity och fyra fragments.

 Jag använder mig av https://pokeapi.co/api/v2/pokemon/pokemon_name  endpointen för att få tag på pokemons namn,typ,bild och hur den låter. Jag har bara använt en liten del av informationen som man får.

Jag använder picasso för att se till så att bilden blir tillräckligt stor och så att den hamnar i rätt vy. Jag delar upp objektet till två olika delar, en för att få fram bilden och en annan för att få fram ljudfilen. 
![<img width="537" alt="image" src="https://github.com/user-attachments/assets/f36023ae-1679-4894-9d3f-a911002658da">]


Jag hämtar ljudfilen och laddar in den till en mediaspelare och startar den när man trycker på ljudknappen.
<img width="537" alt="image" src="https://github.com/user-attachments/assets/5b983cff-5f70-4df5-a6be-f5d8aed30cb5">


Om jag hade haft mer tid så hade jag implementerat så att man kan se vilka evolutioner pokemonen har, vilka moves den har och var i spelet man kan stöta på dem.

Det som var svårast för mig var att använda sig av Navigation då det blev mycket som gick fel och det är svårt att fixa buggar då det är saker som händer i bakgrunden 
