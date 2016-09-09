package com.example.hackeru.camera;

import android.content.Context;
import android.hardware.Camera;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hackeru on 9/5/2016.
 */
public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback, Camera.PictureCallback, Camera.PreviewCallback {

    private final Camera CAMERA;
    private SurfaceHolder holder;
    private Context context;

    public CameraPreview(Context context, Camera camera, Button btn){
        super(context);

        CAMERA = camera;
        holder = getHolder();
        holder.addCallback(this);
        /*
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                CAMERA.takePicture(null, CameraPreview.this, CameraPreview.this);
            }
        });
        */
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        try {
            CAMERA.setPreviewDisplay(holder);
            CAMERA.startPreview();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        if (holder == null){
            return;
        }
        CAMERA.stopPreview();
        changeParams();
        CAMERA.setPreviewCallback(this);
        try {
            CAMERA.setPreviewDisplay(holder);
        } catch (IOException e) {
            e.printStackTrace();
        }
        CAMERA.startPreview();
    }

    private void changeParams(){
        Camera.Parameters params = CAMERA.getParameters();
        List<Camera.Size> sizeList = params.getSupportedPictureSizes();

        /*
        for (Camera.Size s : sizeList){
            Log.d("TAG", "width: " + s.width + ", height: " + s.height);
        }
        */

        Log.d("TAG", params.getPictureSize().width + "," + params.getPictureSize().height);
        Log.d("TAG", params.getWhiteBalance() + "");
        Log.d("TAG", params.getJpegQuality() + "");

        params.setPictureSize(sizeList.get(0).width, sizeList.get(0).height);

        CAMERA.setParameters(params);   // save changes.

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }


    @Override
    public void onPictureTaken(byte[] data, Camera camera) {
        Toast.makeText(context, "CHEEZE", Toast.LENGTH_SHORT).show();
    }

    private int counter = 0;

    @Override
    public void onPreviewFrame(byte[] data, Camera camera) {
        //Log.d("TAG", "frame: " + ++counter);
    }
}
