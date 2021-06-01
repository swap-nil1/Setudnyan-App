package com.example.setudnyanapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ContactUsActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
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