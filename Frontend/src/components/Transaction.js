/* eslint-disable react-hooks/exhaustive-deps */
import React, { useState, useEffect } from 'react'
import axios from "axios";


const Dashboard = () => {

    const [Transactions,setTransactions] = useState([]);
    const [CurrentBalance,setCurrentBalance] = useState(0);
    var gg = JSON.parse(localStorage.getItem("user"));
    
      
     
      const fetchTransactionDetails = async () => {
            const tt = await axios.post(`http://localhost:5018/api/account/statement`,
            {
                accountNumber : gg.username
            },
                {
                    headers: {
                        Authorization : 'Bearer ' + gg.accessToken
                    }
                });
            //console.log(tt.data.payload.transactionHistory);
            setTransactions(tt.data.payload.transactionHistory);
            setCurrentBalance(tt.data.payload.currentBalance);
        }
      useEffect(()=> {
        fetchTransactionDetails()
      },[]);

    return (
        <div className="container mt-5">
           <h1 className='uwu' style={{ marginLeft: "533px", marginTop: "38px" }}>Transactions of {gg.username}</h1>
           <h1 className='dost' style={{ marginLeft: "472px", marginTop: "29px" }}>Current Balance for {gg.username}'s account is {CurrentBalance}</h1>
        <div className='details' style={{ marginLeft: "264px", marginTop: "49px" }}>
           {Transactions.map(it => {
                return (
                <div key={it.id} >
                    <h2 key={it.id}>Name: {it.accountNumber}</h2>
                    <h2 key={it.id}>Transaction Amount: {it.transactionAmount} {it.transactiontype}</h2>
                    <h2 key={it.id}>Transaction Date and Time: {new Date(it.transactionDateTime).toString()}</h2>
                    <hr />
                </div>
        );
      })}
          </div>
        </div>
    )
}

export default Dashboard
