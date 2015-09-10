package com.elitecore.andsfparsing.utility;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

/*public class AlarmReceiver extends BroadcastReceiver {

    public void onRecieve(Context context, Intent intent)
    {

    }
}*/

public class RefreshService extends Service {
    public RefreshService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    public int onStartCommand(Intent intent, int flags, int startId){
          final BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

            }
        };
        return START_STICKY;
    }
}
