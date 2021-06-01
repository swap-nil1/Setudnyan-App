package com.example.setudnyanapplication;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ImageSpan;
import android.view.MenuItem;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.google.android.material.navigation.NavigationView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import org.w3c.dom.Text;

import static com.example.setudnyanapplication.R.id.image;
import static com.example.setudnyanapplication.R.id.nav_certificate;


public class NavigationDrawerActivity2 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{

    private AppBarConfiguration mAppBarConfiguration;
    FragmentTransaction fragmentManager;
    NavigationView navigationView;
    FragmentTransaction ft;
    DrawerLayout drawer;
    ActionBarDrawerToggle toggle;
    Intent intent;
    TextView textView1;
    ViewFlipper vflip;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer2);
        Toolbar toolbar = findViewById(R.id.toolbar);
       /* ImageSpan is=new ImageSpan(NavigationDrawerActivity2.this, R.drawable.income_cert);
       // SpannableString text=new SpannableString("Income Certificate");
        textView1.setSpan(is,text.length()-2,text.length(),0);*/
        vflip=(ViewFlipper) findViewById(R.id.ViewFlipper);


        int images[]={R.drawable.pancard,R.drawable.aadhar2,R.drawable.income_cert
                ,R.drawable.mahadbt,R.drawable.maharashtrakrishivibhag,R.drawable.vidyalakshmilogo};
        for(int i=0;i<images.length;i++)
        {
            ViewFlippers(images[i]);
        }
        drawer = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    public void ViewFlippers(int images)
    {
        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(images);
        vflip.addView(imageView);
        vflip.setFlipInterval(5000);
        vflip.setAutoStart(true);
        vflip.setInAnimation(this, android.R.anim.slide_in_left);
        vflip.setOutAnimation(this, android.R.anim.slide_out_right);
        /*imageView.setClickable(true);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                final  int set=images;
                switch (set)
                {
                    case 0:
                    {
                        intent=new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent.setData(Uri.parse("https://www.pan.utiitsl.com"));
                        startActivity(intent);
                    }
                    case 1:
                    {
                        intent=new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent.setData(Uri.parse("https://uidai.gov.in"));
                        startActivity(intent);
                    }
                    case 2:
                    {
                        intent=new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent.setData(Uri.parse("https://aaplesarkar.mahaonline.gov.in"));
                        startActivity(intent);
                    }
                    case 4:
                    {
                        intent=new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent.setData(Uri.parse("https://mahadbtmahait.gov.in"));
                        startActivity(intent);
                    }
                }

            }
        });*/
    }
    @Override
    public  void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.navigation_drawer_activity2, menu);
        return true;
    }

   /* @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }*/
      @Override
      public void onBackPressed()
      {
          drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
          if (drawer.isDrawerOpen(GravityCompat.START))
          {
              drawer.closeDrawer(GravityCompat.START);
          } else {
              super.onBackPressed();
          }
      }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item)
    {
        /*android.support.v4.app.FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();*/
//        FragmentManager fm=getSupportFragmentManager();
//        ft=fm.beginTransaction();

        int id = item.getItemId();
        if(id==R.id.Log_out)
        {
            final AlertDialog.Builder buil;
            buil = new AlertDialog.Builder(this);
            buil.setMessage("Confirm want to Logout");
            buil.setCancelable(true);
            buil.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }

            }); buil.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
            AlertDialog builder=buil.create();
            builder.show();

        }
        else if(id== nav_certificate)
        {
            intent=new Intent(NavigationDrawerActivity2.this,CertificateActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.nav_govtportals)
        {
            intent=new Intent(NavigationDrawerActivity2.this,GovnmentPortalsActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.nav_govtscheme)
        {
            intent=new Intent(NavigationDrawerActivity2.this,GovnmentSchemeActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.nav_Contact_us)
        {
            intent=new Intent(NavigationDrawerActivity2.this,ContactUsActivity.class);
            startActivity(intent);
        }
        else if (id==R.id.nav_Feedback)
        {
            intent=new Intent(NavigationDrawerActivity2.this,FeedbackActivity.class);
            startActivity(intent);
        }
        else if (id==R.id.nav_custom)
        {
            intent=new Intent(NavigationDrawerActivity2.this,CustomServiceActivity.class);
            startActivity(intent);
        }
        /*switch (id)
        {
            case R.id.nav_home:{

                }break;
            case R.id.Contact_us:{
                //ft.replace(R.id.container,new ContactUsFragment());
                }break;
            case R.id.Log_out:
                {
                    final AlertDialog.Builder buil;
                    buil = new AlertDialog.Builder(this);
                    buil.setMessage("Confirm want to Logout");
                    buil.setCancelable(true);
                    buil.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }

                    }); buil.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                    AlertDialog builder=buil.create();
                    builder.show();

                }
        }*/
        //ft.commit();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if (id == R.id.option_menu)
        {
            final AlertDialog.Builder buil;
            buil = new AlertDialog.Builder(this);
            buil.setMessage("Confirm want to Logout");
            buil.setCancelable(true);
            buil.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialogInterface, int i)
                {
                    dialogInterface.cancel();
                }

            }); buil.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                intent=new Intent(NavigationDrawerActivity2.this,MainActivity.class);
                intent.putExtra("finish",true);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
            AlertDialog builder=buil.create();
            builder.show();
        }
        return super.onOptionsItemSelected(item);
    }
}
