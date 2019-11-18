package com.bloodbrothers.abdulahad.psl4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class AllTeams extends AppCompatActivity {

    public AdView mAdView;

    static String TeamName;

    int K = R.drawable.karachi;
    int I = R.drawable.islamabad;
    int M = R.drawable.multan;
    int L = R.drawable.lahore;
    int Q = R.drawable.quetta;
    int P = R.drawable.peshawar;


    String k = "Karachi Kings" , l="Lahore Qalandars" , i = "Islamabad United" , q="Quetta Gladiators" , p="Peshawar Zalmi" , m="Multan Sultans" , tbd="TBD" ;

    int images[]= {I , K , L , M , P , Q };

    String teams[] = {i , k ,l , m , p , q};

    String name[] = {"Islamabad" , "Karachi" , "Lahore" , "Multan" , "Peshawar" , "Quetta"};

    ListView listView;
    ImageView imageView1;
    TextView textView1;
    Button btn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_teams);

        MobileAds.initialize(this,"ca-app-pub-6134982693737903~8334469609");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        listView=(ListView)findViewById(R.id.listviewteam);

        CustomAdapter customAdapter=new CustomAdapter();
        listView.setAdapter(customAdapter);

    }


    class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return images.length;
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

            view=getLayoutInflater().inflate(R.layout.teamslayout,null);

            imageView1=(ImageView)view.findViewById(R.id.timage);
            textView1=(TextView)view.findViewById(R.id.tname);
            btn=(Button) view.findViewById(R.id.tdetail);


            imageView1.setImageResource(images[i]);
            textView1.setText(teams[i]);


            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TeamName = name[i];
                    Intent i = new Intent(AllTeams.this , playerProfile.class);
                    startActivity(i);
                }
            });

            return view;
        }
    }

}
