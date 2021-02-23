package com.myz.flume;

import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.interceptor.Interceptor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author mayunzhen
 * @version 1.0
 * @date 2021/2/1 14:15
 * @desc
 */
public class TypeInterceptor implements Interceptor {
    //声明一个存放事件的集合
    private List<Event> addHeaderEvents;
    @Override
    public void initialize() {
        //初始化
        addHeaderEvents = new ArrayList<>();
    }
    //单个事件拦截
    @Override
    public Event intercept(Event event) {
        //1获取事件中的头信息
        Map<String, String> headers = event.getHeaders();
        //2获取事件中的body信息
        String body = new String(event.getBody());
        //3根据body中是否有hello来决定添加怎样的头信息
        if(body.contains("hello")){
            //添加头信息
            headers.put("type","mayunzhen");
        }else {
            //添加头信息
            headers.put("type","bigdata");
        }
        return event;
    }
    //批量事件拦截
    @Override
    public List<Event> intercept(List<Event> events) {
        //1.清空集合
        addHeaderEvents.clear();
        //2.遍历每一个events
        for(Event event : events){
            addHeaderEvents.add(intercept(event));
        }
        //3返回结果
        return addHeaderEvents;
    }

    @Override
    public void close() {

    }
    public static class Builder implements Interceptor.Builder{

        @Override
        public Interceptor build() {
            return new TypeInterceptor();
        }

        @Override
        public void configure(Context context) {

        }
    }
}
