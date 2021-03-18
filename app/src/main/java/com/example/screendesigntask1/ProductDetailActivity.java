package com.example.screendesigntask1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ProductDetailActivity extends AppCompatActivity {
    ImageView topImageView;
    TextView name;
    private Animation animBlink,animation;
    private RelativeLayout bottomView,giftView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        topImageView = findViewById(R.id.topImageView);
        name = findViewById(R.id.name);
        bottomView = findViewById(R.id.bottomView);
        giftView = findViewById(R.id.giftView);
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();

        ProductData productData =
                (ProductData)bundle.getSerializable("data");
        if(productData != null)
        {
            bottomView.setVisibility(View.VISIBLE);
            animation = AnimationUtils.loadAnimation(getApplicationContext(),
                    R.anim.anim);
            animBlink = AnimationUtils.loadAnimation(getApplicationContext(),
                    R.anim.blink);
            topImageView.setImageResource(productData.getImagesUrl());
            bottomView.startAnimation(animation);
            giftView.startAnimation(animBlink);
            name.setText(productData.getProductName());
        }
    }
}