package proxys.B_proxy;

/**
 * 模拟一个演员（service实现层）
 */
public class Actor implements IActor{

    @Override
    public void basicAct(float money) {
        System.out.println("拿到钱，开始基本表演：" + money);
    }

    @Override
    public void dangerAct(float money) {
        System.out.println("拿到钱，开始危险表演：" + money);
    }
}
