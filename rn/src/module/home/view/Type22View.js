import React from 'react'
import {Image,StyleSheet} from "react-native";
import AppTheme from "../../../base/util/Theme";
import Device from "../../../base/util/Device";

/**
 * 这个一个单张图片的view
 */
class Type22View extends React.Component {

    render() {
        let data = this.props.data;
        if(!data&&data.length==0){
            return null;
        }
        let dataitem=data[0];
        if(!dataitem.desc||dataitem.desc.length==0){
            return (<Text>desc is null</Text>)
        }
        let descitem=dataitem.desc[0];
        return (
            <Image style={style.img} source={{uri:descitem.pic_url}}></Image>
        )

    }

}
const style = StyleSheet.create({
    img:{
        width:Device.Screen.width,
        height:150,
    }
})
export default Type22View