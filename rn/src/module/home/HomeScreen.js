import React from 'react';
import {Image, StyleSheet, StatusBar, Text, View, ScrollView} from 'react-native';
import TitleView from "./view/TitleView";
import HomeInfo from '../../../json/home.json'
import Type3View from "./view/Type3View";
import Constants from "../../core/entity/Constants";
import AppTheme from "../../base/util/Theme";
import Type22View from "./view/Type22View";
import Type21View from "./view/Type21View";
import Type9View from "./view/Type9View";
import Type23View from "./view/Type23View";
import Type24View from "./view/Type24View";
import Type25View from "./view/Type25View";

class HomeScreen extends React.Component {
     render() {
        let themeArry = HomeInfo.theme;
        return (

            <View style={{flex: 1}}>
                <TitleView/>
                <ScrollView style={style.scroll}>
                    {themeArry && themeArry.length > 0 && this.renderList(themeArry)}
                </ScrollView>
            </View>
        );
    }

    // noinspection JSAnnotator
    renderList(value: Object) {
        let members = value.map((element, index) => {
            return this.renderItemForType(element.type,element.data)
        });
        return (
            <View style={style.container}>
                {members}
            </View>
        )
    }

    // noinspection JSAnnotator
    renderItemForType(type: number,data:Object) {
        if(type==Constants.HOME_VIEW_TYPE.TYPE_3){
            return this.renderType3View(data);
        }else if(type==Constants.HOME_VIEW_TYPE.TYPE_9){
            return this.renderType9View(data);
        }else if(type==Constants.HOME_VIEW_TYPE.TYPE_21){
            return this.renderType21View(data);
        }else if(type==Constants.HOME_VIEW_TYPE.TYPE_22){
            return this.renderType22View(data);
        }else if(type==Constants.HOME_VIEW_TYPE.TYPE_23){
            return this.renderType23View(data);
        }else if(type==Constants.HOME_VIEW_TYPE.TYPE_24){
            return this.renderType24View(data);
        }else if(type==Constants.HOME_VIEW_TYPE.TYPE_25){
            return this.renderType25View(data);
        }
    }

    // noinspection JSAnnotator
    renderType3View(data:Object) {
        return (
           <Type3View key='renderType3View' data={data}/>
        )
    }
    // noinspection JSAnnotator
    renderType9View(data:Object) {
        return (
            <Type9View key='renderType9View'  data={data}></Type9View>
        )
    }
    // noinspection JSAnnotator
    renderType21View(data:Object) {
        return (
            <Type21View key='renderType21View' data={data}></Type21View>
        )
    }
    // noinspection JSAnnotator
    renderType22View(data:Object) {
        return (
           <Type22View key='renderType22View' data={data}/>
        )
    }
    // noinspection JSAnnotator
    renderType23View(data:Object) {
        return (
            <Type23View key='renderType23View'  data={data}></Type23View>
        )
    }

    // noinspection JSAnnotator
    renderType24View(data:Object) {
        return (
            <Type24View key='renderType24View'   data={data}></Type24View>
        )
    }

    // noinspection JSAnnotator
    renderType25View(data:Object) {
        return (
            <Type25View key='renderType25View'   data={data}></Type25View>
        )
    }
}

const style = StyleSheet.create({
    scroll: {
        backgroundColor:AppTheme.Color.bg_home
    },
    container: {
        backgroundColor: AppTheme.Color.bg,
        flexDirection: 'column'
    },
})
export default HomeScreen;