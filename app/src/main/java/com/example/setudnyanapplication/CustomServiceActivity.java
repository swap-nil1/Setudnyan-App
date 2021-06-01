package com.example.setudnyanapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Objects;

public class CustomServiceActivity extends AppCompatActivity
{
    Intent intent;
    Spinner sp1,sp2;
    String[] city=new String[] {"Pandharpur","Gopalpur","Bhandishegaon"};
    String[] center=new String[] {"Dhairyam Computers And Maha E Seva Kendra","Maha E Seva Kendra","Sachin Bajare Maha E-Seva Kendra",
    "Digital E Seva Kendra","Jai Malhar Digital Seva Kendra"};
    Button btnservices;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_service);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        sp1=(Spinner)findViewById(R.id.spinnercity);
        sp2=(Spinner)findViewById(R.id.spinnercenter);
        btnservices=(Button)findViewById(R.id.btnservices);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,city);
        sp1.setAdapter(adapter);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,center);
        sp2.setAdapter(adapter2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        btnservices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(sp1!=null && sp2!=null)
                {
                    intent = new Intent(CustomServiceActivity.this, MahaEsevaFormActivity.class);
                    startActivity(intent);
                }
            }
        });

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