package com.bridgelabz.sqlitedemo;

/**
 * Created by Nadimuddin on 14/9/16.
 */
public class EmployeeInfo
{
    //data of employee
    String mId, mName, mLastName, mCity;

    //constructor to take data of employee from outside of class
    EmployeeInfo(String id, String name, String lastName, String city)
    {
        mId = id;
        mName = name;
        mLastName = lastName;
        mCity = city;
    }

    //return id of employee
    String getId()
    {
        return mId;
    }

    //return name of employee
    String getName()
    {
        return mName;
    }

    //return last name of employee
    String getLastName()
    {
        return mLastName;
    }

    //return city of employee
    String getCity()
    {
        return mCity;
    }
}
