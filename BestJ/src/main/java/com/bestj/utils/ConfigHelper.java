package com.bestj.utils;

import java.util.Properties;

/**
 * 属性文件助手类
 */
public final class ConfigHelper {
    private static final Properties CONFIG_PROPS = PropsUtil.loadProps(ConfigConstant.CONFIG_FILE);

    /**
     * 获取JDBC驱动
     */
    public static String getJdbcDriver() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_DRIVER);
    }


    /**
     * 获取JDBC url
     */
    public static String  getJdbcUrl() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_URL);
    }

    /**
     * 获取JDBC username
     */
    public static String getJdbcUsername() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_USERNAME);
    }

    /**
     * 获取JDBC password
     */
    public static String getJdbcPassword() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_PASSWORD);
    }

    /**
     * 获取基础包
     */
    public static String getBasePackage() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_BASE_PACKAGE);
    }

    /**
     * 获取JSP 路径
     */
    public static String getJspPath() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_JSP_PATH, "/WEB-INF/jsp/");
    }

    /**
     * 获取静态资源路径
     */
    public static String getAssetPath() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_ASSET_PATH, "/asset/");
    }


    public static void main(String[] args) {
        System.out.println(getJdbcDriver());
        System.out.println(getJdbcUrl());
        System.out.println(getJdbcUsername());
        System.out.println(getJdbcPassword());
        System.out.println(getBasePackage());
        System.out.println(getJspPath());
        System.out.println(getAssetPath());
    }
}
