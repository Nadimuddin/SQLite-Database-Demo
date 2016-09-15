package com.bridgelabz.sqlitedemo;

import android.app.Dialog;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by bridgelabz1 on 14/9/16.
 * purpose: learning android
 */
public class UpdateData extends Dialog implements View.OnClickListener
{
    //EditText to take input data from user
    EditText mId, mName, mLastName, mCity;

    //button to perform update operation
    Button mUpdate;

    Context mContext;
    public UpdateData(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_data);

        /*
        * getting XML objects
         */
        mId = (EditText)findViewById(R.id.editTextUpdateId);
        mName = (EditText)findViewById(R.id.editTextUpdateName);
        mLastName = (EditText)findViewById(R.id.editTextUpdateLastName);
        mCity = (EditText)findViewById(R.id.editTextUpdateCity);
        mUpdate = (Button)findViewById(R.id.dialogButtonUpdate);

        mUpdate.setOnClickListener(this);
    }

    //method for update operation
    public void updateData()
    {
        //to get how many rows are updated
        int rowsAffected;

        //initializing object of SQLiteDatabaseDemo class
        SQLiteDatabaseDemo dbDemo = new SQLiteDatabaseDemo(mContext);

        /*
        * call updateData method of SQLiteDatabaseDemo
        * it returns no. of rows updated
         */
        rowsAffected = dbDemo.updateData(mId.getText().toString(), mName.getText().toString(),
                mLastName.getText().toString(), mCity.getText().toString());

        if(rowsAffected > 0)
        {
            Toast.makeText(mContext, rowsAffected+" row(s) affected", Toast.LENGTH_SHORT).show();

            //close the dialog
            dismiss();
        }
        else
        {
            Toast.makeText(mContext, "No any row affected", Toast.LENGTH_SHORT).show();
            mId.setText("");
            mName.setText("");
            mLastName.setText("");
            mCity.setText("");
        }
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.dialogButtonUpdate)
        {
            updateData();
        }

    }
}
