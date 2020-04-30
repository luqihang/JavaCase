package code.luqh;

public interface ParamBuilder {

    static void build() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getClassName());
    }
}
