# Proiectare_Software
# Aplicatie a unei companii aeriene pentru vanzarea biletelor de avion:

## _**Descriere generala**:_
Acest proiect, dezvoltat cu ajutorul platformei Spring Boot, are ca scop crearea unei mediu virtual destinat rezervarii si cumpararii biletelor de avion, avand ca scop livrarea unei experiente eficiente utilizatorilor.

Aplicatia ofera urmatoarele **functionalitati** principale:

- cautarea zborurilor in functie de niste campuri pe care utilizatorul le completeaza(orasul de plecare, orasul destinatie, data plecarii, optional retur);
- daca nu exista un zbor direct, se afiseaza zboruri cu escala;
- utilizatorul trebuie sa aiba optiunea de a-si alege locul in avion;
- utilizatorul trebuie sa aiba optiunea de a alege tipul de bagaj(ex: de cala, de mana etc.);
- utilizatorul trebuie sa aiba posibilitatea de a-si crea un cont si de a se loga;
- aplicatia trebuie sa aiba functionalitati pentru unul sau mai multi admini, care sa poata adauga sau sterge zboruri si care sa poata modifica diferite aspecte prezente in aplicatie;
- utilizatorul trebuie sa poata introduce datele personale ale pasagerilor de pe un bilet;
- utilizatorul trebuie sa primeasca confirmarea rezervarii dupa completarea tuturor pasilor;

## **_Diagrama bazei de date:_**
![Javatpoint](db2.png) 

## **_Apeluri HTTP:_**
**Apelurile HTTP** realizate în Postman sunt esențiale pentru testarea și dezvoltarea unei aplicații web. Iată câteva aspecte importante despre apelurile HTTP în Postman:

API este prescurtarea de la "Interfață de Programare a Aplicației" (Application Programming Interface). Este un set de reguli, protocoale și instrumente care permit interacțiunea și comunicarea între diferitele componente ale unei aplicații software sau între aplicații diferite.

**Testarea API-urilor:** Postman oferă un mediu de lucru prietenos pentru a trimite cereri HTTP către API-uri și a examina răspunsurile.

**Metode HTTP și Rute:** Poți specifica metoda HTTP (GET, POST, PUT, DELETE etc.) și ruta (URL) către care vrei să trimiti cererea. În plus, poți adăuga și parametri, antete și corpuri de cerere, în funcție de necesitățile aplicației tale.

**Parametri și Antete:** Postman îți permite să adaugi parametri de query sau de cale în cerere, precum și antete personalizate, pentru a simula diferite scenarii și configurații.

În general, apelurile HTTP realizate în Postman sunt un instrument esențial pentru dezvoltatorii de software, oferindu-le posibilitatea de a testa, depana și îmbunătăți API-urile și aplicațiile lor într-un mod flexibil și interactiv.

## **_Implementarea Design pattern-ului Observer:_**
Implementarea acestui design pattern are ca scop notificarea utilizatorilor in legatura cu scaderea sau cresterea preturilor biletelor de avion, reprezentand o modificare importanta aparuta in sistem.
Pentru realizarea acestei functionalitati, s-au urmat mai multi pasi:
- **injectarea** UserService în NotificationService, in scopul realizarii unui design corespunzător și a unei separari clare a responsabilităților.
- utilizarea unei liste de utilizatori pentru **observatori**: alegerea unei liste de utilizatori pentru a ține evidența observatorilor este o modalitate simplă și eficientă de a gestiona acești observatori.
- adăugarea și eliminarea facilă a observatorilor cu ajutorul metodelor subscribe() si unsubscribe(), precum și notificarea acestora despre evenimente importante, cum ar fi modificările de preț ale biletelor.

