package io.arabot.hazelcastspringbootpoc.beans;

import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.StreamSerializer;
import io.arabot.hazelcastspringbootpoc.models.Student;

import java.io.IOException;


public class StudentSerializer implements StreamSerializer<Student> {

    @Override
    public int getTypeId() {
      return Student.serialVersionUID;
    }

    @Override
    public void write(ObjectDataOutput out, Student student) throws IOException {
        out.writeInt(student.getId());
        out.writeString(student.getFirstname());
        out.writeString(student.getLastname());
    }

    @Override
    public Student read(ObjectDataInput objectDataInput) throws IOException {
        Student student = new Student();
        student.setId(objectDataInput.readInt());
        student.setFirstname(objectDataInput.readString());
        student.setLastname(objectDataInput.readString());
        return student;
    }
}