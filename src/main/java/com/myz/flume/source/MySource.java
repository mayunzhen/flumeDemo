package com.myz.flume.source;

import org.apache.flume.Context;
import org.apache.flume.EventDeliveryException;
import org.apache.flume.PollableSource;
import org.apache.flume.conf.Configurable;
import org.apache.flume.event.SimpleEvent;
import org.apache.flume.source.AbstractSource;

/**
 * @author mayunzhen
 * @version 1.0
 * @date 2021/2/1 14:07
 * @desc
 */
public class MySource extends AbstractSource implements Configurable, PollableSource {
    //定义全局前缀和后缀
    private static String prefix ;
    private static String subfix ;

    @Override
    public void configure(Context context) {
        //读取配置信息，给前后缀赋值
       prefix = context.getString("prefix","");
       subfix = context.getString("subfix","mayunzhen");
    }

    /**
     * 1接受数据（for循环 造数据）
     * 2封装成Event
     *3将Event传给Channel
     * @return
     * @throws EventDeliveryException
     */
    @Override
    public Status process() throws EventDeliveryException {
        Status status = null;
        try {
            //1接收数据
            for (int i = 0; i < 5; i++) {
                //2.构建Event对象
                SimpleEvent event = new SimpleEvent();
                //3.给Event设置值
                event.setBody((prefix + "--" + i + "--" + subfix).getBytes());
                //4.将Event传给Channel
                getChannelProcessor().processEvent(event);
            }
            status = Status.READY;
        }catch (Exception e){
            e.printStackTrace();
            status = Status.BACKOFF;
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public long getBackOffSleepIncrement() {
        return 0;
    }

    @Override
    public long getMaxBackOffSleepInterval() {
        return 0;
    }
}
