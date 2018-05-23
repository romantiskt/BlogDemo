import { Dimensions,PixelRatio} from "react-native";

const Device = {
    Screen: {
      pixelRatio: PixelRatio.get(),
      pixelSize: 1 / PixelRatio.get(),
  
      screenSize: {
        width: Dimensions.get('window').width,
        height: Dimensions.get('window').height,
      },
      width: Dimensions.get('window').width,
      height: Dimensions.get('window').height,
    },
  
  };
  
  export default Device;