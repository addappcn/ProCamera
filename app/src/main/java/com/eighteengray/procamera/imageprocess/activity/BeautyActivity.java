package com.eighteengray.procamera.imageprocess.activity;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;

import com.eighteengray.commonlibrary.BaseActivity;
import com.eighteengray.procamera.R;
import com.eighteengray.procameralibrary.common.Constants;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class BeautyActivity extends BaseActivity
{
    @BindView(R.id.iv_beauty)
    ImageView iv_beauty;
    private Drawable drawable;
    private Bitmap bitmap = null;
    String path;
    int width;


    Handler handler = new Handler()
    {
        @Override
        public void handleMessage(Message msg)
        {
            super.handleMessage(msg);
            switch (msg.what)
            {
                case Constants.CUTPIC:
                    Intent mIntent = new Intent();
                    mIntent.putExtra(Constants.CROPIMAGEPATH, path);
                    setResult(RESULT_OK, mIntent);
                    finish();
                    break;

                default:
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);


        /*width = ScreenUtils.getScreenWidth(BeautyActivity.this);
        path = getIntent().getStringExtra(Constants.CROPIMAGEPATH);
        bitmap = ImageUtils.getBitmapFromPathSimple(path);
        drawable = new BitmapDrawable(bitmap);*/

        btn_right.setVisibility(View.VISIBLE);

        Bitmap bitmap = ((BitmapDrawable) getResources().getDrawable(R.mipmap.album_black_24dp)).getBitmap();
        int w = bitmap.getWidth(), h = bitmap.getHeight();
        int[] pix = new int[w * h];
        bitmap.getPixels(pix, 0, w, 0, 0, w, h);
//        int [] resultPixes=ImageProcessJni.gray(pix,w,h);
//        Bitmap result = Bitmap.createBitmap(w,h, Bitmap.Config.RGB_565);
//        result.setPixels(resultPixes, 0, w, 0, 0,w, h);
//        iv_beauty.setImageBitmap(result);
    }

    @Override
    public int getLayoutResId()
    {
        return R.layout.aty_beauty;
    }


    @OnClick({R.id.btn_right})
    public void click(View view)
    {
        switch (view.getId())
        {
            case R.id.btn_right:
                new Thread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                       /* Bitmap cutBitmap = mCropImage.getCropImage();
                        File file = FileUtils.createFile(SDCardUtils.getAppFile(BeautyActivity.this).getAbsolutePath(), "cutBitmap.jpg");
                        path = file.getAbsolutePath();
                        ImageUtils.saveBitmap2Album(BeautyActivity.this, cutBitmap);
                        handler.sendEmptyMessage(Constants.CUTPIC);*/
                    }
                }).start();
                break;

            default:
                break;
        }
    }


}
