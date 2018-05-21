import React from 'react';
import {StatusBar, Text, View} from 'react-native';


class HeadView extends React.Component {
    render() {
        return (
            <View>
                <StatusBar
                    backgroundColor="blue"
                    barStyle="light-content"
                />
            </View>
        );
    }
}

export default HeadView