package com.bloodbrothers.abdulahad.psl4;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.squareup.picasso.Picasso;

public class playerCompleteDetail extends AppCompatActivity {

    ImageView imageView1 , imageView2 ;
    TextView textView1;

    public AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_complete_detail);

        textView1 = (TextView)findViewById(R.id.pctext);
        imageView1=(ImageView)findViewById(R.id.pcimage);
        imageView2=(ImageView)findViewById(R.id.dcimage);

        MobileAds.initialize(this,"ca-app-pub-6134982693737903~8334469609");

        mAdView = findViewById(R.id.adView7);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        textView1.setText(""+playerProfile.txt1);
        Picasso.get().load(playerProfile.img1).into(imageView1);
        Picasso.get().load(playerProfile.img2).into(imageView2);

    }
}
