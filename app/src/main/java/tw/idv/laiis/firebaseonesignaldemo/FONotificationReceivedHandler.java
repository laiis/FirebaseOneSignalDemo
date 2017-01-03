package tw.idv.laiis.firebaseonesignaldemo;

import android.util.Log;

import com.onesignal.OSNotification;
import com.onesignal.OneSignal;

import org.json.JSONObject;

/**
 * Created by laiis on 2017/1/3.
 */

class FONotificationReceivedHandler implements OneSignal.NotificationReceivedHandler {
    @Override
    public void notificationReceived(OSNotification notification) {
        JSONObject data = notification.payload.additionalData;
        String customKey;

        if (data != null) {
            customKey = data.optString("customkey", null);
            if (customKey != null)
                Log.i(FOApplication.TAG, "customkey set with value: " + customKey);
        }
    }
}
