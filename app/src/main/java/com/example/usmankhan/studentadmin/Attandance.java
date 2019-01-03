package com.example.usmankhan.studentadmin;

import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Attandance extends AppCompatActivity {
EditText mark_attandance;
DbHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_attandance );
        db=new DbHelper( this );
        mark_attandance=(EditText)findViewById( R.id.attandance );
    }

    public void att_btn(View view) {
        try{
            db.addAttandance( mark_attandance.getText().toString());
        }catch (SQLiteException e)
        {
            Toast.makeText( Attandance.this,"Already Exist That",Toast.LENGTH_SHORT).show();
        }
    }
}
