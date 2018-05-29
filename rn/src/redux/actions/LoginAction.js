import * as TYPES from '../ActionTypes';


export function login(phone) {
    return (dispatch) => {
        //开始获取，发送一个dispatch
        dispatch(init(phone));
        /**
         * 在这里假装做了一个类似于调接口的操作
         */
        //获取成功，发送一个dispatch
        setTimeout(
            () => {  dispatch(success(phone)); },
            500
        );

    }
}

/**
 * 这里会通过dispatch把action送给reducer，TYPE是判断拿到的是哪个action。
 */
function init(list) {
    return {
        type: TYPES.ACTION_LOGINING,
        message: '开始获取',
        bean: list,
    }
}

function success(list) {
    return {
        type: TYPES.ACTION_LOGIN_SUCCESS,
        message: '获取成功',
        bean: list,
    }
}