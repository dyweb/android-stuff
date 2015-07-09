package com.dongyueweb.app.crossy.utils.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by ljj on 2015/3/7.
 */
public abstract class UniversalAdapter<T> extends BaseAdapter {

    protected LayoutInflater layoutInflater;
    protected Context context;
    protected List<T> dataList;
    protected final int resourceId;

    public UniversalAdapter(Context context, List<T> dataList, int resourceId){
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.dataList = dataList;
        this.resourceId = resourceId;
    }

    @Override
    public int getCount()
    {
        return dataList.size();
    }

    @Override
    public T getItem(int position)
    {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        final UniversalViewHolder viewHolder =
                UniversalViewHolder.getViewHolder(context,convertView,parent,resourceId,position);
        convert(viewHolder, getItem(position), position);
        return viewHolder.getConvertView();
    }

    public abstract void convert(UniversalViewHolder viewHolder, T item, int position);
}
