package com.example.setudnyanapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.Html;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import javax.mail.Message;
import javax.mail.MessageAware;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

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
        sp1= findViewById(R.id.spinnerservices);
        sp2= findViewById(R.id.spinnercopy);
        btnsned= findViewById(R.id.btnsend);
        Name= findViewById(R.id.edittextappname);
        ContactEmail= findViewById(R.id.editTextTextPersonName2);
        Appointment= findViewById(R.id.editTextTextPersonName4);

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
                final String username="swapnilbhuite1893@gmail.com";
                final String password="#Password123#";
                String receiverEmail="swapnilbhuite888@gmail.com";
                Subject=sp1.getSelectedItem().toString();
                final String applicantName=Name.getText().toString();
                mAppointment=Appointment.getText().toString();
                dCopy=sp2.getSelectedItem().toString();
                final String msg=dCopy;
                String email=ContactEmail.getText().toString();
                Properties pros=new Properties();
                pros.put("mail.smtp.auth",true);
                pros.put("mail.smtp.starttls.enable",true);
                pros.put("mail.smtp.host","smtp.gmail.com");
                pros.put("mail.smtp.port",587);
                Session session=Session.getInstance(pros, new javax.mail.Authenticator(){
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication()
                        {
                            return new PasswordAuthentication(username,password);
                        }
                        });
                try {
                    Message message=new MimeMessage(session);
                    message.setFrom(new InternetAddress(username));
                    message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(receiverEmail));
                    message.setSubject(Subject);
                    message.setText(msg);
                    Transport.send(message);
                    Toast.makeText(MahaEsevaFormActivity.this,"Email Send Successfully",Toast.LENGTH_LONG).show();
                }
                catch (MessagingException e)
                {
                    throw new RuntimeException(e);
                }
            }
        });
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }
    /*private void sendEmail()
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
    }*/
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