package com.example.intentservice;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

public class MessageRecieved extends ResultReceiver {
    private MainActivity.Message message;
    public MessageRecieved(MainActivity.Message message) {
        super(new Handler());
        this.message=message;
    }

    @Override
    protected void onReceiveResult(int resultCode, Bundle resultData) {
        super.onReceiveResult(resultCode, resultData);
        message.displayMessage(resultCode,resultData);
    }
}
