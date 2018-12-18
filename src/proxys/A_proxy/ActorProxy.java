package proxys.A_proxy;

/**
 * 代理类（经纪公司）：对原有方法（service实现层）的功能增强
 */
public class ActorProxy implements IActor {

    private Actor actor;

    public ActorProxy(Actor actor) {
        this.actor = actor;
    }

    @Override
    public void basicAct(float money) {
        //经纪公司需要抽取20%的费用，演员实际获得80%费用
        actor.basicAct(money*0.8f);
    }

    @Override
    public void dangerAct(float money) {
        //经纪公司需要抽取10%的费用，演员实际获得90%费用
        actor.dangerAct(money*0.9f);
    }
}
