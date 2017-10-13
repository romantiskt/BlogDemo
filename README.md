# Advance
   这是一个简陋的demo，会用来练习一些自定义View,或者一些新功能，架构上的尝试，仅仅作为一个练习作品，所以项目很多地方会有不完善的情况，
   上传到github,只是为了同步代码方便，如果恰巧能给一些新同学以启发，那便是莫大的荣幸了，还望诸君不吝赐教。

       
RxJava操作符的练习

*  __Observable__    不支持背压的Observable
*  __Flowable__      支持背压的Observable
*  __Obsever__       与Observable一起使用
*  __Subscriber__    与Flowable一起使用   
*  __just__          将单个数据或多个数据源转为一个observable
*  __map__           对序列中的observable通过一个指定自定义函数转化为一个新类型的Observable
*  __zip__           将多个Observable组装成一个Observable发送
*  __disposable__    将多个Observable管理在一起，防止泄露
*  __defer__         在观察者订阅之前不创建这个Observable(赋值都会在订阅后进行)，为每一个观察者创建一个新的Observable
*  __take__         只发射前面的x项数据 此外还有takelast  takefitst
*  __timer__        延迟发射数据
*  __interval__     定时发射，类似秒表
*  __single__       发射单一事件的Observable
*  __completable__  忽略onNext事件的订阅，只关注成功和失败
*  __reduce__       算法工具，对一个序列通过指定函数两两运算
*  __buffer__       缓存的概念，从一个数据源拿出几项打包发射
*  __skip__         跳过前面的x项数据
*  __scan__         类似于reduce,不同在于这里会输入一个序列经过函数处理后发射一个序列
*  __Subject__      四种类似的Subject的功能不同点
   * PublishSubject   从哪里订阅，就从哪里开始发射数据
   * ReplaySubject    无论怎样，都会发射全部数据
   * AsyncSubject     只会发送最后一个,而且需要调用 onComplete()才会发射
   * ehaviorSubject  会从订阅的最近的上一个开始发射数据
*  __ConnectableObservable__    ConnectableObservable 和connect联合使用  connect会触发ConnectableObservable发射数据
*  __connect__       并且只会发射 connect()之后的数据；
*  __replay__       为缓存多少个事件 即使事件已经发射完  也还是可以通过订阅接收到事件
*  __concat__       有序的组合多个observable
*  __concatMap__    有序的将一个序列逐个展开，在其中可进行数据源类型的变换操作
*  __flatMap__      无序的将一个序列逐个展开，在其中可进行数据源类型的变换操作
*  __merge__        将多个Observable合并为一个Observable，即将多个事件源转为一个Observable发射
*  __distinct__     会过滤掉重复的数据源
*  __last__         只会发射最后一个数据源，带参数则是提供默认值
*  __Throttle__     在每次事件触发后的一定时间间隔内丢弃新的事件
*  __switchMap__    当源Observable发射一个数据项 onNext(x1)时，这个时候还没被订阅接收，重新onNext(X2)时，x1就会被抛弃掉(例如搜索框的实现，输入文字改变联网获取数据)
*  __debounce__     当源Observable在一段时间间隔内不再有新的数据被发射时，才会真实发射数据，如果有新的数据发射，则这个时间间隔会被重置
*  __window__       和buffer的不同之处在于，它处理过后发射的是observable,(如果碰到源Observable多线程情况下，window(x),会有失误的情况，如x=3,可能会发送2项或3项)
*  __delay__        延迟发射Observable的结果

    参考：[操作符说明](https://www.zhihu.com/question/32209660?sort=created)另外一个比较全面的Rxjava操作符说明