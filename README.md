# AndroidUtil
Android工具类

## AppUtils

```
/**
     * 安装App(支持7.0)
     *
     * @param filePath  文件路径
     * @param authority 7.0及以上安装需要传入清单文件中的{@code <provider>}的authorities属性
     *                  <br>参看https://developer.android.com/reference/android/support/v4/content/FileProvider.html
     */
    public static void installApp(String filePath, String authority)
```

```
/**
     * 安装App（支持7.0）
     *
     * @param file      文件
     * @param authority 7.0及以上安装需要传入清单文件中的{@code <provider>}的authorities属性
     *                  <br>参看https://developer.android.com/reference/android/support/v4/content/FileProvider.html
     */
    public static void installApp(File file, String authority)
```

```
/**
     * 安装App（支持6.0）
     *
     * @param activity    activity
     * @param filePath    文件路径
     * @param authority   7.0及以上安装需要传入清单文件中的{@code <provider>}的authorities属性
     *                    <br>参看https://developer.android.com/reference/android/support/v4/content/FileProvider.html
     * @param requestCode 请求值
     */
    public static void installApp(Activity activity, String filePath, String authority, int requestCode) 
```

```
/**
     * 安装App(支持6.0)
     *
     * @param activity    activity
     * @param file        文件
     * @param authority   7.0及以上安装需要传入清单文件中的{@code <provider>}的authorities属性
     *                    <br>参看https://developer.android.com/reference/android/support/v4/content/FileProvider.html
     * @param requestCode 请求值
     */
    public static void installApp(Activity activity, File file, String authority, int requestCode)
```

```
/**
     * 静默安装App
     * <p>非root需添加权限 {@code <uses-permission android:name="android.permission.INSTALL_PACKAGES" />}</p>
     *
     * @param filePath 文件路径
     * @return {@code true}: 安装成功<br>{@code false}: 安装失败
     */
    public static boolean installAppSilent(String filePath) 
```

```
/**
     * 卸载App
     *
     * @param packageName 包名
     */
    public static void uninstallApp(String packageName) 
```

```
/**
     * 卸载App
     *
     * @param activity    activity
     * @param packageName 包名
     * @param requestCode 请求值
     */
    public static void uninstallApp(Activity activity, String packageName, int requestCode)
```

```
/**
     * 静默卸载App
     * <p>非root需添加权限 {@code <uses-permission android:name="android.permission.DELETE_PACKAGES" />}</p>
     *
     * @param packageName 包名
     * @param isKeepData  是否保留数据
     * @return {@code true}: 卸载成功<br>{@code false}: 卸载失败
     */
    public static boolean uninstallAppSilent(String packageName, boolean isKeepData)
```

```
 /**
     * 判断App是否有root权限
     *
     * @return {@code true}: 是<br>{@code false}: 否
     */
    public static boolean isAppRoot()
```

```
 /**
     * 打开App
     *
     * @param packageName 包名
     */
    public static void launchApp(String packageName)
```

```
/**
     * 打开App
     *
     * @param activity    activity
     * @param packageName 包名
     * @param requestCode 请求值
     */
    public static void launchApp(Activity activity, String packageName, int requestCode)
```

```
/**
     * 判断App是否安装
     *
     * @param packageName 包名
     * @return {@code true}: 已安装<br>{@code false}: 未安装
     */
    public static boolean isInstallApp(String packageName)
```

```
/**
     * 获取App版本号
     *
     * @return App版本号
     */
    public static String getAppVersionName()
```

```
/**
     * 获取App版本号
     *
     * @param packageName 包名
     * @return App版本号
     */
    public static String getAppVersionName(String packageName)
```

```
/**
     * 获取App版本码
     *
     * @return App版本码
     */
    public static int getAppVersionCode()
```

```
/**
     * 获取App版本码
     *
     * @param packageName 包名
     * @return App版本码
     */
    public static int getAppVersionCode(String packageName)
```

```
/**
     * 判断App是否是系统应用
     *
     * @return {@code true}: 是<br>{@code false}: 否
     */
    public static boolean isSystemApp()
```

```
/**
     * 判断App是否是系统应用
     *
     * @param packageName 包名
     * @return {@code true}: 是<br>{@code false}: 否
     */
    public static boolean isSystemApp(String packageName)
```

## Utils

```java
/**
     * 初始化工具类
     *
     * @param context 上下文
     */
    public static void init(Context context)
```

```java
/**
     * 获取ApplicationContext
     *
     * @return ApplicationContext
     */
    public static Context getContext()
```  
  

