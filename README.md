# not-tunes

[![standard-readme compliant](https://img.shields.io/badge/standard--readme-OK-green.svg?style=flat-square)](https://github.com/RichardLitt/standard-readme)

### Noroff Java Fullstack bootcamp Assignment 6: not-tunes Spring Boot Web API

A Java web application powered by Spring Boot. It converts Chinook sample SQL database queries into data displayed on Thymeleaf templates and REST endpoints. Thymeleaf home page displays five random tracks, artists and genres. User can search for songs by inputing queries into search box. Queries can consist of a track name, artist name or their combination.

## Table of Contents

- [Install](#install)
- [Usage](#usage)
- [API](#api)
- [Maintainers](#maintainers)
- [Contributing](#contributing)
- [License](#license)

## Install

Clone the repository into the directory of your choice.

```
git clone https://github.com/teemunasanen/not-tunes.git
```

## Usage

Run the project with a compatible IDE of your choice. May need some work depending on your setup.

## API

### 1. Customer endpoints

```
api/customers
```
- Get all the customers saved into the database.

```
api/customers/{id}
```
- Get the customer with the given id.

```
api/customers/search?name={name}
```
- Get the customer with the given name.
- Can concatenate first and last names: ``name=daanp`` -> "Daan Peeters"

```
api/customers/page/{size}?offset={offset}
```
- Paginate customers by page size limit and offset.
- Offset skips all customer ids before the offset value: ``offset=10`` -> get customers starting from id 11

```
api/customers/countries
```
- Get countries by the number of customers.

```
api/customers/invoice
```
- Get the biggest spenders among customers (Highest added invoice amount).

```
api/customers/{id}/popular/genre
```
- Get the customer's favorite genre by customer's id.

### 2. Other endpoints

```
api/random/track
```
- Get five random tracks.

```
api/random/artist
```
- Get five random artists.

```
api/random/genre
```
- Get five random genres.

```
api/track?name={name}
```
- Get tracks matching the name query.
- Can be concatenated: ``name=audioslave%20cochise`` -> returns the track Audioslave - Cochise

### 3. Create and update customers

- Create a customer: ``POST`` to ``api/customers``. Provide a request body such as:
````{
 "customerId": "{id}",
 "firstName": "{firstName}",
 "lastName": "{lastName}",
 "country": "{country}",
 "postalCode": "{postalCode}",
 "phone": "{phone}",
 "email": "{email}"
}
````
- Update a customer: ``PUT`` to ``api/customers/{id}``. Provide a request body.

[Postman](https://www.postman.com/) is a great tool to handle these requests.

## Maintainers

[@JuliusHuttunen](https://github.com/JuliusHuttunen)

[@teemunasanen](https://github.com/teemunasanen)

## Contributing

PRs accepted.

Small note: If editing the README, please conform to the [standard-readme](https://github.com/RichardLitt/standard-readme) specification.

## License

MIT © 2022 Julius Huttunen &amp; Teemu Näsänen
