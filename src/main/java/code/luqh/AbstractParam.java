package code.luqh;

import java.io.File;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * @author luqh
 * @date 2019/10/14
 **/

public abstract class AbstractParam<T extends AbstractParam> {

    private HashMap<String, Object> dataSource = new HashMap<>();

    static {
        System.out.println(Thread.currentThread().getStackTrace()[1].getClassName());

        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            System.out.println(stackTraceElement.getClassName());
        }
    }

    public T param(String k, Object v) {
        dataSource.put(k, v);
        return (T) this;
    }

    public <V> V param(String k) {
        return (V) dataSource.get(k);
    }


    public Map<String, Object> toMap() {
        return dataSource;
    }
}
