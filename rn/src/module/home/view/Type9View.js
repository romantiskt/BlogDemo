import React from 'react'
import {Image, StyleSheet, Text, View} from "react-native";
import AppTheme from "../../../base/util/Theme";
import Device from "../../../base/util/Device";
import Swiper from 'react-native-swiper'

/**
 * 这个是一个轮播view
 */
class Type9View extends React.Component {

    render() {
        let data = this.props.data;
        if (!data && data.length == 0) {
            return null;
        }
        let dataitem = data[0];
        if (!dataitem.desc || dataitem.desc.length == 0) {
            return (<Text>desc is null</Text>)
        }
        let imgs = dataitem.desc;
        if (!imgs || imgs.length == 0) {
            return null;
        }
        let members = imgs.map((element, index) => {
            return this.renderItemImg(element, index);
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
                        autoplay={true}>
                    {members}
                </Swiper>
            </View>
        )

    }

    renderItemImg(element, index) {
        return (
            <View key={index} style={style.slide}>
                <Image style={style.img} source={{uri: element.pic_url}}
                       resizeMode='cover'
                />
            </View>
        )
    }
}

const style = StyleSheet.create({
    img: {
        width: Device.Screen.width,
        height: 96,
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
        marginBottom: 10

    }
})
export default Type9View