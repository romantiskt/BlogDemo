import React from 'react';
import {Text, View, StyleSheet, Button, TouchableHighlight} from 'react-native';
import Device from "../../base/util/Device";
import AppTheme from "../../base/util/Theme";

class DemoScreen extends React.Component {
    render() {
        return (
            <View style={{flex: 1, flexDirection: 'column'}}>
                <Text style={style.titlebar}>demo</Text>

                <TouchableHighlight >
                    <Text style={style.button_redux}  onPress={() =>this._onPressButton() }>redux</Text>
                </TouchableHighlight>
            </View>
        );
    }

    _onPressButton() {
        this.props.navigation.navigate('reduxdemo')
    }
}

const style = StyleSheet.create({
    titlebar: {
        width: Device.Screen.width,
        height: 52,
        backgroundColor: AppTheme.Color.white,
        textAlign: 'center',
        textAlignVertical: 'center',
        fontSize: 15,
        color: AppTheme.Color.txt_sub_h1,
    },
    button_redux: {
        backgroundColor:AppTheme.Color.commonMain,
        width:Device.Screen.width-30,
        height:45,
        marginLeft:15,
        marginTop:15,
        textAlign: 'center',
        textAlignVertical: 'center',
        color:AppTheme.Color.white,
        borderRadius   : 3,
    }
})

export default DemoScreen;