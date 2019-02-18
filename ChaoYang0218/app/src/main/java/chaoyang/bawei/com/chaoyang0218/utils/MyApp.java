package chaoyang.bawei.com.chaoyang0218.utils;

import android.app.Application;
import android.media.MediaCas;
import android.os.storage.StorageManager;

import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        File s = StorageUtils.getOwnCacheDirectory(getApplicationContext(),"/image*");
        ImageLoaderConfiguration build = new ImageLoaderConfiguration.Builder(this)
                .defaultDisplayImageOptions(opes())
                .diskCacheFileCount(100)
                .diskCacheSize(5*1024*1024)
                .diskCache(new UnlimitedDiskCache(s))
                .build();
        ImageLoader.getInstance().init(build);
    }

    private DisplayImageOptions opes() {
        return new DisplayImageOptions.Builder()
                .cacheOnDisk(true)
                .cacheInMemory(true)
                .build();
    }


}
