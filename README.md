# Flights meta subscriber

## About the project

The app that allows to merge some subscribe on flights to one "meta"-subscribe. This project based on [cycle of articles](https://javarush.ru/groups/posts/2400-sozdanie-sistemih-monitoringa-cen-na-aviabiletih-poshagovoe-rukovodstvo) about SkyScanner API, [part 2](https://javarush.ru/groups/posts/2401-sozdanie-sistemih-monitoringa-cen-na-aviabiletih-poshagovoe-rukovodstvo-chastjh-2) and [part 3](https://javarush.ru/groups/posts/2402-sozdanie-sistemih-monitoringa-cen-na-aviabiletih-poshagovoe-rukovodstvo-chastjh-3). More info and ready to use SkyScanner library in the next articles - [part 1](https://javarush.ru/groups/posts/2430-gayd-po-sozdaniju-klienta-dlja-skyscanner-api-i-ego-publikacii-v-jcenver-i-maven-central) and [part 2](https://javarush.ru/groups/posts/2431-gayd-po-sozdaniju-klienta-dlja-skyscanner-api-i-ego-publikacii-v-jcenver-i-maven-central-chastj). Because SkyScanner API on Rapid is deprecated, we will use [Aviasales API](https://www.aviasales.ru/API). Docs on [travelpayouts](https://support.travelpayouts.com/hc/ru/articles/203956163-Aviasales-API-%D0%B4%D0%BE%D1%81%D1%82%D1%83%D0%BF%D0%B0-%D0%BA-%D0%B4%D0%B0%D0%BD%D0%BD%D1%8B%D0%BC-%D0%B4%D0%BB%D1%8F-%D1%83%D1%87%D0%B0%D1%81%D1%82%D0%BD%D0%B8%D0%BA%D0%BE%D0%B2-%D0%BF%D0%B0%D1%80%D1%82%D0%BD%D1%91%D1%80%D1%81%D0%BA%D0%BE%D0%B9-%D0%BF%D1%80%D0%BE%D0%B3%D1%80%D0%B0%D0%BC%D0%BC%D1%8B#prices-for-dates) and [github](https://travelpayouts.github.io/slate/). Aviasales Search API [rules](https://support.travelpayouts.com/hc/ru/articles/210995808-%D0%A3%D1%81%D0%BB%D0%BE%D0%B2%D0%B8%D1%8F-%D0%BF%D1%80%D0%B5%D0%B4%D0%BE%D1%81%D1%82%D0%B0%D0%B2%D0%BB%D0%B5%D0%BD%D0%B8%D1%8F-%D0%B4%D0%BE%D1%81%D1%82%D1%83%D0%BF%D0%B0-%D0%BA-API-%D0%BF%D0%BE%D0%B8%D1%81%D0%BA%D0%B0-%D0%B1%D0%B8%D0%BB%D0%B5%D1%82%D0%BE%D0%B2) allow only for user search, therefore we will use [**cashed** data](https://support.travelpayouts.com/hc/ru/articles/203956083-%D0%A3%D1%81%D0%BB%D0%BE%D0%B2%D0%B8%D1%8F-%D0%BF%D1%80%D0%B5%D0%B4%D0%BE%D1%81%D1%82%D0%B0%D0%B2%D0%BB%D0%B5%D0%BD%D0%B8%D1%8F-%D0%B4%D0%BE%D1%81%D1%82%D1%83%D0%BF%D0%B0-%D0%BA-API-%D0%B4%D0%B0%D0%BD%D0%BD%D1%8B%D1%85) - last 48 hours, based on users search.

## Plan to develop

* Add Postgresql database support to project. Write db schema on [https://dbdiagram.io](https://dbdiagram.io/d/61b4583b8c901501c0eb6ddb). We will add next tables:
  * [Country](https://travelpayouts.github.io/slate/#data-of-countries-in-json-format)
  * [City](https://travelpayouts.github.io/slate/#city-data-in-json-format)
  * [Airport](https://travelpayouts.github.io/slate/#airport-data-in-json-format)
  * User
  * UserContactTypes
  * UserContacts
  * Subscribe
  * SubscribeDetails
  * SubscribeResults
  * ScheduleInterval
* Maybe we need to add BPMN model to project. Created, for example, in [Camunda modeler](https://camunda.com/products/camunda-platform/modeler/)
* Add Spring Scheduler to project and add next API data for update it once a day:
  * [Country](https://travelpayouts.github.io/slate/#data-of-countries-in-json-format)
  * [City](https://travelpayouts.github.io/slate/#city-data-in-json-format)
  * [Airport](https://travelpayouts.github.io/slate/#airport-data-in-json-format)
* Add data and service layer (entity, dto, repositories, service) to project for other objects.
* Add REST API to project
* Add frontend

## How to use

## Where to view results
