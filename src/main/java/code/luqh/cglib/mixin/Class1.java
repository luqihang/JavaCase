package code.luqh.cglib.mixin;

/**
 * @author luqh
 * @date 2019/10/29
 **/
public class Class1 implements Interface1, Interface2 {

    private String className = "Class1";

    @Override
    public String first() {
        return "first behaviour: " + this.className;
    }

    @Override
    public String second() {
        return "class 1 first behaviour: " + this.className;
    }
}
