package com.lcw.demo.imagepicker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.lcw.library.imagepicker.ImagePicker;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_SELECT_IMAGES_CODE = 0x01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.bt_select_images).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.getInstance().setImageLoader(new GlideLoader()).saveState(true).showCamera(true).setMaxCount(9).start(MainActivity.this, REQUEST_SELECT_IMAGES_CODE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SELECT_IMAGES_CODE && resultCode == RESULT_OK) {
            Toast.makeText(this, data.getStringArrayListExtra(ImagePicker.EXTRA_RESULT).toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
