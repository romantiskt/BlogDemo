import React from 'react';
import {Image, StyleSheet, StatusBar, Text, View, ScrollView} from 'react-native';
import TitleView from "./view/TitleView";
import HomeInfo from '../../../json/home.json'
import Type3View from "./view/Type3View";

class HomeScreen extends React.Component {
    render() {

        let themeArry = HomeInfo.theme;
        return (

            <View style={{flex: 1}}>
                <TitleView/>
                <Text>{themeArry.length}</Text>
                <ScrollView style={style.scroll}>
                    {this.renderList(themeArry)}
                </ScrollView>

            </View>
        );
    }

    // noinspection JSAnnotator
    renderList(value: Object) {
        let members = value.map((element, index) => {
            return (<Text>{value.type}</Text>)
        });
        return (
            <View style={{flexDirection:'column'}}>
                {members}
            </View>
        )
    }
}

const style = StyleSheet.create({
    scroll: {}
})
export default HomeScreen;