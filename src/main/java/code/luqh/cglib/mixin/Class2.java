package code.luqh.cglib.mixin;

/**
 * @author luqh
 * @date 2019/10/29
 **/
public class Class2 implements Interface2 {

    private String className = "Class2";

    @Override
    public String second() {
        return "second behaviour: " + this.className;
    }

}
