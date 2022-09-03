**Авторизация**
Авторизация осуществляется через POST метод `http://localhost:8080/auth/login`
Type: `Basic Auth`  
При успешной авторизации status response буде код 200 и в header ответа в поле x-csrf-token придёт токен который необходимо отправлять в header запроса x-csrf-token

Пример Curl:
`curl --location --request POST 'http://localhost:8080/auth/login' \
--header 'Authorization: Basic QWRtaW46QWRtaW4x' \
--data-raw ''`

**Пролонгация залогового билета**
`curl --location --request PUT 'http://localhost:8080/pledge_ticket/3' \
--header 'x-csrf-token: eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI0NGRlM2Q0YjdhMzM0MGUwYTVjNWE3ODAxM2FlMThkOSIsImlhdCI6MTY2MjIyMDI5NiwibmJmIjoxNjYyMjIwMjk2LCJleHAiOjE2NjIyMjIwOTZ9.XU6wTUUEc6IIUT8kGl-trer5dfc1gN8UwSBCnI_raIc' \
--header 'Content-Type: application/json' \
--data-raw '{
    "endDate" : "2026-01-01"
}'`

**Создание залогового билета**
`curl --location --request POST 'http://localhost:8080/pledge_ticket/' \
--header 'x-csrf-token: eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxM2ExODA0ZGUwNGM0NGE1OTQ2ZDc1YWRhOGM2MTQ1NiIsImlhdCI6MTY2MjIyMDc1NCwibmJmIjoxNjYyMjIwNzU0LCJleHAiOjE2NjIyMjI1NTR9.pDKipemcHFKtjK6DpTjoXv84NpOB-LrZ2qsxw-ZzXfM' \
--header 'Content-Type: application/json' \
--data-raw '{
    "user" : {
        "id" : "1"
    },
    "startDate" : "2022-01-10",
    "endDate" : "2033-01-01",
    "assessedValue" : "12.2",
    "loanAmount" : "12.2",
    "description" : "Мега описание5",
    "pledgedProperty" : "Свойство"
}'`