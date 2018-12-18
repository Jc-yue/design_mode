package proxys.A_proxy;

/**
 * 目标对象（演员）和代理对象（经纪公司）需要共同实现的接口：给相应的钱，进行表演
 */
public interface IActor {

    /**
     * 基本表演
     * @param money
     */
    void basicAct(float money);

    /**
     * 危险表演
     * @param money
     */
    void dangerAct(float money);
}
