package ${PACKAGE_NAME};


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;

import com.acukanov.rocketmetrics.R;
import com.acukanov.rocketmetrics.ui.base.BaseActivity;
import com.acukanov.rocketmetrics.utils.ActivityCommon;
import com.acukanov.rocketmetrics.utils.LogUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ${NAME} extends BaseActivity {
    private static final String LOG_TAG = LogUtils.makeLogTag(${NAME}.class);
    @BindView(R.id.toolbar) Toolbar mToolbar;

    public static void startActivity(Activity activity, Fragment fragment) {
        Intent intent = new Intent(activity, ${NAME}.class);
        if (fragment != null) {
            fragment.startActivity(intent);
        } else {
            activity.startActivity(intent);
        }
        activity.overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        ButterKnife.bind(this);
        ActivityCommon.setUpActionBarToolbar(this, mToolbar).setNavigationOnClickListener(l -> {
            onBackPressed();
        });
        ActivityCommon.setHomeAsUp(this);
        /*getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_content, MyFragment.newInstance())
                .commit();*/
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
    }
}
