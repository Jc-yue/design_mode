package proxys.A_proxy;

/**
 * 目标类（目标对象）
 */
public class Actor implements IActor{

    @Override
    public void basicAct(float money) {
        System.out.println("拿到钱，进行基本表演：" + money);
    }

    @Override
    public void dangerAct(float money) {
        System.out.println("拿到钱，进行危险表演：" + money);
    }
}
