import React from 'react';
import {StatusBar, Text, StyleSheet, View, Image} from 'react-native';
import AppTheme from "../../../base/util/Theme";
import Device from "../../../base/util/Device";

class HeadView extends React.Component {
    render() {
        return (
            <View>
                <StatusBar
                    backgroundColor={AppTheme.Color.commonMain}
                    barStyle="light-content"
                />
                <View style={styles.title_bar}>
                    <Image
                        source={require('../../../../image/mine/ic_default_avatar.png')}
                        style={styles.avatar}
                    />
                    <Text style={styles.white_txt} >18617122868</Text>
                    <Text style={[styles.white_txt,{flex:1,textAlign:'right',marginRight:15,fontSize:15}]}>设置</Text>
                </View>
            </View>
        );
    }
}

const styles = StyleSheet.create({
    title_bar: {
        backgroundColor:AppTheme.Color.commonMain,
        height: 52,
        flexDirection: 'row',
        width: Device.Screen.width,
        alignItems:'center'
    },
    common_txt: {
        color: 'blue',
        width:100
    },
    avatar:{
        width:30,
        height:30,
        marginLeft:15
    },
    white_txt:{
        color:AppTheme.Color.white,
        textShadowColor:AppTheme.Color.white,
        fontSize:13,
        marginLeft:10

    }
});
export default HeadView