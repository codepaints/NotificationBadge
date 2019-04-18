package com.codepaints.notificationbadge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MenuItem menuItem;
    // badge text view
    TextView badgeCounter;
    // change the number to see badge in action
    int pendingNotifications = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_notification, menu);

        menuItem = menu.findItem(R.id.nav_notification);

        // check if any pending notification
        if (pendingNotifications == 0) {
            // if no pending notification remove badge
            menuItem.setActionView(null);
        } else {

            // if notification than set the badge icon layout
            menuItem.setActionView(R.layout.notification_badge);
            // get the view from the nav item
            View view = menuItem.getActionView();
            // get the text view of the action view for the nav item
            badgeCounter = view.findViewById(R.id.badge_counter);
            // set the pending notifications value
            badgeCounter.setText(String.valueOf(pendingNotifications));
        }

        return super.onCreateOptionsMenu(menu);
    }
}
