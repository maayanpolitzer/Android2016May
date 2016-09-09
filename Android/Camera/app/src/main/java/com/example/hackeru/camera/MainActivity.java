package com.example.hackeru.camera;

import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private Camera camera;
    private FrameLayout frameLayout;
    private Button takePhotoBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
        takePhotoBtn = (Button) findViewById(R.id.takePhotoBtn);

    }

    @Override
    protected void onResume() {
        super.onResume();
        // connect to the camera...
        camera = getCameraInstance();
        if(camera != null){
            Log.d("TAG", "OK");
            CameraPreview preview = new CameraPreview(this, camera, takePhotoBtn);
            frameLayout.addView(preview);   // CameraPreview class is extending View class so we can add view to it.
        }else{
            Log.d("TAG", "null");
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        // release the camera...
        if (camera != null){
            camera.release();
        }
    }

    private Camera getCameraInstance(){
        Camera c = null;
        try{
            c = Camera.open();
        }catch(Exception e){
            // there is a problem connecting to the camera... (e).
            Log.d("TAG", "problem " + e);
        }
        return c;
    }

}














