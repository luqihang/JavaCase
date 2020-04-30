package code.luqh.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author luqh
 * @date 2019/10/22
 **/
public class SDK {

    interface Callback {
        void callback(Param cbParam);
    }

    interface Exec {
        void exec(Param param, Callback callback);
    }

    static class Param {

    }


    abstract static class LoginExector implements Exec, Callback {

        void preTask() {

        }

        abstract Param param();

        @Override
        public void exec(Param param, Callback callback) {

        }

        @Override
        public void callback(Param cbParam) {

        }

        void lastTask() {

        }
    }

    public void call(LoginExector exector) {
        exector.preTask();
        exector.exec(exector.param(), exector);
        exector.lastTask();
    }


    Map<Class, LoginExector> holder = new HashMap<>();

    public void listen(Class<LoginExector> clazz, Exec exec) {

        LoginExector exector = holder.get(clazz);
        if (exector != null) {
        }
    }

    public static void main(String[] args) {
        Param param = new Param();
        SDK sdk = new SDK();
        sdk.call(new LoginExector() {

            @Override
            Param param() {
                return param;
            }

            @Override
            public void callback(Param cbParam) {

            }
        });

        sdk.listen(LoginExector.class, new Exec() {
            @Override
            public void exec(Param param, Callback callback) {

            }
        });
    }
}
