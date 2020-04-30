package code.luqh.javassist.generator;

import javassist.*;
import javassist.bytecode.AnnotationsAttribute;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author luqh
 * @date 2019/10/30
 **/
public class Main {

    public static void main(String[] args) throws CannotCompileException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NotFoundException {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("code.luqh.javassist.generator.PersonService");

        CtMethod personFly = cc.getDeclaredMethod("personFly");
        personFly.insertBefore("System.out.println(\"起飞之前准备降落伞\");");
        personFly.insertAfter("System.out.println(\"成功落地。。。。\");");


        CtMethod newFly = CtNewMethod.copy(personFly, "g", cc, null);
        cc.addMethod(newFly);
        //新增一个方法
        CtMethod ctMethod = new CtMethod(CtClass.voidType, "joinFriend", new CtClass[]{}, cc);
        ctMethod.setModifiers(Modifier.PUBLIC);
        ctMethod.setBody("{System.out.println(\"i want to be your friend\");}");
        cc.addMethod(ctMethod);

        Object person = cc.toClass().newInstance();
        // 调用 personFly 方法
        Method personFlyMethod = person.getClass().getMethod("personFly");
        personFlyMethod.invoke(person);
        //调用 joinFriend 方法
        Method execute = person.getClass().getMethod("joinFriend");
        execute.invoke(person);

        Method g = person.getClass().getMethod("g");
        g.invoke(person);
    }
}
