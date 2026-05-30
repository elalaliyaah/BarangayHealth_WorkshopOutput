# Barangay Health Appointment System

Molato, Eliyah G.

COMP 009 Object-Oriented Programming

BSIT 2-2

BarangayHealth_WorkshopOutput

Barangay Health Appointment System is a desktop app for managing patient appointments across Medical, Dental, and Vaccination departments.

---

## Requirements/Instructions:
1. Multiple Views
2. Database connection
3. Environments stored securely

---

## Supabase Setup

1. Go to supabase.com and create a project
2. Go to the SQL Editor
3. Go to Project Settings, then Database, and copy connection details

---

## Environment Variables

Create a .env file
```
DB_URL=[url]
DB_USER=[user]
DB_PASSWORD=[password]
```
The .env file is listed in .gitignore and will not be pushed to GitHub

---

## Running the App

1. Open the project in IntelliJ IDEA
2. Let Maven download dependencies
3. Make sure .env file is in the project root
4. Run Launcher.java

---

## Screens

| Screen | Description |
|---|---|
| Welcome Page | App introduction with Enter button |
| Dashboard | Cards showing patient count per department |
| Add Patient | Form to book a new appointment |
| View All Patients | Table of all records with delete |
