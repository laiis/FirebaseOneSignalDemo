package tw.idv.laiis.firebaseonesignaldemo;

import android.app.Application;

import com.onesignal.OneSignal;

/**
 * Created by laiis on 2017/1/3.
 */

public class FOApplication extends Application {

    public static final String TAG = FOApplication.class.getName();

    @Override
    public void onCreate() {
        super.onCreate();
        initialOnesignal();
    }

    private void initialOnesignal() {
        // Logging set to help debug issues, remove before releasing your app.
        if (BuildConfig.DEBUG) {
            OneSignal.setLogLevel(OneSignal.LOG_LEVEL.DEBUG, OneSignal.LOG_LEVEL.WARN);
        }

        OneSignal.startInit(this)
                .setNotificationOpenedHandler(new FONotificationOpenedHandler())
                .setNotificationReceivedHandler(new FONotificationReceivedHandler())
                .autoPromptLocation(true)
                .init();
    }
}
