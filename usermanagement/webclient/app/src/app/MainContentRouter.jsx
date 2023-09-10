import React from "react";
import {Route, Switch} from "react-router-dom";
import MyUserMain from "./features/myUser/MyUserMain";
import AddressMain from "./features/address/AddressMain";
import OrganisationMain from "./features/organisation/OrganisationMain";
import PassportMain from "./features/passport/PassportMain";
import CartMain from "./features/cart/CartMain";
import ArticleMain from "./features/article/ArticleMain";
import Home from "./features/home/Home";

function MainContentRouter() {
    return (
        <>
            <Switch>
                <Route path={"/myuser"} component={MyUserMain}/>
                <Route path={"/address"} component={AddressMain}/>
                <Route path={"/organisation"} component={OrganisationMain}/>
                <Route path={"/passport"} component={PassportMain}/>
                <Route path={"/cart"} component={CartMain}/>
                <Route path={"/article"} component={ArticleMain}/>
            </Switch>
            <Route exact path={"/"} component={Home}/>
            <Route path="/logout" component={() => {
                window.location.href = window.location.pathname + "api/user/logout";
                return null;
            }}/>
        </>
    );
}

export default MainContentRouter;
