package com.da08.component;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {
//    public static final String NOTI = "noti";

    @Override
    public void onReceive(Context context, Intent intent) {
        context.startActivity(new Intent(context,BlurActivity.class));   // 뒤에 먼저 하고있던 앱은 onPause 상태가 됨 (youtube 는 이번에 새로 업그레이드 되어서 백단에서 돌아가기때문에 적용이 안 됨)
//        context.startActivity(new Intent(context,MainActivity.class));
//        switch (intent.getAction()){
//            case Intent.ACTION_BATTERY_CHANGED:  // 배터리에 변경이 생겼을 경우 br이 반응을 확인하고 시작
//                MyService.startMyService(context);  // 내가 어떤 서비스를 시작할건지 명확해 짐
//                break;
//            case MyReceiver.NOTI:
//                context.startActivity(new Intent(MainActivity.class.getName()));
//        }
    }
}
