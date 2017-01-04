package tw.idv.laiis.firebaseonesignaldemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    private static boolean activityStarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initial();
    }

    @Override
    protected void onResume() {
        super.onResume();
        handleArguments();
    }

    private void handleArguments() {
        Bundle args = getIntent().getExtras();
        if (args != null) {
            String rawJson = args.getString("payload");
            try {
                JSONObject jsonObject = new JSONObject(rawJson);
                for (Iterator<String> iterator = jsonObject.keys(); iterator.hasNext(); ) {
                    String key = iterator.next();
                    Toast.makeText(MainActivity.this, "You recieve a gcm extra data: " + jsonObject.getString(key), Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                Log.e(MainActivity.class.getName(), " ---> error message: " + e.getMessage());
            }

        }
    }

    private void initial() {
        if (activityStarted
                && getIntent() != null
                && (getIntent().getFlags() & Intent.FLAG_ACTIVITY_REORDER_TO_FRONT) != 0) {
            finish();
            return;
        }

        activityStarted = true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        activityStarted = false;
    }
}
