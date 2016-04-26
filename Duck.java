package behavior.strategyPattern;

/**
 * 鸭子类的超类
 */
public abstract class Duck {
    //为行为接口类型声明两个变量，所有鸭子类都继承他们
    protected FlyBehavior flyBehavior;
    protected QuackBehavior quackBehavior;
    //展示外观的方法，所有的鸭子都有的行为，声明在超类中
    public abstract void display();

    /**
     * 把具体的行为交给委托给行为类
     */
    public void performFly(){
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void swim() {
        System.out.println("all ducks can float,even decoys");
    }

    public FlyBehavior getFlyBehavior() {
        return flyBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public QuackBehavior getQuackBehavior() {
        return quackBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
