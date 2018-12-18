package proxys.A_proxy;

/**
 * 剧组找演员
 */
public class Test {

    public static void main(String[] args) {

        System.out.println("-----------------静态代理模拟测试-------------------");

        //剧组自己找演员
        System.out.println("剧组自己找演员，演员获得100%的报酬...");
        Actor actor = new Actor();
        actor.basicAct(5000f);
        actor.dangerAct(10000f);

        System.out.println();

        //剧组通过经纪公司（代理对象）找演员
        System.out.println("剧组通过经纪公司找演员，基本表演的报酬是80%，危险表演的报酬是90%...");
        ActorProxy proxy = new ActorProxy(actor);
        proxy.basicAct(5000f);
        proxy.dangerAct(10000f);
    }
}
