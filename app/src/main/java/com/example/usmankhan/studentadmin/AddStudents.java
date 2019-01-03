package com.example.usmankhan.studentadmin;

import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddStudents extends AppCompatActivity {
    EditText name,dep,roll;
    DbHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_add_students );
        name=(EditText)findViewById( R.id.name );
        dep=(EditText)findViewById( R.id.dep );
        roll=(EditText)findViewById( R.id.roll );
        db=new DbHelper( this );


    }

    public void btn_click(View view) {
           try{
               db.addStudents( name.getText().toString(),dep.getText().toString(),Integer.parseInt( roll.getText().toString() ));
           }catch (SQLiteException e)
           {
               Toast.makeText( AddStudents.this,"Already Exist That",Toast.LENGTH_SHORT).show();
           }
    }
}
