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

### jooq
[GradleでJOOQを使ってみた](https://qiita.com/Kakky/items/4635ae4303eb0965d935)