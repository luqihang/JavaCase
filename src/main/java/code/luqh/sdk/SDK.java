package code.luqh.sdk;

import com.google.common.collect.ConcurrentHashMultiset;

import java.util.List;

/**
 * @author luqh
 * @date 2019/10/22
 **/
public class SDK {

    static void call(Exector exector) {
        exector.preTask();
        exector.exec(exector.param(), exector);
        exector.lastTask();
    }

    static void listen(Exector exec) {

    }
}
