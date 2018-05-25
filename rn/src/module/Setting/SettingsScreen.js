import React from 'react';
import {Text, View} from 'react-native';
import {createStackNavigator} from "react-navigation";
import ReduxDemo from "../demo/redux/ReduxDemo";


class SettingsScreen extends React.Component {
    render() {
        return (
            <View style={{flex: 1, justifyContent: 'center', alignItems: 'center'}}>
                <Text>this is setting!</Text>
            </View>
        );
    }
}

export default createStackNavigator(
    {
        setting: {screen: SettingsScreen},
        reduxdemo: {screen: ReduxDemo}
    },
    {
        mode: 'card',
        headerMode: 'none'
    });