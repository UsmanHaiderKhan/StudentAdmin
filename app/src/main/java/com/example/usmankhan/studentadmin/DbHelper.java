package com.example.usmankhan.studentadmin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;

public class DbHelper extends SQLiteOpenHelper {

    public static final String TAG = DbHelper.class.getSimpleName();
    public static final String DB_NAME = "Student.db";
    public static final int DB_VERSION = 4;

    public static final String USER_TABLE = "users";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASS = "password";

    public static final String STUDENTS_TABLE = "Students";
    public static final String STU_COLUMN_ID = "_id";
    public static final String STU_COLUMN_NAME = "name";
    public static final String STU_COLUMN_DEP = "department";
    public static final String STU_COLUMN_ROLLNO = "roll_no";

    public static final String ATTANDANCE_TABLE = "Attandance";
    public static final String ATT_COLUMN_ID = "_id";
    public static final String ATT_COLUMN_NAME = "name";

    public static final String FACULTY_TABLE = "Faculty";
    public static final String FA_COLUMN_ID = "_id";
    public static final String FA_COLUMN_NAME = "name";
    public static final String FA_COLUMN_DEP = "department";
    public static final String FA_COLUMN_SALARY = "salary";


    public static final String CREATE_TABLE_USERS = "CREATE TABLE " + USER_TABLE + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_EMAIL + " TEXT,"
            + COLUMN_PASS + " TEXT);";

    public static final String CREATE_TABLE_STUDENTS = "CREATE TABLE " + STUDENTS_TABLE + "("
            + STU_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + STU_COLUMN_NAME + " TEXT,"
            + STU_COLUMN_DEP+" TEXT,"
            + STU_COLUMN_ROLLNO + " INTEGER);";

    public static final String CREATE_TABLE_ATTANDANCE = "CREATE TABLE " + ATTANDANCE_TABLE + "("
            + ATT_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + ATT_COLUMN_NAME + " TEXT);";

    public static final String CREATE_TABLE_FACULTY = "CREATE TABLE " + FACULTY_TABLE + "("
            + FA_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + FA_COLUMN_NAME + " TEXT,"
            + FA_COLUMN_DEP+" TEXT,"
            + FA_COLUMN_SALARY + " INTEGER);";

    public DbHelper(Context context) {
        super( context, DB_NAME, null, DB_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL( CREATE_TABLE_USERS );
        db.execSQL( CREATE_TABLE_STUDENTS );
        db.execSQL( CREATE_TABLE_ATTANDANCE );
        db.execSQL( CREATE_TABLE_FACULTY );


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL( "DROP TABLE IF EXISTS " + USER_TABLE );
        db.execSQL( "DROP TABLE IF EXISTS " + STUDENTS_TABLE );
        db.execSQL( "DROP TABLE IF EXISTS " + FACULTY_TABLE );
        db.execSQL( "DROP TABLE IF EXISTS " + ATTANDANCE_TABLE );
        onCreate( db );
    }


    /**
     * Storing user details in database
     */
    public void addUser(String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put( COLUMN_EMAIL, email );
        values.put( COLUMN_PASS, password );

        long id = db.insert( USER_TABLE, null, values );
        db.close();

        Log.d( TAG, "user inserted" + id );
    }
    public void addStudents(String name, String dep,int roll) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put( STU_COLUMN_NAME, name );
        values.put( STU_COLUMN_DEP,dep );
        values.put( STU_COLUMN_ROLLNO,roll );

        long id = db.insert( STUDENTS_TABLE, null, values );
        db.close();

        Log.d( TAG, "Student inserted" + id );
    }
    public void addFaculty(String name, String dep,int salary) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put( FA_COLUMN_NAME, name );
        values.put( FA_COLUMN_DEP,dep );
        values.put( FA_COLUMN_SALARY,salary );

        long id = db.insert( FACULTY_TABLE, null, values );
        db.close();

        Log.d( TAG, "Faculty inserted" + id );
    }
    public void addAttandance(String name) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put( FA_COLUMN_NAME, name );

        long id = db.insert( ATTANDANCE_TABLE, null, values );
        db.close();

        Log.d( TAG, "Attandance inserted" + id );
    }
    public void all_Faculty(TextView textView)
    {
        Cursor cursor=this.getReadableDatabase().rawQuery( "SELECT * FROM "+FACULTY_TABLE,null );
        textView.setText( "" );
        while (cursor.moveToNext())
        {
            textView.append( cursor.getString( 1 )+" "+cursor.getString( 2 )+" "+cursor.getString( 3 )+"\n" );
        }
    }
    public void all_students(TextView textView)
    {
        Cursor cursor=this.getReadableDatabase().rawQuery( "SELECT * FROM "+STUDENTS_TABLE,null );
        textView.setText( "" );
        while (cursor.moveToNext())
        {
            textView.append( cursor.getString( 1 )+" "+cursor.getString( 2 )+" "+cursor.getString( 3 )+"\n" );
        }
    }
    public boolean getUser(String email, String pass) {
        //HashMap<String, String> user = new HashMap<String, String>();
        String selectQuery = "select * from  " + USER_TABLE + " where " +
                COLUMN_EMAIL + " = " + "'" + email + "'" + " and " + COLUMN_PASS + " = " + "'" + pass + "'";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery( selectQuery, null );
        // Move to first row
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            return true;
        }
        cursor.close();
        db.close();

        return false;
    }
}
