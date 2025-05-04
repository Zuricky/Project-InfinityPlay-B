# 🎮 Project InfinityPlay ♾️

[![Tech Stack](https://img.shields.io/badge/React-17.0.2-blue?logo=react\&logoColor=white)](https://reactjs.org/) [![Spring Boot](https://img.shields.io/badge/Spring--Boot-2.6.0-green?logo=spring\&logoColor=white)](https://spring.io/projects/spring-boot) [![PostgreSQL](https://img.shields.io/badge/PostgreSQL-13-316192?logo=postgresql\&logoColor=white)](https://www.postgresql.org/) [![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

---

## 🔗 Link Front-End

**[Repository FrontEnd](https://github.com/Zuricky/Project-InfinityPlay-F)**

---

## 📖 Cos’è Project InfinityPlay?

Project InfinityPlay è una piattaforma full‑stack per l’acquisto e la gestione di videogiochi, progettata per dimostrare competenze full stack con un’architettura pulita e professionale.
Include funzionalità tipiche di uno store digitale e un'interfaccia moderna, responsive e sicura.

---

## 📦 Tecnologie Utilizzate

| Front-end                      | Back-end                                            | Database      | API Docs                     |
| ------------------------------ | --------------------------------------------------- | ------------- | ---------------------------- |
| React, React Router, Bootstrap | Spring Boot, Spring Data JPA, Spring Security (JWT) | PostgreSQL 🐘 | Swagger/OpenAPI 📝 (Postman)|

---

## 🛠️ Caratteristiche Principali

* 🔒 **Autenticazione & Autorizzazione**
* 📂 **Catalogo giochi** con ricerche e filtri avanzati
* 📑 **Dettaglio prodotto** (descrizione, prezzo, immagini)
* 🛒 **Gestione Carrello & Checkout**
* 💳 **Storico Ordini** nel profilo utente
* ❤️ **Wishlist** per salvare i preferiti
* 🗨️ **Recensioni Utenti** con stelle e commenti

---

## 🚀 Installazione & Avvio

Segui questi passaggi per eseguire il progetto in locale:

1. **Clona il repository**

   ```bash
   git clone https://github.com/Zuricky/Project-InfinityPlay.git
   cd project-infinityplay
   ```

2. **Configura le variabili d’ambiente**
   Crea un file `.env` nella cartella `backend`:

   ```env
   DB_URL=jdbc:postgresql://localhost:5432/project_infinityplay
   DB_USER=user
   DB_PASS=password
   JWT_SECRET=secret
   ```

3. **Avvia il Back-end**

   ```bash
   cd backend
   ./mvnw spring-boot:run
   ```

4. **Avvia il Front-end**

   ```bash
   cd frontend
   npm install
   npm start
   ```

5. **Visita l’app**

   * Front-end: `http://localhost:3000`
   * Swagger UI: `http://localhost:8080/swagger-ui.html`

---

## 🖥️ Come Utilizzare

* Registrati o effettua il login 🔑
* Esplora il catalogo e applica filtri 🎲
* Aggiungi giochi al carrello e procedi al checkout 🛒
* Consulta lo storico ordini dal profilo 📂
* Aggiungi ai preferiti tramite wishlist ❤️
* Lascia una recensione per i titoli giocati ⭐

---

## 🎁 Extra: PC Building 💻

Resta sintonizzato per i **kit PC preassemblati** dedicati al gaming e allo streaming! 🔧

---

## 📄 Licenza

Questo progetto è rilasciato sotto licenza **MIT**. Vedi il file [LICENSE](LICENSE) per maggiori dettagli.
