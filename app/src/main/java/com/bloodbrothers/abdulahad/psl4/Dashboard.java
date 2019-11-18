package com.bloodbrothers.abdulahad.psl4;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class Dashboard extends AppCompatActivity {

    public AdView mAdView;

    public InterstitialAd interstitialAd1,interstitialAd2,interstitialAd4;
    ViewFlipper viewFlipper;
    Button schedule_match, stadium_info, score, prev_champ, All_teams, rate_us, points_table;


    int gallery_grid_Images[] = {R.drawable.bg_image1, R.drawable.bg_image2, R.drawable.bg_image3, R.drawable.bg_image4};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        schedule_match = (Button) findViewById(R.id.id_matchSchedule);
        stadium_info = (Button) findViewById(R.id.id_stadiumDetail);
        score = (Button) findViewById(R.id.id_liveScore);
        prev_champ = (Button) findViewById(R.id.id_previousChamp);
        All_teams = (Button) findViewById(R.id.id_allTeam);
        rate_us = (Button) findViewById(R.id.id_rateus);
        points_table = (Button) findViewById(R.id.id_pointTable);

        viewFlipper = (ViewFlipper) findViewById(R.id.flipper);

        MobileAds.initialize(this,"ca-app-pub-6134982693737903~8334469609");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        interstitialAd1 = new InterstitialAd(this);
        interstitialAd1.setAdUnitId("ca-app-pub-6134982693737903/2998382443");
        interstitialAd1.loadAd(new AdRequest.Builder().build());
        interstitialAd1.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                Intent i = new Intent(Dashboard.this, Schedule.class);
                startActivity(i);
                interstitialAd1.loadAd(new AdRequest.Builder().build());

            }
        });

        interstitialAd2 = new InterstitialAd(this);
        interstitialAd2.setAdUnitId("ca-app-pub-6134982693737903/1081577805");
        interstitialAd2.loadAd(new AdRequest.Builder().build());
        interstitialAd2.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                Intent i = new Intent(Dashboard.this, liveScore.class);
                startActivity(i);
                interstitialAd2.loadAd(new AdRequest.Builder().build());

            }
        });


        interstitialAd4 = new InterstitialAd(this);
        interstitialAd4.setAdUnitId("ca-app-pub-6134982693737903/1600452558");
        interstitialAd4.loadAd(new AdRequest.Builder().build());
        interstitialAd4.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                Intent i = new Intent(Dashboard.this, stadiumDetails.class);
                startActivity(i);
                interstitialAd4.loadAd(new AdRequest.Builder().build());

            }
        });


        schedule_match.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Intent i = new Intent(Dashboard.this, Schedule.class);
//                startActivity(i);

                if (interstitialAd1.isLoaded()) {
                    interstitialAd1.show();
                } else {
                    Intent i = new Intent(Dashboard.this, Schedule.class);
                    startActivity(i);
                }

            }
        });


        stadium_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Intent i = new Intent(Dashboard.this, stadiumDetails.class);
//                startActivity(i);
                if (interstitialAd4.isLoaded()) {
                    interstitialAd4.show();
                } else {
                    Intent i = new Intent(Dashboard.this, stadiumDetails.class);
                    startActivity(i);
                }
            }
        });


        score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isNetworkConnected()==true){
//                    Intent i = new Intent(Dashboard.this, liveScore.class);
//                    startActivity(i);
                    if (interstitialAd2.isLoaded()) {
                        interstitialAd2.show();
                    } else {
                        Intent i = new Intent(Dashboard.this, liveScore.class);
                        startActivity(i);
                    }
                }else{
                    Toast.makeText(Dashboard.this , "Connect to Internet to Continue" , Toast.LENGTH_SHORT).show();
                }


            }
        });


        prev_champ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Dashboard.this, previousChamps.class);
                startActivity(i);

            }
        });

        points_table.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isNetworkConnected()==true){
                    Intent i = new Intent(Dashboard.this, pointsTable.class);
                    startActivity(i);
                }else{
                    Toast.makeText(Dashboard.this , "Connect to Internet to Continue" , Toast.LENGTH_SHORT).show();
                }

            }
        });


        All_teams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isNetworkConnected()==true){
                    Intent i = new Intent(Dashboard.this, AllTeams.class);
                    startActivity(i);
                }else{
                    Toast.makeText(Dashboard.this , "Connect to Internet to Continue" , Toast.LENGTH_SHORT).show();
                }



            }
        });



        rate_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                    Intent rateIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getPackageName()));
                    startActivity(rateIntent);
                }catch (Exception e){
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id="+getPackageName())));
                }

            }
        });


        for (int i = 0; i < gallery_grid_Images.length; i++) {
            setFlipperImage(gallery_grid_Images[i]);
        }

    }

    void setFlipperImage(int res) {
        ImageView image = new ImageView(getApplicationContext());
        image.setBackgroundResource(res);
        viewFlipper.addView(image);
        viewFlipper.startFlipping();

    }


    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }
}