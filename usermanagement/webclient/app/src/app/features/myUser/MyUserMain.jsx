import React from "react";
import {Route} from "react-router-dom";
import MyUserOverview from "./MyUserOverview";
import MyUserDetail from "./MyUserDetail";

function MyUserMain() {
    return (
        <>
            <React.Fragment>
                <Route exact path="/myuser" component={MyUserOverview}/>
                <Route exact path="/myuser/create" component={MyUserDetail}/>
                <Route exact path="/myuser/update/:id" component={MyUserDetail}/>
            </React.Fragment>
        </>
    );
}

export default MyUserMain;
