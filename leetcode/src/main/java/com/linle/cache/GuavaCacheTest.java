package com.linle.cache;


import com.google.common.cache.*;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author chendeli
 * @Description:
 * @date 2023/8/11 13:24
 */
public class GuavaCacheTest {
    //模拟数据源
    static final class Constants{

        public static Map<String,String> hm = new HashMap<>();

        static {
            hm.put("1","张飞");
            hm.put("2","关羽");
            hm.put("3","赵云");
            hm.put("4","刘备");
            hm.put("5","黄忠");
        }
    }


        public static void main(String args[]) throws Exception {
            LoadingCache<String,Object> cache = CacheBuilder.newBuilder()
                    // 最大3个 //Cache中存储的对象,写入3秒后过期
                    .maximumSize(3).expireAfterWrite(3,
                    //记录命中率 ////失效通知
                            TimeUnit.SECONDS).recordStats().removalListener(new
                            RemovalListener<Object, Object>() {
                                @Override
                                public void onRemoval(RemovalNotification<Object, Object>
                                                              notification){
                                    System.out.println(notification.getKey()+":"+notification.getCause());
                                }
                            })
                            .build(
                                    new CacheLoader<String, Object>() {
                                        @Override
                                        public String load(String s) throws Exception {
                                            return Constants.hm.get(s);
                                        }
                                    }
                            );
            /*
            初始化cache
            */
            initCache(cache);
            System.out.println(cache.size());
            displayCache(cache);
            System.out.println("=============================");
            Thread.sleep(1000);
            System.out.println(cache.getIfPresent("1"));
            Thread.sleep(2500);
            //CacheLoader在创建cache对象时，采用CacheLoader来获取数据，当缓存不存在时能够自动加载数据到缓存中。
            System.out.println("=============================");
            displayCache(cache);
        }


    public static Object get(String key,LoadingCache cache)throws Exception{
        Object value=cache.get(key, new Callable() {
            @Override
            public Object call() throws Exception {
                Object v= Constants.hm.get(key);
                //  设置回缓存
                cache.put(key,v);
                return v;
            }
        });
        return value;
    }
    public static void initCache(LoadingCache cache)throws Exception{
/*
前三条记录
*/
        for(int i=1;i<=3;i++){
            cache.get(String.valueOf(i));
        }
    }
    /**
     * 获得当前缓存的记录
     * @param cache
     * @throws Exception
     */
    public static void displayCache(LoadingCache cache)throws Exception{
        Iterator its=cache.asMap().entrySet().iterator();
        while(its.hasNext()){
            System.out.println(its.next().toString());
        }
    }
}
