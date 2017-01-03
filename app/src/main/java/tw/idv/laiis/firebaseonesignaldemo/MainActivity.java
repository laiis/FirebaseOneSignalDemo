package tw.idv.laiis.firebaseonesignaldemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static boolean activityStarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initial();
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
}
