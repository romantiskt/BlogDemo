import {AppRegistry,YellowBox} from 'react-native';
import App from './src/module/home/HomeController';

YellowBox.ignoreWarnings(['Warning: isMounted(...) is deprecated', 'Module RCTImageLoader']);//屏蔽掉这个warning
AppRegistry.registerComponent('RnDemo', () => App);
