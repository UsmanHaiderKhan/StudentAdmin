package com.example.usmankhan.studentadmin;

import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class DashBoard extends AppCompatActivity {
    private Button btnLogout;
    private Session session;
    TextView textView;
    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_dash_board );
        btnLogout=(Button)findViewById( R.id.btnLogout );
        textView=(TextView)findViewById( R.id.text_view );
        db=new DbHelper( this );
        session = new Session(this);
        if(!session.loggedin()){
            logout();
        }
        btnLogout = (Button)findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
    }
    private void logout(){
        session.setLoggedin(false);
        finish();
        startActivity(new Intent(DashBoard.this,Login.class));
    }


    public void view_data(View view) {
        Intent intent=new Intent(this,StudentRecord.class);
        startActivity( intent );

    }

    public void add_btn(View view) {
        Intent intent=new Intent(this,AddStudents.class);
        startActivity( intent );
    }

    public void attandance(View view) {
        startActivity( new Intent(this,Attandance.class) );
    }

    public void add_faculty_Member(View view) {
        startActivity( new Intent(this,AddFaculty.class) );
    }

    public void view_faculty_Member(View view) {
        startActivity( new Intent(this,FacultyRecord.class) );
    }
}
