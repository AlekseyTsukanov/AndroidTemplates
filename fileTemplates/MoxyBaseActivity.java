package ${PACKAGE_NAME};


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.MvpDelegate;

public class ${NAME} extends AppCompatActivity {
    private MvpDelegate<? extends MvpAppCompatActivity> mMvpDelegate;

    public ${NAME}() {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getMvpDelegate().onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.getMvpDelegate().onDetach();
        if(this.isFinishing()) {
            this.getMvpDelegate().onDestroy();
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        this.getMvpDelegate().onSaveInstanceState(outState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.getMvpDelegate().onAttach();
    }

    public MvpDelegate getMvpDelegate() {
        if(this.mMvpDelegate == null) {
            this.mMvpDelegate = new MvpDelegate(this);
        }
        return this.mMvpDelegate;
    }
}
