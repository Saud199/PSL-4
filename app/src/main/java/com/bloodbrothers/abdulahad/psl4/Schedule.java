package com.bloodbrothers.abdulahad.psl4;

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

public class Schedule extends AppCompatActivity {
    int K = R.drawable.karachi;
    int I = R.drawable.islamabad;
    int M = R.drawable.multan;
    int L = R.drawable.lahore;
    int Q = R.drawable.quetta;
    int P = R.drawable.peshawar;

    int T = R.drawable.champ;

    String k = "Karachi Kings" , l="Lahore Qalandars" , i = "Islamabad United" , q="Quetta Gladiators" , p="Peshawar Zalmi" , m="Multan Sultans" , tbd="TBD" ;


    int images[]= {I , M , P , I , L , I , P , Q , P , M , I , Q , I , P , Q , M , L , K , M , K , P , M , Q , K , L , Q , K , L , K , L , T , T , T , T };
    int images2[]={L , K , Q , M , K , Q , L , M , K , L , P , L , K , M , K , I , Q , I , P , L , I , Q , P , M , P , I , P , I , Q , M , T , T , T , T };

    String match[]={ "1st Match (14 Feb)" , "2nd Match (15 Feb)" , "3rd Match (15 Feb)" , "4th Match (16 Feb)" , "5th Match (16 Feb)" ,
                     "6th Match (17 Feb)" , "7th Match (17 Feb)" , "8th Match (20 Feb)" , "9th Match (21 Feb)" , "10th Match (22 Feb)" ,
                      "11th Match (22 Feb)" , "12th Match (23 Feb)" ,"13th Match (23 Feb)" ,"14th Match (24 Feb)" , "15th Match (24 Feb)" ,
                      "16th Match (26 Feb)" , "17th Match (27 Feb)" , "18th Match (27 Feb)" , "19th Match (28 Feb)" , "20th Match (28 Feb)" ,
                       "21st Match (1 Mar)" , "22nd Match (1 Mar)" , "23rd Match (4 Mar)" , "24th Match (4 Mar)" , "25th Match (5 Mar)" ,
                      "26th Match (5 Mar)" , "27th Match (7 Mar)" , "28th Match (9 Mar)" , "29th Match (10 Mar)" , "30th Match (10 Mar)" ,
                      "Eliminator - 1 (12 Mar)" , "Qualifier (13 Mar)" , "Eliminator - 2 (15 Mar)" , "Final (17 Mar)"
                    };

    String time[]={"10:00 PM (PST) , Dubai" , "4:30 PM (PST) , Dubai" , "9:00 PM (PST) , Dubai" , "4:30 PM (PST) , Dubai"  , "9:00 PM (PST) , Dubai" ,
                   "4:30 PM (PST) , Dubai" , "9:00 PM (PST) , Dubai" , "9:00 PM (PST) , Sharjah" , "9:00 PM (PST) , Sharjah" , "4:30 PM (PST) , Sharjah" ,
                    "9:00 PM (PST) , Sharjah" , "4:30 PM (PST) , Sharjah" , "9:00 PM (PST) , Sharjah" , "4:30 PM (PST) , Sharjah" , "9:00 PM (PST) , Sharjah" ,
                    "9:00 PM (PST) , Dubai" , "4:30 PM (PST) , Dubai" , "9:00 PM (PST) , Dubai" , "4:30 PM (PST) , Dubai" , "9:00 PM (PST) , Dubai" ,
                    "4:30 PM (PST) , Dubai" , "9:00 PM (PST) , Dubai" , "4:30 PM (PST) , Abu Dhabi" , "9:00 PM (PST) , Abu Dhabi" , "4:30 PM (PST) , Abu Dhabi"  ,
                    "9:00 PM (PST) , Abu Dhabi" , "9:00 PM (PST) , Karachi" , "9:00 PM (PST) , Lahore" , "4:30 PM (PST) , Karachi" , "9:00 PM (PST) , Lahore" ,
                    "9:00 PM (PST) , Lahore" , "9:00 PM (PST) , Lahore" , "9:00 PM (PST) , Karachi" , "9:00 PM (PST) , Karachi"
    };

    String teams[] = {i+" VS "+l , m+" VS "+k , p+" VS "+q , i+" VS "+m , l+" VS "+k , i+" VS "+q , p+" VS "+l , q+" VS "+m , p+" VS "+k , m+" VS "+l ,
                    i+" VS "+p , q+" VS "+l , i+" VS "+k , p+" VS "+m , q+" VS "+k , m+" VS "+i , l+" VS "+q , k+" VS "+i , m+" VS "+p , k+" VS "+l ,
                    p+" VS "+i , m+" VS "+q , q+" VS "+p , k+" VS "+m , l+" VS "+p , q+" VS "+i , k+" VS "+p , l+" VS "+i , k+" VS "+q , l+" VS "+m ,
                    tbd+" VS "+tbd , tbd+" VS "+tbd , tbd+" VS "+tbd , tbd+" VS "+tbd
    };

    ListView listView;
    ImageView imageView1 , imageView2;
    TextView textView1 , textView2 , textView3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        listView=(ListView)findViewById(R.id.listview);

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

            view=getLayoutInflater().inflate(R.layout.customlayout,null);

            imageView1=(ImageView)view.findViewById(R.id.img1);
            imageView2=(ImageView)view.findViewById(R.id.img2);
            textView1=(TextView)view.findViewById(R.id.txt1);
            textView2=(TextView)view.findViewById(R.id.txt2);
            textView3=(TextView)view.findViewById(R.id.txt3);




            imageView1.setImageResource(images[i]);
            imageView2.setImageResource(images2[i]);
            textView1.setText(match[i]);
            textView2.setText(time[i]);
            textView3.setText(teams[i]);


            return view;
        }
    }

}
