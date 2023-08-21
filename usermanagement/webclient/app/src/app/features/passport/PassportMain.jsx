import React from "react";
import {Route} from "react-router-dom";
import PassportOverview from "./PassportOverview";
import PassportDetail from "./PassportDetail";

function PassportMain() {
    return (
        <>
            <React.Fragment>
                <Route exact path="/passport" component={PassportOverview}/>
                <Route exact path="/passport/create" component={PassportDetail}/>
                <Route exact path="/passport/update/:id" component={PassportDetail}/>
            </React.Fragment>
        </>
    );
}

export default PassportMain;
