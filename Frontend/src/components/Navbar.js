import React from 'react'
// import axios from 'axios';
import { useHistory,Link } from 'react-router-dom';

const Navbar = () => {
    const history = useHistory();
    

    const Logout = async () => {
        try {
            console.log(localStorage.getItem("user"));
            localStorage.removeItem("user");
            history.push("/");
        } catch (error) {
            console.log(error);
        }
    }

    return (
        <nav className="navbar is-light" role="navigation" aria-label="main navigation">
            <div className="container">
                <div className="navbar-brand">
                   {/* <h1>
                        Welcome to wallet App
                    </h1> */}

                    <a href="/" role="button" className="navbar-burger burger" aria-label="menu" aria-expanded="false" data-target="navbarBasicExample">
                        <span aria-hidden="true"></span>
                        <span aria-hidden="true"></span>
                        <span aria-hidden="true"></span>
                    </a>
                </div>

                <div id="navbarBasicExample" className="navbar-menu">
                <div className="navbar-start">
                        <div  className="navbar-item">
                        <Link to="/dashboard" >  Wallet Application</Link>
            
                        </div>
                    </div>
                    <div className="navbar-end">
                        <div className="navbar-item">
                            <div className="buttons">
                                <button onClick={Logout} className="button is-light">
                                    Log Out
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </nav>
    )
}

export default Navbar
