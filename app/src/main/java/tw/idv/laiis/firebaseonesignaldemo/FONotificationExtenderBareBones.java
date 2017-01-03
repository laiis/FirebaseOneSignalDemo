package tw.idv.laiis.firebaseonesignaldemo;

import android.util.Log;

import com.onesignal.NotificationExtenderService;
import com.onesignal.OSNotificationReceivedResult;

/**
 * Created by laiis on 2017/1/3.
 */

public class FONotificationExtenderBareBones extends NotificationExtenderService {
    @Override
    protected boolean onNotificationProcessing(OSNotificationReceivedResult receivedResult) {
        Log.i(FOApplication.TAG, "onNotificationProcessing ");
        // Read properties from result.

        // Return true to stop the notification from displaying.

        return false;
    }
}
