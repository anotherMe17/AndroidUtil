package io.github.anotherme17.androidutil.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import io.github.anotherme17.androidutil.adapter.holder.ViewHolderHelper;

/**
 * @author AnotherMe17
 */
public abstract class BaseAdapter<R> extends android.widget.BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;

    private List<R> mData;

    public BaseAdapter(Context context, List<R> data) {
        this.mContext = context;
        this.mData = data;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public R getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolderHelper helper;
        if (convertView == null) {
            convertView = mInflater.inflate(getLayoutId(), parent, false);
            helper = new ViewHolderHelper(convertView);
            convertView.setTag(helper);
        } else {
            helper = (ViewHolderHelper) convertView.getTag();
        }

        injectView(helper, getItem(position), position);

        return convertView;
    }

    public abstract int getLayoutId();

    public abstract void injectView(ViewHolderHelper helper, R data, int position);
}
