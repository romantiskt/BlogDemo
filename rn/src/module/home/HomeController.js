import React from 'react';
import {Image, Text, View} from 'react-native';
import {createBottomTabNavigator} from 'react-navigation';
import HomeScreen from './HomeScreen';
import SettingsScreen from '../Setting/SettingsScreen';
import MineScreen from '../mine/MineScreen';

export default createBottomTabNavigator(
    {
        Home: HomeScreen,
        Mine:MineScreen,
        Settings: SettingsScreen,
    },
    {
        navigationOptions: ({navigation}) => ({
            tabBarIcon: ({focused, tintColor}) => {
                const {routeName} = navigation.state;
                let iconName;
                if (routeName === 'Home') {
                    return <Image
                        source={require('../../../image/home/tab_home_selected.png')}
                        style={[{height: 24, width: 24}, {tintColor: tintColor}]}
                    />;
                } else if (routeName === 'Settings') {
                    return <Image
                        source={require('../../../image/home/tab_mine_selected.png')}
                        style={[{height: 24, width: 24}, {tintColor: tintColor}]}
                    />;
                }else if(routeName==='Mine'){
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
        },
    }
);