package com.bawei.liziyan20200401.util;

import android.widget.ImageView;

import com.bawei.liziyan20200401.App;
import com.bawei.liziyan20200401.R;
import com.bumptech.glide.Glide;

public class ImageUtil {
    private static ImageUtil instance;
    public ImageUtil() {}

    public static ImageUtil getInstance() {
        if (instance == null) {
            instance = new ImageUtil();
        }
        return instance;
    }

    public void getPictore(String path, ImageView imageView){
        Glide.with(App.context)
                .load(path)
                .circleCrop()
                .error(R.mipmap.ic_launcher)
                .into(imageView);
    }
}
