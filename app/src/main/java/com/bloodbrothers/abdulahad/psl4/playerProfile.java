package com.bloodbrothers.abdulahad.psl4;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class playerProfile extends AppCompatActivity {


    ListView listView;

    public AdView mAdView;

    ArrayList pimageArray =new ArrayList<String>();
    ArrayList dimageArray = new ArrayList<String>();
    ArrayList nameArray = new ArrayList<String>();

    ProgressDialog mProgressDialog;

    static String img1,img2,txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_profile);
        listView = (ListView)findViewById(R.id.listviewprofile);

        MobileAds.initialize(this,"ca-app-pub-6134982693737903~8334469609");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mProgressDialog = new ProgressDialog(this);


         mProgressDialog = new ProgressDialog(this);

        mProgressDialog.setTitle("Please Wait");
        mProgressDialog.setMessage("Fetching Player Details...");
        mProgressDialog.show();


        DatabaseReference ref= FirebaseDatabase.getInstance().getReference("Teams").child(""+AllTeams.TeamName);

        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {


                String name = String.valueOf(dataSnapshot.child("PlayerName").getValue());
                String profilepic = String.valueOf(dataSnapshot.child("ProfileURL").getValue());
                String Detailpic = String.valueOf(dataSnapshot.child("DetailURL").getValue());

                nameArray.add(name);
                pimageArray.add(profilepic);
                dimageArray.add(Detailpic);

                if(nameArray.size()>17){
                    mProgressDialog.dismiss();
                    CustomAdapter1 customAdapter=new CustomAdapter1();
                    listView.setAdapter(customAdapter);
                }

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {


            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                mProgressDialog.dismiss();
                Toast.makeText(playerProfile.this ,"Unable to fetch details" , Toast.LENGTH_SHORT).show();
            }
        });

    }


    class CustomAdapter1 extends BaseAdapter {
        @Override
        public int getCount() {
            return pimageArray.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {

            view=getLayoutInflater().inflate(R.layout.playerlayout,null);

            ImageView  imageView1=(ImageView)view.findViewById(R.id.pimage);
            TextView   textView=(TextView)view.findViewById(R.id.pname);
            Button  btn=(Button) view.findViewById(R.id.pprofile);


            String url = ""+pimageArray.get(i);

            textView.setText(""+nameArray.get(i));

             Picasso.get().load(url).into(imageView1);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    img1 = ""+pimageArray.get(i);
                    img2 = ""+dimageArray.get(i);
                    txt1 = ""+nameArray.get(i);

                    Intent i = new Intent(playerProfile.this , playerCompleteDetail.class);
                    startActivity(i);

                }
            });



            return view;
        }
    }




}



