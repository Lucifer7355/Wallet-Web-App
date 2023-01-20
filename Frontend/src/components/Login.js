import React, { useState } from 'react'
import axios from 'axios';
import { useHistory } from 'react-router-dom';

const Login = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [msg, setMsg] = useState('');
    const history = useHistory();

    const routeChange = () =>{ 
        let path = "/register"; 
        history.push(path);
      }
    const Auth = async (e) => {
        e.preventDefault();
        try {
          await axios.post('http://localhost:5018/api/auth/signin', {
                username: email,
                password: password
            }).then(response => {
                if (response.data.accessToken) {
                  localStorage.setItem("user", JSON.stringify(response.data));
                }
            });
            var gg = JSON.parse(localStorage.getItem("user"));
            const name = gg.username;
            await axios.post('http://localhost:5018/api/account/create', {
                accountNumber: name,
                currentBalance : 0.00,
            },
            {
                headers: {
                    Authorization : 'Bearer ' + gg.accessToken
                }
            });
            
            history.push("/dashboard");
        } catch (error) {
            if (error.response) {
                setMsg(error.response.data.msg);
            }
        }
    }

    return (
        <section className="hero has-background-grey-light is-fullheight is-fullwidth">
            <div className="hero-body">
                <div className="container">
                    <div className="columns is-centered">
                        <div className="column is-4-desktop">
                            <form onSubmit={Auth} className="box">
                                <p className="has-text-centered">{msg}</p>
                                <div className="field mt-5">
                                    <label className="label">Username</label>
                                    <div className="controls">
                                        <input type="text" className="input" placeholder="Username" value={email} onChange={(e) => setEmail(e.target.value)} />
                                    </div>
                                </div>
                                <div className="field mt-5">
                                    <label className="label">Password</label>
                                    <div className="controls">
                                        <input type="password" className="input" placeholder="******" value={password} onChange={(e) => setPassword(e.target.value)} />
                                    </div>
                                </div>
                                <div className="field mt-5">
                                    <button className="button is-success is-fullwidth">Login</button>
                                </div>
                                <div className="field mt-5">
                                    <button className="button is-success is-fullwidth" onClick={routeChange} >Dont have account ?</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    )
}

export default Login
