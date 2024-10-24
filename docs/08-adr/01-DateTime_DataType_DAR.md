# DAR for datatype finalization for DateTime data

###### Author(s):

- Venkat

## Introduction

This document is created to decide on the Datatype that needs to be used for storing datetime data. Comparision is between the below datatypes

1. Date
2. LocalDateTime
3. TimeStamp
4. Long

## Findings

| Sr. No | DataType           | Advantages                                                   | Disadvantages                                                |
| ------ | ------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 1      | java.util.date     | This datatype can be used for only date and Datetime database types | Mapping date with JPA Entity will require using @Temporal    |
| 2      | LocalDateTime      | Recommended by PL/SQL for PostgreSQL (https://tada.github.io/pljava/use/datetime.html)  - (https://jdbc.postgresql.org/documentation/head/8-date-time.html) | This is without Timezone representation. **OffsetDateTime** is with Timezone. It is immutable. There seems to be some performance issue when conversion from Localdatetime to Date |
| 3      | java.sql.TimeStamp | No need of @Temporal                                         | This ties the JPA entity to JDBC classes. It inherits from java.util.date |
| 4      | Long (epoch)       | Easy to compare. No confusion on formats or timezone differences | Since date is stored as long in database its not readable and needs conversion. (**select** **to_timestamp**(milliseconds/1000)) |



## Result

Its recommended to use LocalDateTime if Timezone is not required and OffsetDatetime of TimeZone is required, as per documentation.

However since the Long i.e. millisecond approach eliminates the datetime cast issues of mm/dd & dd/mm. 





### Decision

It was finalised that as per the recommendations of PL/SQL **java.time.OffsetDateTime** will be used for all the Datetime fields in the Services. TimeStamp with TimeZone to be used for Postgres columntype

###### Attendees

- venkat