import React from 'react';
import {Text, StyleSheet, View, ScrollView} from 'react-native';
import TitleView from "./view/TitleView";
import HeadView from "./view/HeadView";
import AppTheme from "../../base/util/Theme";
import AccountInfo from '../../../json/mine.json'
import GridView from "./view/GridView";
import ItemsView from "./view/ItemsView";

class MineScreen extends React.Component {
    componentWillMount() {
        console.log("AccountInfo"+AccountInfo);
    }
    render() {
        return (
            <View style={style.container}>
                <TitleView/>
                <ScrollView style={style.scroll}>
                    <HeadView/>
                    <GridView account_info={AccountInfo.account_info}/>
                    <ItemsView data={AccountInfo}/>
                    <View style={style.space}/>
                </ScrollView>
            </View>

        );
    }
}

const style = StyleSheet.create({
    container: {
        flex: 1,
        flexDirection: 'column',
        backgroundColor:AppTheme.Color.bg
    },
    scroll:{

    },
    space:{
        height:30,
        backgroundColor:AppTheme.Color.bg
    }

});
export default MineScreen;