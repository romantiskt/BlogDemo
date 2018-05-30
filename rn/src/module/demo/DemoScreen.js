import React from 'react';
import {Text, View, StyleSheet, Button, TouchableHighlight} from 'react-native';
import Device from "../../base/util/Device";
import AppTheme from "../../base/util/Theme";
import Log from "../../base/util/Log";
import {connect} from "react-redux";

class DemoScreen extends React.Component {
    constructor(props) {
        super(props);
        //设置状态
        this.state = {
            image : 1,
            text : '',
        }
    }
    render() {
        return (
            <View style={{flex: 1, flexDirection: 'column'}}>
                <Text style={style.titlebar}>demo list</Text>

                <TouchableHighlight >
                    <Text style={style.button_redux}  onPress={() =>this._onPressButton() }>redux </Text>
                </TouchableHighlight>

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
    _onPressButton() {
        Log.d('click');
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
    },
    txt:{
        textAlign:'center',
        marginTop:40
    }
})
function select(store) {
    return {
        loginReducer: store.LoginReducer,
    }
}

export default connect(select)(DemoScreen);