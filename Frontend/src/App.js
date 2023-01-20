import { BrowserRouter, Route, Switch } from "react-router-dom";
import Dashboard from "./components/Dashboard";
import Login from "./components/Login";
import Navbar from "./components/Navbar";
import Register from "./components/Register";
import CreditMoney from "./components/CreditMoney";
import DebitMoney from "./components/DebitMoney";
import Transaction from "./components/Transaction";

function App() {
  return (
    <BrowserRouter>
      <Switch>
        <Route exact path="/">
          <Login/>
        </Route>
        <Route path="/register">
          <Register/>
        </Route>
        <Route path="/dashboard">
          <Navbar/>
          <Dashboard/>
        </Route>
        <Route path="/creditMoney">
        <Navbar/>
          <CreditMoney/>
        </Route>
        <Route path="/debitMoney">
        <Navbar/>
          <DebitMoney/>
        </Route>
        <Route path="/transactionDetails">
        <Navbar/>
          <Transaction/>
        </Route>
      </Switch>
    </BrowserRouter>
  );
}

export default App;
