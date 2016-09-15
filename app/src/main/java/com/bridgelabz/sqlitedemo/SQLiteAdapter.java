package com.bridgelabz.sqlitedemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Nadimuddin on 14/9/16.
 * purpose: learning android
 */
public class SQLiteAdapter extends BaseAdapter {
    //ArrayList to store Employee info
    ArrayList<EmployeeInfo> mArrayList;

    LayoutInflater mInflater;

    //constructor to take Context & ArrayList
    SQLiteAdapter(Context context, ArrayList<EmployeeInfo> arrayList)
    {
        mArrayList = arrayList;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        if(view == null)
            view = mInflater.inflate(R.layout.layout_for_data, viewGroup, false);

        //TextView to display id
        TextView id;

        //TextView to display name
        TextView name;

        //TextView to display last name
        TextView lastName;

        //TextView to display city
        TextView city;

        /*
        * getting XML objects of components
        */
        id = (TextView)view.findViewById(R.id.viewID);
        name = (TextView)view.findViewById(R.id.viewName);
        lastName = (TextView)view.findViewById(R.id.viewLastName);
        city = (TextView)view.findViewById(R.id.viewCity);

        //display id on TextView
        id.setText(mArrayList.get(i).getId());

        //display name on TextView
        name.setText(mArrayList.get(i).getName());

        //display last name on TextView
        lastName.setText(mArrayList.get(i).getLastName());

        //display city on TextView
        city.setText(mArrayList.get(i).getCity());

        return view;
    }
}
