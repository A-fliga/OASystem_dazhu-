package org.oasystem.application;

import android.app.Application;
import android.content.Context;


import com.tencent.smtt.sdk.QbSdk;

import org.oasystem.utils.FontsUtils;

import static org.oasystem.constants.Constants.CORE_INIT;


/**
 * Created by www on 2018/12/27.
 */

public class MyApplication extends Application {
    private static Context context;
    private static MyApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        FontsUtils.setDefaultFont(this, "serif", "fonts/mstypeface.ttf");
        context = getApplicationContext();
        application = this;
        //增加这句话
        QbSdk.initX5Environment(this, new QbSdk.PreInitCallback() {
            @Override
            public void onCoreInitFinished() {
                CORE_INIT = true;
            }

            @Override
            public void onViewInitFinished(boolean b) {

            }
        });
    }

    public static Context getContext() {
        return context;
    }

    public static MyApplication getAppContext() {
        return application;
    }
}
