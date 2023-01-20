/* eslint-disable react-hooks/exhaustive-deps */
import React, { useState } from 'react'
import axios from "axios";
import { Link } from 'react-router-dom';

const Dashboard = () => {
    
    const [Balance,setBalance] = useState("");
    const [Clicked,setClicked] = useState(false);
    var gg = JSON.parse(localStorage.getItem("user"));
    
      const getBalance = async (event) => {
        event.preventDefault();
        const name = gg.username;
        const tt = await axios.get(`http://localhost:5018/api/account/getbalance/${name}`,
            {
                headers: {
                    Authorization : 'Bearer ' + gg.accessToken
                }
            });
        //console.log(typeof tt.data);
        setBalance(tt.data);
        setClicked(true);
      };
     
      

    return (
        <div className="container mt-5">
            <h1 className="wel" style = {{ marginLeft: "484px", marginTop: "69px" }}>Welcome Back: {gg.username}, what would you like to do ?</h1>
            
            <div className='mew' style={{ marginLeft: "88px", marginTop: "-28px" }}>
            <button className="button is-success" style= {{ marginTop: "100px", marginLeft: "100px" }} onClick={getBalance} >Check current balance?</button>
            <Link to="/creditMoney" className="button is-success" style= {{ marginTop: "100px", marginLeft: "100px" }}> Credit some money</Link>
            <Link to="/debitMoney" className="button is-success" style= {{ marginTop: "100px", marginLeft: "100px" }}> Debit some money</Link>
            <Link to="/transactionDetails" className="button is-success" style= {{ marginTop: "100px", marginLeft: "100px" }}> Transaction Details</Link>
            </div>
            <div className='balancing' style={{ marginTop: "105px", marginLeft: "490px" }}>
                    { (Clicked===true) &&
                <h2>
                    Current balance of your account is : {Balance} Rupees.
                </h2>
            }
            </div>
            
        </div>
    )
}

export default Dashboard
