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
public class DeleteData extends Dialog implements View.OnClickListener
{
    Context mContext;

    //take id from user as key to delete specific row
    EditText mId;

    //button to delete data
    Button mDelete;

    //constructor
    public DeleteData(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_data);

        //get XML object of EditText & Button
        mId = (EditText)findViewById(R.id.editTextDeleteId);
        mDelete = (Button)findViewById(R.id.dialogButtonDelete);

        mDelete.setOnClickListener(this);
    }

    //method to delete data
    private void deleteData()
    {
        SQLiteDatabaseDemo dbDemo;

        //count no. of rows deleted
        int rowsDeleted;

        //initializing object of SQLiteDatabaseDemo class by calling it's constructor
        dbDemo = new SQLiteDatabaseDemo(mContext);

        /*
        * call deleteData method of SQLiteDatabaseDemo class
        * & pass id of employee to it
        * this method returns no. of rows deleted
        * if given id not found it will return 0
         */
        rowsDeleted = dbDemo.deleteData(mId.getText().toString());

        if(rowsDeleted > 0)
        {
            Toast.makeText(mContext, rowsDeleted+" row(s) deleted", Toast.LENGTH_SHORT).show();
            dismiss();
        }
        //if it return 0 no. of rows show below message
        else
        {
            Toast.makeText(mContext, "No any row deleted", Toast.LENGTH_SHORT).show();
            mId.setText("");
        }
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.dialogButtonDelete)
        {
            deleteData();
        }
    }
}
