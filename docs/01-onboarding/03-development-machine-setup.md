# Development Environment

All developers should have [tools](02-tools.md) mentioned here installed on their machine.

## Setting up environment

 1. **Java 17** : Install Java using [Jabba](https://github.com/shyiko/jabba)

```shell
curl -sL https://github.com/shyiko/jabba/raw/master/install.sh | bash && . ~/.jabba/jabba.sh
```
```shell
jabba install zulu@1.17.0
```

2. **IntelliJ Idea Community Edition: Java IDE** : Install the latest version of Intellij from [here](https://www.jetbrains.com/idea/download)


3. **Typora: MarkText** : Install the latest version of MarkText from [here](https://marktext.app)

4. **Git** : Install the latest version of Git from [here](https://git-scm.com/downloads)

5. **VSCode** : Install the latest version of VS Code from [here](https://code.visualstudio.com/download)


6. **Docker** : Install the latest version of Docker from [here](https://docs.docker.com/get-started/#download-and-install-docker)


7. **Postgres** : Install Postgres 12.6
```shell
docker run -p 5432:5432 --name psql  -e POSTGRES_PASSWORD=PTNJTCebpuQH -d postgres:12.6
```

8. **DBeaver** : Install the latest community edition of DBeaver from [here](https://dbeaver.io/download/)


9. **Redis** : Install Redis 6.2.4
```shell
docker run -p 6379:6379 --name redis  -d redis:6.2.4
```

10. **Python** : Install python 3.9.2 from [here](https://python.org/downloads/)

11. **CookieCutter** : Install cookiecutter 1.7.2
```shell
python3 -m pip install --user cookiecutter
```

## Git command-line configuration

Make sure you have configured your user with Git. This information will be used by Git.

```
git config --global user.name "Your Fullname"
git config --global user.email "Your Email"
```

Windows users should use Git bash for better command-line experience.

If you are not well-versed with Git then you can read the [tutorial](https://github.com/shekhargulati/git-the-missing-tutorial).

## Connecting to Azure Repo using SSH

Refer to this [link](https://docs.microsoft.com/en-us/azure/devops/repos/git/use-ssh-keys-to-authenticate?view=azure-devops) to setup SSH for your Github account.

## Clone the application

Clone the application using the following command.

```
git@gitlab.snapwork.com:mybank/mybank-ms.git
```

## Building the application

To build the application please run following command.

```
maven clean build
```

For Windows

```
maven clean build
```