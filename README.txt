De lege bestanden (.placeholder.txt) in de dieptste mappen van het project zijn enkel bedoeld om de betreffende map aan git toe te voegen en zo de gehele mappenstructuur zichtbaar te maken.

Het project bevat een log4j.properties bestand waardoor meer informatie zichtbaar is tijdens deployment van de War file in Tomcat.

De database gegevens zijn naar een apart bestand (icarasdb.properties) verplaatst zodat wijzigen aanbrengen vereenvoudigd wordt. Het wisselen van database kan dan door de betreffende properties (na '=') aan te passen.

Op dit moment ondersteunt het project zowel HSQLDB als MySQL (vastgelegd in de POM) en dit zal overgaan naar MySQL omdat dit de gekozen database voor deployment is. Deze dubbele ondersteuning is bedoeld om mensen die de demo draaiend hebben niet in deze sprint te dwingen over te stappen naar MySQL. De huidige properties zijn dan ook ingesteld op gebruik van de hsqldb waarvoor in het demoproject een database starter is toegevoegd.

Om te voorkomen dat er in het ontwikkeltraject versie-problemen ontstaan, zijn hier de volgende versie afspraken vastgelegd:

jdk 1.8.*
Maven versie: 3.2.3 voor hele project
Tomcat: 7.0.54
(Spring, Hibernate etc wordt geregeld door de POM files.)
