import React from 'react'
import {Text, StyleSheet, TouchableHighlight, View} from "react-native";
import {connect} from "react-redux";
import AppTheme from "../../../base/util/Theme";
import Device from "../../../base/util/Device";
import {login} from '../../../redux/actions/LoginAction';
import Log from "../../../base/util/Log";

class ReduxDemo extends React.Component {
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
            <View style={{flexDirection: 'column'}}>
                <Text style={style.txt}>{this.state.text ? this.state.text : 'hello world'}  </Text>

                <TouchableHighlight>
                    <Text style={style.button_redux} onPress={() => this._onPressButton()}>Login</Text>
                </TouchableHighlight>
            </View>

        )
    }

    _onPressButton() {
        let phone = '18617122868';
        this.props.dispatch(login(phone));
    }

    componentWillReceiveProps(nextProps) {
        Log.d("props change ");
        Log.d("nextProps.LoginReducer___ "+nextProps.loginReducer);
        if (nextProps.loginReducer != null) {
            if (nextProps.loginReducer.status == 'success') {
                this.setState({
                    image: 2,
                })
            } else {
                this.setState({
                    image: 1,
                })
            }
            this.setState({
                text: nextProps.loginReducer.status,
            })
        }
    }

    /**
     * 生命周期 - 因为state变动频繁，不建议将redux的回调代码在这里处理，而且这里面是不能进行setState的操作的。
     * @param {*} nextProps
     * @param {*} nextState
     */
    shouldComponentUpdate(nextProps, nextState) {
        console.log("执行了shouldComponentUpdate");
        return true;
    }
}


const style = StyleSheet.create({

    button_redux: {
        backgroundColor: AppTheme.Color.commonMain,
        width: Device.Screen.width - 30,
        height: 45,
        marginLeft: 15,
        marginTop: 15,
        textAlign: 'center',
        textAlignVertical: 'center',
        color: AppTheme.Color.white,
        borderRadius: 3,
    },
    txt:{
        textAlign:'center',
        marginTop:40
    }
});

function select(store) {
    return {
        loginReducer: store.LoginReducer,
    }
}

export default connect(select)(ReduxDemo);