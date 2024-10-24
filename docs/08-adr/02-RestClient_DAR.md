# DAR to Decide on HTTP Client

###### Author(s):

- Venkat

## Introduction

This document is created to decide on the HTTP Client that needs to be used in the project for backend microservices.

1. RestTemplate
2. OkHttp
3. Java 11 HTTP Client
4. Feign



## Findings

| Sr. No | DataType            | Features                                                     | Disadvantages                                                |
| ------ | ------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 1      | RestTemplate        | Spring Boot Implementation. Encapsulates details as compared to http client. Synchronous client to perform HTTP requests. | This might be deprecated in the future. **WebClient** is the successor |
| 2      | OkHttp              | Depends on Okio and Kotlin Standard Library. It comes with advanced features such as connection pooling (if HTTP/2 isn’t available), transparent GZIP compression, and response caching to avoid the network completely for repeated requests. | Third party                                                  |
| 3      | Java 11 HTTP Client | It provides both synchronous and Asynchronous approaches.    | Not Known                                                    |
| 4      | Feign client        | Used with MIcroservice architecture. Supports Spring cloud components. A proxy is created for the REST API that needs to be used. The approach is declarative. Being declarative testing gets eliminated. (https://cloud.spring.io/spring-cloud-netflix/multi/multi_spring-cloud-feign.html). It also supports encoding and logging. | Not known                                                    |



## Result

Its recommended to use **Feign client** since we are using microservices architecture and would be using Spring cloud components like config server etc.



### Decision

  It was finalised Feign Client will be used for intercommunication between the Microservices

###### Attendees

-  