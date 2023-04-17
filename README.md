# RESTful API

## Пример серверной части веб-приложения с использованием Spring Boot 3

Учебный проект направления ["Основы программирования на языке Java"](https://vk.com/jkursk).

### Сборка проекта

Для очистки проекта необходимо выполнить следующую команду Maven:

```shell
.\mvnw clean
```

Для сборки необходимо выполнить следующую команду Maven:

```shell
.\mvnw package
```

Получившийся JAR-файл будет помещён в каталог *target*.

Для запуска необходимо выполнить следующую команду:

```shell
java -jar target\rest-1.0-SNAPSHOT.jar
```

### Сборка образа Docker-контейнера

Для создания контейнера необходимо установить среду выполнения Docker и выполнить следующую команду Maven:

```shell
.\mvnw spring-boot:build-image
```

Создание образа из Dockerfile:

```shell
docker build -t itcube46/rest:1.0-SNAPSHOT .
```

Запуск образа:

```shell
docker run -p 8080:8080 itcube46/rest:1.0-SNAPSHOT
```