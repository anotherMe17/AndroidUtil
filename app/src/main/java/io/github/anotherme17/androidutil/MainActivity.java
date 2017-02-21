package io.github.anotherme17.androidutil;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.Arrays;

import butterknife.Bind;
import io.github.anotherme17.androidutil.adapter.MainActAdapter;

public class MainActivity extends BaseActivity {

    @Bind(R.id.act_main_listview)
    ListView mListview;

    private MainActAdapter mAdapter;

    private String[] mActName = new String[]{"SPUtils"};
    private Class[] mAct = new Class[]{SPUtilsActivity.class};

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {
        mAdapter = new MainActAdapter(this, Arrays.asList(mActName));
        mListview.setAdapter(mAdapter);

        mListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(mAct[position]);
            }
        });
    }
}
