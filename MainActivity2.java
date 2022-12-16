package com.example.several_activitys_shevtsova_303;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity2 extends AppCompatActivity {
    EditText txt;
    Switch a;
    Switch b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txt=findViewById(R.id.txt_2);
        a= findViewById(R.id.switch_1);
        b=findViewById(R.id.switch_2);
        Intent i = getIntent();

        String s = i.getStringExtra("abc");
        Boolean a_2 = i.getBooleanExtra("a1", false);
        Boolean b_2 = i.getBooleanExtra("b1", false);
        if(a_2==true){
           a.setChecked(true);
        }
        else{
           a.setChecked(false);
        }
        if(b_2==true){
            b.setChecked(true);
        }
       else{
           b.setChecked(false);
       }
        txt.setText(s);
    }

    public void on_Cancel(View view){
        setResult(RESULT_CANCELED);
        finish();

    }
    public void on_OK(View view){
        Intent i=new Intent();
        Boolean Checked = a.isChecked();
        Boolean Cheked_2 = b.isChecked();
        if(Checked){a.setChecked(true);}
        else{a.setChecked(false);}
        if (Cheked_2){b.setChecked(true);}
        else{b.setChecked(false);}
        String s = txt.getText().toString();
        i.putExtra("qwe",s);
        i.putExtra("a", a.isChecked());
        i.putExtra("b",b.isChecked());
        setResult(RESULT_OK,i);
        finish();
    }


}