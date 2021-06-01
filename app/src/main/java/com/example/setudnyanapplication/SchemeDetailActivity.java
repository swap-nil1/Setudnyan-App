package com.example.setudnyanapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Objects;

public class SchemeDetailActivity extends AppCompatActivity {
    int PressedId;
    String title;
    TextView txt1,textViewdetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheme_detail);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        txt1=(TextView)findViewById(R.id.textViewScemeTile);
        textViewdetails=(TextView)findViewById(R.id.textView11);
        PressedId=getIntent().getExtras().getInt("ButtonNumber");
        title=getIntent().getExtras().getString("title");
        switch (PressedId)
        {
            case 1: {
                txt1.setText(title);
                textViewdetails.setText(getString(R.string.scheme1details));
            }break;
            case 2: {
                txt1.setText(title);
                textViewdetails.setText(getString(R.string.scheme2details));
                break;
            }
            case 3:
            {
                txt1.setText(title);
                textViewdetails.setText(getString(R.string.scheme3deitals));
                break;
            }
            case 4:
            {
                txt1.setText(title);
                textViewdetails.setText(getString(R.string.scheme4details));
                break;
            }
            case 5:
            {
                txt1.setText(title);
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + PressedId);
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