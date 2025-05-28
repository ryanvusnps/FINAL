package com.example.afinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class StudentAdapter extends ArrayAdapter<Student> {
    public StudentAdapter(Context context, List<Student> students) {
        super(context, 0, students);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Student student_mssv_0372 = getItem(position);

        TextView tvMSSV_mssv_0372 = convertView.findViewById(R.id.tvMSSV_mssv_0372);
        TextView tvName_mssv_0372 = convertView.findViewById(R.id.tvName_mssv_0372);
        TextView tvAvatar_mssv_0372 = convertView.findViewById(R.id.tvAvatar_mssv_0372);

        if (student_mssv_0372 != null) {
            tvMSSV_mssv_0372.setText(student_mssv_0372.getMssv());
            tvName_mssv_0372.setText(student_mssv_0372.getName());
            
            // Hiển thị chữ cái đầu của tên làm avatar
            String name = student_mssv_0372.getName();
            if (!name.isEmpty()) {
                String[] nameParts = name.split(" ");
                String initials = "";
                if (nameParts.length >= 2) {
                    initials = nameParts[0].substring(0, 1) + nameParts[nameParts.length - 1].substring(0, 1);
                } else {
                    initials = name.substring(0, Math.min(2, name.length()));
                }
                tvAvatar_mssv_0372.setText(initials.toUpperCase());
            }
        }

        return convertView;
    }
}