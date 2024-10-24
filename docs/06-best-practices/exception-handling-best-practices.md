**Exception Handling Best practices**

We are using spring boot as framework for developing microservices. 

Below are best practices of exception handling that every developer needs to stick to.

- **Use @ControllerAdvice  for handling exceptions**

  This solves many issues of maintaining code quality, as well as increase readability of the code. This will help everyone to debug all the errors at a common place of your application.

  * Throw custom exceptions from service layer

        public ApiResponse<DeviceResponse>
        registerDevice(DeviceRegisterRequest deviceRegisterRequest) 
                                                throws 	DeviceNotFoundExcption {
        .......
        }

  * Don't handle exceptions in controller

        @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
        public ApiResponse<DeviceResponse> registerDevice(@Valid @RequestBody DeviceRegisterRequest deviceRegisterRequest) {
          return deviceService.registerDevice(deviceRegisterRequest);
        }

  * Use ControllerAdvice to generate error response

        @ControllerAdvice
        public class RestExceptionHandler {
        @ExceptionHandler(value = {DeviceNotFoundExcption.class})
        @ResponseStatus(value = HttpStatus.OK)
        @ResponseBody
          ApiResponse<DeviceResponse> handleDeviceNotFound(DeviceNotFoundExcption ex) {
            ..........
            //TODO - call CMS for actual message to be sent to front end say 'errorMessag'
            return ApiResponse<DeviceResponse>.error(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), errorMessage, errors));
          }
        }
  
  * Use @ResponseStatus as 200 i.e. HttpStatus.OK for every handled exception as shown above.
  
  * ErrorResponse code should be used carefully based on below listing
  
    `404 NOT FOUND`
  
    `400 Bad Request`
  
    `403 Forbidden`
    
    `Any custom code as per service logic`


  * Error message - call CMS for actual message  


- **Don’t use printStackTrace() statement**

- **Define custom exceptions as per need**

  Suppose, we have 3 fields. Account number, Mobile number, Device Number.

  Each field has its own validation routine. If it fails, we can throw Custom exception which should extend `RuntimeException`.

  e.g.

   `InvalidAccountException` `InvalidMobileException` `InvalidDeviceException`        `//Avoid this`

  Better approach is to club similar exceptions and create only single exception

  e.g.

  `InvalidFieldException`     `//Use this`

- **Throw Specific Exceptions**

  More specific the exception is that you throw, the better.

  `public void doNotDoThis() throws Exception {         //Avoid this`
  `     ...`
  `}`

  `public void doThis() throws AccountNotFoundException {   //Use this
      ...
  }`

- **Catch the Most Specific (i.e. subclass) Exception First**

  Most IDEs help you with this best practice. They report an unreachable code block when you try to catch the less specific exception first.

  The problem is that only the first catch block that matches the exception gets executed. So, if you catch an *SQLException* first, you will never reach the catch block that should handle the more specific *BatchUpdateException* because it’s a subclass of the *SQLException*.

  You can see an example of a try-catch statement in the following code snippet. The first catch block handles all *BatchUpdateException*s and the second one all *SQLException*s which are not a *BatchUpdateException*.

        public void catchMostSpecificExceptionFirst() {
           try {
             //batch update code
           } catch (BatchUpdateException be) {
            throw new InvalidAmountException(be);
           } catch (SQLException se) {
            throw new SystemException(se);
           }
        }

- **Catch multiple exceptions in single catch block with similar actions**

  Below code snipplet catches all exceptions with similar actions in same catch block.

        try { 
          ...
        } catch (IllegalArgumentException | SecurityException | IllegalAccessException |
              NoSuchFieldException e) { 
             throw new SystemException(e);
        }

- **Don’t Catch Throwable**

  Throwable is the superclass of all exceptions and errors. You can use it in a catch clause, but you should never do it!

        try { 
          ...
        } catch (Throwable e) {  //Avoid this 
          //some code;
        }

- **Try to accurately cover the exceptions in the custom exceptions**

  It’s sometimes better to catch a standard exception and to wrap it into a custom one. A typical example for such an exception is an application or framework specific business exception. 

        public void calculateInterest(String input) throws InvalidAmountException {
          try {
           // do something
          } catch (NumberFormatException e) {
            throw new InvalidAmountException("Invalid amount encountered.", e);
          }
        }

- **Never consume the exception in a catch block**

  Never do the return “null” rather than handling the exception, it consumes the exception and fails the matter of error permanently.

      catch (NoSuchMethodException e) {
      return null;	//avoid this
      }

- **Clean Up Resources in a Finally Block**

      FileInputStream inputStream = null;`
      try {
          File file = new File("./tmp.txt");
          inputStream = new FileInputStream(file);
          //inputStream.close(); 		//Avoid this;
      } catch (FileNotFoundException e) {
          log.error(e);
      } catch (IOException e) {
          log.error(e);
      } finally {
          inputStream.close()
      }


- **Handle exceptions in master class**

  In our case, master class is controlleradvice layer. Avoid handling exceptions in Helper classes or utility classes.

  
