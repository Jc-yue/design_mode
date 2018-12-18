package proxys.B_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 模拟一个剧组
 */
public class Test {

    public static void main(String[] args) {
        //剧组找演员
        final Actor actor = new Actor();

        /**
         * 参数含义：
         *      ClassLoader loader: 目标对象类加载器（固定写法）
         *      Class<?>[] interfaces: 目标对象实现的接口类型（固定写法）
         *      InvocationHandler h: 事件处理，如何代理
         *
         */
        IActor iActorProxy = (IActor) Proxy.newProxyInstance(actor.getClass().getClassLoader(),
                actor.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 执行目标对象的任何方法都会任何方法，都会经过invoke方法，该方法具有拦截的功能
                     * @param proxy 代理对象的方法，不一定每次都用的到
                     * @param method 当前执行的方法对象
                     * @param args  执行方法所需的参数
                     * @return  当前执行方法的返回值
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        String name = method.getName();
                        float money = (float) args[0];
                        Object rtValue = null;
                        if ("basicAct".equals(name)) {
                            rtValue = method.invoke(actor, money*0.8f);
                        }if ("dangerAct".equals(name)) {
                            rtValue = method.invoke(actor, money*0.9f);
                        }
                        return rtValue;
                    }
                });

        System.out.println("-----------------proxy动态代理模拟测试-------------------");

        //剧组自己找演员
        System.out.println("剧组自己找演员，演员获得100%的报酬...");
        actor.basicAct(5000f);
        actor.dangerAct(10000f);

        System.out.println();

        //剧组通过经纪公司（代理对象）找演员
        System.out.println("剧组通过经纪公司找演员，基本表演的报酬是80%，危险表演的报酬是90%...");
        iActorProxy.basicAct(5000f);
        iActorProxy.dangerAct(10000f);
    }
}
