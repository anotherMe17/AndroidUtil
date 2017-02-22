package io.github.anotherme17.androidutil;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.OnClick;
import io.github.anotherme17.android_util.Utils;
import io.github.anotherme17.android_util.sp.SPUtils;
import io.github.anotherme17.androidutil.adapter.SPAdapter;

/**
 * @author AnotherMe17
 */
public class SPUtilsActivity extends BaseActivity {

    public static final String TAG = "SPUtilsActivity";

    @Bind(R.id.sp_add_string)
    TextView mSpAddString;
    @Bind(R.id.sp_string_key)
    EditText mSpStringKey;
    @Bind(R.id.sp_string_value)
    EditText mSpStringValue;
    @Bind(R.id.sp_add_boolean)
    TextView mSpAddBoolean;
    @Bind(R.id.sp_boolean_key)
    EditText mSpBooleanKey;
    @Bind(R.id.sp_boolean_value)
    Spinner mSpBooleanValue;
    @Bind(R.id.sp_add_int)
    TextView mSpAddInt;
    @Bind(R.id.sp_int_key)
    EditText mSpIntKey;
    @Bind(R.id.sp_int_value)
    EditText mSpIntValue;
    @Bind(R.id.sp_show)
    ListView mSpShow;

    private List<String> mData;
    private SPUtils mSPUtils;

    private SPAdapter mAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_sputils;
    }

    @Override
    public void init() {
        mSPUtils = Utils.getSpUtils();
        mData = getAllSP();
        mAdapter = new SPAdapter(this, mData);
        mSpShow.setAdapter(mAdapter);

        setListViewHeightBasedOnChildren(mSpShow);

        mSpShow.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
               /* String key = mData.get(position);
                Logger.v(TAG, "remove key = " + key);
                mSPUtils.remove(key);
                updateSP();*/
                return false;
            }
        });
    }

    @OnClick({R.id.sp_add_string, R.id.sp_add_boolean, R.id.sp_add_int, R.id.clear})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sp_add_string:
                addString();
                break;
            case R.id.sp_add_boolean:
                addBoolean();
                break;
            case R.id.sp_add_int:
                addInt();
                break;
            case R.id.clear:
                clearSP();
                break;
        }
    }

    private void addBoolean() {
        String key = mSpBooleanKey.getText().toString();
        String value = mSpBooleanValue.getSelectedItem().toString();

        if (TextUtils.isEmpty(key) || TextUtils.isEmpty(value)) {
            Logger.v(TAG, "String key or Value is Empty");
            return;
        }

        if (mSPUtils.contains(key)) {
            Logger.v(TAG, "key = " + key + " is already exist");
            return;
        }

        mSPUtils.put(key, Boolean.valueOf(value));

        updateSP();
    }

    private void addString() {
        String key = mSpStringKey.getText().toString();
        String value = mSpStringValue.getText().toString();

        if (TextUtils.isEmpty(key) || TextUtils.isEmpty(value)) {
            Logger.v(TAG, "String key or Value is Empty");
            return;
        }

        if (mSPUtils.contains(key)) {
            Logger.v(TAG, "key = " + key + " is already exist");
            return;
        }

        mSPUtils.put(key, value);

        updateSP();
    }

    private void addInt() {
        String key = mSpIntKey.getText().toString();
        String value = mSpIntValue.getText().toString();

        if (TextUtils.isEmpty(key) || TextUtils.isEmpty(value)) {
            Logger.v(TAG, "String key or Value is Empty");
            return;
        }

        if (mSPUtils.contains(key)) {
            Logger.v(TAG, "key = " + key + " is already exist");
            return;
        }

        mSPUtils.put(key, Integer.parseInt(value));

        updateSP();
    }

    private void clearSP() {
        mSPUtils.clear();
        updateSP();
    }

    private void updateSP() {
        mData=getAllSP();
        mAdapter.setData(mData);

        setListViewHeightBasedOnChildren(mSpShow);
    }

    private List<String> getAllSP() {
        List<String> sp = new ArrayList<>();
        Map<String, ?> map = mSPUtils.getAll();
        for (String key : map.keySet()) {
            String spValue = "Key: " + key + "   Value: " + map.get(key);
            sp.add(spValue);
        }

        Logger.v(TAG, sp.toString());

        return sp;
    }

    public void setListViewHeightBasedOnChildren(ListView listView) {
        // 获取ListView对应的Adapter
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }

        int totalHeight = 0;
        for (int i = 0, len = listAdapter.getCount(); i < len; i++) {
            // listAdapter.getCount()返回数据项的数目
            View listItem = listAdapter.getView(i, null, listView);
            // 计算子项View 的宽高
            listItem.measure(0, 0);
            // 统计所有子项的总高度
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        // listView.getDividerHeight()获取子项间分隔符占用的高度
        // params.height最后得到整个ListView完整显示需要的高度
        listView.setLayoutParams(params);
    }
}
