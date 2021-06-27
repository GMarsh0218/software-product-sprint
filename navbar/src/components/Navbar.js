import React from 'react';
import '../css/Navbar.css';
import logo from '../img/weed-logo.svg';

const Navbar = () => {

    return(
        <div className="Navbar">
            <img src={logo} className='app-logo' alt='logo'/>
            <nav className="Navbar-left">
                <ul>
                    <li></li>
                    <li></li>
                    <li></li>
                </ul>
            </nav>
        </div>
    );
}

export default Navbar;