# AndroidUtil
Android工具类

## AppUtils


- installApp(String filePath, String authority)//安装App(支持7.0)
- installApp(File file, String authority)//安装App（支持7.0）
- installApp(Activity activity, String filePath, String authority, int requestCode)//安装App（支持6.0）
- installApp(Activity activity, File file, String authority, int requestCode)//安装App(支持6.0)
- installAppSilent(String filePath) //静默安装App(6.0后失效)
- uninstallApp(String packageName)//卸载App
- uninstallApp(Activity activity, String packageName, int requestCode)//卸载App
- uninstallAppSilent(String packageName, boolean isKeepData)//静默卸载App
- boolean isAppRoot()//判断App是否有root权限
- launchApp(String packageName)//打开App
- launchApp(Activity activity, String packageName, int requestCode)//打开App
- boolean isInstallApp(String packageName)//判断App是否安装
- String getAppVersionName()// 获取App版本号
- String getAppVersionName(String packageName)//获取App版本号
- int getAppVersionCode()//获取App版本码
- int getAppVersionCode(String packageName)//获取App版本码
- boolean isSystemApp()//判断App是否是系统应用
- boolean isSystemApp(String packageName)//判断App是否是系统应用
- 


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
  

