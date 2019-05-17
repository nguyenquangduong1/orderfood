package com.example.nguyenquangduong.totnghiep.Helper;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.Uri;
import android.os.Build;

import com.example.nguyenquangduong.totnghiep.R;

public class NotificationHelper extends ContextWrapper {

    private static final String EDMT_CHANEL_ID = "com.example.nguyenquangduong.totnghiep.EDMTDev";
    private static final String EDMT_CHANEL_NAME = "Eat It";

    private NotificationManager manager;

    public NotificationHelper(Context base){
        super(base);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
            createChanel();
    }

    @TargetApi(Build.VERSION_CODES.O)
    private void createChanel() {
        NotificationChannel edmtChannel = new NotificationChannel(EDMT_CHANEL_ID,EDMT_CHANEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT);
        edmtChannel.enableLights(false);
        edmtChannel.enableVibration(true);
        edmtChannel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
        getManager().createNotificationChannel(edmtChannel);
    }

    public NotificationManager getManager() {
     if (manager == null)
         manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
     return manager;

    }

    @TargetApi(Build.VERSION_CODES.O)
    public Notification.Builder getEatItChannelNotification(String title, String body, PendingIntent contentIntent,
                                                            Uri soundUri)
    {
        return new Notification.Builder(getApplicationContext(),EDMT_CHANEL_ID)
                .setContentIntent(contentIntent)
                .setContentTitle(title)
                .setContentText(body)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setSound(soundUri)
                .setAutoCancel(false);
    }
}
