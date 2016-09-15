package com.bridgelabz.sqlitedemo;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Nadimuddin on 14/9/16.
 * purpose: learning android
 */
public class InsertData extends Dialog implements View.OnClickListener
{
    //EditText to take input data from user
    EditText mId, mName, mLastName, mCity;

    //button to insert data
    Button mInsert;
    Context mContext;

    public InsertData(Context context)
    {
        super(context);
        mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert_data);

        /*
        * getting XML objects
         */
        mId = (EditText)findViewById(R.id.editTextId);
        mName = (EditText)findViewById(R.id.editTextName);
        mLastName = (EditText)findViewById(R.id.editTextLastName);
        mCity = (EditText)findViewById(R.id.editTextCity);
        mInsert = (Button)findViewById(R.id.dialogButtonInsert);

        mInsert.setOnClickListener(this);
    }

    //method to insert data
    public boolean insertData()
    {
        //initializing object of SQLiteDatabaseDemo class by calling it's constructor
        SQLiteDatabaseDemo dbDemo = new SQLiteDatabaseDemo(mContext);

        //flag to indicate whether data is inserted or not
        boolean flag = false;

        //call method of SQLiteDatabaseDemo to insert data in SQLite database
        boolean isInserted = dbDemo.insertData(Integer.parseInt(mId.getText().toString()),
                mName.getText().toString(), mLastName.getText().toString(),
                mCity.getText().toString());

        /*
        * if data inserted set flag as true
        * otherwise set false
         */
        if(isInserted)
            flag = true;

        return flag;
    }

    @Override
    public void onClick(View view)
    {
        if(view.getId() == R.id.dialogButtonInsert)
        {
            /*
            * call method to insert data
            * which returns whether data is inserted or not
            */
            boolean flag = insertData();

            //if flag is true
            if(flag)
                Toast.makeText(mContext, "Data inserted", Toast.LENGTH_SHORT).show();
            //if flag is false
            else
                Toast.makeText(mContext, "Data not inserted", Toast.LENGTH_SHORT).show();

            //close the dialog
            dismiss();
        }
    }
}
