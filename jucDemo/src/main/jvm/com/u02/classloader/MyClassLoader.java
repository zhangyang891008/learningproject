package com.u02.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;


/*
    自定义了一个classloader，加载指定目录下的类，删除target目录中的Person.class文件，然后让其到指定目录下加载

 */
public class MyClassLoader extends ClassLoader {

    private static String LOAD_PATH = "/Users/zy/classLoadPath/";

    private static ClassLoader parent;

    private static Map<String, Class<?>> classMap = new HashMap<>();

    public MyClassLoader(ClassLoader parent){
        this.parent = parent;
    }

    @Override
    protected Class<?> loadClass(String name, boolean parentStrategy) throws ClassNotFoundException {
        //1.check if the class is alreay loaded!
        Class<?> myClass = classMap.get(name);

        //2.if the class is not loaded visit parent classloader
        try{
            if(myClass == null){
                myClass = parent.loadClass(name);
            }
        } catch (Exception e){
            //e.printStackTrace();
        }


        //3.if parent classloader cannot load the class, load it by myself
        if(myClass == null){
            myClass = this.findClass(name);
            classMap.put(name,myClass);
        }

        return myClass;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String replaceName = name.replace('.','/') + ".class";
        File classFile = new File(LOAD_PATH+replaceName);
        FileInputStream in = null;
        ByteArrayOutputStream out = null;
        Class<?> aClass = null;
        if(classFile.exists()){
            try {
                in = new FileInputStream(classFile);
                out = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int size = 0;
                while((size = in.read(buffer))!=-1){
                    out.write(buffer,0,size);
                }
                byte[] bytes = out.toByteArray();
                aClass = defineClass(name, bytes, 0, bytes.length);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if(aClass != null)
            return aClass;
        return null;
    }
}
