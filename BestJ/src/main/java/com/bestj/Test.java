package com.bestj;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

class Student<T> {
    private T name;
    public void setName(T name) {
        this.name = name;
    }

    public T getName() {
        return this.name;
    }
}


public class Test {
    public static <T> T getObject(T data) {
        System.out.println("泛型方法");
        return data;
    }
    public static void main(String[] args) {
//
//        Student<String> stu = new Student<>();
//        stu.setName("dutlzn");
//        System.out.println(stu.getName());
        File files = new File("D:\\BestJ\\BestJ\\src\\main\\java\\com\\bestj\\utils");
        File[] fileAccept = files.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.getPath().endsWith(".java")) {
                    return true;
                } else {
                    return false;
                }

            }
        });

        for(File file :fileAccept) {
            System.out.println(file);
        }
    }

}
