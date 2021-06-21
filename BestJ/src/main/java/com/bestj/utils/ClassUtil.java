package com.bestj.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/**
 * 类操作工具器
 */
public class ClassUtil {
    private static final Logger log = LoggerFactory.getLogger(ClassUtil.class);


    /**
     * 获取类加载器
     */
    public static ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    /**
     * 获取类
     */
    public static Class<?> loadClass(String className, Boolean initialize) {
        Class<?> cls = null;
        try {
            cls = Class.forName(className, initialize, getClassLoader());
        } catch (ClassNotFoundException e) {
            log.error("[X] can not load class", e);
            return null;
        }
        return cls;
    }


    /**
     * 从指定包路径加载类
     */
    public static Set<Class<?>> getClassFromPackage(String packageName) {
        // 获取类加载器
        ClassLoader classLoader = getClassLoader();

        // 获取资源
        URL url = classLoader.getResource(packageName.replace(".", "/"));
        if (url == null) {
            log.error("[X] can not load anything from package:", packageName);
            return null;
        }


        Set<Class<?>> setClass = null;

        if (url.getProtocol().equalsIgnoreCase("file")) {
            setClass = new HashSet<>();
            File fileDict = new File(url.getPath());
            addClass(setClass, fileDict, packageName);

        }
        return setClass;
    }

    private static void addClass(Set<Class<?>> setClass, File fileDict, String packageName) {
        if(fileDict.isDirectory() == false) return ;

        File[] files = fileDict.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                // 如果是目录 就继续递归
                if (pathname.isDirectory()) {
                    return true;
                }
                // 如果是文件的话 就判断是不是.class文件
                else {
                    // 如果是class文件 就加入
                    String absolutePath = pathname.getAbsolutePath();
                    if (absolutePath.endsWith(".class")) {
                        addClassSet();
                    }
                    return false;
                }
            }
        });

    }

    public static void main(String[] args) {
        getClassFromPackage("com.bestj.utils");
    }


}
