package code.luqh.cglib.mixin;

import net.sf.cglib.proxy.Mixin;

/**
 * @author luqh
 * @date 2019/10/29
 **/
public class Main {
    public static void main(String[] args) {
        Mixin mixin = Mixin.create(
            new Class[]{Interface1.class, Interface2.class, MixinInterface.class},
            new Object[]{new Class1(), new Class2()}
        );
        MixinInterface mixinDelegate = (MixinInterface) mixin;

        System.out.println(mixinDelegate.first());

        System.out.println(mixinDelegate.second());


    }
}
