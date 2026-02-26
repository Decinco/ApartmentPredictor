# Apartment Predictor API

## Product Goal

The Apartment Predictor API serves as the main backend for the Apartment Predictor application. It acts as both a database and a rest API service which stores and exposes data about Apartments, the Contracts that bind them to their Owners, and nearby Schools, as well as Reviews and Reviewers for the Apartments. This data can then be read or changed by the frontend via the aforementioned endpoints.

## Technical Details

The backend uses the following classes:

```mermaid
erDiagram
    OWNER }o--o{ CONTRACT : owns
    CONTRACT }o--|| APARTMENT : attached_to
    APARTMENT ||--o{ REVIEW : has
    REVIEWER ||--o{ REVIEW : posts
    SCHOOL }o--o{ APARTMENT : is_near
    USER }o..o{ REVIEWER: is
    USER }o..o{ OWNER: is

    APARTMENT {
        string id
        string name
        string description
        string location
        long price
        int area
        int bedrooms
        int bathrooms
        int stories
        boolean guestroom
        boolean basement
        boolean waterHeating
        boolean airConditioning
        boolean parking
        FurnsishingStatus furnishingStatus
    }
    OWNER {
        string id
        string nif
        string phoneNumber
    }
    REVIEW {
        string id
        string title
        string contents
        int rating
    }
    REVIEWER {
        string id
        string userDisplayName
        Date reviewDate
    }
    USER {
        string id
        string firstName
        string lastName
        string email
        int age
        byte[] password
    }
    CONTRACT {
        string id
        Date start
        Date end
    }
    SCHOOL {
        string id
        string name
        EducationLevel level
        string location
        int rating
        boolean isPublic
    }
```

### Apartment

### Contract

### School

### Review

### User

User uses InheritanceType TABLE_PER_CLASS, which means both it and inheriting classes have a table with all possible fields (those from User and additional specific ones) in the database. This allows the api to get all the users, regardless of the category, and execute queries on them.

The main reason why this method was chosen over @MappedSuperclass was making login more straightforward, as all the users can conveniently be found in a single table. The poor performance is not a concern as the class only serves as a parent for one "layer" of classes: no class will ever inherit from owner or reviewer.

### Reviewer: User

### Owner: User
