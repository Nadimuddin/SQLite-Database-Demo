package com.bridgelabz.sqlitedemo;

/**
 * Created by Nadimuddin on 14/9/16.
 * purpose: learning android
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";

    //Buttons to insert data to SQLite database
    Button mInsert;

    //Buttons to view data from SQLite database
    Button mView;

    //Buttons to update data in SQLite database
    Button mUpdate;

    //Buttons to delete data from SQLite database
    Button mDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        * getting XML object
         */
        mInsert = (Button)findViewById(R.id.buttonAdd);
        mUpdate = (Button)findViewById(R.id.dialogButtonUpdate);
        mView = (Button)findViewById(R.id.buttonView);
        mDelete = (Button)findViewById(R.id.buttonDelete);

        mInsert.setOnClickListener(this);
        mView.setOnClickListener(this);
        mUpdate.setOnClickListener(this);
        mDelete.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.buttonAdd:
                //call InsertData class
                InsertData insertData = new InsertData(this);

                //show dialog for taking input
                insertData.show();
                Log.i(TAG, "onClick: Dialog showed");
                break;
            case R.id.buttonView:
                //call another activity to show data
                Intent intent = new Intent(this, ViewData.class);

                //display activity
                startActivity(intent);
                break;

            case R.id.dialogButtonUpdate:
                //call UpdateData class
                UpdateData updateData = new UpdateData(this);

                //show dialog for taking input to update
                updateData.show();
                break;

            case R.id.buttonDelete:
                //call DeleteData class
                DeleteData deleteData = new DeleteData(this);

                //show dialog for asking user which data to be delete
                deleteData.show();
                break;
        }
    }
}
