import React from 'react';
import {Text, StyleSheet, View, Image} from "react-native";
import AppTheme from "../../../base/util/Theme";
import Device from "../../../base/util/Device";

class HeadView extends React.Component {
    render() {
        return (
            <View style={{flexDirection: 'column'}}>
                <View style={style.container}>
                    <View style={{width:Device.Screen.width,alignItems:'center',flexDirection:'row',justifyContent:'center'}}>
                        <Text style={style.txt_title}>未满期总资金(元)</Text>
                        <Image style={{width:23,height:23,marginLeft:8}}
                            source={require('../../../../image/mine/ic_show_num.png')}
                        />
                    </View>
                    <Text style={style.txt_sum}>234323.00</Text>
                </View>
                <Image
                    source={require('../../../../image/mine/bg_arc.png')}
                />
                <View style={style.item_sub}>

                </View>
            </View>
        )
    };
}

const style = StyleSheet.create({
    container: {
        height: 130,
        backgroundColor: AppTheme.Color.commonMain,
    },
    item_sub: {
        backgroundColor: AppTheme.Color.white,
        height: 84
    },
    txt_sum:{
        fontSize:33,
        color:AppTheme.Color.white,
        width:Device.Screen.width,
        textAlign:'center',
        marginTop:10

    },
    txt_title:{
        color:AppTheme.Color.txt_gray,
        fontSize:13.5
    }

});
export default HeadView