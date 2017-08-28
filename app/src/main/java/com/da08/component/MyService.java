package com.da08.component;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

// manifest 등록을 해 줘야 하기 때문에 new Service 나 상속받지 않고 메뉴를 통해서 만들어 줌
public class MyService extends Service {
    public static void startMyService(Context context){
        context.startService(new Intent(MyService.class.getName()));
    }
    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    /*
     bind 는 activity 에 달려있는 서비스 , 바인딩이되면 상호간 통신이 되는 상태
     다른 종류의 task 에서 돌 수 있음(하나의 앱인데 다른 task 라는 이유로 폰에서 지난 앱 사용을 볼때 두개가 뜸)
     bind 서비스는 서비스 죽인다고 죽지않음 -> 연관되어있는 액티비티 전부다 unbind 되고나서야 죽음
      */
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    /*
    독립적 , demon 서비스 , 잠금화면 만들기 ...
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
