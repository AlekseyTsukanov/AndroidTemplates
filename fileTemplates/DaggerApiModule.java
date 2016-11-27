package ${PACKAGE_NAME};


import com.acukanov.rocketmetrics.data.remote.RocketApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module(includes = {RetrofitModule.class})
public class ${NAME} {

    // RocketApi is an interface with remote methods to use with retrofit2
    @Provides
    @Singleton
    public RocketApi provideRocketApi(Retrofit retrofit) {
        return retrofit.create(RocketApi.class);
    }
}
