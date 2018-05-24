import {Text, StyleSheet, View, Image} from "react-native";
import React from 'react'
import PropTypes from 'prop-types';
import AppTheme from "../../../base/util/Theme";
import Device from "../../../base/util/Device";

class GridView extends React.Component {
    // noinspection JSAnnotator
    renderProduct(product: Object, index: number, isBreak: bool) {
        return (
            <View key={index} style={[style.grid_item]}>
                <View style={{flex:1,alignItems:'center',flexDirection:'row'}}>
                    <Image style={style.img} source={{uri: product.icon}}></Image>
                    <View style={{marginLeft:14,flexDirection:'column'}}>
                        <Text style={style.txt_item_title}>{product.title}</Text>
                        <Text style={style.txt_item_sub}>{product.title}</Text>
                    </View>

                </View>
                {(index % 2 == 0) && <View style={style.devider}></View>}
            </View>
        );
    };

    render() {
        let account_info = this.props.account_info;
        if (!account_info || account_info.length == 0) {
            return null;
        }
        let members = account_info.map((element, index) => {
            return this.renderProduct(element, index, (index + 1) % 2 == 0)
        });
        return (
            <View style={style.outerBox}>
                {members}
            </View>
        )
    };

}

const style = StyleSheet.create({
    grid_item: {
        backgroundColor: AppTheme.Color.white,
        width: Device.Screen.width / 2,
        height: 85,
        flexDirection: 'row',
        marginTop: 0.5,
        justifyContent: 'flex-end'
    },
    outerBox: {
        flexDirection: 'row',
        flexWrap: 'wrap',
        width: Device.Screen.width,
        marginTop: 10
    },
    img: {
        width: 25,
        height: 25,
        marginLeft:14
    },
    devider: {
        height: 85,
        width: 0.5,
        backgroundColor: AppTheme.Color.bg,
    },
    txt_item_title:{
        fontSize:17,
        color:AppTheme.Color.txt_sub_h1,
    },
    txt_item_sub:{
        fontSize:14,
        color:AppTheme.Color.txt_sub_h2
    }
});
export default GridView