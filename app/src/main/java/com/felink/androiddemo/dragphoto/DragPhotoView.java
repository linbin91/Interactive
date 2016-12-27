package com.felink.androiddemo.dragphoto;

import android.content.Context;
import android.util.AttributeSet;

import uk.co.senab.photoview.PhotoView;

/**
 * Created by Administrator on 2016/12/27.
 */

public class DragPhotoView extends PhotoView {

    private OnTapListener mTapListener;
    private OnExitListener mExitListener;


    public DragPhotoView(Context context) {
        super(context);
    }

    public DragPhotoView(Context context, AttributeSet attr) {
        super(context, attr);
    }

    public DragPhotoView(Context context, AttributeSet attr, int defStyle) {
        super(context, attr, defStyle);
    }

    public void setOnTapListener(OnTapListener listener) {
        mTapListener = listener;
    }

    public void setOnExitListener(OnExitListener listener) {
        mExitListener = listener;
    }

    public interface OnTapListener {
        void onTap(DragPhotoView view);
    }

    public interface OnExitListener {
        void onExit(DragPhotoView view, float translateX, float translateY, float w, float h);
    }
}
