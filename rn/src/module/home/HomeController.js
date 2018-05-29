import React from 'react';
import {Image, Text, View} from 'react-native';
import {createBottomTabNavigator} from 'react-navigation';
import HomeScreen from './HomeScreen';
import SettingsScreen from '../demo/DemoList';
import MineScreen from '../mine/MineScreen';
import DemoScreen from "../demo/DemoScreen";

export default createBottomTabNavigator(
    {
        首页: HomeScreen,
        我的:MineScreen,
        demo:DemoScreen,
    },
    {
        navigationOptions: ({navigation}) => ({
            tabBarIcon: ({focused, tintColor}) => {
                const {routeName} = navigation.state;
                let iconName;
                if (routeName === '首页') {
                    return <Image
                        source={require('../../../image/home/tab_home_selected.png')}
                        style={[{height: 24, width: 24}, {tintColor: tintColor}]}
                    />;
                } else if (routeName === 'Settings') {
                    return <Image
                        source={require('../../../image/home/tab_mine_selected.png')}
                        style={[{height: 24, width: 24}, {tintColor: tintColor}]}
                    />;
                }else if(routeName==='我的'){
                    return <Image
                        source={require('../../../image/home/tab_mine_selected.png')}
                        style={[{height: 24, width: 24}, {tintColor: tintColor}]}
                    />;
                }else if(routeName==='demo'){
                    return <Image
                        source={require('../../../image/home/tab_mine_selected.png')}
                        style={[{height: 24, width: 24}, {tintColor: tintColor}]}
                    />;
                }
            },

        }),

        tabBarOptions: {
            activeTintColor: 'tomato',
            inactiveTintColor: 'gray',
            labelStyle: {
                fontSize: 11,
            },
        },
        initialRouteName: '我的',

    }
);