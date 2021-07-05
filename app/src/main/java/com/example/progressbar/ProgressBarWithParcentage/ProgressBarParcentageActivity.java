package com.example.progressbar.ProgressBarWithParcentage;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.progressbar.R;

public class ProgressBarParcentageActivity extends AppCompatActivity {


    int pStatus = 0;
    private Handler handler=new Handler();
     private TextView tv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar_parcentage);


        Resources resources=getResources();
        Drawable drawable=resources.getDrawable(R.drawable.circular);
        final ProgressBar mProgress= (ProgressBar) findViewById(R.id.circularProgressbar);
        mProgress.setProgress(0);   // Main Progress
        mProgress.setSecondaryProgress(100); // Secondary Progress
        mProgress.setMax(100); // Maximum Progress
        mProgress.setProgressDrawable(drawable);
        tv = (TextView) findViewById(R.id.tv);



       /* Resources res = getResources();
        Drawable drawable = res.getDrawable(R.drawable.circular);
        final ProgressBar mProgress = (ProgressBar) findViewById(R.id.circularProgressbar);
        mProgress.setProgress(0);   // Main Progress
        mProgress.setSecondaryProgress(100); // Secondary Progress
        mProgress.setMax(100); // Maximum Progress
        mProgress.setProgressDrawable(drawable);

        */
        ObjectAnimator animation = ObjectAnimator.ofInt(mProgress, "progress", 0, 100);
        animation.setDuration(10000);
        animation.setInterpolator(new DecelerateInterpolator());
        animation.start();


       new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (pStatus < 100) {
                    pStatus += 1;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            mProgress.setProgress(pStatus);
                            tv.setText(pStatus + "%");
                        }
                    });
                    try {
                        // Sleep for 200 milliseconds.
                        // Just to display the progress slowly
                        Thread.sleep(100 ); //thread will take approx 3 seconds to finish
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();



    }
}