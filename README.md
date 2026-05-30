# Barangay Health Appointment System

A JavaFX desktop app for managing patient appointments across Medical, Dental, and Vaccination departments.

---

## Tech Stack
- Java 21
- JavaFX 21
- PostgreSQL via Supabase
- dotenv-java (for secure credentials)
- Maven

---

## Supabase Setup

1. Go to [supabase.com](https://supabase.com) and create a project.
2. Go to the **SQL Editor** and run:

```sql
CREATE TABLE patients (
  id SERIAL PRIMARY KEY,
  patient_name TEXT NOT NULL,
  department TEXT NOT NULL,
  concern TEXT,
  date DATE,
  created_at TIMESTAMP DEFAULT NOW()
);
```

3. Go to **Project Settings → Database** and copy your connection details.

---

## Environment Variables

Create a `.env` file in the **root of the project** (same folder as `pom.xml`):

```
DB_URL=jdbc:postgresql://db.<your-project-ref>.supabase.co:5432/postgres
DB_USER=postgres
DB_PASSWORD=your_supabase_password
```

> ⚠️ The `.env` file is listed in `.gitignore` and will NOT be pushed to GitHub.

---

## Running the App

1. Open the project in IntelliJ IDEA.
2. Let Maven download dependencies.
3. Make sure your `.env` file is in the project root.
4. Run `Launcher.java` (or use `mvn javafx:run`).

---

## Screens

| Screen | Description |
|---|---|
| Welcome | App intro with Enter button |
| Dashboard | Cards showing patient count per department |
| Add Patient | Form to book a new appointment |
| View All Patients | Table of all records with delete |
