package proxys.C_proxy;

/**
 * 模拟一个演员
 */
public class Actor {

    public void basicAct(float money) {
        System.out.println("拿到钱，开始基本表演：" + money);
    }

    public void dangerAct(float money) {
        System.out.println("拿到钱，开始危险表演：" + money);
    }
}
