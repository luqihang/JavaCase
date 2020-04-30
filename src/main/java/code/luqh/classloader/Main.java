package code.luqh.classloader;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author luqh
 * @date 2019/11/01
 **/
public class Main {

    public static void main(String[] args) throws MalformedURLException {

        String classDataRootPath = "E:\\classloadTest";
        FileSystemClassLoader fscl1 = new FileSystemClassLoader(classDataRootPath);
//        FileSystemClassLoader fscl2 = new FileSystemClassLoader(classDataRootPath);
        String className = "com.adobe.xmp.properties.XMPProperty";
        String className2 = "code.Test";

        URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{new URL("file", null,"E:\\classloadTest" + File.separator)});


        System.out.println(fscl1);
//        System.out.println(fscl2);
        try {
            Class<?> aClass = urlClassLoader.loadClass(className2);
            System.out.println(aClass);
            System.out.println(aClass.getClassLoader());

//            Class<?> class1 = fscl1.loadClass(className);
////            Object obj1 = class1.newInstance();
//            System.out.println(class1.getClassLoader());
//
//            Class<?> class2 = fscl2.loadClass(className);
//
////            Object obj2 = class2.newInstance();
//            System.out.println(class2.getClassLoader());
//
//            System.out.println(class1.getClassLoader().equals(class2.getClassLoader()));
//
//
//            System.out.println("实例化");
//            Method test = class1.getMethod("test");
//            test.invoke(class1.newInstance());

        } catch (Exception e) {
            e.printStackTrace();
        }


//        try {
//            Class<?> aClass = Class.forName("sample.Test", true, fscl1);
//
//            System.out.println(aClass);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }


    }
}
