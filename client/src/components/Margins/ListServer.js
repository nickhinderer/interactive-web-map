import React, { useState } from 'react';
import { Dropdown, DropdownToggle, DropdownMenu, DropdownItem } from 'reactstrap';
import {ServerData} from "./ServerInfo";

export default function ListServers(props) {
    const [dropdownOpen, setDropdownOpen] = useState(false);
    const[choose,setChoose]=useState("Choose Other Server");
    
    function handleChange(event) {
        props.onChange(event.target.value);
        
    }

    const toggle = () => setDropdownOpen(prevState => !prevState);
    return (
        <><Dropdown  isOpen={dropdownOpen} toggle={toggle}>
            <DropdownToggle>
                {choose}
            </DropdownToggle>
            <DropdownMenu style={{ height:'300px', overflow:'scroll'}} >
            
               
            {ServerData.map((Server) => (
                <div key={Server.index}>
                     <DropdownItem onClick={(e)=>{handleChange(e),setChoose(Server.name)}} value={Server.URL}>{Server.name}</DropdownItem>
                </div>
            ))}
                
            </DropdownMenu>
        </Dropdown></>
  );
}
