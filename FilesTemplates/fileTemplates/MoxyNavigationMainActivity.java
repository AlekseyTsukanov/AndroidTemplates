package ${PACKAGE_NAME};


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;

import com.acukanov.rocketmetrics.R;
import com.acukanov.rocketmetrics.RocketApp;
import com.acukanov.rocketmetrics.ui.base.BaseActivity;
import com.acukanov.rocketmetrics.utils.ActivityCommon;
import com.acukanov.rocketmetrics.utils.LogUtils;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ${NAME} extends BaseActivity implements IMainView {
    private static final String LOG_TAG = LogUtils.makeLogTag(${NAME}.class);
    public static final String INSTANCE_STATE_FRAGMENT_KEY = "instance_state_fragment_key";
    @InjectPresenter MainPresenter mPresenter;
    @BindView(R.id.toolbar) Toolbar mToolbar;
    @BindView(R.id.navigation_view) NavigationView mNavigationView;
    @BindView(R.id.drawer) DrawerLayout mDrawerLayout;
    private View mHeaderView;

    private FragmentManager mFragmentManager;
    private Fragment mFragment;

    public static void startActivity(Activity activity, Fragment fragment) {
        Intent startIntent = new Intent(activity, ${NAME}.class);
        startIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        if (fragment != null) {
            fragment.startActivity(startIntent);
        } else {
            activity.startActivity(startIntent);
        }
        activity.overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RocketApp.getAppComponent().inject(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        ActivityCommon.setHomeAsUp(this);

        mFragmentManager = getSupportFragmentManager();
        if (savedInstanceState != null) {
            if (mFragmentManager.getFragment(savedInstanceState, INSTANCE_STATE_FRAGMENT_KEY) == null) {
                //mFragment = ApplicationsFragment.newInstance();
            } else {
                //mFragment = mFragmentManager.getFragment(savedInstanceState, INSTANCE_STATE_FRAGMENT_KEY);
            }
        } else {
            //mFragment = ApplicationsFragment.newInstance();
        }
        /*mFragmentManager.beginTransaction()
                .replace(R.id.main_content, mFragment)
                .commit();*/

        mHeaderView = LayoutInflater.from(this).inflate(R.layout.partial_drawer_header, null);
        mNavigationView.addHeaderView(mHeaderView);

        mNavigationView.setNavigationItemSelectedListener((menuItem) -> {
            if (menuItem.isChecked()) {
                menuItem.setChecked(false);
            } else {
                menuItem.setChecked(true);
            }
            mDrawerLayout.closeDrawers();
            switch (menuItem.getItemId()) {
                case R.id.menu_drawer_test1:
                    //mFragment = ApplicationsFragment.newInstance();
                    //mPresenter.navigationItemSelected(mFragment);
                    break;
                case R.id.menu_drawer_test2:
                    break;
            }
            return true;
        });

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,
                mDrawerLayout,
                mToolbar,
                R.string.res_menu_drawer_open,
                R.string.res_menu_drawer_close) {

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        mDrawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mFragment.isAdded()) {
            getSupportFragmentManager().putFragment(outState, INSTANCE_STATE_FRAGMENT_KEY, mFragment);
        }
    }

    @Override
    public void onNavigationItemSelected(Fragment fragment) {
        if (fragment != null) {
            mFragmentManager.beginTransaction()
                    .replace(R.id.main_content, fragment)
                    .commit();
        }
    }
}
