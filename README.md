# Un template d'Application en Ligne de Commande (CLI) avec Java 23 et les JEP 458 et 477

[![Classic Build](https://github.com/java-cli-apps/java-23-quickstart/actions/workflows/build.yml/badge.svg)](https://github.com/java-cli-apps/java-23-quickstart/actions/workflows/build.yml)

Le template **java-23-quickstart** permet de démarrer une nouvelle application en commande ligne avec Java et Gradle.

Ce template nécessite d'utiliser Java 23 ou une version supérieure car il utilise les JEPs suivantes :

* La [JEP 458: Launch Multi-File Source-Code Programs](https://openjdk.org/jeps/458) qui permet de lancer un programme Java dont le code est réparti dans
  plusieurs fichiers sources sans avoir besoin de les compiler préalablement
* La [JEP 477: Implicitly Declared Classes and Instance Main Methods (Third Preview)](https://openjdk.org/jeps/477) qui permet de :
  * Se passer de déclaration de classe
  * Simplifier la déclaration de la méthode `main`
  * Utiliser les méthodes de la classe `java.io.IO` sans devoir les importer

## Construire votre application

Après avoir [créé le dépôt GitHub](https://github.com/new?template_name=java-23-quickstart&template_owner=java-cli-apps)
de votre nouvelle application à partir de ce template, vous pouvez suivre les étapes suivantes pour construire votre application.

### Changer le nom de l'application

Pour changer le nom de l'application, initialement nommée _Quickstart_, il faut positionner la variable `APP_NAME`
dans le terminal comme suit :

```bash
$ export APP_NAME=MyCmdLine
```

### Lancer l'application localement

```bash
$ make run-app
```

```console
./gradlew run --args="--language French"
Bonjour 🇫🇷
```

### Construire le livrable de l'application

Le livrable de l'application comprend les sources ainsi que ses dépendances.

```bash
$ make package
```

```console
./gradlew scriptsDistZip
```

#### Shell de lancement

Le script de lancement [Application.sh](bin/Application.sh), dont le rôle est de lancer le fichier
[Application.java](src/main/java/Application.java), est renommé lors de la construction du livrable en `MyCmdLine.sh`.

Cela permet d'ajouter plusieurs applications dans le `PATH` et donc d'invoquer directement `MyCmdLine.sh`.

### Installer l'application

```bash
$ DEST_DIR=/home/user make install
```

```console
unzip -q -d /home/user build/distributions/QuickStart.zip
```

### Lancer l'application installée

```bash
$ DEST_DIR=/home/user make run-installed-app
```

```console
PATH=/home/user/QuickStart/bin:/usr/lib/jvm/jdk-23/bin:/home/fopy/.local/bin:... QuickStart.sh --language French
Bonjour 🇫🇷
```

Il ne nous reste plus qu'à :

- Implémenter notre métier dans [Application.java](src/main/java/Application.java)
- Ajouter dans le répertoire [src/main/java](src/main/java) les fichiers qui déclarent les classes utilisées par `Application.java`
- Ajouter les caractéristiques de nos dépendances dans [gradle/libs.versions.toml](gradle/libs.versions.toml) et [build.gradle.kts](build.gradle.kts)

## Autres templates

### Sans utiliser Java 23

Si vous ne disposez pas de Java 23, vous pouvez utiliser le template [basic-java-11-quickstart](https://github.com/java-cli-apps/basic-java-11-quickstart)
qui ne requiert que la version 11 de Java. Il est alors nécessaire que tout le code Java réside dans le même fichier
comme décrit dans la [JEP 330](https://openjdk.org/jeps/330).

### Sans utiliser Gradle

Si vous ne disposez pas de Gradle ou que vous ne souhaitez pas l'utiliser, vous pouvez utiliser le template [basic-java-23-quickstart](https://github.com/java-cli-apps/basic-java-23-quickstart)
qui ne requiert que `make` pour construire l'application.
