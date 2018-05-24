import React from 'react'
import {Image, StyleSheet, Text, View} from "react-native";
import AppTheme from "../../../base/util/Theme";
import Device from "../../../base/util/Device";
import Swiper from 'react-native-swiper'

/**
 * 这个是一个轮播view
 */
class Type25View extends React.Component {

    render() {
        let data = this.props.data;
        if (!data && data.length == 0) {
            return null;
        }
        let dataitem = data[0];
        if (!dataitem.desc || dataitem.desc.length == 0) {
            return (<Text>desc is null</Text>)
        }
        let desc = dataitem.desc;
        if (!desc || desc.length == 0) {
            return null;
        }
        let pages = [];
        let items = [];
        for (let i = 0; i < desc.length; i++) {
            if (items.length == 4) {
                pages.push(items)
                items = [];
            }
            items.push(desc[i]);
        }

        let members = pages.map((element, index) => {
            return this.renderItem(element, index);
        });
        return (
            <View style={style.container}>

                <Swiper style={style.wrapper}
                        dot={<View style={{
                            backgroundColor: AppTheme.Color.gray,
                            width: 4,
                            height: 4,
                            borderRadius: 7,
                            marginLeft: 5,
                            marginRight: 5
                        }}/>}
                        activeDot={<View style={{
                            backgroundColor: AppTheme.Color.commonMain,
                            width: 4,
                            height: 4,
                            borderRadius: 7,
                            marginLeft: 5,
                            marginRight: 5
                        }}/>}
                        paginationStyle={{
                            bottom: 10
                        }}
                        loop={true}
                        autoplay={false}>
                    {members}
                </Swiper>
            </View>
        )

    }

    renderItem(element, index) {
        return (
            <View key={index} style={style.slide}>
                {this.renderItemChildren(element)}
            </View>
        )
    }

    renderItemChildren(element) {
        if (!element || element.length == 0) {
            return null;
        }
        let members = element.map((element, index) => {
            return this.renderItemGridView(element, index);
        });
        return (
            <View style={style.outerBox}>
                {members}
            </View>
        )
    }

    renderItemGridView(element, index) {
        return (
            <View key={index} style={[style.grid_item]}>
                <Image style={style.img} source={{uri: element.pic_url}}></Image>
                <Text style={style.txt_item_title}>{element.txt}</Text>
            </View>)
    }
}

const style = StyleSheet.create({
    img: {
        width:41,
        height: 41,
    },
    wrapper: {},
    slide: {
        justifyContent: 'center',
        backgroundColor: 'transparent'
    },
    container: {
        flex: 1,
        height: 96,
        width: Device.Screen.width,
        marginTop: 10,
        marginBottom: 10,
        backgroundColor: AppTheme.Color.white

    },
    grid_item: {
        backgroundColor: AppTheme.Color.white,
        width: Device.Screen.width / 4,
        height: 98,
        flexDirection: 'column',
        alignItems: 'center',
    },
    outerBox: {
        flexDirection: 'row',
        flexWrap: 'wrap',
        width: Device.Screen.width,
        marginTop: 10
    },
    txt_item_title: {
        fontSize: 12,
        marginTop: 8,
        color: AppTheme.Color.txt_sub_h1
    }
})
export default Type25View