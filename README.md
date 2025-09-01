# 🚀 Spring Boot REST API

Простой RESTful сервис для управления счетами с использованием **Spring Boot 3.0+** и **Java 21**.

## ✨ Особенности

- ✅ Полный CRUD (Create, Read, Update, Delete) операции
- ✅ Встроенная база данных H2 с веб-консолью
- ✅ Использование DTO для запросов и ответов
- ✅ Глобальная обработка исключений
- ✅ Транзакционность с Propagation.REQUIRES_NEW
- ✅ Lombok для сокращения boilerplate кода
- ✅ Actuator для мониторинга

## 🛠 Технологии

- ![Java](https://img.shields.io/badge/Java-21-orange?style=flat-square)
- ![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.0+-6DB33F?style=flat-square)
- ![H2 Database](https://img.shields.io/badge/H2-Database-1BC8E0?style=flat-square)
- ![Maven](https://img.shields.io/badge/Maven-3.8+-CB3837?style=flat-square)
- ![Lombok](https://img.shields.io/badge/Lombok-1.18+-pink?style=flat-square)

## 📦 Зависимости

Основные зависимости:
- `spring-boot-starter-web`
- `spring-boot-starter-data-jpa`
- `spring-boot-starter-actuator`
- `h2database`
- `lombok`

## 🚀 Запуск приложения

1. Клонируйте репозиторий:
```bash
git clone https://github.com/DKAVrZoV65F/spring-hello.git
cd hello-spring
```

2. Запустите приложение:
```bash
mvn spring-boot:run
```

Приложение будет доступно по адресу: `http://localhost:8080`

## 📊 H2 Console

Доступ к встроенной базе данных:  
`http://localhost:8080/h2-console`  
Логин: `sa`  
Пароль: `password`  
JDBC URL: `jdbc:h2:mem:mydb`

## 📡 API Endpoints

| Метод | Эндпоинт | Описание |
|-------|----------|----------|
| `GET` | `/hello` | Тестовый endpoint |
| `POST` | `/accounts` | Создать новый аккаунт |
| `GET` | `/accounts/{id}` | Получить аккаунт по ID |
| `GET` | `/accounts` | Получить все аккаунты |
| `PUT` | `/accounts/{id}` | Обновить аккаунт |
| `DELETE` | `/accounts/{id}` | Удалить аккаунт |
| `GET` | `/string?ABC={text}` | Эхо-сервис |

### Примеры запросов:

**Создание аккаунта:**
```bash
curl -X POST http://localhost:8080/accounts \
-H "Content-Type: application/json" \
-d '{
    "name": "John Doe",
    "email": "john@mail.com",
    "bill": 1000
}'
```

**Получение всех аккаунтов:**
```bash
curl http://localhost:8080/accounts
```

## 🏗 Структура проекта

```
src/
├── main/
│   ├── java/
│   │   └── org/example/hellospring/
│   │       ├── controller/       # REST контроллеры
│   │       ├── entity/           # Сущности БД
│   │       ├── repository/       # JPA репозитории
│   │       ├── service/          # Бизнес-логика
│   │       ├── exception/        # Кастомные исключения
│   │       └── dto/              # Data Transfer Objects
│   └── resources/
│       └── application.yml       # Конфигурация
```

## 🔧 Настройки

Основные настройки в `application.yml`:
- Имя приложения: `hello-spring`
- H2 console включена
- База данных в памяти: `jdbc:h2:mem:mydb`
- JPA диалект: H2

## 📝 Особенности реализации

- Использование DTO для изоляции сущностей БД от API
- Транзакционность с разными propagation уровнями
- Кастомное исключение `AccountNotFoundException`
- Слоистая архитектура (Controller-Service-Repository)

## 🧪 Тестирование

Для запуска тестов:
```bash
mvn test
```

---

## 📄 Лицензия

Этот проект создан в учебных целях.
