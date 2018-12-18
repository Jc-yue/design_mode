package proxys.B_proxy;

/**
 *
 *演员抽象接口（service层）：给相应的钱，进行表演
 *
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
