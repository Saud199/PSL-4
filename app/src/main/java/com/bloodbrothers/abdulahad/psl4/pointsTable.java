package com.bloodbrothers.abdulahad.psl4;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class pointsTable extends AppCompatActivity {

    TextView iplay,iwon,ilost,itie,irunrate,ipoints,
             kplay,kwon,klost,ktie,krunrate,kpoints,
             lplay,lwon,llost,ltie,lrunrate,lpoints,
             mplay,mwon,mlost,mtie,mrunrate,mpoints,
             pplay,pwon,plost,ptie,prunrate,ppoints,
             qplay,qwon,qlost,qtie,qrunrate,qpoints;

    ProgressDialog mProgressDialog;

    public AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points_table);

        MobileAds.initialize(this,"ca-app-pub-6134982693737903~8334469609");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mProgressDialog = new ProgressDialog(this);

        iplay = (TextView) findViewById(R.id.iplayed);
        iwon = (TextView) findViewById(R.id.iwon);
        ilost = (TextView) findViewById(R.id.ilost);
        itie = (TextView) findViewById(R.id.itie);
        irunrate = (TextView) findViewById(R.id.irate);
        ipoints = (TextView) findViewById(R.id.ipoints);

        kplay = (TextView) findViewById(R.id.kplayed);
        kwon = (TextView) findViewById(R.id.kwon);
        klost = (TextView) findViewById(R.id.klost);
        ktie = (TextView) findViewById(R.id.ktie);
        krunrate = (TextView) findViewById(R.id.krate);
        kpoints = (TextView) findViewById(R.id.kpoints);

        lplay = (TextView) findViewById(R.id.lplayed);
        lwon = (TextView) findViewById(R.id.lwon);
        llost = (TextView) findViewById(R.id.llost);
        ltie = (TextView) findViewById(R.id.ltie);
        lrunrate = (TextView) findViewById(R.id.lrate);
        lpoints = (TextView) findViewById(R.id.lpoints);

        mplay = (TextView) findViewById(R.id.mplayed);
        mwon = (TextView) findViewById(R.id.mwon);
        mlost = (TextView) findViewById(R.id.mlost);
        mtie = (TextView) findViewById(R.id.mtie);
        mrunrate = (TextView) findViewById(R.id.mrate);
        mpoints = (TextView) findViewById(R.id.mpoints);

        pplay = (TextView) findViewById(R.id.pplayed);
        pwon = (TextView) findViewById(R.id.pwon);
        plost = (TextView) findViewById(R.id.plost);
        ptie = (TextView) findViewById(R.id.ptie);
        prunrate = (TextView) findViewById(R.id.prate);
        ppoints = (TextView) findViewById(R.id.ppoints);

        qplay = (TextView) findViewById(R.id.qplayed);
        qwon = (TextView) findViewById(R.id.qwon);
        qlost = (TextView) findViewById(R.id.qlost);
        qtie = (TextView) findViewById(R.id.qtie);
        qrunrate = (TextView) findViewById(R.id.qrate);
        qpoints = (TextView) findViewById(R.id.qpoints);

        mProgressDialog.setTitle("Please Wait");
        mProgressDialog.setMessage("Fetching Points...");
        mProgressDialog.show();


        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Points").child("Islamabad");

        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                String IL = String.valueOf(dataSnapshot.child("Lost").getValue());
                String IP = String.valueOf(dataSnapshot.child("Played").getValue());
                String IPts = String.valueOf(dataSnapshot.child("Points").getValue());
                String IRr = String.valueOf(dataSnapshot.child("RunRate").getValue());
                String IT = String.valueOf(dataSnapshot.child("Tie").getValue());
                String IW = String.valueOf(dataSnapshot.child("Won").getValue());

                iplay.setText(""+IP);
                iwon.setText(""+IW);
                ilost.setText(""+IL);
                itie.setText(""+IT);
                irunrate.setText(""+IRr);
                ipoints.setText(""+IPts);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {}

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {}

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {}

            @Override
            public void onCancelled(DatabaseError databaseError) {
                mProgressDialog.dismiss();
                Toast.makeText(pointsTable.this ,"Unable to fetch points" , Toast.LENGTH_SHORT).show();
            }
        });

        DatabaseReference kref = FirebaseDatabase.getInstance().getReference("Points").child("Karachi");

        kref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                String KL = String.valueOf(dataSnapshot.child("Lost").getValue());
                String KP = String.valueOf(dataSnapshot.child("Played").getValue());
                String KPts = String.valueOf(dataSnapshot.child("Points").getValue());
                String KRr = String.valueOf(dataSnapshot.child("RunRate").getValue());
                String KT = String.valueOf(dataSnapshot.child("Tie").getValue());
                String KW = String.valueOf(dataSnapshot.child("Won").getValue());

                kplay.setText(""+KP);
                kwon.setText(""+KW);
                klost.setText(""+KL);
                ktie.setText(""+KT);
                krunrate.setText(""+KRr);
                kpoints.setText(""+KPts);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                mProgressDialog.dismiss();
                Toast.makeText(pointsTable.this ,"Unable to fetch points" , Toast.LENGTH_SHORT).show();
            }
        });

        DatabaseReference lref = FirebaseDatabase.getInstance().getReference("Points").child("Lahore");

        lref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                String LL = String.valueOf(dataSnapshot.child("Lost").getValue());
                String LP = String.valueOf(dataSnapshot.child("Played").getValue());
                String LPts = String.valueOf(dataSnapshot.child("Points").getValue());
                String LRr = String.valueOf(dataSnapshot.child("RunRate").getValue());
                String LT = String.valueOf(dataSnapshot.child("Tie").getValue());
                String LW = String.valueOf(dataSnapshot.child("Won").getValue());

                lplay.setText(""+LP);
                lwon.setText(""+LW);
                llost.setText(""+LL);
                ltie.setText(""+LT);
                lrunrate.setText(""+LRr);
                lpoints.setText(""+LPts);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                mProgressDialog.dismiss();
                Toast.makeText(pointsTable.this ,"Unable to fetch points" , Toast.LENGTH_SHORT).show();
            }
        });

        DatabaseReference mref = FirebaseDatabase.getInstance().getReference("Points").child("Multan");

        mref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                String ML = String.valueOf(dataSnapshot.child("Lost").getValue());
                String MP = String.valueOf(dataSnapshot.child("Played").getValue());
                String MPts = String.valueOf(dataSnapshot.child("Points").getValue());
                String MRr = String.valueOf(dataSnapshot.child("RunRate").getValue());
                String MT = String.valueOf(dataSnapshot.child("Tie").getValue());
                String MW = String.valueOf(dataSnapshot.child("Won").getValue());

                mplay.setText(""+MP);
                mwon.setText(""+MW);
                mlost.setText(""+ML);
                mtie.setText(""+MT);
                mrunrate.setText(""+MRr);
                mpoints.setText(""+MPts);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                mProgressDialog.dismiss();
                Toast.makeText(pointsTable.this ,"Unable to fetch points" , Toast.LENGTH_SHORT).show();
            }
        });

        DatabaseReference pref = FirebaseDatabase.getInstance().getReference("Points").child("Peshawar");

        pref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                String PL = String.valueOf(dataSnapshot.child("Lost").getValue());
                String PP = String.valueOf(dataSnapshot.child("Played").getValue());
                String PPts = String.valueOf(dataSnapshot.child("Points").getValue());
                String PRr = String.valueOf(dataSnapshot.child("RunRate").getValue());
                String PT = String.valueOf(dataSnapshot.child("Tie").getValue());
                String PW = String.valueOf(dataSnapshot.child("Won").getValue());

                pplay.setText(""+PP);
                pwon.setText(""+PW);
                plost.setText(""+PL);
                ptie.setText(""+PT);
                prunrate.setText(""+PRr);
                ppoints.setText(""+PPts);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                mProgressDialog.dismiss();
                Toast.makeText(pointsTable.this ,"Unable to fetch points" , Toast.LENGTH_SHORT).show();
            }
        });

        DatabaseReference qref = FirebaseDatabase.getInstance().getReference("Points").child("Quetta");

        qref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                String QL = String.valueOf(dataSnapshot.child("Lost").getValue());
                String QP = String.valueOf(dataSnapshot.child("Played").getValue());
                String QPts = String.valueOf(dataSnapshot.child("Points").getValue());
                String QRr = String.valueOf(dataSnapshot.child("RunRate").getValue());
                String QT = String.valueOf(dataSnapshot.child("Tie").getValue());
                String QW = String.valueOf(dataSnapshot.child("Won").getValue());

                qplay.setText(""+QP);
                qwon.setText(""+QW);
                qlost.setText(""+QL);
                qtie.setText(""+QT);
                qrunrate.setText(""+QRr);
                qpoints.setText(""+QPts);

                mProgressDialog.dismiss();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                mProgressDialog.dismiss();
                Toast.makeText(pointsTable.this ,"Unable to fetch points" , Toast.LENGTH_SHORT).show();
            }
        });



    }

}

