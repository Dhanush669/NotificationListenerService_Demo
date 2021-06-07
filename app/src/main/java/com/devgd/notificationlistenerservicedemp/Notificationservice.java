package com.devgd.notificationlistenerservicedemp;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;

import androidx.core.app.NotificationCompat;

public class Notificationservice extends NotificationListenerService {
    String result ="";
    //Triggered when listenerservice is connected
    @Override
    public void onListenerConnected() {
        super.onListenerConnected();

        Log.i("NotificationListener","Connected");

    }

    //Triggered when service is started
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.i("NotificationListener","Started");
        return super.onStartCommand(intent, flags, startId);
    }

    //Triggered when notification is posted or removed
    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        super.onNotificationPosted(sbn);

        Notification notification=sbn.getNotification();
        Bundle bundle=notification.extras;
        try {
            String title = bundle.getString(NotificationCompat.EXTRA_TITLE);
            String message = bundle.getString(NotificationCompat.EXTRA_TEXT);
            Log.i("notificaion",message);
            MainActivity.textView.setText(result);
            result+="Title :"+title+"\n";
            result+="Message :"+message+"\n";
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    //Triggered when listenerservice is disconnected
    @Override
    public void onListenerDisconnected() {
        super.onListenerDisconnected();
        Log.i("NotificationListener","disConnected");

    }


}
