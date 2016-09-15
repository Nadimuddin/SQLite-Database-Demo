package com.bridgelabz.sqlitedemo;
/**
 * Created by Nadimuddin on 12/9/16.
 * purpose: learning android
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/*This class is use to interacting with SQLite Database
* and perform insert, delete, update & view database
 */
public class SQLiteDatabaseDemo extends SQLiteOpenHelper
{
    private static final String TAG = "SQLiteDatabaseDemo";

    //give name to database
    private static final String DATABASE_NAME = "Employee.db";

    //name of table
    private static final String TABLE_NAME = "Employee_table";

    //column1 of table
    private static final String COL1 = "ID";

    //column2 of table
    private static final String COL2 = "NAME";

    //column3 of table
    private static final String COL3 = "LAST_NAME";

    //column4 of table
    private static final String COL4 = "CITY";

    //constructor which create a new database with a given name
    SQLiteDatabaseDemo(Context context)
    {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        //call method of SQLiteDatabase which execute a SQL query(to create table)
        sqLiteDatabase.execSQL("create table Employee_table(" +
                COL1+" integer," +
                COL2+" text," +
                COL3+" text," +
                COL4+" text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //sqLiteDatabase.execSQL("Drop table if exists "+TABLE_NAME);
    }

    /*
    * method to perform insert operation
    * it takes employee data as parameter
     */
    public boolean insertData(int id, String name, String last_name, String city)
    {
        //get writable database
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        //ContentValues to put data in one object
        ContentValues contentValues = new ContentValues();

        //put id to column1
        contentValues.put(COL1,  id);

        //put name to column2
        contentValues.put(COL2, name);

        //put last name to column3
        contentValues.put(COL3, last_name);

        //put city to column4
        contentValues.put(COL4, city);

        /*call insert method of SQLiteDatabase class
        * it returns unique id of inserted row
        * if data is not inserted then it returns -1
         */
        long result = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

        if(result == -1)
            return false;
        else
            return true;
    }

    //method to view data from SQLiteDatabase
    public Cursor getData()
    {
        //object to get readable database
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        /*call method of SQLiteDatabase class to execute SQL query
        * & get result of query to the Cursor
         */
        Cursor result = sqLiteDatabase.rawQuery("Select * from "+TABLE_NAME, null);

        return result;
    }

    //method to perform update operation
    public  int updateData(String id, String name, String lastName, String city)
    {
        //to get how many rows are updated
        int rowsAffected;

        //object to get writable database
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        //ContentValues to put data in one object
        ContentValues contentValues = new ContentValues();

        //put id to column1
        contentValues.put(COL1,  id);

        //put name to column2
        contentValues.put(COL2, name);

        //put last name to column3
        contentValues.put(COL3, lastName);

        //put city to column4
        contentValues.put(COL4, city);

        /*
        * call update method of SQLiteDatabase class
        * which returns no. of rows updated
         */
        rowsAffected = sqLiteDatabase.update(TABLE_NAME, contentValues, COL1+" = ?", new String[] {id});

        return rowsAffected;
    }

    //method to perform delete operation
    public int deleteData(String id)
    {
        //to get how many rows are deleted
        int rowsAffected;

        //object to get writable database
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        /*
        * call delete method SQLiteDatabase class
        * it returns no. of rows deleted
         */
        rowsAffected = sqLiteDatabase.delete(TABLE_NAME, COL1+" = ?", new String[] {id});

        return rowsAffected;
    }
}
