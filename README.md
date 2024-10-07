# Quotations Microservice

This microservice receives requests to create new quotations, providing a formatted view for the user that will later be converted to PDF. It publishes events such as first-time payments to the payment microservice and sends dental procedures and prices to the billing microservice.

## Table of Contents
- [Installation](#installation)
- [Examples](#Examples)
- [JavaDocs](#Documentation)
- [License](#license)

## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/
## Prerequisites
- **Java 17**
- **Maven**
- **RabbitMQ**
- **MySQL**

## Documentation
## Examples
In order to get make a new Quotation we need to do it like this:
```http
POST /Quotation

Content-Type: application/json
```
```json
{
   "patientName": "John Doe",
   "payment": 0,
   "dentalProcedure": [
      { "dentalProcedure": "Dental Procedure1" },
      { "dentalProcedure": "Dental Procedure2" }
   ]
}
```
### Outcome
```json
{
   "improvementPlan": [
      {
         "dentalProcedure": "Dental Procedure1",
         "price": 5000.0
      },
      {
         "dentalProcedure": "Dental Procedure2",
         "price": 5000.0
      }
   ],
   "payment": "$0",
   "patientName": "John Doe",
   "total": "$100.000.00",
   "paymentDate": "3 october, 2024"
}
```
## License