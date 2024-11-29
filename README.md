

---

# **User-Login-Info** 🛠️🔐

A robust **User Management and Attendance Tracking System** built using **Spring Framework** and **JPA/Hibernate**. This project provides functionalities like user registration, login/logout, attendance management, and CRUD operations, with a focus on scalability and professional-grade implementation.

---

## 🚀 **Features**

- **User Management**:
    - 📋 Register a new user with unique credentials.
    - 🔑 Login with secure authentication.
    - 🔓 Logout with automatic attendance updates.
    - ✏️ Update user details (name, phone number, password).
    - 🗑️ Delete user accounts securely.

- **Attendance Tracking**:
    - ⏱️ Automatically record login/logout times.
    - 📊 View attendance history for users.

- **Database Integration**:
    - Seamless ORM mapping using **Hibernate**.
    - Relational database design with **JPA annotations**.

- **Spring Integration**:
    - Dependency injection using **Spring Framework**.
    - Modular configuration with **Spring Beans**.

---

## 🧱 **Project Structure**

```
src/
├── main/
│   ├── java/
│   │   ├── com.uli.dao/          # Data Access Object (DAO) Layer
│   │   ├── com.uli.dto/          # Data Transfer Objects (Entities)
│   │   ├── com.uli.service/      # Spring Configuration & Utility Classes
│   │   └── com.uli.view/         # Driver Program for User Interaction
│   └── resources/
│       ├── META-INF/             # Persistence configuration
│       └── application.properties
```

---

## 📜 **Technologies Used**

| Technology           | Purpose                          |
|-----------------------|----------------------------------|
| **Java**             | Core programming language        |
| **Spring Framework** | Dependency injection and beans   |
| **JPA/Hibernate**    | ORM and database interaction     |
| **MySQL**            | Relational database management   |
| **Lombok**           | Simplifies boilerplate code      |
| **IntelliJ IDEA**    | Development IDE                  |

---

## ⚙️ **Installation**

### **Prerequisites**
1. **Java 17+** installed.
2. **MySQL** database setup.
3. **Maven** or **Gradle** installed.

### **Steps**
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/User-Login-Info.git
   cd User-Login-Info
   ```
2. Configure the database:
    - Update database connection details in `persistence.xml` or `application.properties`.

3. Build the project:
   ```bash
   mvn clean install
   ```

4. Run the project:
   ```bash
   java -jar target/User-Login-Info.jar
   ```

---

## 🛠️ **Usage**

### **1. Register a User**
- Input: Name, Phone Number, Password.
- Creates a new user record in the database.

### **2. Login**
- Input: Phone Number, Password.
- Validates credentials and creates an attendance record.

### **3. Logout**
- Input: Attendance ID.
- Updates logout time and attendance status.

### **4. Update User**
- Input: Choose to update name, phone number, or password.

### **5. Delete User**
- Input: Phone Number.
- Permanently deletes the user record.

---

## 🏗️ **Contributing**

We welcome contributions to improve this project! To contribute:
1. Fork this repository.
2. Create a new branch for your feature or bug fix.
3. Submit a pull request with a detailed description.

Please ensure your contributions comply with our [License](#-license).

---

## 📄 **License**

This project is licensed under the [MIT License](LICENSE).  
Feel free to use, modify, and distribute this project within the bounds of the license.

---

## 👥 **Acknowledgments**

- 💡 Special thanks to the **Spring** and **Hibernate** teams for providing excellent documentation and frameworks.
- 🙌 Inspired by best practices in software development.

---

## 🔗 **Connect With Me**

- **GitHub**: [Purohit1999](https://github.com/Purohit1999)
- **LinkedIn**: [Param Purohit](https://www.linkedin.com/in/param-p-370616310/)

---

## ⭐ **Support This Project**

If you found this project helpful, please consider giving it a **star** 🌟 on GitHub. Your support helps me keep improving the project!

Thank you for checking out **User-Login-Info**! 😊

---
