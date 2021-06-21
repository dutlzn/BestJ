package com.bestj.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/**
 * 类操作工具器
 */
public class ClassUtil {
    private static Logger log = LoggerFactory.getLogger(ClassUtil.class);

    /**
     * 获取类加载器
     */
    public static ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    /**
     * 加载类
     */
    public static Class<?> loadClass(String className, boolean isInitialized) {
        Class<?> cls;
        try {
            cls = Class.forName(className, isInitialized, getClassLoader());
        } catch (ClassNotFoundException e) {
            log.error("class load fail.", e);
            throw new RuntimeException(e);
        }
        return cls;
    }

    /**
     * 获取指定包名下的类
     */
    public static Set<Class<?>> getClassSet(String packageName) {
        // 1 获取类加载器
        ClassLoader classLoader = getClassLoader();
        // 2 通过类加载器来加载资源
        URL url = classLoader.getResource("com.bestj.utils".replace(".","/"));
        if (url == null) {
            log.error("[X]unable to retrieve anything from package");
            return null;
        }
        Set<Class<?>> classSet = null;
        if (url.getProtocol().equalsIgnoreCase("file")) {
            classSet = new HashSet<>();
            File fileDict = new File(url.getPath());
            addClass(classSet, fileDict, packageName);
        }
        return classSet;
    }

    private static void addClass(Set<Class<?>> classSet, File fileDict, String packageName) {
        if( fileDict.isDirectory() == false ) return ;


    }

    public static void main(String[] args) {


    }


}
