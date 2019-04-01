package com.pkgs.api.util;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * TODO:
 *
 * <p>
 *
 * @author cs12110 create at 2019-03-30 13:36
 * <p>
 * @since 1.0.0
 */
public class ClassLoaderUtil {

    /**
     * url array for classloader init
     */
    private static URL[] initUrlArray = {};
    private static MyUrlClassLoader loader = new MyUrlClassLoader(initUrlArray);


    /**
     * 加载jar包
     *
     * @param jarPath jar path
     */
    public static void addJar(String jarPath) {
        loader.add(jarPath);
    }

    /**
     * load class as you need
     *
     * @param className className, such as: com.pkgs.mod1.Mod1ServiceImpl
     * @return Object
     */
    public static Object load(String className) {
        try {
            Class<?> targetClass = loader.loadClass(className);
            return targetClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException("We can't load class for u: " + className);
    }

    /**
     * 自定义class loader
     */
    static class MyUrlClassLoader extends URLClassLoader {

        MyUrlClassLoader(URL[] urls) {
            super(urls);
        }

        /**
         * 加载jar
         *
         * @param jarFilePath jar包位置
         */
        void add(String jarFilePath) {
            File file = new File(jarFilePath);
            if (!file.exists()) {
                throw new IllegalArgumentException("The path of jar never exists");
            }

            try {
                super.addURL(file.toURI().toURL());
                System.out.println("Add:" + jarFilePath + " into loader");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
