package com.example.afinal;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView tvDetailMSSV_mssv_0372 = findViewById(R.id.tvDetailMSSV_mssv_0372);
        TextView tvDetailName_mssv_0372 = findViewById(R.id.tvDetailName_mssv_0372);
        TextView tvDetailGroup_mssv_0372 = findViewById(R.id.tvDetailGroup_mssv_0372);
        TextView tvDetailTopic_mssv_0372 = findViewById(R.id.tvDetailTopic_mssv_0372);
        TextView tvDetailDescription_mssv_0372 = findViewById(R.id.tvDetailDescription_mssv_0372);
        ImageView ivImage_mssv_0372 = findViewById(R.id.ivImage_mssv_0372);

        Student student_mssv_0372 = (Student) getIntent().getSerializableExtra("student");

        if (student_mssv_0372 != null) {
            tvDetailMSSV_mssv_0372.setText("MSSV: " + student_mssv_0372.getMssv());
            tvDetailName_mssv_0372.setText("Tên: " + student_mssv_0372.getName());
            tvDetailGroup_mssv_0372.setText("Tên nhóm: " + student_mssv_0372.getGroupName());
            tvDetailTopic_mssv_0372.setText("Đề tài: " + student_mssv_0372.getTopic());
            tvDetailDescription_mssv_0372.setText("Mô tả: " + student_mssv_0372.getDescription());
        }

        // Hình ảnh hiện tại để placeholder, bạn có thể thêm hình ảnh sau
    }
}