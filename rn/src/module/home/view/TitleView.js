import React from 'react';
import {StatusBar, Text, StyleSheet, View, Image} from 'react-native';
import AppTheme from "../../../base/util/Theme";
import Device from "../../../base/util/Device";

class TitleView extends React.Component {
    render() {
        return (
            <View>
                <StatusBar
                    barStyle="dark-content"
                    translucent={false}
                />
                <View style={styles.title_bar}>
                    <Image
                        source={require('../../../../image/mine/ic_default_avatar.png')}
                        style={styles.avatar}
                    />
                    <Text style={styles.txt}>186****2868</Text>
                    <View style={{flex:1,flexDirection:'row',justifyContent:'flex-end'}}>
                        <Image style={[styles.img_right]}
                               source={require('../../../../image/home/navi_message.png')}></Image>
                    </View>
                </View>
            </View>
        );
    }
}

const styles = StyleSheet.create({
    title_bar: {
        backgroundColor: AppTheme.Color.white,
        height: 52,
        flexDirection: 'row',
        width: Device.Screen.width,
        alignItems: 'center'
    },
    avatar: {
        width: 30,
        height: 30,
        marginLeft: 15
    },
    txt: {
        color: AppTheme.Color.txt_sub_h1,
        fontSize: 13,
        marginLeft: 10

    },
    img_right: {
        marginRight: 15,
        width: 22,
        height: 22,
    }
});
export default TitleView