import { ProSidebar, Menu, MenuItem, SubMenu } from 'react-pro-sidebar';
import React, { useState, useEffect } from "react";

import './sidebar.scss';




function SideNav() {

    const [activeKey, setActiveKey] = useState("1");
    const handleSelect = (eventKey) => {
        setActiveKey(eventKey);
    };
    return (
        <div className="SideBar-Containter">
            <ProSidebar className="pro-sidebar">
                <Menu iconShape="square">
                    <MenuItem >Dashboard</MenuItem>
                    <SubMenu title="Components" >
                        <MenuItem>Component 1</MenuItem>
                        <MenuItem>Component 2</MenuItem>
                    </SubMenu>
                </Menu>
            </ProSidebar>
        </div>
    );
};


export default SideNav;