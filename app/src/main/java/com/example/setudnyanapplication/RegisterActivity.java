package com.example.setudnyanapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class RegisterActivity extends AppCompatActivity
{
    Button btnregister;
    EditText textV1,textV2,textV3,textV4;
    FirebaseAuth firebaseAuthuth;
    Intent intent;
    EditText Etext1,Etext2,Etext3,Etext4;
    ProgressBar progressBar;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnregister=(Button)findViewById(R.id.register_btn);
        textV1=(EditText) findViewById(R.id.editTextTextPersonName);
        progressBar=(ProgressBar)findViewById(R.id.progressBar2);
        textV1.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(textV1, InputMethodManager.SHOW_IMPLICIT);
        textV2=(EditText) findViewById(R.id.editTextTextPersonEmail);
        textV3=(EditText) findViewById(R.id.editTextTextPersonPassword);
        textV3.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        textV4=(EditText) findViewById(R.id.editTextTextPersonPhone);
        firebaseAuthuth=FirebaseAuth.getInstance();
        sharedPreferences = getApplicationContext().getSharedPreferences("Reg", 0);
        editor = sharedPreferences.edit();
        /*if(firebaseAuthuth.getCurrentUser()!=null)
        {
            intent=new Intent(RegisterActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        else
        {
            Log.i("sign in","not sign in");
        }*/
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String userEmail=textV2.getText().toString().trim();
                String userPass=textV3.getText().toString().trim();
                String userpassconrm=textV4.getText().toString().trim() ;
                sharedPreferences = getApplicationContext().getSharedPreferences("Reg", 0);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("User Id",userEmail);
                editor.putString("User Pass",userPass);
                editor.apply();


                if(TextUtils.isEmpty(userEmail))
                {
                    textV2.setError("Email Required");
                    return;
                }
                if(TextUtils.isEmpty(userPass))
                {
                    textV3.setError("Password Required");
                    return;
                }
                if(userPass.length()<6)
                {
                    textV3.setError("Password Must be Greater than 6 Character");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                firebaseAuthuth.createUserWithEmailAndPassword(userEmail,userPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(RegisterActivity.this,"Register Successful",Toast.LENGTH_SHORT).show();
                            intent=new Intent(RegisterActivity.this,MainActivity.class);
                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(RegisterActivity.this,"Error"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}