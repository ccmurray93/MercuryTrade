package com.mercury.platform.core.utils;

import com.mercury.platform.shared.CachedFilesUtils;
import com.mercury.platform.shared.events.EventRouter;
import com.mercury.platform.shared.events.custom.FileChangeEvent;
import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

import java.io.File;

/**
 * Exslims
 * 08.12.2016
 */
public class FileMonitor {
    private static final long POLLING_INTERVAL = 100;
    public FileMonitor() {
        File folder = new File(CachedFilesUtils.getGamePath() + File.separator + "logs");

        FileAlterationObserver observer = new FileAlterationObserver(folder);
        FileAlterationMonitor monitor = new FileAlterationMonitor(POLLING_INTERVAL);
        FileAlterationListener listener = new FileAlterationListenerAdaptor(){
            @Override
            public void onFileChange(File file) {
                if (file.getAbsolutePath().contains("Client.txt")) {
                    EventRouter.fireEvent(new FileChangeEvent());
                }
            }
        };

        observer.addListener(listener);
        monitor.addObserver(observer);
        try {
            monitor.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
