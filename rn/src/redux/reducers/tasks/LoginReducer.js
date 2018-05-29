
import * as TYPES from '../../ActionTypes';

/**
 * 这里可以初始化一个默认的实体类
 */
const initialState = {
    status: 'loading...',
    isSuccess: false,
    bean:null,
    message : '',
}
/**
 * 在这里可以拿到action并return给IndexReducers.js进行分发。
 *
 * 根据type判断了是从哪个action过来的数据，并进行选择性return。
 */
export default function login(state = initialState, action) {
    switch (action.type) {
        case TYPES.ACTION_LOGINING: // 初始状态
            return Object.assign({}, state, {
                status: 'loading...',
                isSuccess: false,
                bean : action.bean,
                message : action.message,
            });
            break;
        case TYPES.ACTION_LOGIN_SUCCESS: // 初始状态
            return Object.assign({}, state, {
                status: 'login success..',
                isSuccess: true,
                bean : action.bean,
                message : action.message,
            });
            break;
        default:
            return state;
    }
}