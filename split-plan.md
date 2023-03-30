# Plan for splitting monolith to microservices

## Files starting with Vet* and related:
monolith/src/main/java/org/springframework/samples/petclinic/controller/VetController.java
monolith/src/main/java/org/springframework/samples/petclinic/service/ClinicService.java

monolith/src/main/java/org/springframework/samples/petclinic/db/PetRepository.java
monolith/src/main/java/org/springframework/samples/petclinic/model/Vet.java

UI:
monolith/src/main/resources/templates/vets/vetList.html

DB:
monolith/src/main/resources/db/data.sql

### Plan:
- package by feature in each layer
- if in shared class, separate to dedicated and move to the package (+ tests)
- UI ? 
- DB  Person - inline
      Base entity - duplicate 
- separation to new maven module
- remove unrelated things from the new module
- crate feature flag (or primary component / qualifiers)
- call the new service from the original one

# Plan v2

- new package
- cleanup revenue repository (delete not relevant save method)
- move yearlyrevenue model
- new model Revenue
  - id
  - sum of cost
  - date (year)
- new visit = upsert revenue
- data pump, cronjob, MQ
- new management service - move logic from ClinicService here
- new mvn module


# Plan v3
- new package for clinic operations
- move related classes to that package:
  - entities (owners, pets, visits)
  - repositories
  - tests
- split off the visit,... related logic/method from ClinicService (copy it to visit package and clean up)
- create DTOs
- create Endpoint for saving and fetching visits (VisitApi)
- split database (extract schema and data from monolith)
- new maven module
- 