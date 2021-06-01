package com.example.setudnyanapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Objects;

public class MahaEsevaFormActivity extends AppCompatActivity
{
    String[] Services=new String[] {"Aadhaar Demographic Update","Aadhaar Mobile Update","Aadhaar eKYC PVC Print","RAP Registration",
    "Darshan Booking","Bus Ticket Booking","Flight Tickets","Life Insurance"};
    String[] Copy=new String[] {"सॉफ्ट कॉपी","हार्ड कॉपी","दोन्ही"};
    Spinner sp1,sp2;
    Button btnsned;
    EditText Name,ContactEmail,Appointment;
    String username,Subject,dCopy,mAppointment;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maha_eseva_form);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        sp1=(Spinner)findViewById(R.id.spinnerservices);
        sp2=(Spinner)findViewById(R.id.spinnercopy);
        btnsned=(Button)findViewById(R.id.btnsend);
        Name=(EditText)findViewById(R.id.edittextappname);
        ContactEmail=(EditText)findViewById(R.id.editTextTextPersonName2);
        Appointment=(EditText)findViewById(R.id.editTextTextPersonName4);

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,Services);
        sp1.setAdapter(adapter);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapter1=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,Copy);
        sp2.setAdapter(adapter1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        btnsned.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                sendEmail();

                /*Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                try {
                    // Explicitly only use Gmail to send
                    emailIntent.setClassName("com.google.android.gm",
                            "com.google.android.gm.ComposeActivityGmail");
                    emailIntent.setType("text/html");
                    // Add the recipients
                    if (email != null)
                        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
                                new String[] { email });
                    if (Subject != null)
                        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
                                Subject);
                    if (msg != null)
                        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, Html.fromHtml(String.valueOf(body)));
                        startActivity(emailIntent);
                    //          myContext.startActivity(emailIntent);
                } catch (Exception e) {
                    emailIntent.setType("text/html");
                    // Add the recipients
                    if (email != null)
                        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
                                new String[] { email });
                    if (Subject != null)
                        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
                                Subject);
                    if (msg != null)
                        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, Html.fromHtml(String.valueOf(body)));
                    //          myContext.startActivity(Intent.createChooser(emailIntent,
                    //                  "Share Via"));
                    startActivity(emailIntent);
                }*/

                /*email.putExtra(Intent.EXTRA_EMAIL,new String[]{"swapnilbhuite888@gmail.com"});
                email.putExtra(Intent.EXTRA_SUBJECT,Subject);
                email.putExtra(Intent.EXTRA_TEXT,msg);
                email.setType("message/rfc822");
                try {
                    if(username.isEmpty() && mAppointment.isEmpty())
                        Toast.makeText(MahaEsevaFormActivity.this,"Please Fill Complete Form",Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(MahaEsevaFormActivity.this,"Application Send to Center",Toast.LENGTH_LONG).show();
                }
                catch (android.content.ActivityNotFoundException e) {
                    Toast.makeText(MahaEsevaFormActivity.this, "No email", Toast.LENGTH_SHORT).show();
                }*/


                /*Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto","swapnilbhuite888@gmail.com", null));
                intent.putExtra(Intent.EXTRA_SUBJECT, Subject);
                intent.putExtra(Intent.EXTRA_TEXT, msg);
                startActivity(Intent.createChooser(intent, "Choose an Email client :"));*/
            }
        });
    }

    private void sendEmail()
    {
        username=Name.getText().toString();
        mAppointment=Appointment.getText().toString();
        Subject=sp1.getSelectedItem().toString();
        dCopy=sp2.getSelectedItem().toString();
        String msg=username +" "+mAppointment+"" +dCopy;
        String email=ContactEmail.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SENDTO,Uri.fromParts("swapnilbhuite888@gmail.com",email,null));
        //intent.putExtra(Intent.EXTRA_EMAIL,email);
        intent.putExtra(Intent.EXTRA_SUBJECT, Subject);
        intent.putExtra(Intent.EXTRA_TEXT, msg);
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Choose an Email client :"));
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