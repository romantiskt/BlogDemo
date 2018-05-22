import React from 'react';
import {Text, StyleSheet, View, ScrollView} from 'react-native';
import TitleView from "./view/TitleView";
import HeadView from "./view/HeadView";
import AppTheme from "../../base/util/Theme";


class MineScreen extends React.Component {
    render() {
        return (
            <View style={style.container}>
                <TitleView/>
                <ScrollView style={style.scroll}>
                    <HeadView/>
                    <View style={style.test1}/>
                    <View style={style.test2}/>
                    <View style={style.test3}/>
                    <View style={style.test1}/>
                    <View style={style.test2}/>
                    <View style={style.test3}/>
                </ScrollView>
            </View>

        );
    }
}

const style = StyleSheet.create({
    container: {
        flex: 1,
        flexDirection: 'column',
    },
    scroll:{

    },
    test1:{
        height:100,
        backgroundColor:AppTheme.Color.gray
    },
    test2:{
        height:100,
        backgroundColor:AppTheme.Color.gray
    },
    test3:{
        height:100,
        backgroundColor:AppTheme.Color.gray
    }
});
export default MineScreen;