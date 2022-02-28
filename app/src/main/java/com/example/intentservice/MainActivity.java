package com.example.intentservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    public AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MessageRecieved recieved=new MessageRecieved(new Message());

        Intent intent=new Intent(MainActivity.this,timer_service.class);
        intent.putExtra("timer",10);
        intent.putExtra("reciever",recieved);
        startService(intent);
    }

    public class Message{
        public void displayMessage(int resultCode, Bundle resultData){
            String message=resultData.getString("message");
            Toast.makeText(MainActivity.this, resultCode+" "+message, Toast.LENGTH_SHORT).show();
        }
    }

    public void med(){

        MobileAds.initialize(this, "ca-app-pub-6866381333968774~1256987606");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                super.onAdClosed();
            }

            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
            }

            @Override
            public void onAdLeftApplication() {
                super.onAdLeftApplication();
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
            }

            @Override
            public void onAdClicked() {
                super.onAdClicked();
            }
        });
    }
}
