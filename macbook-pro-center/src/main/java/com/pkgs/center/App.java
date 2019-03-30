package com.pkgs.center;

import com.pkgs.api.service.ApiService;
import com.pkgs.api.util.ClassLoaderUtil;

/**
 * TODO:
 *
 * <p>
 *
 * @author cs12110 create at 2019-03-30 13:46
 * <p>
 * @since 1.0.0
 */
public class App {

    public static void main(String[] args) {
        loadMod1();
        loadMod2();
    }

    /**
     * 加载模块1
     */
    private static void loadMod1() {

        // 模块1jar所在位置
        String mod1 = "/opt/projects/java/macbook-pro/macbook-pro-mod1/target/macbook-pro-mod1-1.0-SNAPSHOT.jar";
        String mod1ServiceImpl = "com.pkgs.mod1.Mod1ApiServiceImpl";

        // 实例化
        ApiService<Object, Object> service1 = load(mod1, mod1ServiceImpl);
        Object value = service1.dealWith("12313");
        System.out.println(value);
    }

    /**
     * 加载模块2
     */
    private static void loadMod2() {

        // 模块jar所在位置
        String mod2 = "/opt/projects/java/macbook-pro/macbook-pro-mod2/target/macbook-pro-mod2-1.0-SNAPSHOT.jar";
        String mod2ServiceImpl = "com.pkgs.mod2.Mod2ApiServiceImpl";

        // 实例化
        ApiService<Object, Object> service2 = load(mod2, mod2ServiceImpl);
        Object value = service2.dealWith("I'm your dad");
        System.out.println(value);
    }


    @SuppressWarnings("unchecked")
    private static <T, P> ApiService<T, P> load(String path, String serviceImplClassName) {
        // 类加载必须由MyClassLoader完成
        ClassLoaderUtil.addJar(path);
        Object reload = ClassLoaderUtil.load(serviceImplClassName);
        return (ApiService) reload;

    }
}
