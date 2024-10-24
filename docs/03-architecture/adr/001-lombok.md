# Using Lombok Library

## Status

**Accepted**

## Context

Records provides a lot of nice features and is neat in code but lombok still has way more features than records.
Lombok is largely about syntactic convenience with the use of following features :

- `@Cleanup`
- `@Getter/@Setter`
- `@ToString`
- `@EqualsAndHashCode`
- `@NoArgsConstructor, @RequiredArgsConstructor and @AllArgsConstructor`
- `@Data`
- `@Value`
- `@Builder`
- `@SneakyThrows`
- `@Slf4j`
- `@UtilityClass`
- `@SuperBuilder`
- `@Tolerate`

Also ,

> **Note:** **Lombok** officially supports [JDK 16](https://projectlombok.org/changelog).

#### Support for lombok with Java 16

| Features                                                               	| Works Well Record 	| Works well with Classes/Var etc 	|
|------------------------------------------------------------------------	|-------------------	|---------------------------------	|
| `@Cleanup`                                                             	| Yes               	| Yes                             	|
| `@Getter`                                                              	| Yes               	| Yes                             	|
| `@Setter`                                                              	| Not Required  	    | Yes                             	|
| `@ToString`                                                            	| No                	| Yes                             	|
| `@EqualsAndHashCode`                                                   	| No                	| Yes                             	|
| `@NoArgsConstructor, @RequiredArgsConstructor and @AllArgsConstructor` 	| No                	| Yes                             	|
| `@Data`                                                                	| No                	| Yes                             	|
| `@Value`                                                               	| Not Required  	    | Yes                             	|
| `@Builder`                                                             	| Yes               	| Yes                             	|
| `@SneakyThrows`                                                        	| Yes               	| Yes                             	|
| `@Slf4j`                                                               	| Yes               	| Yes                             	|
| `@UtilityClass`                                                        	| NA                	| Yes                             	|
| `@SuperBuilder`                                                        	| No                	| Yes                             	|
| `@Tolerate`                                                            	| Not Required      	| Yes                             	|


## Decision

To add following dependency in `build.gradle` of microservices

```groovy
  compileOnly 'org.projectlombok:lombok:1.18.20'
  annotationProcessor 'org.projectlombok:lombok:1.18.20'
```

## Consequences

- Benefits from both Records & Lombok
- Unknown bugs can be encountered as there are still [open issues](https://github.com/projectlombok/lombok/issues?q=java+16+is%3Aopen+)

> **Note:** Need to check compatibility with JDK 17 prior to migration.
> 
**_References_** :
- [Lombok](https://projectlombok.org/features/all)
- [Records](https://blogs.oracle.com/javamagazine/records-come-to-java#anchor_8)





