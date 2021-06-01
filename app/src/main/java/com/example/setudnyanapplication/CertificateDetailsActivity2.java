package com.example.setudnyanapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;

public class CertificateDetailsActivity2 extends CertificateActivity
{

    CheckBox cb1,cb2,cb3,cb4,cb5,cb6,cb7,cb8,cb9,cb10,cb11;
    int value;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certificate_details2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        cb1=(CheckBox)findViewById(R.id.checkBoxA);
        cb2=(CheckBox)findViewById(R.id.checkBoxB);
        cb3=(CheckBox)findViewById(R.id.checkBoxC);
        cb4=(CheckBox)findViewById(R.id.checkBoxD);
        cb5=(CheckBox)findViewById(R.id.checkBoxE);
        cb6=(CheckBox)findViewById(R.id.checkBoxF);
        cb7=(CheckBox)findViewById(R.id.checkBoxG);
        cb8=(CheckBox)findViewById(R.id.checkBoxH);
        cb9=(CheckBox)findViewById(R.id.checkBoxI);
        cb10=(CheckBox)findViewById(R.id.checkBoxJ);
        cb11=(CheckBox)findViewById(R.id.checkBox2);

        Intent mIntent = getIntent();
        value = mIntent.getIntExtra("position", 0);

        switch (value) {
            case 0: {
                cb1.setChecked(true);
                cb4.setChecked(true);
                cb2.setChecked(true);
                cb7.setChecked(true);
            }
            break;
            case 1: {
                cb3.setChecked(true);
                cb2.setChecked(true);
                cb6.setChecked(true);
                cb10.setChecked(true);
                cb4.setChecked(true);
                cb7.setChecked(true);
            }
            break;
            case 2: {
                cb4.setChecked(true);
                cb5.setChecked(true);
                cb10.setChecked(true);
                cb6.setChecked(true);
            }
            break;
            case 3: {
                cb10.setChecked(true);
                cb1.setChecked(true);
                cb7.setChecked(true);
            }
            case 4: {
                cb9.setChecked(true);
                cb2.setChecked(true);
                cb10.setChecked(true);
                cb7.setChecked(true);
            }
            case 5:
            {
                cb8.setChecked(true);
                cb10.setChecked(true);
            }
            case 6:
            {
                cb10.setChecked(true);
            }

        }
    }
    @Override
    public boolean onSupportNavigateUp()
    {
        finish();
        return super.onSupportNavigateUp();
    }
    @Override
    public void onBackPressed()
    {
        finish();
        super.onBackPressed();
    }
}