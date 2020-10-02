package com.example.ui;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.ui.Activity.MessageEntry;
import com.example.ui.Database.LogDB.AddNewViewmodelLog;


public class AlarmReciever extends BroadcastReceiver {

    private int mID;
    String contact;
    String massege;

    private AddNewViewmodelLog addNewViewmodellog;


    @Override
    public void onReceive(Context context, Intent intent) {

        int notificationid = intent.getIntExtra("notificationid", 1);
        String msg = intent.getStringExtra("massege");
        String num = intent.getStringExtra("phone");

        mID = intent.getIntExtra(MessageEntry.EXTRA_ID,-1);
        contact = intent.getStringExtra(MessageEntry.EXTRA_TITLE);
        massege = intent.getStringExtra(MessageEntry.EXTRA_MESSAGE);

        Intent mainintent = new Intent(context, MessageEntry.class);
        final PendingIntent contenetintent = PendingIntent.getActivity(context, mID, mainintent, PendingIntent.	FLAG_IMMUTABLE);

        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(num, null, msg, null, null);


        String result = "Check your scheduled massege";
        if (msg.isEmpty() || num.isEmpty()) {
            return;
        }
        else {
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

            }
            Toast.makeText(context, result, Toast.LENGTH_SHORT).show();
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context,"channelid")
                    .setSmallIcon(R.drawable.ic_baseline_notifications_24)
                    .setContentTitle(result)
                    .setContentText(msg)
                    .setContentIntent(contenetintent)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);

            NotificationManagerCompat notificationManager =NotificationManagerCompat.from(context);
            notificationManager.notify(notificationid, builder.build());

            // TODO transfer the data from scheduled to logs
            // addNewViewmodellog= ViewModelProviders.of(activity).get( AddNewViewmodelLog.class );

            //            Logs_list Done = new Logs_list(contact,massege);
            //            addNewViewmodellog.insert(Done);
            // TODO delete the data from scheduled

        }

    }

}
