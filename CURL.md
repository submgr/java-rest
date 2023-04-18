# Тестовые команды cURL

## Пользователи 

### Получить всех пользователей

```shell
curl -X GET http://localhost:8080/api/users
```

### Получить пользователя по эл. почте

```shell
curl -X GET http://localhost:8080/api/users/admin@itcube46.ru
```

### Создать пользователя

```shell
curl -H "Content-Type: application/json" -X POST -d \
'{"email":"a@a","password":"pw","username":"test","age":0}' \
http://127.0.0.1:8080/api/users/create
```

### Изменить пользователя

```shell
curl -H "Content-Type: application/json" -X PATCH -d \
'{"email":"a@a","password":"password","username":"test","age":0}' \
http://127.0.0.1:8080/api/users/update/5
```

### Удалить пользователя

```shell
curl -X DELETE http://127.0.0.1:8080/api/users/delete/5
```

## Публикации

### Последние публикации

```shell
curl -X GET http://localhost:8080/api/posts?recent -u admin@itcube46.ru:password
```

### Все публикации пользователя

```shell
curl -X GET http://localhost:8080/api/posts/user/1 -u admin@itcube46.ru:password
```

### Создание публикации

```shell
curl -H "Content-Type: application/json" -X POST \
-d '{"userId":1,"title":"test","content":"test","views":100}' \
http://127.0.0.1:8080/api/posts/add -u admin@itcube46.ru:password
```

### Обновление публикации

```shell
curl -H "Content-Type: application/json" -X PATCH \
-d '{"userId":1,"title":"New title","content":"New Content","views":1000}' \
http://127.0.0.1:8080/api/posts/update/1 -u admin@itcube46.ru:password
```

### Удаление публикации

```shell
curl -X DELETE http://127.0.0.1:8080/api/posts/delete/1 -u admin@itcube46.ru:password
```

## Комментарии

### Все комментарии пользователя

```shell
curl -X GET http://localhost:8080/api/comments/user/3 -u admin@itcube46.ru:password
```

### Все комментарии к публикации

```shell
curl -X GET http://localhost:8080/api/comments/post/2 -u admin@itcube46.ru:password
```

## Точки переработки отходов

### Получение точек по городу

```shell
curl -X GET http://localhost:8080/api/points/city/Test
```

### Создание точки

```shell
curl -H "Content-Type: application/json" -X POST \
-d '{"city":"Test","latitude":51.643452,"longitude":36.122982,"specialization":"metal","organization":"eco","phone":"","receptionDays":"Пн-Пт 8:00 — 17:00, Сб 8:00 — 14:00"}' \
http://127.0.0.1:8080/api/points/add
```
