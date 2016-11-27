package ${PACKAGE_NAME};


import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class ${NAME} {

    public static Toolbar setUpActionBarToolbar(AppCompatActivity activity, int toolbarId) {
        Toolbar actionBarToolbar = (Toolbar) activity.findViewById(toolbarId);
        return setUpActionBarToolbar(activity, actionBarToolbar);
    }

    public static Toolbar setUpActionBarToolbar(AppCompatActivity activity, Toolbar toolbar) {
        if (toolbar != null) {
            activity.setSupportActionBar(toolbar);
        }
        return toolbar;
    }

    public static ActionBar setHomeAsUp(AppCompatActivity activity) {
        ActionBar actionBar = activity.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        return actionBar;
    }
}
