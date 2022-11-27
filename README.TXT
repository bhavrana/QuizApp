
Introduction
============
Greetings!
This project is a bare-bones Spring Boot RESTful webservice, it is intended to be a simple backend to an online quiz application.


Build and Run
=============
Required: Java JDK11, Maven

The project is built with Maven with and can be packaged like so;
$ mvn clean package

The site can be run from the main class;
com.fs.quiz.QuizApplication

Or executed from the runnable jar;
$ java -jar quiz-0.0.1-SNAPSHOT.jar


Features to Implement
=====================
Please try adding the following features (feel free to make any code improvements and refactoring you deem necessary):

1) Feature One
As an api consumer,
I want the /questions endpoint to return all questions available in the question repository.
So that I can retrieve the questions available for a quiz.

Sample Input :
-----------------

curl --location --request GET 'http://localhost:8080/questions'

Sample Output:
-----------------

{
    "Questions": [
        {
            "id": 1,
            "question": "What is the capital of Cuba?"
        },
        {
            "id": 2,
            "question": "What is the capital of France?"
        },
        {
            "id": 3,
            "question": "What is the capital of Poland?"
        },
        {
            "id": 4,
            "question": "What is the capital of Germany?"
        },
        {
            "id": 5,
            "question": "What Is The Heaviest Organ In The Human Body?"
        },
        {
            "id": 6,
            "question": "What Is The Only Planet That Spins Clockwise?"
        },
        {
            "id": 7,
            "question": "The Horsehead Nebula Can Be Found In What Constellation?"
        },
        {
            "id": 8,
            "question": "The World’s Fastest-Growing Plant Is A Species Of What?"
        }
    ]
}

2) Feature Two
As an api consumer,
I want an endpoint to check a given answer for any available question is correct.
So that I can validate the answers for each question in the quiz.

Sample Input 1
---------------

curl --location --request POST 'http://localhost:8080/questions' \
--header 'Content-Type: application/json' \
--data-raw '{
    "questionAnswerMap" : {
        "1" : "havana",
        "2" : "test"
        }
}'

Sample Output 1
----------------

{
    "Result": [
        {
            "questionId": 1,
            "question": "What is the capital of Cuba?",
            "givenAnswer": "havana",
            "result": "correct",
            "expectedAnswer": "Havana"
        },
        {
            "questionId": 2,
            "question": "What is the capital of France?",
            "givenAnswer": "test",
            "result": "incorrect",
            "expectedAnswer": "Paris"
        }
    ]
}

Sample Input 2
-----------------

curl --location --request POST 'http://localhost:8080/questions' \
--header 'Content-Type: application/json' \
--data-raw '{
    "questionAnswerMap" : {
        "10" : "havana",
        "2" : "test"
        }
}'

Sample Output 2
-----------------

{
    "Error": {
        "message": "Question not found for ID 10",
        "status": "invalid input"
    }
}

3) Feature Three
As an api consumer,
I want to retrieve a different set of questions depending on the type of quiz e.g. Geography Quiz or Science Quiz
So that I can support providing different types of quiz.

Sample Input
-----------------

curl --location --request GET 'http://localhost:8080/questions/geography'

Sample Output
----------------

{
    "Questions": [
        {
            "id": 1,
            "question": "What is the capital of Cuba?"
        },
        {
            "id": 2,
            "question": "What is the capital of France?"
        },
        {
            "id": 3,
            "question": "What is the capital of Poland?"
        },
        {
            "id": 4,
            "question": "What is the capital of Germany?"
        }
    ]
}

Good luck!


