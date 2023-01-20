# Wallet-Web-App
# High Level Design of application
![Credit/Debit Wallet Application HLD](https://github.com/Lucifer7355/Wallet-Web-App/blob/main/Details/credit_debit_wallet_HLD.jpg)
# Demonstration images Backend :
Accessing Public end point without authentication or authorization
![Accessing Public end point without authentication or authorization](https://github.com/Lucifer7355/Wallet-Web-App/blob/main/Demonstration_images/Public%20End%20Point.png)
Register new user 
![Register new user](https://github.com/Lucifer7355/Wallet-Web-App/blob/main/Demonstration_images/Register_new_user.png)
Login that user
![Login that user](https://github.com/Lucifer7355/Wallet-Web-App/blob/main/Demonstration_images/Login_that_user.png)
Create list of accounts using auth token in header-1
![Create list of accounts using auth token in header-1](https://github.com/Lucifer7355/Wallet-Web-App/blob/main/Demonstration_images/create_list_of_accounts1.png)
Create list of accounts using auth token in header-2
![Create list of accounts using auth token in header-2](https://github.com/Lucifer7355/Wallet-Web-App/blob/main/Demonstration_images/create_list_of_accounts2.png)
Create single account-1
![Create single account-1](https://github.com/Lucifer7355/Wallet-Web-App/blob/main/Demonstration_images/create_single_account1.png)
Create single account-2
![Create single account-2](https://github.com/Lucifer7355/Wallet-Web-App/blob/main/Demonstration_images/create_single_account2.png)
Add money-1
![Add money-1](https://github.com/Lucifer7355/Wallet-Web-App/blob/main/Demonstration_images/addmoney1.png)
Add money-2
![Add money-2](https://github.com/Lucifer7355/Wallet-Web-App/blob/main/Demonstration_images/addmoney2.png)
Withdraw money
![Withdraw money](https://github.com/Lucifer7355/Wallet-Web-App/blob/main/Demonstration_images/withdrawmoney.png)
Transaction from one account to another-1
![Transaction from one account to another-1](https://github.com/Lucifer7355/Wallet-Web-App/blob/main/Demonstration_images/Transfermoney1.png)
Transaction from one account to another-2
![Transaction from one account to another-2](https://github.com/Lucifer7355/Wallet-Web-App/blob/main/Demonstration_images/Transfermoney2.png)
Fetch all the available accounts-1
![Fetch all the available accounts-1](https://github.com/Lucifer7355/Wallet-Web-App/blob/main/Demonstration_images/Fetch_all_available_accounts1.png)
Fetch all the available accounts-2
![Fetch all the available accounts-2](https://github.com/Lucifer7355/Wallet-Web-App/blob/main/Demonstration_images/Fetch_all_available_accounts2.png)

# Demonstration images Frontend :
Register an account
![Register an account](https://github.com/Lucifer7355/Wallet-Web-App/blob/main/Demonstration_images/Register%20an%20account.png)
Login page-1
![Login page-1](https://github.com/Lucifer7355/Wallet-Web-App/blob/main/Demonstration_images/LoginPage1.png)
Login page-2
![Login page-2](https://github.com/Lucifer7355/Wallet-Web-App/blob/main/Demonstration_images/LoginPage2.png)
Application Dashboard
![Application Dashboard](https://github.com/Lucifer7355/Wallet-Web-App/blob/main/Demonstration_images/Dashboard.png)
Check Current balance
![Check Current balance](https://github.com/Lucifer7355/Wallet-Web-App/blob/main/Demonstration_images/CheckCurrentBalance.png)
Credit 7 rupees
![Credit 7 rupees](https://github.com/Lucifer7355/Wallet-Web-App/blob/main/Demonstration_images/CreditMoney.png)
After credit money left in account
![After credit money left in account](https://github.com/Lucifer7355/Wallet-Web-App/blob/main/Demonstration_images/AfterCreditMoney.png)
Debit 7 rupees
![Debit 7 rupees](https://github.com/Lucifer7355/Wallet-Web-App/blob/main/Demonstration_images/DebitMoney.png)
After debit money left in account
![After debit money left in account](https://github.com/Lucifer7355/Wallet-Web-App/blob/main/Demonstration_images/CurrentBalanceAfterDebit.png)

Transaction details for current account-1
![Transaction details for current account-1](https://github.com/Lucifer7355/Wallet-Web-App/blob/main/Demonstration_images/Transactions1.png)

Transaction details for current account-2
![Transaction details for current account-2](https://github.com/Lucifer7355/Wallet-Web-App/blob/main/Demonstration_images/Transactions2.png)

# Details about the backend and frontend

## Backend(SpringBoot) :
1. Number of Models which i created are 4.
- Account,Role,Transaction,User.
- Account model has following properties : {accountId,accountNumber,currentBalance}. Its for keeping track of wallet account holders.
- Role model has two properties : {id,name(which can be only of enum type ROLE_ADMIN,ROLE_MODERATOR,ROLE_USER)}
- Transaction model has following properties : {transactionId,accountNumber,transactionAmount,transactionDateTime,transactiontype}. It is created to keep track of debit/credit and one account to another account transaction.
- User model has following properties : {id,username,email,password,roles}. Used for authentication and creation of user.
- The models User and Role are associated with Spring Security which is used to enable JWT authentication and securing controller end points.
- ERole is an ENUM for the 3 roles available in the database, namely {ROLE_ADMIN,ROLE_MODERATOR,ROLE_USER}. They have to be prepopulated after running the backend so that a new user can be created.
- To populate the Role Schema just run this command after running database :  INSERT INTO banking_system.roles (name) VALUES ('ROLE_USER'),('ROLE_MODERATOR'),('ROLE_ADMIN');

2. Number of repositories are 4.
- AccountRepository has a method which finds the Account by its accountNumber from the DB;
- RoleRepository has a method which returns Role based on the role Enum asked from the DB.
- TransactionRepository has a method which finds all the accounts with an accountnumber from DB.
- UserRepository has three methods which will find User by its name,check if a username exists and check if an email exists in the DB.

3. POJO (Plain Old Java Object) : 
- There are two types of pojo in the project.
a) Request POJOS : 
	- AccountStatementRequest has attribute {accountNumber};
	- CreditRequest has attributes {accountNumber,currentBalance}.
	- DebitRequest has attributes {accountNumber,currentBalance}.
 	- LoginRequest has attributes {username(cannot be blank), password(cannot be blank)}.
	- SignupRequest has attributes {username(cannot be blank,can have size minimum=3 and maximum 20),email(cannot be blank,can have size of at max 50),role,password(cannot be blank,can have size minimum=6 and maximum 40)}.
	- TransferBalanceRequest has attributes {fromAccountNumber,toAccountNumber,amount}.
	- AccountStatement POJO which has attributes {currentBalance,transactionHistory}.

b) Response POJOS :
	- JwtResponse has attributes {token,type(which is fixed "Bearer "),id,username,email,roles}.
	- MessageResponse has attributes {message}.
	- Response has attributes {status,payload,errors,metadata}.
	- ResponseError has attributes {timestamp,message,details}.

4. Available Services are 3 : 
- AccountServiceImpl : It has methods implemented to ->
	- save an account object.
	- find all list of accounts available.
	- find accountby accountnumber.
	- sending money from one account to another.
	- getting transaction statements for a given account number.
	- crediting some amount of money in an account.
	- Debiting some amount of money in an account.
	- save a list of account objects in the DB.
	- find the balance for a given account number.
- UserDetailsImpl : It has methods implemented to ->
	- build user object by using builder design pattern and things related to spring auth.
- UserDetailsServiceImpl : It has methods implemented to -> 
	- To load user by its username and return UserDetails object using builder pattern. If the user does not exists then it throws User not found exception.

5. JWT authentication related classes : 
- JwtUtils class has methods for generating, validating and getting username from the JWT token.
- AuthTokenFilter class has methods for parsing JWT authorization header and extracting JWT token and setting user authentication, which dispatches further dispatches request to other filters. 

6. It has 3 controllers namely :

- AccountController : which has follwing end points defined---> 
```
POST ---> http://localhost:5018/api/account/create ----> create Account object and store in DB;

POST ---> http://localhost:5018/api/account/createAll ----> store list of account objects into DB which are being passed;

GET ----> http://localhost:5018/api/account/all ---> find all accounts;

POST ---> http://localhost:5018/api/account/sendmoney ----> TransferBalanceRequest;

POST ----> http://localhost:5018/api/account/statement ----> AccountStatementRequest;

POST ----> http://localhost:5018/api/account/addmoney ----> add some money to your account;

POST ----> http://localhost:5018/api/account/withdrawmoney ----> withdraw some money from your account;
```
- TestController has following end points defined.
```
GET ---> http://localhost:5018/api/test/all : -----> To access "Public Content" string without any authentication.
GET ---> http://localhost:5018/api/test/user : ----> To access "User Content" string having role "USER", "MODERATOR", "ADMIN".
GET ---> http://localhost:5018/api/test/mod : ----> To access "Moderator Board" string having role "MODERATOR".
GET ---> http://localhost:5018/api/test/admin : ----> To access "Admin Board" string having role "ADMIN".
```

Signup : ---> 
```
POST ----> http://localhost:5018/api/auth/signup ---> For creating a new account having role only "USER" by default.

Signup request syntax: ->
{
 "username" : "Ankit",
 "email" : "ankitviddya@gmail.com",
  "password" : "Ankit@1234"
}
```
Login request syntax: ---> 
```
POST ----> http://localhost:5018/api/auth/signin ---> For signin and returning JWT token which can be used for authorization purposes.
{
"username" : "Ankit",
"password" : "Ankit@1234"
}
```

7. WebSecurityConfig class is there for enabling spring security for the REST end points. It has methods defined for using our deined Authentication filter,BCRYPT password 
encoder and the filter chain. 
```
The filter chain configured in this class enables everyone to access "/api/auth/**","/api/test/**, end points. But to access further end points, 
user must be authenticated and make a request with authorization header enabled having "Bearer JWTtoken". 
```

### Further Details about DB configuration, JWT expiration time and private secret key stored at server can be changed as per requirements from application.properties file. 

## FrontEnd :------> 

1. I have created a React js Front-End to consume the created RESt api and display an end user friendly Wallet web application.
2. It has components made for CreditMoney page,DashBoard Page,DebitMoney,Login,Navbar,Register, and Transaction page.
3. App.js has routes configured for various page requests and security enabled.
4. The required dependencies are mentioned into package.json which can be installed by just hitting "npm i" after cloning frontend part.


# Steps to Run : 
- Just run the Backend Server on port 5018.
- Run the Front End on port 3000.
- Cors are enabled at the sever for the http://localhost:3000/ hence there wont be any issue calling rest apis after authentication off-course :).
- Note that for any new user a new wallet account created will have 0 rupees balance.
