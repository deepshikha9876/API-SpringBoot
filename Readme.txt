CREATE TABLE responses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    response VARCHAR(10000)
);

// H2 Database
URL - http://localhost:2025/h2-console
	JDBC URL: jdbc:h2:mem:testdb
	User Name: sa
	Password: sa
	
// Register (only body)
- POST - http://localhost:2025/auth/register
- Body - raw
{
    "firstName":"A",   
    "lastName":"B",
    "email":"A1BCEEE",
    "mobile":"876567",
    "username":"Akfg",
    "password":"190"
}

// Login (params username, password)
- POST - http://localhost:2025/auth/login?username=Akfg&password=190

// GET  (params -symbols)
- GET - http://localhost:2025/coins/data?symbols=BTC,ETHLTC
- Bearer token

//Update
- PUT - http://localhost:2025/profile/update
- Bearer token
- Body - raw
{
    "firstName":"C",
    "lastName":"B",
    "mobile":"9999",
    "email":"A1BCEEE"
}