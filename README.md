# Eldorado-Hackathon, команда Smart Retail

  
## Участники
* **Фирсаков Тимур** - product manager, telegram: @timurfirsakov 
* **Марашли Илья** - UI/UX, Analitics, telegram: @thebluekit
* **Рыженкова Настя** - Analytics, Data Science, telegram: @avryzhenkova
* **Лозовский Леша** - Backend dev, telegram: @Lozovski_Aleksey 
* **Власов Глеб** - Android, telegram: @velvalvvi 

## Стек технологий backend
* JDK 11 
* REST API – архитектура
* SpringBoot - для автоматической конфигурации
* JPA, Hibernate – работа с базой данных
* H2 – встроенная база данных
* Swagger

## Стек технологий android
* Android SDK 
* Язык Kotlin 
* Retrofit – для работы с REST API
* Coil – для загрузки изображений


## Разрабатываемые процессы
<p align="center">
  <img src="https://github.com/LozovskiAlexey/eldorado/blob/main/Sources/processes.svg">
</p>

### Описание процессов
* **Идентификация консультации**: начало взаимодействия клиента с консультантом. Сканируется QR-код клиента. По идентификаторам клиента и консультанта создается консультация с пустой корзиной. У консультанта отображается информация о клиенте (имя, теги).
* **Формирование корзины**: сканируется QR-код товара. По полученным данным выводится информация о товаре, идентификатор товара добавляется в корзину. 
* **Отправка корзины**: по завершении работы с клиентом нажимается кнопка «Отправить». На почту клиента отправляется список собранных товаров, статус консультации назначается «не завершен» (покупка не была совершена). В случае, если корзина пустая – на почту не происходит отправка, консультации назначается статус «Товары не выбраны».
* **Назначение тегов клиенту**: выбираются теги из списка, клиенту по идентификатору в базе данных назначаются данные теги. 
  
  
## Описание данных

### Компоненты Базы данных
<p align="center">
  <img src="https://github.com/LozovskiAlexey/eldorado/blob/main/Sources/DB_Entities.svg">
</p>

* **Tags:** Разработанная нами фича - тег, описывающий увлечения клиента, состоит из уникального идентификатора и названия тега
* **Client:** Сущность клиента, идентификатор и общая информация необходимо брать из CRM, для прототипа используются Integer значения. 
* **Consultant:** Сущность консультанта, описывается идентификатором и именем, которые необходимо получать из CRM. 
* **Consultation:** Сущность консультации - наша разработанная сущность, в ней хранится информация о консультации, проведенной в реальном времени в магазине
* **Product:** Сущность товара, в идеале должна браться из базы Эльдорадо. 

### Данные для передачи
Для обмена данными используются **DTO**(data transfer object) модели.  
<p align="center">
  <img src="https://github.com/LozovskiAlexey/eldorado/blob/main/Sources/DTO.svg">
</p>

  
## Описание взаимодействия компонентов
**Компоненты:**
* Consultant (Smartphone)
* Client (Smartphone)
* Backend
* Database
  
  
<p align="center">
  <img src="https://github.com/LozovskiAlexey/eldorado/blob/main/Sources/ModuleInteraction.svg">
</p>

## REST API

* **GET client/consultantId/clientId** – получить информацию о клиенте (имя, теги), создать консультацию  
**На выход:** информация о консультации
```yaml
{
    "clientName" : string, 
    "consultationId" : Integer, 
    "tags" : list<string>
}
```
  
* **GET consultation/consultationId/productid** – получить информацию о товаре, записать товар в корзину  
**На выход:** Информация о товаре
```yaml
{
    name: String,
    image: String,
    price: Integer,
    amount: Integer
}
```

* **POST consultation/consultationId** – отправить корзину пользователю  
**На вход:** Список товаров
```yaml
{
    "products" : List<ProductDto>
}
```

* **POST client/tags/clientId** – назначить теги клиенту  
**На вход:** Список тегов для клиента
```yaml
{
    "tags" : list<string>
}
```
  
Получаемые данные из Эльдорадо: надо, чтобы в их базе данных были наши теги, пока их нет, взаимодействия тоже нет. 

* **GET statistics/consultantId** – получить статистику по консультанту  
**На выход:** Описание работы консультанта
```yaml
{
    "consultantId" : int, 
    "consultantName" : string, 
    "totalConsultations" : int, 
    "succeededConsultations" : int, 
    "unfinishedConsultations" : int
}
```

* **POST consultation/consultationId/purchase** – изменить статус консультации на успешную  
**На вход:** Список идентификаторов товаров и их количество
```yaml
{
   "products": List<ProductDto>
}
```




## Диаграмма классов Backend
<p align="center">
  <img src="https://github.com/LozovskiAlexey/eldorado/blob/main/Sources/Class_diagram.svg">
</p>

Структура представляет собой 4 слоя (слой данных(модели) не отображен, но описан выше). 
* **Слой репозиторий:** используется для взаимодействия с базой данных, получение объекта модели или списка объектов по заданному полю
* **Слой сервис** используется для выполнения основной логики, производит сбор данным при помощи репозитория, преобразует данные, при необходимости
* **Слой контроллер** используется для взаимодействия с backend, через него при помощи сервисов выполняется основная логика. Верхний слой взаимодействия с Backend. 
