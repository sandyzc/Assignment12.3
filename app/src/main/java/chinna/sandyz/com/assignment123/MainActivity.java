package chinna.sandyz.com.assignment123;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void sendNotification(View view) {
        String[] events = new String[6];

        events[0] = "Helloo..!";
        events[1] = "How are you?";
        events[2] = "HIII !!";
        events[3] = "i am fine...";
        events[4] = "what about you? all is well?";
        events[5] = "Yes, every thing is all right..";

        Bitmap icon1 = BitmapFactory.decodeResource(getResources(),
                R.mipmap.ic_launcher);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
                this).setAutoCancel(true)
                .setContentTitle("Inbox Style notification")
                .setSmallIcon(R.mipmap.ic_launcher).setLargeIcon(icon1)
                .setContentText("Hello World!");

        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();

        // Sets a title for the Inbox style big view
        inboxStyle.setBigContentTitle("Event Details");

        // Moves events into the big view
        for (int i = 0; i < events.length; i++) {

            inboxStyle.addLine(events[i]);
        }
        // Moves the big view style object into the notification object.
        mBuilder.setStyle(inboxStyle);

        // Creates an explicit intent for an Activity in your app
        Intent resultIntent = new Intent(this, Main2Activity.class);

        // The stack builder object will contain an artificial back stack for
        // the
        // started Activity.
        // This ensures that navigating backward from the Activity leads out of
        // your application to the Home screen.
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);

        // Adds the back stack for the Intent (but not the Intent itself)
        stackBuilder.addParentStack(Main2Activity.class);

        // Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,
                PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(resultPendingIntent);

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // mId allows you to update the notification later on.
        mNotificationManager.notify(100, mBuilder.build());
    }
}
