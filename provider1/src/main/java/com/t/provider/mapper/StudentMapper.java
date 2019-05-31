package com.t.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.t.model.Student;

public interface StudentMapper extends BaseMapper<Student> {
    Long insertStudent(Student student);
}
