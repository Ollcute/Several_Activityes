package com.example.several_activitys_shevtsova_303;

import static java.lang.Integer.parseInt;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText txt;
    TextView txt_vivod;
    CheckBox chB_1;
    CheckBox chB_2;
    private String m_Text = "";


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.txt_data);
        txt_vivod = findViewById(R.id.txt_vivod);
        chB_1 = findViewById(R.id.chB_1);
        chB_2 = findViewById(R.id.chB_2);


    }


    public void Exit_App(View view) {
        AlertDialog alertbox = new AlertDialog.Builder(this)
                .setIcon(R.drawable.icon)
                .setMessage("Do you want to exit application?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    // do something when the button is clicked
                    public void onClick(DialogInterface arg0, int arg1) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    // do something when the button is clicked
                    public void onClick(DialogInterface arg0, int arg1) {
                    }
                })
                .show();
    }

    public void Open_Dialog(View view) {

        String s = txt.getText().toString();
        Intent i = new Intent(this,MainActivity2.class);
        i.putExtra("abc", s);
        i.putExtra("a1",chB_1.isChecked());
        i.putExtra("b1",chB_2.isChecked());

        startActivityForResult(i,555);

    }

    @Override
    protected void onActivityResult(int requesCode, int resultCode, @Nullable Intent data) {
        if (requesCode == 555) {
            if (data != null) {
                String s = data.getStringExtra("qwe");
                Boolean a_2 = data.getBooleanExtra("a",false);
                Boolean b_2 = data.getBooleanExtra("b", false);
                if(a_2==true){
                    chB_1.setChecked(true);
                }
                else{chB_1.setChecked(false);}
                if(b_2==true){
                    chB_2.setChecked(true);
                }
                else{chB_2.setChecked(false);}
                txt_vivod.setText(s);


            }
        }
        super.onActivityResult(requesCode,resultCode, data);
    }
    public void New_Dialog(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enter a new message");

        // Set up the input
        final EditText input = new EditText(this);
        // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);
        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                m_Text = input.getText().toString();
                txt_vivod.setText(m_Text);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();







}}