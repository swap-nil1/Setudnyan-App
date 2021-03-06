package com.example.setudnyanapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.Objects;

public class SchemeDetailActivity extends AppCompatActivity {
    int PressedId;
    String title,value;
    TextView txt1,textViewdetails;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
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
                textViewdetails.setText(getString(R.string.scheme5));
                break;
            }
            case 6:
            {
                txt1.setText(title);
                textViewdetails.setText(getString(R.string.scheme6));
                break;
            }
            case 7:
            {
                txt1.setText(title);
                textViewdetails.setText(getString(R.string.scheme7));
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