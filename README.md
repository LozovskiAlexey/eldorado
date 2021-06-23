# eldorado

## Участники
* **Фирсаков Тимур** - product manager, telegram: @timurfirsakov 
* **Марашли Илья** - UI/UX, Analitics, telegram: @thebluekit
* **Рыженкова Настя** - Analytics, Data Science, telegram: @avryzhenkova
* **Лозовский Леша** - Backend dev, telegram: @Lozovski_Aleksey 
* **Власов Глеб** - Android, Frontend dev, telegram: @velvalvvi 


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

## Описание процессов
* **Идентификация консультации**: начало взаимодействия клиента с консультантом. Сканируется QR-код клиента. По идентификаторам клиента и консультанта создается консультация с пустой корзиной. У консультанта отображается информация о клиенте (имя, теги).
* **Формирование корзины**: сканируется QR-код товара. По полученным данным выводится информация о товаре, идентификатор товара добавляется в корзину. 
* **Отправка корзины**: по завершении работы с клиентом нажимается кнопка «Отправить». На почту клиента отправляется список собранных товаров, статус консультации назначается «не завершен» (покупка не была совершена). В случае, если корзина пустая – на почту не происходит отправка, консультации назначается статус «Товары не выбраны».
* **Назначение тегов клиенту**: выбираются теги из списка, клиенту по идентификатору в базе данных назначаются данные теги. 



## Описание данных


## Описание взаимодействия компонентов
**Компоненты:**
* Consultant (Smartphone)
* Client (Smartphone)
* Backend
* Database


## REST API

## Диаграмма классов Backend

