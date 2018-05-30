import React from 'react'
import {Text, View} from "react-native";
import NativeCircleView from "../../../core/view/NativeCircleView";

class WidgetShowScreen extends React.Component {


    render() {

        return (
            <View style={{flexDirection: 'column'}}>
                <Text>Normally, only the creator of a Deferred should call this method; you can prevent other code from
                    changing the Deferred's state by returning a restricted Promise object through deferred.promise().

                    When the Deferred is rejected, any failCallbacks added by deferred.then() or deferred.fail() are
                    called.
                    Callbacks are executed in the order they were added. Each callback is passed the args from the
                    deferred.reject() call. Any failCallbacks added after the Deferred enters the rejected state are
                    executed immediately when they are added, using the arguments that were passed to the
                    deferred.reject()
                    call. For mor</Text>
              <NativeCircleView/>
            </View>
        )
    }


}

export default WidgetShowScreen