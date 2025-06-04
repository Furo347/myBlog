# 📘 Projet Spring Boot – Gestion des Entités avec Relations

Ce projet a pour objectif de développer une application Spring Boot complète en suivant une série d'étapes pédagogiques. Le projet utilise Spring Boot, Spring Data JPA et une base de données MySQL pour la gestion des entités avec des relations complexes.

---

## 🧱 Technologies utilisées

- Java 17+
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Lombok (optionnel)

---

## 🔧 Étapes de développement

### 🌱 Spring 1 : Initialisation du projet

- Création d'un projet Spring Boot avec les dépendances de base.
- Configuration de l'environnement (application.properties / application.yml).
- Mise en place d'un contrôleur simple pour afficher **"Hello World"** dans le navigateur.

### 🗄️ Spring 2 : Connexion à la base de données

- Connexion à une base de données MySQL.
- Configuration des paramètres de connexion (URL, username, password).
- Création d’une entité JPA.
- Sauvegarde d'une instance de cette entité dans la base.

### 🔄 Spring 3 : Création d’un contrôleur REST

- Mise en place d’un contrôleur REST pour gérer les entités.
- Implémentation des opérations CRUD : 
  - Create
  - Read
  - Update
  - Delete
- Utilisation de Spring Data JPA pour les opérations en base.

### 🔍 Spring 4 : Requêtes personnalisées

- Création de méthodes de requête personnalisées.
- Utilisation des conventions de nommage de Spring Data JPA.
- Compréhension du fonctionnement des requêtes générées automatiquement.
- Tests des requêtes via Postman ou Swagger.

### 🔗 Spring 5 : Relation Many-to-One

- Mise en place d’une relation **Many-to-One** entre 'Article' et 'Category'.
- Gestion des relations via annotations JPA ('@ManyToOne', '@JoinColumn').
- Implémentation d’une relation bidirectionnelle.

### 🔄 Spring 6 : Relation One-to-Many (bidirectionnelle)

- Renforcement de la relation entre 'Category' et 'Article' avec une approche bidirectionnelle.
- Utilisation de '@OneToMany(mappedBy = "...")' côté 'Category'.
- Gestion de la sérialisation JSON (éviter les boucles infinies avec '@JsonManagedReference' / '@JsonBackReference').

### 🧩 Spring 7 : Relation Many-to-Many simple

- Création d’une relation **Many-to-Many** entre deux entités (ex: 'Student' ↔ 'Course').
- Configuration des jointures avec '@ManyToMany' et '@JoinTable'.
- Gestion des ajouts et suppressions dans les relations.

### 🧠 Spring 8 : Relation Many-to-Many avancée

- Mise en place d’une **relation Many-to-Many complexe** (avec entité intermédiaire si nécessaire).
- Gestion des cas d’utilisation avancés avec Spring Data JPA.
- Tests et validation de l’intégrité des relations.

---

## 🚀 Lancer le projet

1. Cloner le repo :
   git clone <url-du-repo>
   cd nom-du-projet


2. Configurer 'application.properties' :

   spring.datasource.url=jdbc:mysql://localhost:3306/nom_bdd
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update

3. Démarrer le projet :

   ./mvnw spring-boot:run

4. Accéder à l'application :

   * [http://localhost:8080](http://localhost:8080)

---

## 🧪 Tests

Les tests peuvent être effectués via :

* Postman (pour tester les endpoints REST)
* Swagger UI (si configuré)
* Console MySQL (vérification des relations et données)

---

## 🧑‍💻 Auteur

* Nom : Portets Florentin
* Formation : Master Développement Web
* Année : 2025

---

## 📄 Licence

Ce projet est destiné à un usage pédagogique.
