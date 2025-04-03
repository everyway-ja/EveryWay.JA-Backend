# Documentazione per i Servizi

## Endpoint: /login
- **Metodo:** POST
- **Parametri:**
  - `username` (String, obbligatorio): Nome utente dell'account.
  - `password` (String, obbligatorio): Password dell'account.
- **Descrizione:** Effettua il login di un utente verificando le credenziali fornite.
- **Errori:**
  - `302 Redirect`: Se l'utente non esiste o è stato eliminato, reindirizza a `/login?error=true`.
- **Reindirizzamento:**
  - `302 Redirect`: Se il login ha successo, reindirizza a `/home`.

## Endpoint: /register
- **Metodo:** POST
- **Parametri:**
  - `name` (String, obbligatorio): Nome dell'utente.
  - `surname` (String, obbligatorio): Cognome dell'utente.
  - `username` (String, obbligatorio): Nome utente desiderato.
  - `email` (String, obbligatorio): Email dell'utente.
  - `password` (String, obbligatorio): Password desiderata.
  - `birthDate` (LocalDate, obbligatorio): Data di nascita dell'utente.
  - `associatedLanguage` (Language, obbligatorio): Lingua associata all'utente.
  - `associatedImage` (Image, obbligatorio): Immagine associata all'utente.
  - `associatedAccountCategories` (List<AccountCategory>, obbligatorio): Categorie di account associate.
- **Descrizione:** Registra un nuovo utente e lo autentica automaticamente.
- **Errori:**
  - `302 Redirect`: Se il nome utente è già in uso, o se i parametri obbligatori non sono validi, reindirizza a `/register?error=true`.
- **Reindirizzamento:**
  - `302 Redirect`: Se la registrazione ha successo, reindirizza a `/home`.

## Endpoint: /upload
- **Metodo:** POST
- **Parametri:**
  - `file` (MultipartFile, obbligatorio): File da caricare.
- **Descrizione:** Carica un singolo file sul server.
- **Errori:**
  - `400 Bad Request`: Se il file è mancante.
  - `500 Internal Server Error`: Se si verifica un errore durante il caricamento.
- **Reindirizzamento:** Nessuno.

## Endpoint: /uploadMultiple
- **Metodo:** POST
- **Parametri:**
  - `files` (MultipartFile[], obbligatorio): Array di file da caricare.
- **Descrizione:** Carica più file sul server.
- **Errori:**
  - `400 Bad Request`: Se uno o più file sono mancanti.
  - `500 Internal Server Error`: Se si verifica un errore durante il caricamento.
- **Reindirizzamento:** Nessuno.

## Endpoint: /addItinerary
- **Metodo:** POST
- **Parametri:**
  - `name` (String, obbligatorio): Nome dell'itinerario.
  - `description` (String, obbligatorio): Descrizione dell'itinerario.
  - `associatedAccount` (Account, obbligatorio): Account associato all'itinerario.
  - `associatedImages` (List<Image>, obbligatorio): Immagini associate all'itinerario.
  - `associatedLocations` (List<Location>, obbligatorio): Località associate all'itinerario.
  - `associatedAccountCategories` (List<AccountCategory>, obbligatorio): Categorie di account associate.
  - `associatedItineraryCategories` (List<ItineraryCategory>, obbligatorio): Categorie di itinerario associate.
- **Descrizione:** Aggiunge un nuovo itinerario con le associazioni specificate.
- **Errori:**
  - `302 Redirect`: Se i parametri obbligatori non sono validi o l'account non è autenticato.
- **Reindirizzamento:**
  - `302 Redirect`: Se l'operazione ha successo, reindirizza a `/home`.

## Endpoint: /addLocation
- **Metodo:** POST
- **Parametri:**
  - `name` (String, obbligatorio): Nome della località.
  - `description` (String, obbligatorio): Descrizione della località.
  - `associatedAccount` (Account, obbligatorio): Account associato alla località.
  - `associatedPosition` (Position, obbligatorio): Posizione associata alla località.
  - `associatedImages` (List<Image>, obbligatorio): Immagini associate alla località.
  - `associatedAccountCategories` (List<AccountCategory>, obbligatorio): Categorie di account associate.
  - `associatedLocationCategories` (List<LocationCategory>, obbligatorio): Categorie di località associate.
- **Descrizione:** Aggiunge una nuova località con le associazioni specificate.
- **Errori:**
  - `302 Redirect`: Se i parametri obbligatori non sono validi o l'account non è autenticato.
- **Reindirizzamento:**
  - `302 Redirect`: Se l'operazione ha successo, reindirizza a `/home`.

## Endpoint: /sendEmail
- **Metodo:** POST
- **Parametri:**
  - `name` (String, obbligatorio): Nome del mittente.
  - `email` (String, obbligatorio): Email del mittente.
  - `message` (String, obbligatorio): Messaggio da inviare.
- **Descrizione:** Invia un'email con i dettagli forniti.
- **Errori:**
  - `400 Bad Request`: Se uno dei parametri è vuoto o se si verifica un errore durante l'invio dell'email.
- **Reindirizzamento:** Nessuno.
