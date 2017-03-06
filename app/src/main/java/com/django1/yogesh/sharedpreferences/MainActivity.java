package com.django1.yogesh.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText,editText2;
    TextView mytext;
    Button saveinfo,displayinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText)findViewById(R.id.editText);
        editText2=(EditText)findViewById(R.id.editText2);
        mytext=(TextView)findViewById(R.id.mytext);
        saveinfo=(Button)findViewById(R.id.savebutton);
        displayinfo=(Button)findViewById(R.id.displaybutton);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }



    public void saveinfoclick(View view){
        SharedPreferences sharedprefer=getSharedPreferences("logininfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedprefer.edit();
        editor.putString("username",editText.getText().toString());
        editor.putString("password",editText2.getText().toString());

        editor.apply();
        Toast.makeText(getApplicationContext(),"Saved",Toast.LENGTH_SHORT).show();
    }


    public void displayinfoclick(View view){
        SharedPreferences sharedprefer=getSharedPreferences("logininfo", Context.MODE_PRIVATE);
        String name=sharedprefer.getString("username","");
        String pass=sharedprefer.getString("password","");

        mytext.setText(name+" "+pass);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
