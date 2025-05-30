package com.example.afinal;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView_mssv_0372;
    private ArrayList<Student> studentList_mssv_0372;
    private ArrayList<Student> originalStudentList_mssv_0372; // Danh sách gốc
    private StudentAdapter adapter_mssv_0372;
    private EditText etSearch_mssv_0372; // Thêm EditText tìm kiếm

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView_mssv_0372 = findViewById(R.id.listView_mssv_0372);
        etSearch_mssv_0372 = findViewById(R.id.etSearch_mssv_0372); // Khởi tạo EditText
        studentList_mssv_0372 = new ArrayList<>();
        originalStudentList_mssv_0372 = new ArrayList<>();

        // Thêm dữ liệu từ danh sách
        studentList_mssv_0372.add(new Student("21200372", "Trần Nguyễn Tường Vũ", "Nhóm 26", "Computer Management", "Quản lý cửa hàng máy tính là ứng dụng được thiết kế để tối ưu hóa hoạt động cho cửa hàng bán máy tính, với các tính năng theo dõi hàng tồn kho, quản lý bán hàng và hỗ trợ khách hàng"));
        studentList_mssv_0372.add(new Student("21200065", "Trần Anh Dũng", "Nhóm 1", "Ứng dụng di động", "Ứng dụng quản lý sinh viên"));
        studentList_mssv_0372.add(new Student("21200192", "Nguyễn Ngọc Quang", "Nhóm 2", "Ứng dụng di động", "Ứng dụng quản lý sinh viên"));
        studentList_mssv_0372.add(new Student("21200014", "Nguyễn Hoàng Nguyên", "Nhóm 2", "Ứng dụng di động", "Ứng dụng quản lý sinh viên"));
        studentList_mssv_0372.add(new Student("21200247", "Trần Quốc Trung", "Nhóm 3", "Ứng dụng di động", "Ứng dụng quản lý sinh viên"));
        studentList_mssv_0372.add(new Student("21200328", "Lê Ngọc Long", "Nhóm 4", "Ứng dụng quản lý", "Ứng dụng quản lý nhóm"));
        studentList_mssv_0372.add(new Student("21200310", "Nguyễn Đăng Duy Mạnh", "Nhóm 5", "Ứng dụng quản lý", "Ứng dụng quản lý nhóm"));
        studentList_mssv_0372.add(new Student("21200374", "Mai Thị Cẩm Lý", "Nhóm 6", "Ứng dụng quản lý", "Ứng dụng quản lý nhóm"));
        studentList_mssv_0372.add(new Student("21200298", "Phạm Hoàng Khải", "Nhóm 6", "Ứng dụng quản lý", "Ứng dụng quản lý nhóm"));
        studentList_mssv_0372.add(new Student("21200307", "Võ Thị Len", "Nhóm 7", "Ứng dụng quản lý", "Ứng dụng quản lý nhóm"));
        studentList_mssv_0372.add(new Student("21200302", "Nguyễn Hồ Tuấn Kiệt", "Nhóm 7", "Ứng dụng quản lý", "Ứng dụng quản lý nhóm"));
        studentList_mssv_0372.add(new Student("21200348", "Võ Tấn Tài", "Nhóm 8", "Ứng dụng quản lý", "Ứng dụng quản lý nhóm"));
        studentList_mssv_0372.add(new Student("21200272", "Nguyễn Đức Việt Bình", "Nhóm 8", "Ứng dụng quản lý", "Ứng dụng quản lý nhóm"));
        studentList_mssv_0372.add(new Student("21200271", "Đặng Nhật Bình", "Nhóm 9", "Ứng dụng quản lý", "Ứng dụng quản lý nhóm"));
        studentList_mssv_0372.add(new Student("21200370", "Trần Quốc Việt", "Nhóm 9", "Ứng dụng quản lý", "Ứng dụng quản lý nhóm"));
        studentList_mssv_0372.add(new Student("21200249", "Hoàng Hữu Tứ", "Nhóm 9", "Ứng dụng quản lý", "Ứng dụng quản lý nhóm"));

        // Lưu danh sách gốc
        originalStudentList_mssv_0372.addAll(studentList_mssv_0372);

        adapter_mssv_0372 = new StudentAdapter(this, studentList_mssv_0372);
        listView_mssv_0372.setAdapter(adapter_mssv_0372);

        // Thiết lập chức năng tìm kiếm
        setupSearchFunction();

        listView_mssv_0372.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent_mssv_0372 = new Intent(MainActivity.this, DetailActivity.class);
            intent_mssv_0372.putExtra("student", studentList_mssv_0372.get(position));
            startActivity(intent_mssv_0372);
        });
    }
    
    private void setupSearchFunction() {
        etSearch_mssv_0372.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterStudents(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

        private void filterStudents(String query) {
        studentList_mssv_0372.clear();
        
        if (query.isEmpty()) {
            // Nếu không có từ khóa tìm kiếm, hiển thị tất cả
            studentList_mssv_0372.addAll(originalStudentList_mssv_0372);
        } else {
            // Lọc theo MSSV hoặc tên
            String lowercaseQuery = query.toLowerCase().trim();
            for (Student student : originalStudentList_mssv_0372) {
                if (student.getMssv().toLowerCase().contains(lowercaseQuery) || 
                    student.getName().toLowerCase().contains(lowercaseQuery)) {
                    studentList_mssv_0372.add(student);
                }
            }
        }
        
        adapter_mssv_0372.notifyDataSetChanged();
    }
}