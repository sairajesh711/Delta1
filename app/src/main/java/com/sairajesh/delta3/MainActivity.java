package com.sairajesh.delta3;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {
    int Clickcount=0;
    private int restore;
    int index=0;
    final private static String COUNT = "count";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RelativeLayout Lay = (RelativeLayout)findViewById(R.id.Layout);
        Lay.setBackgroundColor(Color.YELLOW);

        Button clickit =  (Button) findViewById(R.id.Clickbutton);
        final String[] value= getResources().getStringArray(R.array.colorcodes);

        clickit.setOnClickListener(
            new Button.OnClickListener(){
                public void onClick(View v){
                    TextView Texts = (TextView)findViewById(R.id.Text);
                    Clickcount++;
                    Texts.setText("Button clicks="+Clickcount);
                    if(index<=21){
                    String newvalue= value[index++];
                    Lay.setBackgroundColor(Color.parseColor(newvalue));}
                    else
                    {index=0;
                    String newvalue= value[index++];
                    Lay.setBackgroundColor(Color.parseColor(newvalue));}
                }

            }
        );
        Button Resetit = (Button)findViewById(R.id.Reset);
        Resetit.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        TextView Tex = (TextView)findViewById(R.id.Text);
                        Clickcount=0;
                        Tex.setText("Button clicks=0");


                    }
                }



        );}
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(COUNT, Clickcount);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        restore =  savedInstanceState.getInt(COUNT);

        Clickcount=restore;
        TextView te = (TextView)findViewById(R.id.Text);
        te.setText("Button clicks=" + restore);


        super.onRestoreInstanceState(savedInstanceState);
    }
}
