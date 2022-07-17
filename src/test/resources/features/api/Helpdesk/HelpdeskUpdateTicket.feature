#language:ru
@testHelpdesk

Функционал: Негативная проверка: перевод статуса тикета из "Закрыт" в "Открыт"

  Сценарий: Создание через API тикета со статусом "закрыт" (4), авторизация в системе,
  попытка изменения статуса тикета на "открыт" (1) с ожиданием ошибки (код ответа 422)

    #создадим тикет со статусом "закрыт" (4) и получим его id
    Если сгенерировать переменные
      | title       | title RRRRRRRRRR |
      | status      | 4                |
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

    #для получения тикета по id необходимо аутентифицироваться в системе
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

    #отправляем HTTP запрос для обновления данных тикета (изменение статуса с "закрыт" (4) на "открыт" (1))
      # и сразу же проверяем статус код (должны получить ответ с кодом 422).
        # Тут выявится баг, т.к. в соответствии с документацией невозможно изменить статус тикета с "закрыт" на "открыт"
          # и должны получить ответ с кодом 422, но по факту статус изменится и получим код 200.
    Если изменить значение переменной status на 1
    И создать запрос
      | method | body                | url                                                     |
      | PUT    | HelpdeskTicket.json | https://at-sandbox.workbench.lanit.ru/api/tickets/${id} |
    И добавить header
      | Authorization | token ${token}   |
      | Content-Type  | application/json |
      | Accept        | application/json |
    И отправить запрос
    Тогда статус код 422