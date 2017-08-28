# Component
###### Service
```java
public static void startMyService(Context context){
        context.startService(new Intent(MyService.class.getName()));
    }
```
###### broadcastReceiver 
```java
public class MyReceiver extends BroadcastReceiver {
    public static final String NOTI = "noti";

    @Override
    public void onReceive(Context context, Intent intent) {
        switch (intent.getAction()){
            case Intent.ACTION_BATTERY_CHANGED:  // 배터리에 변경이 생겼을 경우 br이 반응을 확인하고 시작
                MyService.startMyService(context);  // 내가 어떤 서비스를 시작할건지 명확해 짐
                break;
            case MyReceiver.NOTI:
                context.startActivity(new Intent(MainActivity.class.getName()));
        }
    }
}
```
###### AlarmManager
```java
AlarmManager am = (AlarmManager) view.getContext().getSystemService(ALARM_SERVICE);
                PendingIntent pi = PendingIntent.getBroadcast(view.getContext(),0,new Intent(view.getContext(),MyReceiver.class),0);
                am.set(AlarmManager.ELAPSED_REALTIME,15000,pi);
                finish();
```

###### Transparent activity 
- res안에 아래 <style> 추가
```xml
<style name="Theme.Transparent" parent="Theme.AppCompat.Light.NoActionBar">
        <item name="android:windowBackground">@android:color/transparent</item>
        <item name="android:colorBackgroundCacheHint">@null</item>
        <item name="android:windowIsTranslucent">true</item>
        <item name="android:windowAnimationStyle">@android:style/Animation</item>
        <item name="android:windowNoTitle">true</item>
        <item name="android:windowContentOverlay">@null</item>
        <item name="android:backgroundDimEnabled">true</item>
        <item name="android:windowFullscreen">true</item>
    </style>
```
> backgroundDimEnabled 가 true면 반투명 false면 투명

- manifests > AndroidManifest.xml
```java
<activity android:name="해당엑티비티"
    android:theme="@style/Theme.Transparent"></activity>
```

- 투명창으로 보이게할 Layout의 배경 background를 transparent 로 지정
```xml
// 첫번째 방법
android:background="@android:color/transparent"
// 두번째 방법
android:background="#00000000"
```

---
> 배터리 변동 체크
```xml
<intent-filter>
                <action android:name="android.intent.action.BATTERY_CHANGED" />
</intent-filter>
```
