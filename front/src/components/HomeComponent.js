import React, {FC, useEffect, useState} from 'react'
import axios from "axios";

export const HomeComponent: FC = () => {
    const [name, setName] = useState("");
    useEffect(() => {
    }, []);

    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            const data = await axios.get(`http://localhost:8080/countyCode/byPhoneCode?phoneCode=${name}`)
            if (data.status === 200) {
                alert(`Country: ${data.data}`)
            }
        } catch (e) {
            alert(`Error: ${e.response.data.message}`)
        }
    }

    return (
        <form onSubmit={handleSubmit}>
            <label>
                Enter Phone Code:
                <input pattern="[0-9]+" type="text"
                       value={name}
                       onChange={e => setName(e.target.value)}
                       name="phoneCode"/>
                <small>Format: only number</small>
                <br/>
            </label>
            <input type="submit" value="Submit"/>
        </form>
    );

}
