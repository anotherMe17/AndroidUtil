package io.github.anotherme17.android_util;

import android.content.Context;

import io.github.anotherme17.android_util.sp.SPUtils;

/**
 * @author AnotherMe17
 */
public class Utils {

    private static Context context;
    private static SPUtils spUtils;

    private Utils() {
        throw new UnsupportedOperationException("you can't instantiate me...");
    }

    /**
     * 初始化工具类
     *
     * @param context 上下文
     */
    public static void init(Context context) {
        init(context,"default_sp");
    }

    /**
     * 初始化工具类
     *
     * @param context 上下文
     * @param SPName  SP 的名称
     */
    public static void init(Context context, String SPName) {
        Utils.context = context.getApplicationContext();
        spUtils = new SPUtils(SPName);
    }

    /**
     * 获取ApplicationContext
     *
     * @return ApplicationContext
     */
    public static Context getContext() {
        if (context != null) return context;
        throw new NullPointerException("u should init first");
    }

    public static SPUtils getSpUtils() {
        return spUtils;
    }
}
