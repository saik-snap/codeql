# Tips and Tricks 

## Gradle Aliases

```
alias gdw=./gradlew
alias gdb=./gradlew build
alias gdbc=./gradlew clean build
```

Run individual project

```
gdw :login-service:build
```

It will also project that are included using includedBuild