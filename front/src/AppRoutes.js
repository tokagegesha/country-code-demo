import React from 'react'
import {Route, Switch} from 'react-router-dom'
import {HomeComponent} from "./components/HomeComponent";

export const AppRoutes = () => {
    return (
        <Switch>
            <Route path='/' component={HomeComponent} exact={true}>
            </Route>
        </Switch>
    );

}
