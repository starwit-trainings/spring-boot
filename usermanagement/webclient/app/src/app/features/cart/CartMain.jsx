import React from "react";
import {Route} from "react-router-dom";
import CartOverview from "./CartOverview";
import CartDetail from "./CartDetail";

function CartMain() {
    return (
        <>
            <React.Fragment>
                <Route exact path="/cart" component={CartOverview}/>
                <Route exact path="/cart/create" component={CartDetail}/>
                <Route exact path="/cart/update/:id" component={CartDetail}/>
            </React.Fragment>
        </>
    );
}

export default CartMain;
