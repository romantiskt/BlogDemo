import React from 'react';
import {Text, View, StyleSheet, TouchableHighlight} from 'react-native';
import Device from "../../base/util/Device";
import AppTheme from "../../base/util/Theme";
import Log from "../../base/util/Log";
import {connect} from "react-redux";
import Toast from "../../core/native/Toast";
import Sp from "../../core/native/Sp";
import Button from "../../base/widget/Button";

class DemoScreen extends React.Component {
    constructor(props) {
        super(props);
        //设置状态
        this.state = {
            image: 1,
            text: '',
        }
    }

    render() {
        return (
            <View style={{flex: 1, flexDirection: 'column'}}>
                <Text style={style.titlebar}>demo list</Text>
                <Button style={style.button_redux} onPress={() => this.clickRedux()} text='redux'/>
                <Button  style={style.button_redux} onPress={() => this.clickNativeToastModule()} text='native toast'/>
                <Button  style={style.button_redux} onPress={() => this.clickSaveToFile()} text='save string to file'/>
                <Button  style={style.button_redux} onPress={() => this.clickGetValueForFile()} text='get string for
                        file'/>
                <Text style={style.txt}>{this.state.text ? this.state.text : 'no login'}  </Text>
            </View>
        );
    }

    componentWillReceiveProps(nextProps) {
        if (nextProps.loginReducer != null) {
            this.setState({
                text: nextProps.loginReducer.status,
            })
        }
    }

    clickRedux() {
        Log.d('click');
        this.props.navigation.navigate('reduxdemo')
    }

    clickNativeToastModule() {
        Toast.show('This is Native Toast ', Toast.SHORT);
    }

    clickSaveToFile() {
        Sp.putString('phone', '18111111111');
    }

    clickGetValueForFile() {
        Sp.getString('phone').then(
            (msg) => {
                Toast.show(msg, Toast.SHORT);
            }
        )

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
        marginTop:10
    },
    txt: {
        textAlign: 'center',
        marginTop: 40
    }
})

function select(store) {
    return {
        loginReducer: store.LoginReducer,
    }
}

export default connect(select)(DemoScreen);