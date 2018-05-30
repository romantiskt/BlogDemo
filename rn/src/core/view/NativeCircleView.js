import React from 'react'
import {Text,requireNativeComponent, View} from "react-native";

var ReactNativeCircleView = requireNativeComponent('ReactCircle', NativeCircleView);

class NativeCircleView extends React.Component {

     render(){
         return (
             <View style={{flexDirection:'column'}}>
                 <Text>this is title</Text>
                 <ReactNativeCircleView style={{width:100,height:100}}/>
             </View>
         )

     }

}

export default NativeCircleView