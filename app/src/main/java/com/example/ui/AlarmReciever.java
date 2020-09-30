package com.example.ui;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.widget.Toast;

public class AlarmReciever extends BroadcastReceiver {

    private int mID;

    @Override
    public void onReceive(Context context, Intent intent) {

        int notificationid = intent.getIntExtra("notificationid", mID);
        String msg = intent.getStringExtra("massege");
        String num = intent.getStringExtra("phone");

        mID = intent.getIntExtra(MessageEntry.EXTRA_ID,-1);

        Intent mainintent = new Intent(context, MessageEntry.class);
        final PendingIntent contenetintent = PendingIntent.getActivity(context, mID, mainintent, PendingIntent.FLAG_ONE_SHOT);

        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(num, null, msg, null, null);


        String result = " ";
        if (msg.isEmpty() || num.isEmpty()) {
            return;
        } else {
            switch (getResultCode()) {
                case Activity.RESULT_OK:
                    result = " massege has sent";
                    break;
                case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                    result = "Generic failure";
                    break;
                case SmsManager.RESULT_ERROR_NO_SERVICE:
                    result = "No service";
                    break;
                case SmsManager.RESULT_ERROR_NULL_PDU:
                    result = "Null PDU";
                    break;
                case SmsManager.RESULT_ERROR_RADIO_OFF:
                    result = "Radio off";
                    break;
                case SmsManager.RESULT_CANCELLED:
                    result = "Massage Was Cancelled";
                    break;
                default:
                    NotificationManager notificationManager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
                    Notification.Builder builder = new Notification.Builder(context);
                    builder.setSmallIcon(R.drawable.ic_baseline_notifications_24)
                            .setContentTitle("Massage sent ")
                            .setContentText(msg)
                            .setWhen(System.currentTimeMillis())
                            .setAutoCancel(true)
                            .setContentIntent(contenetintent);
                    notificationManager.notify(notificationid, builder.build());

            }
            Toast.makeText(context, result, Toast.LENGTH_SHORT).show();

            // TODO transfer the data from scheduled to logs

            // TODO delete the data from scheduled

        }


    }

}
