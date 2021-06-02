 # E-commerce application
 
 ### To Do List
 
 ###### Trello
```
  https://trello.com/b/AsLbiBOz/e-commerce
```

### Tech Stack

###### Backend
```
 - Java 11
 - Spring Framework
 - PostgreSQL
 - Hexagonal Architecture
 - Unit Tests
 - Integration Tests
 - Contract Tests
```

###### Frontend 
```
 - Javascript
 - React.js
 - Redux
```

###### Devops
```
 - Docker
 - Kubernates 
 - Github actions
 - ELK stack
```

### Requirements

For building and running the application you need :

###### Version
```
- JDK 11   version : 11.0.11 
- Maven    version : 3.6.3
- Docker   version : 20.10.6
- Node.js  version : 14.16.0
- Npm      version : 7.11.0
```

 

### Build & Run 

###### Docker

```
  docker-compose down --remove-orphans
```

```
  docker-compose up -d --build
```

###### Backend
```
  mvn clean install 
```

```
  mvn --projects your-service spring-boot:run
```
  
###### Frontend
 
```
npm install
```

```
npm start
```

### Ports
```
  - category-service port : http://localhost:8001
  - product-service port  : http://localhost:8002
  - ui-service port       : http://localhost:3000
```

### License

Distributed under the MIT License. See [LICENSE](LICENSE) for more information.


  
