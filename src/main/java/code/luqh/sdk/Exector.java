package code.luqh.sdk;

public abstract class Exector implements Callback {

    void preTask() {}

    abstract Param param();

    abstract public void exec(Param param, Callback callback);

    @Override
    public void callback(Param cbParam) {}

    void lastTask(){}


}
