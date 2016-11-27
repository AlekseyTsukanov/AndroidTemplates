package ${PACKAGE_NAME};


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.MvpDelegate;

public class ${NAME} extends Fragment {
    private MvpDelegate<? extends MvpAppCompatFragment> mMvpDelegate;
    private Activity mActivity;

    public ${NAME}() {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity) {
            mActivity = (Activity) context;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getMvpDelegate().onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        this.getMvpDelegate().onAttach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        this.getMvpDelegate().onDetach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        boolean anyParentIsRemoving = false;

        for(Fragment parent = this.getParentFragment(); !anyParentIsRemoving && parent != null; parent = parent.getParentFragment()) {
            anyParentIsRemoving = parent.isRemoving();
        }

        if(this.isRemoving() || anyParentIsRemoving || this.getActivity().isFinishing()) {
            this.getMvpDelegate().onDestroy();
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        this.getMvpDelegate().onSaveInstanceState(outState);
    }

    public MvpDelegate getMvpDelegate() {
        if(this.mMvpDelegate == null) {
            this.mMvpDelegate = new MvpDelegate(this);
        }
        return this.mMvpDelegate;
    }

    public void setTitle(String title) {
        ActionBar actionBar = ((BaseActivity) mActivity).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(title);
        }
    }

    public void setTitle(@StringRes int resId) {
        setTitle(getActivity().getString(resId));
    }
}
