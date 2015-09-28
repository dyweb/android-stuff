package com.dongyueweb.app.crossy.utils.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by ljj on 2015/3/7.
 * 通用的Adapter中的ViewHolder
 */
public class UniversalViewHolder {
    private final SparseArray<View> viewSparseArray;
    private View convertView;
    private int position;

    public UniversalViewHolder(Context context, ViewGroup parent, int layoutId, int position) {
        this.viewSparseArray = new SparseArray<View>();
        this.position = position;
        convertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        convertView.setTag(this);
    }

    public static UniversalViewHolder getViewHolder(Context context, View cView,
                                                    ViewGroup parent, int layoutId, int position){
        if(cView == null){
            return new UniversalViewHolder(context,parent,layoutId,position);
        }else{
            return (UniversalViewHolder)cView.getTag();
        }
    }

    public <T extends View> T getView(int viewId){
        View view = viewSparseArray.get(viewId);
        if(view == null){
            view = convertView.findViewById(viewId);
            viewSparseArray.put(viewId,view);
        }
        return (T)view;
    }

    public View getConvertView(){
        return convertView;
    }

    public int getPosition(){
        return position;
    }

    //TextView
    public UniversalViewHolder setText(int viewId, String text){
        TextView textView = getView(viewId);
        textView.setText(text);
        return this;
    }

    //ImageView
    public UniversalViewHolder setImageResource(int viewId, int drawableId){
        ImageView imageView = getView(viewId);
        imageView.setImageResource(drawableId);
        return this;
    }

    //ImageView
    public UniversalViewHolder setImageBitmap(int viewId, Bitmap bitmap){
        ImageView imageView = getView(viewId);
        imageView.setImageBitmap(bitmap);
        return this;
    }

    //ImageView
    public UniversalViewHolder setImageUrl(int viewId, String url){
        ImageView imageView = getView(viewId);
        ImageLoader.getInstance().displayImage(url,imageView);
        return this;
    }


}
