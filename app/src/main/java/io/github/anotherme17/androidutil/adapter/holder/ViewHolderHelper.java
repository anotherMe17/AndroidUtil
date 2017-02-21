package io.github.anotherme17.androidutil.adapter.holder;

import android.support.annotation.IdRes;
import android.support.v4.util.SparseArrayCompat;
import android.view.View;
import android.widget.TextView;

/**
 * @author AnotherMe17
 */
public class ViewHolderHelper {

    private SparseArrayCompat<View> mViews;
    private View mContentView;

    public ViewHolderHelper(View convertView) {
        this.mContentView = convertView;
        mViews = new SparseArrayCompat<>();
    }

    public <T extends View> T getView(@IdRes int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mContentView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public TextView getTextView(@IdRes int viewId) {
        return getView(viewId);
    }

    public ViewHolderHelper setText(@IdRes int viewId, String text) {
        getTextView(viewId).setText(text);
        return this;
    }
}
