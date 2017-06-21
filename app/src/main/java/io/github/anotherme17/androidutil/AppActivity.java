package io.github.anotherme17.androidutil;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;

import com.orhanobut.logger.Logger;

import butterknife.Bind;
import butterknife.OnClick;
import io.github.anotherme17.android_util.AppUtils;
import io.github.anotherme17.android_util.FileIOUtils;
import io.github.anotherme17.android_util.SDCardUtils;

/**
 * Created by Administrator on 2017/6/21.
 */

public class AppActivity extends BaseActivity {

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};

    @Bind(R.id.copy_app)
    Button mCopyApp;
    @Bind(R.id.del_app)
    Button mDelApp;
    @Bind(R.id.install_app)
    Button mInstallApp;

    @Override
    public int getLayoutId() {
        return R.layout.activity_app;
    }

    @Override
    public void init() {
        verifyStoragePermissions(AppActivity.this);
    }

    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE);
        }
    }

    @OnClick({R.id.copy_app, R.id.del_app, R.id.install_app})
    public void onViewClicked(View view) {
        String copyFile = SDCardUtils.getSDCardPath() + "test.apk";
        switch (view.getId()) {
            case R.id.copy_app:
                if (!SDCardUtils.isSDCardEnable()) {
                    Logger.d("AppActivity", "SD卡不可用");
                    return;
                }

                Logger.d("AppActivity", "SD卡剩余大小 " + SDCardUtils.getFreeSpace());

                Logger.d("AppActivity", "拷贝文件至 " + copyFile);

                FileIOUtils.writeFileFromAssets("HighNetTv_1.0.apk", copyFile);
                break;
            case R.id.del_app:
                break;
            case R.id.install_app:
                AppUtils.installAppSilent(copyFile);
                break;
        }
    }
}
