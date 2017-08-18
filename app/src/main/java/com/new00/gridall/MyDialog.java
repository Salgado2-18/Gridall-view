package com.new00.gridall;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MyDialog extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_dialog);
        Intent intent=getIntent();
        if(intent!=null)
        {
            int imageid=intent.getIntExtra("countryImage",R.drawable.india);
            String countryName=intent.getStringExtra("countryName");
            ImageView myImage= (ImageView) findViewById(R.id.imageView2);
            myImage.setImageResource(imageid);
            TextView mycountry= (TextView) findViewById(R.id.textView2);
            mycountry.setText(countryName);
        }
    }
    public void closeDialog(View v){
        Log.d("Yash","dialogue box closes");
        finish();
    }
}
