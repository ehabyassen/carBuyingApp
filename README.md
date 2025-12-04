🚗 Car Buying App – Spring Boot MVP

A lightweight backend service for managing customer car-buying requests and supplier offers, built with Spring Boot, H2, Flyway, JPA, and MapStruct.

---

🚀 Quick Start
Requirements

Java 17+

Maven 3.8+

---

Build
mvn clean install

Run
mvn spring-boot:run

---

H2 Console
http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:car_app_db
User: sa
Password: (empty)

---

📌 API Endpoints
Customer Requests

---

Base Path: /api/requests

➤ Create a Request
POST /api/requests

Body

{
"customerId": 101,
"description": "Looking for Corolla 2018",
"checkedByCompany": "Auto Check Co"
}

➤ List Requests (filter by status + pagination)
GET /api/requests?status=ACTIVE&page=0&size=10

➤ Update Request Status
PATCH /api/requests/1

Body

{
"status": "Closed"
}

---

Supplier Offers

Base Path: /api/offers

➤ Submit Offer
POST /api/offers

Body

{
"supplierId": 205,
"requestId": 1,
"price": 350000,
"carDetails": "Good condition, 80k km"
}

➤ List Offers by Request
GET /api/offers/by-request/1

➤ List Offers by Supplier
GET /api/offers/by-supplier/205

---

🗄️ Database & Migrations

Flyway migration scripts are located in:

src/main/resources/db/migration/


V1__create_car_buying_app_tables.sql – schema & indexes

V2__seed_data.sql – demo data

---

⚙️ Configuration Overview (application.properties)

H2 in-memory database

Flyway schema migrations enabled

Hibernate auto-DDL disabled (ddl-auto=none)

SQL logging enabled

---

🧱 Tech Stack

Spring Boot 3.x

H2 Database

Flyway

Spring Data JPA

MapStruct

Java 17

---

📁 Project Structure
controller/
service/
repository/
model/
dto/
enums/
mapper/
adapter/      # Inspection adapters