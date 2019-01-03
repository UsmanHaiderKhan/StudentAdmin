package com.example.usmankhan.studentadmin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FacultyRecord extends AppCompatActivity {
TextView faculty;
DbHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_faculty_record );
        faculty=(TextView)findViewById( R.id.faculty );
        db=new DbHelper( this );

    }

    public void view_faculty(View view) {
        db.all_Faculty( faculty );
    }
}
