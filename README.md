# not-tunes

[![standard-readme compliant](https://img.shields.io/badge/standard--readme-OK-green.svg?style=flat-square)](https://github.com/RichardLitt/standard-readme)
[![web](https://img.shields.io/static/v1?logo=icloud&message=Online&label=web&color=success)](https://not-tunes.herokuapp.com/)

### Noroff Java Fullstack bootcamp Assignment 6: not-tunes Spring Boot Web API

A Java web application powered by Spring Boot. It converts Chinook sample SQL database queries into data displayed on Thymeleaf templates and REST endpoints. Thymeleaf home page displays five random tracks, artists and genres. User can search for songs by inputing queries into search box. Queries can consist of a track name, artist name or their combination.

## Table of Contents

- [Install](#install)
- [Usage](#usage)
- [API](#api)
- [Examples](#examples)
- [Live](#live)
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

## Examples

Postman collections exported into JSON.

<details>
<summary>Customer endpoints: </summary>
<br>
 
````{
	"info": {
		"_postman_id": "66263f98-1fdf-43fa-af7a-c62e52894e5c",
		"name": "Customer",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
	},
	"item": [
		{
			"name": "Create new customer",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\r\n \"customerId\": \"60\",\r\n \"firstName\": \"Julius\",\r\n \"lastName\": \"Huttunen\",\r\n \"country\": \"Finland\",\r\n \"postalCode\": \"00420\",\r\n \"phone\": \"0455314\",\r\n \"email\": \"huttunen@suomi.fi\"\r\n}"
				},
				"url": {
					"raw": "http://localhost:8080/api/customers",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"customers"
					]
				}
			},
			"response": []
		},
		{
			"name": "Get all customers",
			"request": {
				"method": "GET",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json",
						"type": "text"
					}
				],
				"url": {
					"raw": "http://localhost:8080/api/customers",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"customers"
					]
				}
			},
			"response": []
		},
		{
			"name": "Get customer by id",
			"request": {
				"method": "GET",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json",
						"type": "text"
					}
				],
				"url": {
					"raw": "http://localhost:8080/api/customers/1",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"customers",
						"1"
					]
				}
			},
			"response": []
		},
		{
			"name": "Get customer by name",
			"request": {
				"method": "GET",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json",
						"type": "text"
					}
				],
				"url": {
					"raw": "http://localhost:8080/api/customers/search?name=daanpeeters",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"customers",
						"search"
					],
					"query": [
						{
							"key": "name",
							"value": "daanpeeters"
						}
					]
				}
			},
			"response": []
		},
		{
			"name": "Paginate customers by limit and offset",
			"request": {
				"method": "GET",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json",
						"type": "text"
					}
				],
				"url": {
					"raw": "http://localhost:8080/api/customers/page/10?offset=10",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"customers",
						"page",
						"10"
					],
					"query": [
						{
							"key": "offset",
							"value": "10"
						}
					]
				}
			},
			"response": []
		},
		{
			"name": "Update customer",
			"request": {
				"method": "PUT",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\r\n \"customerId\": \"60\",\r\n \"firstName\": \"Joonas\",\r\n \"lastName\": \"Huttunen\",\r\n \"country\": \"Finland\",\r\n \"postalCode\": \"00420\",\r\n \"phone\": \"045531422\",\r\n \"email\": \"huttunen@suomi.fi\"\r\n}"
				},
				"url": {
					"raw": "http://localhost:8080/api/customers/60",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"customers",
						"60"
					]
				}
			},
			"response": []
		},
		{
			"name": "Get countries by the amount of customers",
			"request": {
				"method": "GET",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json",
						"type": "text"
					}
				],
				"url": {
					"raw": "http://localhost:8080/api/customers/countries",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"customers",
						"countries"
					]
				}
			},
			"response": []
		},
		{
			"name": "Get highest spending customers",
			"request": {
				"method": "GET",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json",
						"type": "text"
					}
				],
				"url": {
					"raw": "http://localhost:8080/api/customers/invoice",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"customers",
						"invoice"
					]
				}
			},
			"response": []
		},
		{
			"name": "Get the favorite genre of a customer",
			"request": {
				"method": "GET",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json",
						"type": "text"
					}
				],
				"url": {
					"raw": "http://localhost:8080/api/customers/1/popular/genre",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"customers",
						"1",
						"popular",
						"genre"
					]
				}
			},
			"response": []
		}
	]
}
````
 
</details>


<details>
<summary>Other endpoints: </summary>
<br>
 
 ````{
	"info": {
		"_postman_id": "bb4922c8-192b-4e78-a016-f706dcc8b562",
		"name": "Other",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
	},
	"item": [
		{
			"name": "Get 5 random tracks",
			"request": {
				"method": "GET",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json",
						"type": "text"
					}
				],
				"url": {
					"raw": "http://localhost:8080/api/random/track",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"random",
						"track"
					]
				}
			},
			"response": []
		},
		{
			"name": "Get 5 random genres",
			"request": {
				"method": "GET",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json",
						"type": "text"
					}
				],
				"url": {
					"raw": "http://localhost:8080/api/random/genre",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"random",
						"genre"
					]
				}
			},
			"response": []
		},
		{
			"name": "Get 5 random artists",
			"request": {
				"method": "GET",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json",
						"type": "text"
					}
				],
				"url": {
					"raw": "http://localhost:8080/api/random/artist",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"random",
						"artist"
					]
				}
			},
			"response": []
		},
		{
			"name": "Get tracks by artist name or track name",
			"request": {
				"method": "GET",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json",
						"type": "text"
					}
				],
				"url": {
					"raw": "http://localhost:8080/api/track?name=audioslave g",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"track"
					],
					"query": [
						{
							"key": "name",
							"value": "audioslave g"
						}
					]
				}
			},
			"response": []
		}
	]
}
 ````
 
</details>

## Live

Docker image created and served through Container Registry at Heroku [not-tunes herokuapp](https://not-tunes.herokuapp.com/)

## Maintainers

[@JuliusHuttunen](https://github.com/JuliusHuttunen)

[@teemunasanen](https://github.com/teemunasanen)

## Contributing

PRs accepted.

Small note: If editing the README, please conform to the [standard-readme](https://github.com/RichardLitt/standard-readme) specification.

## License

MIT © 2022 Julius Huttunen &amp; Teemu Näsänen
