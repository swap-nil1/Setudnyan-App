package com.example.setudnyanapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

import static android.content.DialogInterface.*;

public class MainActivity extends AppCompatActivity {
    EditText usr,pass;
    private String tag="NotSignedIn";
    Button btn_login, btn_skip;
    Intent intent;
    FirebaseAuth firebaseAuth;
    String userPass, userEmail;
    InputMethodManager imm;
    ProgressBar psbar;
    TextView textViewforgot, textviewReg;
    ImageView img;
    int totalAttempts = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_login = findViewById(R.id.log_btn);
        psbar = findViewById(R.id.progressBar);
        img=findViewById(R.id.imageView3);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation aniRotateClk = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_anticlockwise);
                img.startAnimation(aniRotateClk);
            }
        });
        textviewReg = findViewById(R.id.textViewRegister2);
        textViewforgot = findViewById(R.id.textViewforgotps);

        usr = findViewById(R.id.log_username);
        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(usr, InputMethodManager.SHOW_IMPLICIT);

        pass = findViewById(R.id.log_password);
        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(pass, InputMethodManager.SHOW_IMPLICIT);
        pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
       // FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser() ;
        if(FirebaseAuth.getInstance()!=null)
        {
            Intent i=new Intent(MainActivity.this,NavigationDrawerActivity2.class);
            //i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        }
        else
        {
            Log.d(tag,"onAuthStateChanged:signed_out");
        }

        setSharedPref();

        firebaseAuth = FirebaseAuth.getInstance();
        textViewforgot.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                psbar.setVisibility(View.INVISIBLE);
                forgotPassword(v);
            }
        });
        textviewReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                psbar.setVisibility(View.INVISIBLE);
                intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userEmail = usr.getText().toString().trim();
                userPass = pass.getText().toString().trim();
                if (totalAttempts != 0)
                {
                    if (TextUtils.isEmpty(userEmail)) {
                        usr.setError("Email Required");
                        return;
                    }
                    if (TextUtils.isEmpty(userPass)) {
                        pass.setError("Password Required");
                        return;
                    }
                    if (userPass.length() < 6) {
                        pass.setError("Password Must be Greater than 6 Character");
                        return;
                    }
                    psbar.setVisibility(View.VISIBLE);
                    firebaseAuth.signInWithEmailAndPassword(userEmail, userPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                intent = new Intent(MainActivity.this, NavigationDrawerActivity2.class);
                                startActivity(intent);
                            } else {
                                totalAttempts--;
                                psbar.setVisibility(View.INVISIBLE);
                                Toast.makeText(MainActivity.this, "Errro" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                else
                {
                    final AlertDialog.Builder buil;
                    buil = new AlertDialog.Builder(MainActivity.this);
                    buil.setMessage("3 Login attempts is over!");
                    buil.setCancelable(false);
                    buil.setNegativeButton("Cancel", new OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i)
                        {
                            dialogInterface.cancel();
                        }

                    }); buil.setPositiveButton("Confirm", new OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                       /* intent=new Intent(MainActivity.this,MainActivity.class);
                        intent.putExtra("finish",true);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);*/
                        dialogInterface.dismiss();
                        finish();
                    }
                });
                    AlertDialog builder=buil.create();
                    builder.show();
                }
            }
        });
    }

    private void setSharedPref()
    {
        SharedPreferences getShared = getSharedPreferences("Reg", MODE_PRIVATE);
        String str1 = getShared.getString("User Id", "");
        String str2 = getShared.getString("User Pass", "");
        usr.setText(str1);
        pass.setText(str2);
    }

    public void forgotPassword(View v)
    {
        psbar.setVisibility(View.INVISIBLE);
        EditText resetEmail = new EditText(this);
        AlertDialog.Builder psresetdialog = new AlertDialog.Builder(MainActivity.this);
        psresetdialog.setTitle("Reset Password");
        psresetdialog.setMessage("Enter Email Id to Receive Reset Link.");
        psresetdialog.setView(resetEmail);
        psresetdialog.setPositiveButton("Yes", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                String mail = resetEmail.getText().toString();
                firebaseAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(MainActivity.this, "Reset Link is Send", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Error ! Reset Link Not Generated" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).setNegativeButton("No", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                    dialog.cancel();
            }
        });

        AlertDialog builder=psresetdialog.create();
        psresetdialog.show();
    }
}
