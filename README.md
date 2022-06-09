# Currency Rate Service

Данный сервис обращается к сервису курсов валют и отображает случайную гифку: [весёлую](https://giphy.com/search/rich) или [грустную](https://giphy.com/search/broke).

## Установка

<details>

<summary>Перечень команд для развертывания сервиса</summary>

```bash
    git clone https://github.com/lihogub/currency-rate-spring.git
    cd currency-rate-spring
    DOCKER_BUILDKIT=1 docker build -t olihogub/currency-rate .
    docker run -p 8080:8080 olihogub/currency-rate currency-rate
```

</details>


### Переменные окружения

<details>

<summary>Сервис настраивается с помощью переменных окружения</summary>

| Переменная окружения  | Описание                                     | Значение  по умолчанию            |
|-----------------------|----------------------------------------------|-----------------------------------|
| GIPHY_API_URL         | URL сервиса с гифками                        | https://api.giphy.com/v1          |
| GIPHY_API_KEY         | Ключ для API сервиса с гифками               | 8Cj2M7PoQWMqd9XfI4j5oLtCLyKZ6e70  |
| OPEN_EXCHANGE_API_URL | URL сервиса с обменными курсами              | https://openexchangerates.org/api |
| OPEN_EXCHANGE_APP_ID  | `app_id` для API сервиса с обменными курсами | 636a9a120ce04033b05dd33427f5b8dd  |
| BASE_CURRENCY         | Базовая валюта                               | USD                               |

</details>

## REST API
    
Базовый URL для всех эндпоинтов REST API http://localhost:8080/api

Описание эндпоинтов в SwaggerUI по адресу http://localhost:8080/api/docs

### Список доступных валют

`GET /currencies` возвращает список всех доступных валют

<details>

<summary> Результат </summary>

```json
[
    ...
    {
        "ticker": "USD",
        "description": "United States Dollar"
    }
    ...
]
```

</details>


### Текущая базовая валюта

`GET /currencies/base` возвращает текущую базовую валюту, относительно которой ведутся расчеты

<details>

<summary> Результат </summary>

```json
{
    "ticker": "RUB",
    "description": "Russian Ruble"
}
```

</details>

### Статус интересующей валюты

`GET /status/{targetCurrencyTicker}` возвращает статус для указанной валюты (валюта указывается как трёхбуквенный код, например, `RUB`)

<details>

<summary> Результат </summary>

```json
{
    "deltaPrice": 2.5,
    "gifUrl": "https://domain.com/mygif.gif"
}
```

</details>

## Front-end

Находится по адресу http://localhost:8080

<span>
  <img src="https://user-images.githubusercontent.com/57266314/172878989-01f2247c-1832-41b5-a168-63c1ba512eb8.gif" width="250">
</span>
