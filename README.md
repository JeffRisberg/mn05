## MN05

## Micronaut 3.10.1 Documentation

- [User Guide](https://docs.micronaut.io/3.10.1/guide/index.html)
- [API Reference](https://docs.micronaut.io/3.10.1/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/3.10.1/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)

---

- [Micronaut Gradle Plugin documentation](https://micronaut-projects.github.io/micronaut-gradle-plugin/latest/)
- [GraalVM Gradle Plugin documentation](https://graalvm.github.io/native-build-tools/latest/gradle-plugin.html)
- [Shadow Gradle Plugin](https://plugins.gradle.org/plugin/com.github.johnrengelman.shadow)

## Feature security documentation

- [Micronaut Security documentation](https://micronaut-projects.github.io/micronaut-security/latest/guide/index.html)

## Feature security-session documentation

- [Micronaut Security Session documentation](https://micronaut-projects.github.io/micronaut-security/latest/guide/index.html#session)

## Feature http-client documentation

- [Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)


## Running this in IDE

Run in the IDE by running the Application.java file.

## Sample endpoints

curl -v POST "http://localhost:8080/login" -H 'Content-Type: application/json; charset=utf-8' -d '
{"username": "alice", "password":"alice@1"}
'

curl -v http://localhost:8080/hello
curl -v http://localhost:8080/goodbye

curl -v "http://localhost:8080/user" --cookie 'SESSION=MWZkYjdjYTAtZTdkNi00NmI5LWEyZDMtZWNkM2EzMmIxODMz'





