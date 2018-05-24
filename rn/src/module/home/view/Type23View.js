import React from 'react'
import Device from "../../../base/util/Device";
import AppTheme from "../../../base/util/Theme";
import {Text, StyleSheet, View, Image} from "react-native";

class Type23View extends React.Component {
    render() {
        let data = this.props.data;
        if (!data && data.length == 0) {
            return null;
        }
        let dataitem = data[0];
        if (!dataitem.desc || dataitem.desc.length == 0) {
            return (<Text>desc is null</Text>)
        }
        let descitem0 = dataitem.desc[0];
        let descitem1 = dataitem.desc[1];
        let descitem2 = dataitem.desc[2];
        return (
            <View style={style.container}>
                <View style={{flexDirection: 'column', alignItems: 'center', height: 76}}>
                    <Text style={style.txt_title}> 惠享生活</Text>
                    <Text style={style.txt_sub_title}> {dataitem.more_txt}</Text>
                </View>
                <View style={{width: Device.Screen.width, height: 0.75, backgroundColor: AppTheme.Color.bg}}/>
                <View style={style.b_all}>
                    <View style={style.b_left}>
                        <Text style={style.txt_product_title}>{descitem0.txt}</Text>
                        <Text style={style.txt_product_sub_title}>{descitem0.memo}</Text>
                        <Image style={style.img} source={{uri:descitem0.pic_url}}></Image>
                    </View>
                    <View style={{height: Device.Screen.width, width: 1, backgroundColor: AppTheme.Color.bg}}/>
                    <View style={style.b_right}>
                        <View style={style.b_right_1}>
                            <View style={{flexDirection:'column'}}>
                                <Text style={[style.txt_product_title,{marginLeft:20}]}>{descitem1.txt}</Text>
                                <Text style={[style.txt_product_sub_title,{marginLeft:20}]}>{descitem1.memo}</Text>
                            </View>
                            <Image style={style.img_right} source={{uri:descitem1.pic_url}}></Image>
                        </View>
                        <View style={{width: Device.Screen.width / 2-0.5, height: 1, backgroundColor: AppTheme.Color.bg}}/>
                        <View style={style.b_right_2}>
                            <View style={{flexDirection:'column'}}>
                                <Text style={[style.txt_product_title,{marginLeft:20}]}>{descitem2.txt}</Text>
                                <Text style={[style.txt_product_sub_title,{marginLeft:20}]}>{descitem2.memo}</Text>
                            </View>
                            <Image style={style.img_right} source={{uri:descitem2.pic_url}}></Image>
                        </View>
                    </View>
                </View>
            </View>
        )

    }

}

const style = StyleSheet.create({
    container: {
        width: Device.Screen.width,
        height: 231,
        backgroundColor: AppTheme.Color.white,
        marginTop: 10,
        flexDirection: 'column'
    },
    txt_title: {
        fontSize: 17,
        marginTop: 20
    },
    txt_sub_title: {
        fontSize: 13,
        color: AppTheme.Color.txt_sub_h2,
    },
    b_all: {
        width: Device.Screen.width-0.5,
        height: 155,
        flexDirection:'row'
    },
    b_left: {
        width: Device.Screen.width / 2-0.5,
        height: 155,
        marginRight:0.5,
        alignItems:'center',
        flexDirection:'column'
    },
    b_right: {
        width: Device.Screen.width / 2-0.5,
        marginLeft:0.5,
        flexDirection:'column'
    },
    b_right_1:{
        height:155/2-0.5,
        flexDirection:'row',
    },
    b_right_2:{
        height:155/2-0.5,
        flexDirection:'row',
    },
    txt_product_title:{
        fontSize:14,
        color:AppTheme.Color.txt_sub_h1,
        marginTop:21

    },
    txt_product_sub_title:{
        fontSize:12,
        color:AppTheme.Color.txt_sub_h2,
        marginTop:2
    },
    img:{
        marginTop:6,
        width:110,
        height:74
    },
    img_right:{
        width:50,
        height:50,
        marginLeft:10,
        marginTop:13
    }
})
export default Type23View