package com.example.setudnyanapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Objects;

import kotlin.random.Random;

public class CertificateActivity extends AppCompatActivity{

    String[] certicates=new String[] {"Income Certificate:मिळकत प्रमाणपत्र",
            "Cast Certificate:कास्ट प्रमाणपत्र","Non Criminanl or Central OBC Certificate:न क्रिमिनॅल किंवा मध्य ओबीसी प्रमाणपत्र",
            "S.E.C Certificate:एस.ई.सी. प्रमाणपत्र","Farmer Certificate:शेतकरी प्रमाणपत्र",
            "Bhumihin Certificate:भूमीहिण प्रमाणपत्र","Reduce Name From Rationcard:रेशनकार्डुन नावी कमि करा",
    };
    Spinner certificatespinner;
    CheckBox cb2;
    Button btnopen;
    TextView textView1;
    public int positionOfSelectedDataFromSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certificate);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        cb2= findViewById(R.id.checkBox2);
        btnopen= findViewById(R.id.btn_open);
        certificatespinner= findViewById(R.id.spinnercertificateView);
        textView1= findViewById(R.id.textViewdecription);
        setupadapter();
        //certificatespinner.setOnClickListener((View.OnClickListener) this);
        certificatespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View view, int position, long id)
            {
                switch(position)
                {
                    case 0:
                    {
                        textView1.setText(getText(R.string.textviewdesc));
                        break;
                    }
                    case 1:
                    {
                        textView1.setText(getText(R.string.textviewc));
                    }break;
                   /* case 2:
                    {
                        textView1.setText(getText(R.string.textnoncriminal));
                    }break;
                    case 3:
                    {
                        textView1.setText(getText(R.string.textSECcert));
                    }break;
                    case 4:
                    {
                        textView1.setText(getText(R.string.textfarmer));
                    }break;*/
                }

                btnopen.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        positionOfSelectedDataFromSpinner= position;
                        Intent i = new Intent (CertificateActivity.this,CertificateDetailsActivity2.class);
                        i.putExtra("position", positionOfSelectedDataFromSpinner);
                        startActivity(i);

                    }
                });
            }
            public void onNothingSelected(AdapterView<?> arg0) { }
        });
    }

    private void setupadapter()
    {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, certicates);
        certificatespinner.setAdapter(adapter);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
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