import {createStackNavigator} from "react-navigation";
import HomeController from "./HomeController";
import SettingsScreen from "../Setting/SettingsScreen";
import React from "react";

const Navigator = createStackNavigator(
    {
        Tab: {screen: HomeController},
        Product: {screen: SettingsScreen}
    },
    {
        initialRouteName:'Tab',
        mode: 'card',
        headerMode:'none'
    });

export default class App extends React.Component {

    render() {
        return (
            <Navigator />
        );
    }
}