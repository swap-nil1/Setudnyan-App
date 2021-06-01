package com.example.setudnyanapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class GovnmentSchemeActivity extends AppCompatActivity
{
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_govnment_scheme);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        btn1=(Button)findViewById(R.id.button3);
        btn2=(Button)findViewById(R.id.button4);
        btn3=(Button)findViewById(R.id.button5);
        btn4=(Button)findViewById(R.id.button6);
        btn5=(Button)findViewById(R.id.button7);
        btn6=(Button)findViewById(R.id.button10);
        btn7=(Button)findViewById(R.id.button8);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                intent=new Intent(GovnmentSchemeActivity.this,SchemeDetailActivity.class);
                intent.putExtra("ButtonNumber",1);
                intent.putExtra("title",btn1.getText());
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                intent=new Intent(GovnmentSchemeActivity.this,SchemeDetailActivity.class);
                intent.putExtra("ButtonNumber",2);
                intent.putExtra("title",btn2.getText());
                startActivity(intent);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                intent=new Intent(GovnmentSchemeActivity.this,SchemeDetailActivity.class);
                intent.putExtra("ButtonNumber",3);
                intent.putExtra("title",btn3.getText());
                startActivity(intent);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                intent=new Intent(GovnmentSchemeActivity.this,SchemeDetailActivity.class);
                intent.putExtra("ButtonNumber",4);
                intent.putExtra("title",btn4.getText());
                startActivity(intent);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                intent=new Intent(GovnmentSchemeActivity.this,SchemeDetailActivity.class);
                intent.putExtra("ButtonNumber",5);
                intent.putExtra("title",btn5.getText());
                startActivity(intent);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                intent=new Intent(GovnmentSchemeActivity.this,SchemeDetailActivity.class);
                intent.putExtra("ButtonNumber",6);
                intent.putExtra("title",btn6.getText());
                startActivity(intent);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                intent=new Intent(GovnmentSchemeActivity.this,SchemeDetailActivity.class);
                intent.putExtra("ButtonNumber",7);
                intent.putExtra("title",btn7.getText());
                startActivity(intent);
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