package com.example.usmankhan.studentadmin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class StudentRecord extends AppCompatActivity {
   TextView textView;
   DbHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_student_record );

        textView=(TextView) findViewById( R.id.text_view );
        db=new DbHelper( this );

    }

    public void view_record(View view) {
   db.all_students( textView );
    }
}
