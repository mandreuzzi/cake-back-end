# cake-back-end
<div id="top"></div>

<h3 align="center">Best-README-Template</h3>
<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">Il progetto</a>
      <ul>
        <li><a href="#built-with">Tecnologie utilizzate</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Per iniziare</a>
      <ul>
        <li><a href="#prerequisites">Prerequisiti</a></li>
        <li><a href="#installation">Installazione</a></li>
      </ul>
    </li>
    <li><a href="#usage">Utilizzo</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## Il progetto
Una pasticceria vende dolci che hanno un nome ed un prezzo.
I dolci vengono esposti su una vetrina virtuale dove tutti possono vedere vederli in vendita.
Andando nella pagina di dettaglio di ciascun dolce ne vengono indicati gli ingredienti che lo compongono.

La gestione della pasticceria è in mano a Luana e Maria che vogliono avere il
proprio account per poter accedere all'area di backoffice tramite email e password.
Nell’area di backoffice si possono gestire i dolci creandoli, modifcandoli o eliminandoli(CRUD).
I dolci in vendita invecchiano ed in base al tempo trascorso dalla loro messa in vendita hanno prezzi diversi: primo giorno
prezzo pieno, secondo giorno costano l’80%, il terzo giorno il 20%. Il quarto giorno non
sono commestibili e devono essere ritirati dalla vendita edi conseguenza non più visibili in vetrina.


### Tecnologie utilizzate

l'applicazione si compone di 2 moduli: front-end e back-end.
Di seguito sono elencate le tecnologie utilizzate in fase di sviluppo per ciascun modulo.

####Front-end

* Piattaforma OS Linux Mint(ver.20)
* Visual Studio Code
* Node.js(ver. 14.17.6 )
* NPM(ver. 6.14.15)
* Angular (ver. 12.2.4)
* Okta per la gestione degli accessi

####Back-end
* Piattaforma OS Linux Mint(ver.20)
* IntelliJIdea CE 2021.2
* Spring Boot (ver. 2.5.5)
    * web
    * data-jpa
    * Lombok
    * mysql-connector

####Data Base
Per il Db è stato utilizzato MySql/WorkBench (ver.8.0.26)

<!-- GETTING STARTED -->
## Per iniziare
Prima di avviare l'applicazione è necessario:
* creare schema e tabelle del DB
* creare la cartella destinata ad upload/download delle immagini
* scaricare i due moduli back-end e front-end
    ### Prerequisiti
Di seguito vengono esposti i passi preliminari da fare:

* Nel modulo di back-end è presente una cartella denominata setup al cui interno vi è un file zip contenente la cartella tmp_img la quale va decompressa subito sotto <USER_HOME>.
Al suo interno sono già presenti alcune immagini che verranno utilizzate al primo avvio.
* Nel modulo di back-end è presente una cartella denominata db-scripts al cui interno sono presenti i file:
  * 01-create-user.sql
  * 02-create-db.sql

Accedere a MySql ed eseguirli nel seguente ordine: 01-create-user.sql -> 02-create-db.sql

### Installazione

1. Tramite git o IDE, scaricare i due moduli da Github tramite i seguenti link:

   ```
   https://github.com/mandreuzzi/cake-front-end.git
   ```

   ```
   https://github.com/mandreuzzi/cake-back-end.git
   ```

2. Per il modulo di front-end:
   * Tramite riga di comando o IDE accedere alla root dell'applicazione ed eseguire:
      ```sh
      npm install
      ```
   * Per avviare l'applicazione sulla porta 4200 eseguire:
```sh
   ng serve --open
   ```
3. Per il modulo di back-end
   * Importare il modulo nel proprio IDE ed  eseguirelo come progetto spring boot  
   * oppure da linea di comando tramite plugin maven:
   ```sh
      mvn spring-boot:run
      ``` 
   
Per accedere al backoffice le credeziali delle due utenze sono:
* username: maria@email.com password: Ottobre2021!
* username: luana@email.com password: Ottobre2021!
   
