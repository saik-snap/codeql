**Logging Best practices**

We are using SLF4j as logging framework. Below are best practices every developer needs to stick to.

* **Do not use `printStackTrace()` or `System.out.println()`**

* **Use Lombok `@Slf4j` annotation to create logger**

* **Use slf4j parameterized log statement**

  Do not use String concatenation. Use parameterized message

  *`log.info("Processing request with id: {}", requestId);`* `//Use this`

  *`log.info("Processing request with id: + requestId");`*  `//Avoid this`

* **Log Exception, exception messages**

  `log.error("Event Received : {}", e);` `//USe this`

  *`log.error("Event Received : {}", e.getMessage());`*  `//Avoid this`

* **Avoid side effect of logging**

  If logging statement itself fails and causes business process to terminate due to exception, this is a huge side effect. Avoid such log statements.

  *`log.info("Processing request with id: {}", request.getId());`* `//Avoid this as it can cause NPE` 

  *`log.info("Processing request with id: {}", request.getId()!=null ? request.getId(): "");`* `//Use this` 

* **Be concise and descriptive**

  Each logging statement should contain both data and description. Consider the following examples:

  *`log.debug("Message processed");`* `//Avoid this`
  
  *`log.debug(JMSMessageID);`* `//Avoid this`

  *`log.debug("Message with id '{}' processed", JMSMessageID);`* `//Use this`

* **Avoid logging sensitive information**

  Since we are working banking application, restrictions are imposed on logging sensitive information. Prevent logging such information. Below is list 

  * PIN
  * OTP
  * customer id
  * etc

* **Avoid Unnecessary logs**

  Avoid unnecessary log statements that are not useful for development or production run.

  Keep in mind, overlogging degrades performance, but don't choose under logging also.

  Think about what logs you will need when tomorrow you are debugging a production system.

* **Don’t forget, logging levels**

  `ERROR` – something terribly wrong had happened

  `WARN` – potential problems that might cause errors and should be monitored in case they fail

  `INFO` - is the default logging level

  `DEBUG` - Logs include more detailed, specific information that aren't needed in normal situations.

  `TRACE` – Very detailed information, intended only for development.

* **Use appropriate log levels**

  When writing your code think twice about a given log message. Not every bit of information is equally important and not every unexpected situation is an error or a critical message. so choose log level wisely.

* **Do not use location information**

  Such as filename, class name, method name, line number in regular logging because in order to derive those information, the framework takes a snapshot of the stack and walk through it. This impacts the performance. Hence use the location information only in the error log and not in the regular log

* **Make sure spelling is right. Intellij shows warning if you misspell**

* **Log interesting scenarios. If you are returning early log it**

  For example

  `if(user == null) {`

      log.info("No user exists with id {}", userId);
    
      return ;

  `}`

 * **Don't log same information twice**

    If you have logged request in controller don't log the same request in service class.

*  **Add context to your logs so that debugging becomes easier**

*  **Don't log the full collection. Log size.**







