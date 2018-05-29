
// 全局Logger配置
var LOGGER_IS_DEBUG = __DEV__;
var LogLevelVerbose = 1,
    LogLevelInfo = 2,
    LogLevelDebug = 3,
    LogLevelWarn = 4,
    LogLevelError = 5;
var LogLevel = LogLevelInfo;

function _logger(level , tag , msg , object = null) {
    if (!LOGGER_IS_DEBUG) {
        return;
    }

    tag = tag? tag: _logger.caller.caller.toString().split('(')[0];

    if(level === 'v' && LogLevel <= LogLevelVerbose){
        _logMsg('Verbose', tag , msg , object);
    }else if(level === 'i' && LogLevel <= LogLevelInfo){
        _logMsg('Info', tag , msg , object);
    }else if(level === 'd' && LogLevel <= LogLevelDebug){
        _logMsg('Debug', tag , msg , object);
    }else if(level === 'w' && LogLevel <= LogLevelWarn){
        _logMsg("Warn", tag , msg , object);
    }else if(level === 'e'){
        _logMsg('Error', tag , msg , object);
    }

    // log the object
    if(typeof(msg) === 'object'){
        console.log(msg);
    }
}

function _logMsg(level, tag, msg , object) {
    if(object){
        console.log('[' + level + '][' + tag + ']  -- ' + msg + ' |');
        console.log(object);
    }else{
        console.log('[' + (new Date().toLocaleTimeString()) + '][' + level + '][' + tag + ']  ' + msg);
    }
}


const Log = {

    d(msg , object = null ,tag=null) {
        _logger('d' , tag , msg , object);
    },


    e(msg , object = null , tag=null) {
        _logger('e' , tag , msg , object);
    },


}
export default Log;
