package com.da08.component;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button button = new Button(this);
        setContentView(button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlarmManager am = (AlarmManager) view.getContext().getSystemService(ALARM_SERVICE);
                PendingIntent pi = PendingIntent.getBroadcast(view.getContext(),0,new Intent(view.getContext(),MyReceiver.class),0);
                am.set(AlarmManager.ELAPSED_REALTIME,15000,pi);
                finish();
            }
        });
//        getBaseContext().registerReceiver(new MyBroadcastReceiver(),new IntentFilter(" my signal"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        getBaseContext().unregisterReceiver();
    }

    // 뷰만 다시 불러오는거라 성능 향상에 좋음
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
//    class MyBroadcastReceiver extends BroadcastReceiver{
//        @Override
//        public void onReceive(Context context, Intent intent) {
//
//        }
//    }
}
