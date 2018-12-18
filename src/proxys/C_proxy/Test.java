package proxys.C_proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Test {

    public static void main(String[] args) {

        final Actor actor = new Actor();
        /**
         *
         */
        Actor actorCjlib = (Actor)Enhancer.create(actor.getClass(),
                new MethodInterceptor() {
                    /**
                     *
                     * @param o
                     * @param method
                     * @param objects
                     * @param methodProxy
                     * @return
                     * @throws Throwable
                     */
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        float money = (float) objects[0];
                        Object rtValue = method.invoke(actor, money * 0.8f);
                        System.out.println("表演结束，获得额外的报酬1000元...");
                        return rtValue;
                    }
                });

        System.out.println("-----------------cjlib动态代理模拟测试-------------------");

        //剧组自己找演员
        System.out.println("剧组自己找演员，演员获得100%的报酬...");
        actor.basicAct(5000f);
        actor.dangerAct(10000f);

        System.out.println();

        //剧组通过经纪公司（代理对象）找演员
        System.out.println("剧组通过经纪公司找演员，演员获得80%的报酬...");
        actorCjlib.basicAct(5000f);
        actorCjlib.dangerAct(10000f);
    }
}
