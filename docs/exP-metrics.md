# Метрики С. Чидамбера и К. Кемерера

| Класс               | число методов | полей | CBO | RFC | LCOM |
|---------------------|---------------|-------|-----|-----|------|
| GameController      | 1             | 1     | 3   | 2   | 0    |
| LoginController     | 3             | 1     | 5   | 7   | 1    |
| RouletteService     | 2             | 3     | 6   | 8   | 1    |
| Bet                 | 6             | 4     | 1   | 6   | 7    |
| Result              | 2             | 3     | 1   | 2   | 0    |
| Roulette            | 5             | 5     | 6   | 8   | 0    |
| User                | 5             | 4     | 0   | 5   | 4    |

* WMC: считаем как число методов. (в таблице)
* DIT, NOC: 0, нет наследования

### Анализ
1. Высокая связность (CBO height coupling) класса `RouletteService`.
   * `RouletteService` слишком зависим от `Bet` и его методов, выполняет вычисления ставок
   * **Решение:** вынести логику в отдельный класс `BetService`, чтобы уменьшить зависимости.
2. Высокая связность (CBO height coupling) класса `Roulette`.
   * Постоянно обращается к классам `Bet` и `User`. Добавляет пользователей, делает ставку, добавляет ставку в массив
   * **Решение:** разделить операции между классами`BetService` и `UserService`
3. Высокий RFC, перегруженность классов `RouletteService` и `Roulette`.
   * Причины и решения те же что и в пункте 1 и 2.
4. Low cohesion для класса `Roulete`. 
   * Хранит информацию о всех пользователях и ставках, поля внутри класса не взаимосвязанны
   * LCOM для него низкий только за счет использования `users` - как базы данных
   * **Решение:** создание отдельной базы данных сервисов для обработки разных классов запросов
5. У класса `Bet` высокий LCOM В основном это потому что все методы которые там есть,
   * В классе в основном сеттеры и геттеры отдельных полей. 
   * Структура данных не оптимальна, большое количество малосвязанных полей и методов
   * **Решение:** Объединить или вынести информацию о ставке (тип, число) в общее поле или отдельный класс `BetInfo`.

Посмотрим на все метрики вместе, больше всего проблем в классах `RouletteService`, `Roulette` и `Bet`. В основном
они связаны с отсутствием дополнительных классов, которые бы позволили более грамотно разделить данные и задачи.
Такими классами могут стать `UserService` и `BetService`. Это позволит решить проблемы с перегрузкой классов `Bet` и `User`, разделить логически не связанные операции в классе
`Roulette` и `RouletteService`, адрессовать их к соответсвующим сущностям. Также поможет выделение информации о ставках в отдельные
конструкции. Это решит проблемы с лишней информацией в классе `Roulette` и возможно c неструктурированной информацией в классе `Bet`





