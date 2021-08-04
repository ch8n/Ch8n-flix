import { useEffect,useState } from 'react'

import netflixIcon from "./netflix.png";
import avatarIcon from "./avatar.png";
import "./Header.css";

export default function Header() {
    

    const [blackBackground, setBlackBackground] = useState(false)

    useEffect(() => {
        window.addEventListener("scroll", () => {
            if (window.scrollY > 100) {
                setBlackBackground(true)
            } else {
                setBlackBackground(false)
            }
        });
        return () => {
            window.removeEventListener("scroll");
        }
    }, [])


    return (
        <div className={`header ${blackBackground && "header__black"}`}>
            <img className="header__logo" src={netflixIcon} alt="Netflix" />
            <img className="header__avatar" src={avatarIcon} alt="Avatar" />
        </div>
    )
}
