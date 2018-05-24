import React from 'react'
import {Text, StyleSheet, View, Image} from "react-native";
import AppTheme from "../../../base/util/Theme";
import Device from "../../../base/util/Device";

/**
 * type=21的数据
 * 这个一个有4个item的gridview
 */
class Type21View extends React.Component {
    render() {
        let data = this.props.data;
        if (!data || data.length == 0) {
            return null;
        }
        let dataArray = [];
        data.forEach(function (element) {//循环数组
            let desc = element.desc;
            if (desc && desc.length > 0) {
                desc.forEach(function (ele) {
                    dataArray.push(ele)
                })
            }
        });
        if (!dataArray || dataArray.length == 0) {
            return null;
        }
        let members = dataArray.map((element, index) => {
            return this.renderItemForIndex(element, index);
        });
        return (
            <View style={{flexDirection: 'column'}}>
                <View style={style.outerBox}>
                    {members}
                </View>
                <View style={{width:Device.Screen.width,height:10,backgroundColor:AppTheme.Color.white}}/>
            </View>
        )
    }

    renderItemForIndex(element, index) {
        return (
            <View key={index} style={[style.grid_item, {
                marginRight: index % 2 == 0 ? 2.5 : 0,
                marginLeft: index % 2 == 0 ? 13.5 : 2.5
            }]}>

                <View style={{flexDirection: 'column'}}>
                    <Text style={style.txt_item_title}>{element.txt}</Text>
                    <Text style={style.txt_item_subtitle}>{element.memo}</Text>
                </View>
                <View style={{flex: 1, justifyContent: 'flex-end', flexDirection: 'row'}}>
                    <Image style={style.img}
                           source={{uri: element.pic_url}}
                    />
                </View>
            </View>
        );
    }
}


const style = StyleSheet.create({
    grid_item: {
        backgroundColor: AppTheme.Color.bg_home,
        width: (Device.Screen.width - 32) / 2,
        height: 68,
        flexDirection: 'row',
        alignItems: 'center',
        marginTop: 5,
    },
    outerBox: {
        flexDirection: 'row',
        flexWrap: 'wrap',
        width: Device.Screen.width,
        backgroundColor: AppTheme.Color.white,
    },
    img: {
        width: 46,
        height: 46,
        marginRight: 10
    },
    txt_item_title: {
        fontSize: 14.5,
        color: AppTheme.Color.txt_sub_h1,
        marginLeft: 10
    },
    txt_item_subtitle: {
        fontSize: 12.5,
        color: AppTheme.Color.txt_sub_h2,
        marginTop: 2,
        marginLeft: 10
    }
});
export default Type21View