package ${PACKAGE_NAME};


import android.app.Application;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

import ${PACKAGE_NAME}.injection.component.ApplicationComponent;
import ${PACKAGE_NAME}.injection.component.DaggerApplicationComponent;
import ${PACKAGE_NAME}.injection.module.ContextModule;

import butterknife.ButterKnife;

public class ${NAME} extends Application {
    private static ApplicationComponent sApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        ButterKnife.setDebug(true);
        sApplicationComponent = DaggerApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
    }

    public static ApplicationComponent getAppComponent() {
        return sApplicationComponent;
    }

    @VisibleForTesting
    public static void setAppComponent(@NonNull ApplicationComponent appComponent) {
        sApplicationComponent = appComponent;
    }
}
