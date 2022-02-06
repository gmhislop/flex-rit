
```
{
  firstName = "Giovanni",
  lastName = "Hislop",
  schoolName = "Hogerschool Novi"
  assignmentName = "Integrale Backend opdracht 1+3"
  
}
```
```
public static void main(String[] args) {    
   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
   LocalDateTime now = LocalDateTime.now();  
   System.out.println(dtf.format(now));  
  }    
   
```

# Voorwoord
Dit document is de uitleg en verantwoording van de ontwikkeling van een Java Object Oriented Programming Backend applicatie, die is ontwikkeld in het kader van de opleiding Full Stack Development aan de Hogeschool Novi. Tijdens het project richt de student zich op het bouwen van een backend van een webapplicatie aan de hand van bijgeleverde casus of naar eigen invulling een idee voor een webapplicatie. Dit zorgt ervoor de theorie volledig tot een uiting komt in de praktijk. Het project vergde een hoge mate aan zelfstandigheid en zelfstudie waarbij er gestructureerd moeten worden gekeken naar de mogelijkheden om het idee te realiseren binnen de gewenste tijd.


# Inhoudsopgave
0. Voorwoord
1. Inleiding
2. Opdrachtbeschrijving	
3. Ideefase
4. Werkwijze
5. Functioneel ontwerp
6. Opzetten project IntelliJ
7. Opzetten Github/Git
8. Installeren Spring boot, Maven
9. Opzetten Postman


# 1. Inleiding
In dit verslag worden de resultaten, conclusies en aanbevelingen besproken die zijn voortgekomen uit het vooronderzoek voor de Integrale Eindopdracht Back End van de Back-end leerlijn aan de Hogeschool Novi. In de eerste hoofdstukken worden de onderzoeksmethode, doelstellingen en de technische ontwerpkeuzes van deze opdracht toegelicht. 


# 2. Opdrachtbeschrijving 

De opdracht luidde als volgt: De student maak een multi-tier web applicatie door gebruik te maken van Java en Spring Boot. Voor het uitvoeren van deze opdracht hebben wij enkele weken gekregen. Voorgaande waren er uiteraard lessen die aansloten bij de opdracht wat ervoor zorgde dat wij al wat bekender konden worden met het concept rondom Object georiënteerd programmeren. 

De webapplicatie moet minimaal voldoen aan de volgende eisen:

- De backend en de database zijn gescheiden en kunnen los van elkaar op verschillende systemen draaien;
- De backend is volgens OOP ontwikkeld met behulp van Java & Spring;
- De database is relationeel;
- Er is gebruik gemaakt van versiebeheer (GIT);
- Maakt gebruik van een build system (maven);
- Bevat unit-testen;
- Is beveiligd en bevat minstens twee user-rollen.

Voordat wij akkoord kregen om te beginnen werd er eerst aandacht besteedt aan de ideefase. De studenten kregen de gelegenheid om 3-5 ideeën voor te stellen en gelijktijdig na te denken over onderwerpen zoals use cases, user rollen en haalbaarheid. In het volgend hoofdstuk zal ik volledig toelichten hoe mijn proces verlopen is en tegen welke dilemma's ik aanliep.

# 3. Ideefase  
Zoals eerder benoemd kon ik pas aan de slag met de daadwerkelijke opdracht bij goedkeuring van het idee. Ik stelde de volgende ideeën voor om te ontwikkelen:

**Concept 1** - Een stem applicatie waarin gebruikers in de vorm van een community kunnen stemmen op bepaalde kledingstukken en/of combinaties. Wanneer een gebruiker twijfelt aan een bepaald kledingstuk, kan deze makkelijk en snel worden beoordeeld door een collectieve groep aan gebruikers.

**Concept 2** - Een platform waarop creatieve werkgevers opdrachten kunnen uitzetten naar werkzoekende die weinig tot geen professionele ervaring hebben. Zo kunnen zij voor een lager tarief naast hun studie een bijbaan hebben waarin zij hun creativiteit tot een uiting kunnen brengen. 

**Concept 3** - Een rittenregistratie applicatie die geautomatiseerd vanuit de agenda van de gebruiker ritten registreert en omzet naar een overzichtelijke rapportage. Met deze applicatie worden de gemaakte kilometers nauwkeurig bijgehouden door te kijken naar het vertrek en aankomstpunt. 

Bij het bedenken van de bovenstaande idee volgde ik nog de voltijd variant van deze leerlijn. Hierdoor was ik voornamelijk gaan kijken naar een applicatie waarbij ik zowel de backend als de frontend tot een uiting kan brengen. Uiteindelijk ben ik toch voor de parttime variant gegaan zodat ik de theorie nog beter kan laten bezinken en mijzelf optimaal kan inzetten binnen de lessen. Uiteindelijk heb ik voor het eerste idee en het tweede idee goedkeuring gekregen. Mijn keus is toen naar het derde idee uitgegaan, dit omdat de grootste uitdaging binnen dat project bij de backend zit en ik persoonlijk hiervan meer gebruik zou kunnen maken. 

##### Het idee 
Maak kennis met FlexRit een rittenregistratie applicatie waarmee de gebruiker makkelijk en snel afgelegde kilometers kan invoeren en bijhouden. Door gebruik te maken van deze applicatie kan de eindgebruiker alle ritten die gemaakt zijn tijdens een werkperiode handmatig invoeren. Na het invullen het vertrek- en aankomstadres wordt er automatisch een berekening gemaakt van de totaal afgelegde kilometers. Het doel van deze applicatie is om de ingevoerde gegevens te verzamelen en om te zetten naar een overzichtelijke rapportage. De Google integratie heb ik helaas achterwege moeten laten, na overleg met mijn docent leek het verstandiger om dit wellicht in de toekomst eraan toe te voegen. Gezien het tijdsbestek was het niet helemaal realistisch.  








# 4. Werkwijze

De werkwijze die ik hanteerde bestond voornamelijk uit het bedenken van subdoelen en weektaken. Om alles zo goed mogelijk overzichtelijk te krijgen ben ik eerst gaan kijken naar een managementtool die past bij mijn manier van werken. Ik ben de volgende tools tegengekomen: 

- Evernote
- Trello
- Jira 

Evernote is qua interface ontzettend goed in elkaar gezet met talloze handige productiviteit extra’s alleen is de standaard gratis versie beperkt waardoor mijn keus toch uit is gegaan naar een wat voordelige oplossing. 

Jira daarentegen ziet er nog professioneler uit dan de concurrenten en is naar mijn mening wat meer gericht op de technische industrie. Met de gratis versie zijn er voldoende mogelijkheden alleen is het in het begin wat lastigere te begrijpen. Ik zal in de loop der tijd zeker wat meer met Jira aan de gang gaan. Dit lijkt mij namelijk een ontzettend fijne tool in geval van grote projecten en samenwerkingen.

Uiteindelijk ik mijn keus uitgegaan naar Trello. Trello is een ontzettend handige en veelgebruikte tool uit mijn werkverleden. De basisfunctionaliteiten zijn gratis, en Trello helpt veel bedrijven met het maken van scrum boards en het managen van grote projecten. Ook hebben zij een wat lagere learning curve waardoor ik binnen korte tijd optimaal gebruik hiervan kan maken. Wat mij vooral aansprak aan trello is de koppeling met Google Agenda, dit omdat er tijdens het gebruik hiervan meer over de API functionaliteiten kan worden verduidelijkt.  

De volgende stappen heb ik ondernomen: 

[x] Ideefase
[x] Functioneel ontwerp
[x] Inrichten IntelliJ
[x] Opzetten Github/Git
[x] Installeren Spring boot, Maven.
[x] Opzetten Postman
[x] Onderzoek en installeren Database 
[x] Testing
[x] Technisch ontwerp
[x] Opstellen ReadMe





# 5. Functioneel ontwerp 
In deze fase zullen er verschillende onderdelen en functies van het nieuw te ontwikkelen systeem worden beschreven met behulp van verschillende UML modellen. UML (Unified Modeling Language) zorgt ervoor dat er goede overzicht komt aan de mogelijke functionaliteiten die wellicht behoren tot de gewenste applicatie. De reden dat er voor UML gekozen is als systeemontwikkelingsmethoden techniek, is dat het een universele en solide basis is voor systeemontwikkeling. Het ontwikkelen van de UML heb ik met behulp van het programma Visual Paradigm gemaakt.  

Ik heb voornamelijk gekeken naar de praktische kant van mijn applicatie en na mijn eerste UML kwam ik tot de conclusie dat ik ook rekening moet houden met het veilig opslaan van data. Mijn eerst UML zag er namelijk zo uit dat de Admin rol werkelijk overal bij kon en alles uiteindelijk ben ik erachter gekomen dat dit in de praktijk helemaal niet aan de orde is, zeker niet in de tijd waar wij nu in leven (zie bijlage A voor de eerste versie van het UML diagram). 

### Mijn eerste UML Use-case diagram bestond uit:
Klik hier om de <a href="https://github.com/gmhislop/flex-rit/blob/31e352a142eb2c2f487f5ac95bf8320c159c9353/Images/Communication%20Diagram1.pdf" target="_top">```UML Use-case Diagram``` versie 1</a> te bekijken

```
User 	    	| Register (POST, PUT).
User 	    	| Login (POST, PUT).
Admin 	    	| Trip management record (GET, PUT, POST, DELETE). 
Admin/ User	    | User management record (GET, PUT, POST, DELETE)
Admin/ User 	| Payment management record (GET, PUT, POST, DELETE)
Admin/ User 	| Manage report management record (GET, PUT, POST, DELETE)
Admin/ User 	| Vehicle management record (GET, PUT, POST and DELETE)
Admin/ User 	| Subscription management record (GET, PUT, POST and DELETE)
```

### Na verbetering zag de UML Use-case diagram er zo uit:
Klik hier de <a href="https://github.com/gmhislop/flex-rit/blob/31e352a142eb2c2f487f5ac95bf8320c159c9353/Images/Communication%20Diagram1.png" target="_top">```UML Use-case Diagram``` versie 2</a> te bekijken

```
User 	    	| Register (POST, PUT).
User 	    	| Login (POST, PUT).
Admin 	    	| Trip management record (GET, PUT, POST, DELETE). 
Admin/ User 	| User Subscription (GET, PUT, POST and DELETE)
Admin/ User 	| Vehicle management record (GET, PUT, POST and DELETE)
```


##### Identiteiten:
1. Ritregistratie - (voertuigen, locaties, chauffeurs).
2. Voertuig - (merk, type en kenteken, kilometerstand en gebruiksduur, van/naar locatie)
3. Gebruiker/admin - naam, contactgegevens, betalingsgegevens, voertuigen,
4. Abonnementen - (prijs, gebruiker)

##### UML sequentiediagram
Het is voor de eindgebruiker of admin niet van groot belang om alle gegevens in te zien of bepaalde handelingen uit te voeren als rekeningoverzicht verwijderen. In de praktijk wordt er namelijk een verzoek ingediend zodat de eindgebruiker met een versleutelde wachtwoord en gebruikersnaam kan inloggen. Een UML moet simpel en begrijpelijk zijn en een goed idee geven van de primaire functies van een applicatie. Persoonlijk vind een sequentiediagram duidelijke wanneer er in een team gewerkt wordt en het specifiek gaat over het vertalen van een bepaalde functionaliteit. 

Klik hier <a href="https://github.com/gmhislop/flex-rit/blob/6cb7384515ed4d4b9441354a88b952c5b3554920/Images/sequence%20diagram.vpd-Page-2%20(1).png" target="_top">```UML Sequence Diagram```</a> om de  te bekijken


# 6. Inrichten project IntelliJ

Volgens school hebben wij geleerd om projecten te starten, openen en opslaan binnen IntelliJ. Toch ben ik toen gaan kijken naar wat de alternatieven zijn. 

IntelliJ doet geweldig werk bij het verhogen van de productiviteit van ontwikkelaars, en hoewel het misschien genoeg lijkt ben ik toch gaan kijken naar een eventuele alternatief. uiteindelijk ben ik bij VScode terrecht gekomen. VSCode gebruikt standaard een zeer lage hoeveelheid RAM, waardoor we meerdere projecten tegelijkertijd kunnen openen. Dit was bij het starten van het project duidelijk zichtbaar mijn laptop kon het niet aan, maar gelukkig heb ik destijd een nieuwe laptop kunnen aanschaffen. En door het gebruik van Git kon ik al mijn gegevens makkelijk en snel weer ophalen. 

Het opzetten van een project in IntelliJ ging vrij makkelijk, dit omdat het lesmateriaal hierop precies is afgesteld. Indien dit niet het geval was, dan was ik voor Visual Studio Code gegaan. Uit ervaring is nu gebleken dat IntelliJ makkelijk te begrijpen is en er veel overeenkomsten zijn met andere IDE's.

# 7. Inrichten Github/Git

Wat is Git en hoe ging het installeren hiervan? Simpel gezegd, Git is een versiebeheersysteem waarmee je je broncode geschiedenis kunt beheren en bijhouden. GitHub is een cloudgebaseerde hosting service waarmee je Git-repositories kunt beheren. Als je open-source projecten hebt die Git gebruiken, dan is GitHub ontworpen om je te helpen ze beter te beheren.

De installatie hiervan ging vrij moeizaam het verliep namelijk niet zo makkelijk als ik dacht. Samen met meerdere docent is het uiteindelijk gelukt. Ik heb in het begin gebruik gemaakt van de desktop versie, maar dit was uiteindelijk redelijk overbodig. Door de IntelliJ integratie is er van alles te doen door gebruik te maken van de terminal. 

Na mij te hebben verdiept in de materie streef ik er nu naar om een professionele Github account te maken en dagelijks tot wekelijks hierop actief te zijn. Git is namelijk een ontzettend belangrijk element bij het vormen van je portfolio. Ik merk dat Git volwaardig onderdeel is van mijn workflow en ik nu niet meer zonder zou kunnen. 





# 8. Installeren Spring boot, Maven

Bij het schrijven van een Spring Boot-toepassing is de Spring Boot Maven-plugin de aanbevolen tool om onze code te bouwen, testen en verpakken. Deze plug-in wordt geleverd met veel handige functies, zoals:

Het lost de juiste dependencies versies voor ons op het kan al onze dependencies (inclusief een ingebouwde applicatieserver indien nodig). Implementeer een aangepaste ```ClassLoader``` om alle externe jar-bibliotheken te lokaliseren en te laden, nu genest in het pakket zoekt automatisch de methode ```main()``` en configureer deze in het manifest, zodat we de hoofdklasse niet hoeven te specificeren in ons java -jar-commando. Mijn ervaring met Spring Boot was ontzettend aangenaam. Spring Boot maakt coderen veel makkelijker en leuker. 

De dingen die mij voornamelijk aanspraken zijn het gebruik van ```Spring Security```, annotaties zoals Lombok, ```@Enity, @Autowired @Getters  @Setters```. Een entiteit bijvoorbeeld vertegenwoordigt een tabel die is opgeslagen in een database. Elke instantie van een entiteit vertegenwoordigt een rij in de tabel. Door deze annotaties hoef je niet meer handmatig een tabel te maken. 


# 9. Opzetten Postman

Het installeren van Postman was in een handomdraai gedaan. Postman is een handig hulpmiddel wanneer u RESTful API's wilt maken, delen, testen en documenteren. Het biedt een moderne gebruikersinterface, waar er geen gedoe is met het schrijven van omslachtige code, maar het eenvoudige gegevensformaat JSON kan gebruiken. Voor het versturen van een eenvoudig verzoek is het dus alleen nodig binnen Postman om de URL, de verplichte headers en de HTTP-methode in te voeren. Om eerlijk te zijn heb ik niet gezocht naar alternatieve. Naar mijn mening werk Postman makkelijk, snel en begrijpelijk. Ook is het ontzettend makkelijk te begrijpen wanneer er gebruik wordt gemaakt van een Workshop. Ik heb namelijk een export gedaan van de meest gebruikte verzoeken binnen mijn applicatie zodat een nieuwe gebruiker deze makkelijk en snel kan testen. 

Enkele alternatieve zijn:
- Azure API Management.
- UserTesting.
- SwaggerHub.






# 10. Onderzoek en installeren Database

Voor het project is er een vereist dat er data kan worden opgeslagen. Voordat de installatie voltooid was heb ik gebruikgemaakt van H2. H2 is een van de populaire in-memory databases geschreven in Java. H2 kan worden ingezet in Java-toepassingen of worden uitgevoerd in de client-server modus. In memory houdt in dat de data maar voor zeer korte tijd wordt opgeslagen. Deze methode heb ik gebruik om de werking van mijn applicatie vroegtijdig te testen. 

Na het oriënteren ben ik, eerste instantie voor DBeaver gegaan in combinatie met MySQL. DBeaver is een GUI cliënt die ervoor zorgt dat er een gebruiksvriendelijke interface ontstaat voor het gebruik van de database. In principe werkt MySQL uitstekend maar na het overstappen van laptop ben ik eens gaan kijken naar pgAdmin in combinatie met PostgreSQL en omzetten van mijn database was vrij makkelijk gedaan. Hierbij was het vooral belangrijk dat de juiste gebruikersnaam, wachtwoord en url wordt ingevuld. Het controleren en aanpassen van het tabelstructuur was hierbij ook noodzakelijk, dit voorkomt onnodige errors.

# 11. Unit Testing
Wanneer functionaliteit moeten worden getest, is het beter om deze te isoleren en de context van geladen frameworks/componenten te beperken. Vaak is het voldoende om het JUnit unit testing framework te gebruiken. zonder extra kaders te laden. Om dit te bereiken, hoeft u uw test alleen maar te annoteren met ```@Test```. 

De ```@SpringBootTest``` annotatie laat uw toepassing automatisch draaien met alle afhankelijkheden die het instrumenteren voor gebruik in tests. Het kan afhankelijkheden vervangen en aangepaste eigenschappen bieden voor de toepassingscontext. Deze annotatie is een geweldig hulpmiddel en een gemakkelijke manier om het gewenste deel klaar te maken voor testen. 

Bij het testen van mijn applicatie heb ik gekozen voor ```@Mockbean``` annotatie. ```MockMVC``` is standaard al opgenomen in spring-boot-starter-test. ```@MockBean``` wordt gebruikt om nep objecten toe te voegen aan de Spring-toepassingscontext. De mock vervangt elke bestaande klasse van hetzelfde type in de toepassingscontext. Hieronder ziet u een voorbeeld waarbij Het gebruikt wpordt om een specifieke waarden te retourneren wanneer deze methode worden aangeroepen. Het gewenste resultaat wordt hieronder aangeduid met het cijfer 1. Wanneer deze waarde retour komt weten wij dat deze methode correct werkt. 
```
@Test
    public void testgetTrips() {
        Mockito.when(tripRepository.findAll()).thenReturn(List.of(new Trip()));
        List<Trip> result = tripService.getTrips();
        Assert.assertEquals(1, result.size());

    }
```

Als er geen klasse van hetzelfde type is gedefinieerd, wordt er een nieuwe toegevoegd. Deze annotatie is handig bij integratietests waarbij een bepaalde klasse, zoals wanneer een externe service, moet worden genept om het zomaar te zeggen.

# 12. Technisch ontwerp

Bij het maken van het technisch ontwerp hebben we bewust gewacht tot latere stadium van het project. Tijdens het project verandert er veel onderweg, wat natuurlijk veel ruimte voor verbetering met zich meebrengt. Uiteindelijk kon alles in zijn geheel in kaart worden gebracht met behulp van een Klassendiagram. Deze is volledig ontwikkeled in Visual Paradigm.

Een klassendiagram is een diagram dat wordt gebruikt bij het ontwerpen en modelleren van software om klassen en hun relaties te beschrijven. Met klassendiagrammen kunnen we software op een hoog abstractieniveau modelleren zonder naar de broncode te hoeven kijken.

Klassen in een klassendiagram komen overeen met klassen in de broncode. Het diagram toont de namen en attributen van de klassen, relaties tussen de klassen en soms de methoden van de klassen. 

Klik hier <a href="https://github.com/gmhislop/flex-rit/blob/1c3627c422ca93ffa909ab1e2921506559e09a4a/Images/class%20diagram.vpd.png" target="_top">```UML Class Diagram```</a> om de  te bekijken

# 13. Opstellen Installatie Handleiding

Nadat ik klaar was met het programmeren van mijn applicatie ben ik begonnen met het schrijven van een installatiehandleiding. Een goede software-installatiehandleiding kan de frustratie van de gebruiker helpen verminderen en de kans vergroten dat de software de eerste keer correct wordt geïnstalleerd. Dit vond ik extreem lastig omdat het voor mij onduidelijk was wat hier precies in hoort en welke eisen hieraan verbonden zijn. Tijdens de lessen zijn er twee manieren behandeld en de volgende bestandstypen zijn toegestaan: 

- Markdown 
- PDF

De reden waarom ik voor Markdown heb gekozen is, omdat het naar mijn mening uitdagender is, beter binnen de ICT-branche past en zorg voor een betere leesbaarheid. Daarnaast zorgt dit ervoor dat ik bekend wordt met professionele tekst editors. Uit ervaring doet Markdown waarvoor het is ontworpen: het biedt een eenvoudige, snelle omgeving waarmee ik direct aan de slag kon. Van nature ben ik redelijk perfectionistisch waardoor ik erg kan opgaan in de wijze waarop iets vormgegeven wordt. Markdown verwijdert alle afleiding van een opmaakwerkbalk en muisklikken. Dit zorgt ervoor dat alles is een minimalistisch technisch ontwerp wordt gezet. 

De structuur van mijn handleiding bestaat voornamelijk uit het begeleiden van de lezer door het installatieproces aan de hand van een korte uitleg en complementaire visuele aanwijzingen. Het begin simpelweg bij het downloaden van het bestand en gaat uiteindelijk over na het testen van de applicatie met de voorgestelde middelen. Het schrijven van de handleiding heeft ervoor gezorgd dat ik mijn stappen ben gaan herleven. En wanneer een persoon in staat is om het aan iemand te leren, zorgt dit er ook voor dat de materie op een of ander wijze beter blijft hangen, uitstekende methode! Het schrijven van de handleiding heb ik met veel plezier gedaan. 


# 14. Bronnen
```

Baeldung | Testing 		
https://www.baeldung.com/postman-testing-collections

Baeldung | Endpoints 		
https://www.baeldung.com/spring-boot-get-all-endpoints

Baeldung | Testing 		
https://www.baeldung.com/spring-boot-get-all-endpoints

Baeldung | GIT 		
https://www.baeldung.com/git-guide

Baeldung | GIT 		
https://www.jetbrains.com/help/idea/settings-version-control-git.html

Markdown org |		
https://www.markdownguide.org/

Learning Postman | 		
https://learning.postman.com/docs/getting-started/introduction/

```













