package com.example.a_fandy.traditionalfood;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailActivity extends AppCompatActivity {
    TextView tvName;
    TextView tvRemarks;
    TextView tvDeskripsi;
    ImageView imgPhoto;

    public static final String EXTRA_REMARKS = "extra_remaks";
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_DESKRIPSI = "extra_deskripsi";
    public static final String EXTRA_IMG = "extra_img";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvName = findViewById(R.id.tv_item_name);
        tvRemarks = findViewById(R.id.tv_item_remarks);
        tvDeskripsi = findViewById(R.id.tv_item_deskripsi);
        imgPhoto = findViewById(R.id.img_item_photo);

        String name = getIntent().getStringExtra(EXTRA_NAME);
        String remarks = getIntent().getStringExtra(EXTRA_REMARKS);
        String img = getIntent().getStringExtra(EXTRA_IMG);
        String deskripsi = getIntent().getStringExtra(EXTRA_DESKRIPSI);

        tvName.setText(name);
        tvRemarks.setText(remarks);
        Glide.with(this)
                .load(img)
                .apply(new RequestOptions().override(55, 55))
                .into(imgPhoto);

        tvDeskripsi.setText(deskripsi);


    }
}
