import React from 'react';
import {StatusBar, Text, View} from 'react-native';
class HomeScreen extends React.Component {
    render() {
        return (
            <View style={{ flex: 1, justifyContent: 'center', alignItems: 'center' }}>
                <StatusBar
                    backgroundColor="white"
                    barStyle="light-content"
                />
                <Text>wo shi zhu ye!</Text>
            </View>
        );
    }
}
export default HomeScreen;