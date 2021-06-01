package com.example.setudnyanapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import java.util.Objects;

public class GovnmentPortalsActivity extends AppCompatActivity
{

    TextView linkTextView1,linkTextView2,linkTextView3,linkTextView4,linkTextView5,linkTextView6,linkTextView7,linkTextView8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_government_portals);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        setupHyperlink();
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
    private void setupHyperlink() {
        linkTextView1 = findViewById(R.id.portal1);
        linkTextView2 = findViewById(R.id.portal2);
        linkTextView3 = findViewById(R.id.portal3);
        linkTextView4 = findViewById(R.id.portal4);
        linkTextView5 = findViewById(R.id.portal5);
        linkTextView6 = findViewById(R.id.portal6);
        linkTextView7 = findViewById(R.id.portal7);
        linkTextView8 = findViewById(R.id.portal8);
        linkTextView1.setMovementMethod(LinkMovementMethod.getInstance());
        linkTextView2.setMovementMethod(LinkMovementMethod.getInstance());
        linkTextView3.setMovementMethod(LinkMovementMethod.getInstance());
        linkTextView4.setMovementMethod(LinkMovementMethod.getInstance());
        linkTextView5.setMovementMethod(LinkMovementMethod.getInstance());
        linkTextView6.setMovementMethod(LinkMovementMethod.getInstance());
        linkTextView7.setMovementMethod(LinkMovementMethod.getInstance());
        linkTextView8.setMovementMethod(LinkMovementMethod.getInstance());
    }
}