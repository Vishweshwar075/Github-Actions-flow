# github-actions-springboot-demo

A clean, beginner-friendly Spring Boot project built specifically for practicing **GitHub Actions CI/CD**.

---

## 🎯 Project Purpose

The primary goal of this repository is to demonstrate how automated continuous integration (CI) works with GitHub Actions on a Spring Boot application. It contains a minimal REST API with two endpoints and comprehensive unit tests. Every push or pull request to the `main` branch triggers an automated workflow that compiles the code, executes tests, and packages an executable JAR file.

---

## 🛠 Technologies Used

- **Java 21**
- **Spring Boot 4.1.1** (Spring Web, Spring Boot Test)
- **Maven** (Build automation tool)
- **JUnit 5 / Spring Boot Test** (MockMvc test slice)
- **GitHub Actions** (Continuous Integration)

---

## 🚀 How to Clone and Run Locally

### 1. Clone the Repository
```bash
git clone <repository-url>
cd github-actions-springboot-demo
```

### 2. Run Tests
Verify that all unit tests pass:
```bash
mvn clean test
```

### 3. Run the Application Locally
Start the embedded Tomcat server on port `8080`:
```bash
mvn spring-boot:run
```

Once started, the application will be listening on `http://localhost:8080`.

---

## 📡 API Endpoints

The application exposes two simple REST endpoints:

### 1. Hello Endpoint
- **Method:** `GET`
- **URL:** `http://localhost:8080/api/hello`
- **Response Status:** `200 OK`
- **Response Body:**
  ```json
  {
    "message": "Hello from Spring Boot!"
  }
  ```

### 2. Status Endpoint
- **Method:** `GET`
- **URL:** `http://localhost:8080/api/status`
- **Response Status:** `200 OK`
- **Response Body:**
  ```json
  {
    "status": "Application is running",
    "version": "1.0.0"
  }
  ```

---

## ⚙️ How GitHub Actions Works in This Project

The repository contains a GitHub Actions workflow defined in [`.github/workflows/ci.yml`](.github/workflows/ci.yml).

### Triggers
The workflow triggers automatically whenever:
1. A **push** is made to the `main` branch.
2. A **pull request** targeting the `main` branch is opened or updated.

### Runner Environment
The job runs inside an **`ubuntu-latest`** virtual environment hosted by GitHub.

### Expected CI Pipeline Flow

```text
Push / Pull Request
        ↓
Checkout Code
        ↓
Setup Java 21
        ↓
Maven Dependencies (Cached)
        ↓
Run Tests (mvn clean test)
        ↓
Build JAR (mvn clean package -DskipTests)
```

1. **Checkout Code:** Uses `actions/checkout@v4` to clone the repository onto the runner.
2. **Setup Java 21:** Uses `actions/setup-java@v4` to configure the Eclipse Temurin JDK 21 distribution and enables Maven dependency caching to speed up subsequent runs.
3. **Run Tests:** Executes `mvn clean test`. If any test fails, the workflow immediately fails and prevents deployment or merging.
4. **Build JAR:** Executes `mvn clean package -DskipTests` to assemble the final executable JAR in the `target/` directory once all tests have succeeded.
