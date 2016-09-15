package com.bridgelabz.sqlitedemo;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Nadimuddin on 14/9/16.
 * purpose: learning android
 */
public class ViewData extends AppCompatActivity
{
    ArrayList<EmployeeInfo> mArrayList;
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.view_data);
        super.onCreate(savedInstanceState);
        mArrayList = new ArrayList<>();

        showData();

    }

    //method to show data
    public void showData()
    {
        //initializing object of SQLiteDatabaseDemo
        SQLiteDatabaseDemo dbDemo = new SQLiteDatabaseDemo(this);

        //getting XML object of ListView
        mListView = (ListView)findViewById(R.id.listView);

        //call getData method of SQLiteDatabaseDemo class
        Cursor result = dbDemo.getData();
        if(result.getCount() < 0)
        {
            Toast.makeText(this, "No data found!", Toast.LENGTH_SHORT).show();
            onDestroy();
        }
        else
        {
            while (result.moveToNext())
            {
                //add object of EmployeeInfo class
                mArrayList.add(new EmployeeInfo(result.getString(0), result.getString(1),
                        result.getString(2), result.getString(3)));
            }
            //initialize adapter with created array list
            SQLiteAdapter adapter = new SQLiteAdapter(this, mArrayList);

            //set adapter to ListView
            mListView.setAdapter(adapter);
        }
    }
}
