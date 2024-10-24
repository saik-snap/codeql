# Mybank Software Development Best Practices

## Coding Best Practices

* Always do server side validation. This just not only include single field validations but
  also field combinations as well. For example, given a CRN and a debit card number always validate
  that debit card is for the same user whose CRN is given.
* Always use HTTP POST for all API operations. Other HTTP methods are not allowed.
* Always wrap response in the `ApiResponse<T>` object. For successful response, you can use
  `ApiResponse.success()` and for failure response we can use `ApiResponse.error()`.
* No message should be hardcoded in the code.
* Convert checked exceptions to unchecked exceptions and throw them. Do not suppress or ignore exceptions. If you do not want to handle it, then re-throw it. The top layer must handle the exception and translate it into what the user can understand.
* We prefer slf4j for logging. It is a facade on top of existing log libraries like Logback, Log4j.
* Log both the message and exception. For example, `log.error("message", e)`.
* JPA entities should not be exposed in REST controllers. Use `*Request` and `*Response` objects.
* Utils classes should not be injected. Also, they should only have static methods.
* Favor builder over long list constructors
* Use `java.time.OffsetDateTime` for all the DateTime datatype in the services



## Microservices

- Always Use *Feign client* for communicating with other Microservices

  

## Event Naming Best Practices

- Use the [Object Action Framework](https://segment.com/academy/collecting-data/naming-conventions-for-clean-data/#the-object-action-framework): name events according to their interacted object and interaction type, for example, `ProductViewed`. For inspiration look at example events [here](https://www.algolia.com/doc/guides/getting-insights-and-analytics/search-analytics/click-and-conversion-analytics/in-depth/capturing-user-behavior-as-events/#example-events).
- Keep your event names simple.
- Make your event names readable for non-technical team members.
- Use `ProperCase` for event names (capitalize every word).

## Database Best Practices

* Names of tables and columns must consist of lower case letters. To combine two word names use underscores. Columns should be named cautiously, as it is costly to change column names lately. For examples, `title`, `created_at`, `is_active`.
* Columns expressing the concept of *True* or *False*, must be named as `is_xxx`, whose data type should be *unsigned tinyint*  For example, `is_active`.
* All tables should have created_at, created_by, last_modified_at, and last_modified_by columns.
* Use `timestamp with timezone` ColumnType for Datetime columns like create_at, last_modified_at etc.

## Tooling Best Practices

* Use IntelliJ for development.
* Use Jabba to install and manage multiple JVM versions.
