#language:ru
@testHelpdesk

Функционал: Тестирование создания тикета с высоким приоритетом

  Сценарий: Создание тикета через API без авторизации с высоким приоритетом (2), авторизоваться в системе,
  получение созданного тикета по id и проверка полученных значений полей тикета с заданными при создании    #создадим тикет и получим его id

    #создадим тикет и получим его id
    Если сгенерировать переменные
      | title       | title RRRRRRRRRR |
      | status      | 1                |
      | description | desc RRRRRRRRR   |
      | priority    | 2                |
      | queue       | 2                |
    И создать запрос
      | method | body                | url                                               |
      | POST   | HelpdeskTicket.json | https://at-sandbox.workbench.lanit.ru/api/tickets |
    И добавить header
      | Content-Type | application/json |
      | Accept       | application/json |
    И отправить запрос
    Тогда статус код 201
    И извлечь данные
      | id | $.id |

    #для получения тикета по id необходимо авторизоваться в системе
    Когда создать запрос
      | method | body                             | url                                             |
      | POST   | HelpdeskUsernameAndPassword.json | https://at-sandbox.workbench.lanit.ru/api/login |
    И добавить header
      | Content-Type | application/json |
      | Accept       | application/json |
    И отправить запрос
    Тогда статус код 200
    И извлечь данные
      | token | $.token |

    #получим тикет по id и сравним поля полученного тикета с заданными на первом шаге
    Если создать запрос
      | method | url                                                     |
      | GET    | https://at-sandbox.workbench.lanit.ru/api/tickets/${id} |
    И добавить header
      | Authorization | token ${token}   |
      | Accept        | application/json |
    И отправить запрос
    Тогда статус код 200

    Если извлечь данные
      | title_actual       | $.title       |
      | status_actual      | $.status      |
      | description_actual | $.description |
      | priority_actual    | $.priority    |
      | queue_actual       | $.queue       |
    Тогда сравнить значения
      | ${title}       | == | ${title_actual}       |
      | ${status}      | == | ${status_actual}      |
      | ${description} | == | ${description_actual} |
      | ${priority}    | == | ${priority_actual}    |
      | ${queue}       | == | ${queue_actual}       |
