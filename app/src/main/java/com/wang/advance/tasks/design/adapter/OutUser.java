package com.wang.advance.tasks.design.adapter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by romantiskt on 2018/10/26.
 */

public class OutUser implements IOuterUser {
    @Override
    public Map getUserBaseUserInfo() {
        HashMap map=new HashMap();
        map.put("name","张三");
        map.put("age","23");
        return map;
    }

    @Override
    public Map getUserHomeInfo() {
        HashMap map=new HashMap();
        map.put("address","shenzhen");
        return map;
    }

    @Override
    public Map getUserOfficalInfo() {
        HashMap map=new HashMap();
        map.put("job","develop");
        return map;
    }
}
