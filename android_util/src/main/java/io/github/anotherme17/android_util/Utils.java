package io.github.anotherme17.android_util;

import android.content.Context;

/**
 * @author AnotherMe17
 */
public final class Utils {

    private static Context sContext;

    private Utils() {
        throw new UnsupportedOperationException("you can't instantiate me...");
    }


    /**
     * 初始化工具类
     *
     * @param context 上下文
     */
    public static void init(Context context) {
        Utils.sContext = context.getApplicationContext();
    }

    /**
     * 获取ApplicationContext
     *
     * @return ApplicationContext
     */
    public static Context getContext() {
        if (sContext != null) return sContext;
        throw new NullPointerException("u should init first");
    }
}
