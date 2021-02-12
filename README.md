# crud-sandbox
sandbox project of CRUD API

you can try ORMs
* master -> spring-data-jpa
* jdbc   -> spring-data-jdbc
* jooq   -> spring-data-jooq

### DB
you can construct using docker-compose

please execute following command

#### up
```
cd docker && docker-compose up -d
```

#### down
```
cd docker && docker-compose down
```

### API document
you can check via swagger-ui

http://localhost:8080/swagger-ui.html

### Appendix
spring-boot-starter-data-jdbcとspring-boot-starter-data-jpa2つとも有効になっていると起動時にエラーが出る

もしspring-data-jdbcを使うとなるとjpaはbos-buildから各基盤での指定に切り離す必要がありそう

```
Parameter 0 of constructor in com.sora.data.crudsandbox.service.MemberService required a bean of type 'com.sora.data.crudsandbox.domain.MemberRepository' that could not be found.
```