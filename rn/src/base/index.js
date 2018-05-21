/**
 *  程序基础库，提供与上层app无关基础框架及工具。包含:<br/>
 *  - Device 维护设备信息
 *  - Log     提供app日志管理功能
 *
 *  @author luochenxun(luochenxun@gmail.com) , 16/4/12.
 *  @copyright © 2017年 Jiayoubao. All rights reserved.
 *
 *  @module app/base
 *  @providesModule app/base
 *  @jsdoc
 */

import Device from './device';
import Network from './network/Network';
import Request from './network/Request';
import Storage from './storage';
import Log from './log';

export {
  // 获取与设备有关的方法与属性
  Device,

  // 网络工具
  Network,
  Request,

  // 本地存储工具
  Storage,

  // 打印日志基础工具对象，可以控制开关，避免Log信息流出正式版
  Log,
}
