package com.example.ui;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.telephony.SmsManager;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.lifecycle.ViewModelProviders;

import com.example.ui.Activity.MessageEntry;
import com.example.ui.Database.LogDB.AddNewViewmodelLog;


public class AlarmReciever extends BroadcastReceiver {

    private int mID;
    String contact;
    String massege;

    BroadcastReceiver smsSentReceiver;
    PendingIntent sentPI;
    String SENT="SMS_SENT";

    private AddNewViewmodelLog addNewViewmodellog;


    @Override
    public void onReceive(Context context, Intent intent) {

        int notificationid = intent.getIntExtra("notificationid", mID);
        String msg = intent.getStringExtra("massege");
        String num = intent.getStringExtra("phone");

        mID = intent.getIntExtra(MessageEntry.EXTRA_ID,-1);
        contact = intent.getStringExtra(MessageEntry.EXTRA_TITLE);
        massege = intent.getStringExtra(MessageEntry.EXTRA_MESSAGE);

        Intent mainintent = new Intent(context, MessageEntry.class);
        final PendingIntent contenetintent = PendingIntent.getActivity(context, mID, mainintent, PendingIntent.FLAG_NO_CREATE);
        sentPI=PendingIntent.getBroadcast(context,0,new Intent(SENT),0);


        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(num, null, msg, null, null);

        String result = "Check your scheduled massege";
        if (msg.isEmpty() || num.isEmpty()) {
            return;
        }
        else {
            smsSentReceiver = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    switch (getResultCode()) {
                        case Activity.RESULT_OK:
                            Toast.makeText(context, "SMS sent", Toast.LENGTH_SHORT).show();
                            // sendSMS(null);
                            break;
                        case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                            Toast.makeText(context, "Generic Failure", Toast.LENGTH_SHORT).show();
                            break;
                        case SmsManager.RESULT_ERROR_NO_SERVICE:
                            Toast.makeText(context, "No Service", Toast.LENGTH_SHORT).show();
                            break;
                        case SmsManager.RESULT_ERROR_NULL_PDU:
                            Toast.makeText(context, "Null PDU", Toast.LENGTH_SHORT).show();
                            break;
                        case SmsManager.RESULT_ERROR_RADIO_OFF:
                            Toast.makeText(context, "Radio off", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }};
            context.registerReceiver(smsSentReceiver,new IntentFilter(SENT));
        }

        Toast.makeText(context, result, Toast.LENGTH_SHORT).show();
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context,"channelid")
                    .setSmallIcon(R.drawable.ic_baseline_notifications_24)
                    .setContentTitle(result)
                    .setContentText(msg)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);

            NotificationManagerCompat notificationManager =NotificationManagerCompat.from(context);
            notificationManager.notify(notificationid, builder.build());

            // TODO transfer the data from scheduled to logs
            // addNewViewmodellog= ViewModelProviders.of(contenetintent).get( AddNewViewmodelLog.class );

            //            Logs_list Done = new Logs_list(contact,massege);
            //            addNewViewmodellog.insert(Done);
            // TODO delete the data from scheduled

        }

    }

