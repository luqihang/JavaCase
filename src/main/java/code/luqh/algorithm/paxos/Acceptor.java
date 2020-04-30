package code.luqh.algorithm.paxos;

/**
 * @author luqh
 * @date 2018/10/25
 **/
public interface Acceptor {


    public void receivePrepare(String fromUid);

    public void receiveAcceptRequest();



}
