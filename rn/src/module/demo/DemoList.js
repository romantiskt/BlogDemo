import React from 'react';
import {Text, View} from 'react-native';
import {createStackNavigator} from "react-navigation";
import ReduxDemo from "./redux/ReduxDemo";
import WidgetShowScreen from "./widget/WidgetShowScreen";


class SettingsScreen extends React.Component {
    render() {
        return (
            <View style={{flex: 1, justifyContent: 'center', alignItems: 'center'}}>
                <Text>this is setting!</Text>
            </View>
        );
    }
}

const navigator = createStackNavigator(
    {
        // setting: {screen: SettingsScreen},
        reduxdemo: {screen: ReduxDemo},
    },
    {
        mode: 'card',
        headerMode: 'none'
    });
export default navigator