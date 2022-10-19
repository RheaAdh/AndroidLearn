package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    String TAG="Main Activity";
    IntentFilter filter ;
    BroadcastReceiver receiver;
    
    private void createNotification(int value) {
        String channelId="package com.example.app2";
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId, "AirplaneMode", NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, channelId)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("AirplaneMode")
                .setContentText("Airplane Mode is set to " + (value == 0 ? "OFF" : "ON"));
        int notificationID=1;
        notificationManager.notify(notificationID,builder.build());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        filter=new IntentFilter("android.intent.action.AIRPLANE_MODE");
        receiver=new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int value= Settings.Global.getInt(context.getContentResolver(),Settings.Global.AIRPLANE_MODE_ON,0);
                createNotification(value);
                Log.d(TAG,"onReceive : "+String.valueOf(value));
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart : ");
        registerReceiver(receiver,filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop : ");
        unregisterReceiver(receiver);
    }
}

