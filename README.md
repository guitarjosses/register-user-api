# register-user-api
Restful Rest Api to register a user

This repo cantains the source code of Restful Api with 2 ednpoints:

1) http://localhost:8080/api/users, get all registered users.
2) http://localhost:8080/api/user, create a user with the next format:

    {
        "name": "Juan Rodriguez",
        "email": "juan#rodriguez.org",
        "password": "hunter2",
        "phones": [
            {
                "number": "1234567",
                "citycode": "1",
                "countrycode": "57"
            }
        ]
    }
