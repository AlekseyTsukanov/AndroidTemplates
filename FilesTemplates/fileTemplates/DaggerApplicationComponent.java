package ${PACKAGE_NAME};


import android.content.Context;

import com.acukanov.rocketmetrics.data.DataManager;
import com.acukanov.rocketmetrics.injection.module.ApiModule;
import com.acukanov.rocketmetrics.injection.module.ContextModule;
import com.acukanov.rocketmetrics.injection.module.EventBusModule;
import com.acukanov.rocketmetrics.ui.main.MainActivity;
import com.acukanov.rocketmetrics.ui.main.MainPresenter;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ContextModule.class, EventBusModule.class, ApiModule.class})
public interface ${NAME} {
    Context getContext();
    EventBus getEventBus();
    DataManager getDataManager();

    void inject(MainActivity mainActivity);
    void inject(MainPresenter mainPresenter);

    /*void inject(ConnectionFragment connectionFragment);
    void inject(ConnectionPresenter connectionPresenter);*/
}
