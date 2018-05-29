import {createStackNavigator} from "react-navigation";
import HomeController from "./HomeController";
import DemoList from "../demo/DemoList";
import React from "react";
import {Provider} from "react-redux";
import configureStore from "../../redux/stores/Store";
const store = configureStore();
const Navigator = createStackNavigator(
    {
        Tab: {screen: HomeController},
        Product: {screen: DemoList}
    },
    {
        initialRouteName: 'Tab',
        mode: 'card',
        headerMode: 'none'
    });

export default class App extends React.Component {

    render() {
        return (
            <Provider store={store}>
                <Navigator/>
            </Provider>
        );
    }
}