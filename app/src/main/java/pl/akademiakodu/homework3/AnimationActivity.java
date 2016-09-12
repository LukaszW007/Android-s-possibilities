package pl.akademiakodu.homework3;

import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AnimationActivity extends AppCompatActivity {
    @BindView(R.id.image)public ImageView image;
    @BindView(R.id.layout)public RelativeLayout layout;

    public static int RUN_ANIMATION =1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        ButterKnife.bind(this);

        final AnimationDrawable animation = (AnimationDrawable) layout.getBackground();




        Handler handler = new Handler(new Handler.Callback(){
            @Override
            public boolean handleMessage (Message msg){
                switch (msg.what){
                    case 1: {
                        animation.start();
                        break;
                    }
                    case 2: {
                        animation.stop();
                        break;
                    }
                }return false;
            }
        });
        handler.sendEmptyMessageDelayed(1,5000);
        handler.sendEmptyMessageDelayed(2,15000);

       /* new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                animation.start();
            }
        },5000);*/

    }
}
