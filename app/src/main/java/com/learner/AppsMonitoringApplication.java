package com.learner;

import android.app.Application;

import com.learner.accessibility.MonitoringAppLifecycleCallbacks;

/**
 * Monitors the Apps used by the User during Lifetime of
 * this Application
 * <p>
 * Developer: Rishabh Dutt Sharma
 * Dated: 5/24/2017.
 */
public class AppsMonitoringApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Checks if the Device is Installed NEW_APIS
        if (Utils.isNewApi())
            /* {@link MonitoringAppLifecycleCallbacks} ensures that
             * {@link com.learner.accessibility.AppsMonitoringService}
             * knows the Launch and End of this Application, so that it
             * sends the Broadcasts only when they're required. */
            registerActivityLifecycleCallbacks(new MonitoringAppLifecycleCallbacks());
    }
}
