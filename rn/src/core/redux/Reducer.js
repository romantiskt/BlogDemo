

/**
 * 事件分发 总模块
 */

import { combineReducers } from 'redux';
import LoginReducer from '../../module/demo/redux/LoginReducer';

//这里面必须要有初始数据 - 否则报错  
const rootReducer = combineReducers({
    LoginReducer,
});

export default rootReducer; 