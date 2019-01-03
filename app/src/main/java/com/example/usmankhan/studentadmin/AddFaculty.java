package com.example.usmankhan.studentadmin;

import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddFaculty extends AppCompatActivity {
EditText name,dep,salary;
DbHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_add_faculty );
        db=new DbHelper( this );
        name=(EditText)findViewById( R.id.name );
        dep=(EditText)findViewById( R.id.dep );
        salary=(EditText)findViewById( R.id.salary );
    }

    public void add_faculty(View view) {
        try {
            db.addFaculty( name.getText().toString(),dep.getText().toString(),Integer.parseInt( salary.getText().toString() ));
        }catch(SQLiteException e)
        {
            Toast.makeText( AddFaculty.this,"Already Exist That",Toast.LENGTH_SHORT).show();
        }
    }
}
