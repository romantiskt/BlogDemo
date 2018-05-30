import {
    Text,
    StyleSheet,
    TouchableHighlight,
} from 'react-native';
import AppTheme from "../util/Theme";
import React from 'react'
import PropTypes from 'prop-types';
const styles = StyleSheet.create({
    buttonText: {
        fontSize: 15,
        color: AppTheme.Color.white,
        alignSelf: 'center',
        marginLeft: 10,
        marginRight: 10
    },
    button: {
        height: 50,
        flexDirection: 'row',
        justifyContent: 'center',
        // borderColor: '#b7242c',
        borderWidth: 0,
        borderRadius: 3,
        marginLeft: 15,
        marginRight: 15
    }
});

function addColorAlpha(color) {
    if (color.charAt(0) === '#') {
        return color + 'AA'
    }
    return color;
}

class Button extends React.Component {
// 组件初始化
    constructor(props) {
        super(props);
        this._pressLock = false;
    }

    _prepareProps() {
        let props = {...this.props};
        let style = {};

        if (this.props.flex) {
            style.flex = this.props.flex;
        }
        if (this.props.width) {
            style.width = parseFloat(this.props.width);
            delete props.width;
        }
        if (this.props.height) {
            style.height = parseFloat(this.props.height);
            delete props.height;
        }
        if(this.props.marginTop){
            style.marginTop=parseFloat(this.props.marginTop);
            delete props.marginTop;
        }

        // background (dim if it's diable)
        let backgroundColor = this.props.backgroundColor || AppTheme.Color.commonMain;
        let backgroundColorPre = (this.props.backgroundColor) ? addColorAlpha(backgroundColor)  // add a alpha of the backgroundColor
            : AppTheme.Color.commonMain;
        props.underlayColor = backgroundColorPre;
        style.backgroundColor = this.props.disabled ? AppTheme.Color.txt_sub_h2
            : backgroundColor;

        // onPress - the same in props
        props.onPress = (event) => {
            if (this._pressLock) return;
            this._pressLock = true;
            this.props.onPress(event);
            setTimeout(() => {
                this._pressLock = false;
            }, 500)
        }

        if (!this.props.style) {
            props.style = [styles.button, style];
        }
        else if (this.props.style instanceof Array) {
            props.style = this.props.style;
            props.style.push(styles.button);
            props.style.push(style);
        }
        else {
            props.style = [styles.button, style, this.props.style];
        }

        return props;
    }

    _prepareTextProps() {
        let props = {};
        let style = {};
        if (this.props.textColor) {
            style.color = this.props.textColor;
        }
        if (this.props.textSize) {
            style.fontSize = this.props.textSize;
        }
        props.style = [styles.buttonText, style];

        return props;
    }

    render() {
        return (
            <TouchableHighlight {...this._prepareProps()}>
                <Text {...this._prepareTextProps()}>{this.props.text}</Text>
            </TouchableHighlight>
        );
    }
}


Button.propTypes = {
    flex: PropTypes.number,
    text: PropTypes.string,
    textColor: PropTypes.string,
    textSize: PropTypes.number,
    backgroundColor: PropTypes.string,
    disabled: PropTypes.bool,
    height: PropTypes.number,
    width: PropTypes.number,
    onPress: PropTypes.func,
    marginTop:PropTypes.number,
}

export default Button;
