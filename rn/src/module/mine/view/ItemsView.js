import React from 'react'
import {Text, StyleSheet, View, Image} from "react-native";
import AppTheme from "../../../base/util/Theme";
import Device from "../../../base/util/Device";

class ItemsView extends React.Component {

    render() {

        let data = this.props.data;
        if (!data) {
            return null;
        }
        let arr = [];
        arr[0] = {'desc': '红包/加息券', 'value': data.coupon_amount,img:''};
        arr[1] = {'desc': '银行卡', 'value': data.bank_cards,img:''};
        arr[2] = {'desc': '加油卡', 'value': data.oil_card,img:''};
        let profile=data.profile;
        if (profile&&profile.length>0) {
            for (i=0;i<profile.length;i++){
                item=profile[i];
             arr[3+i]={'desc':item.caption,'value':'',img:item.icon}
            }
        }

        let members = arr.map((element, index) => {
            return this.renderItem(element, index)
        });
        return (
            <View style={style.container}>

                {members}
            </View>
        );


    };

    // noinspection JSAnnotator
    renderItem(element: Object, index: number) {
        let icon = this.setImg(index);
        return (
            <View key={index} style={[style.out,{marginTop:index==3?10:0.7}]}>
                <Image style={style.img_left}
                       source={element.img?{uri:element.img}:icon}
                />
                <Text style={style.txt_left}>{element.desc}</Text>
                <View style={{flex: 1, justifyContent: 'flex-end', flexDirection: 'row'}}>
                    <Text style={style.txt_right}>{element.value}</Text>
                    <Image style={style.img_right}
                           source={require('../../../../image/mine/right_arrow.png')}
                    />
                </View>
            </View>
        )
    };

    setImg(index){
        switch(index){
            case 0:
                return require('../../../../image/mine/ic_coupon.png')
            case 1:
                return require('../../../../image/mine/ic_bankcard.png')
            case 2:
                return require('../../../../image/mine/ic_gascard.png')
        }
    }
}

const style = StyleSheet.create({
    container: {
        marginTop: 10,
        backgroundColor: AppTheme.Color.bg,
        flexDirection: 'column'
    },
    out: {
        backgroundColor: AppTheme.Color.white,
        height: 52,
        width: Device.Screen.width,
        flexDirection: 'row',
        alignItems: 'center'
    },
    img_left: {
        width: 20,
        height: 20,
        marginLeft: 15

    },
    txt_left: {
        fontSize: 15,
        color: AppTheme.Color.txt_sub_h1,
        marginLeft: 10
    },
    img_right: {
        width: 20,
        height: 20,
        marginRight: 15

    },
    txt_right: {
        fontSize: 15,
        color: AppTheme.Color.txt_sub_h2,
        marginRight: 10
    }
})
export default ItemsView