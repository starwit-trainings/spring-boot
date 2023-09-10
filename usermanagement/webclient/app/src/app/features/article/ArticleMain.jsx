import React from "react";
import {Route} from "react-router-dom";
import ArticleOverview from "./ArticleOverview";
import ArticleDetail from "./ArticleDetail";

function ArticleMain() {
    return (
        <>
            <React.Fragment>
                <Route exact path="/article" component={ArticleOverview}/>
                <Route exact path="/article/create" component={ArticleDetail}/>
                <Route exact path="/article/update/:id" component={ArticleDetail}/>
            </React.Fragment>
        </>
    );
}

export default ArticleMain;
