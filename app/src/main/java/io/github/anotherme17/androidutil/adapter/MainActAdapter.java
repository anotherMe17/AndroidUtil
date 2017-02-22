package io.github.anotherme17.androidutil.adapter;

import android.content.Context;

import java.util.List;

import io.github.anotherme17.androidutil.R;
import io.github.anotherme17.androidutil.adapter.holder.ViewHolderHelper;

/**
 * @author AnotherMe17
 */
public class MainActAdapter extends BaseAdapter<String> {

    public MainActAdapter(Context context, List<String> data) {
        super(context, data);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_text;
    }

    @Override
    public void injectView(ViewHolderHelper helper, String data, int position) {
        helper.setText(R.id.item_text, data);
    }
}
