package io.arabot.hazelcastspringbootpoc.services;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import io.arabot.hazelcastspringbootpoc.models.Student;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@CacheConfig(cacheNames = StudentService.STUDENTS)
public class StudentService {

    public List<Student> students = new ArrayList<>();
    public static final String STUDENTS = "students";
    private final HazelcastInstance hazelcastInstance;

    public StudentService(HazelcastInstance hazelcastInstance) {
        this.hazelcastInstance = hazelcastInstance;
    }

    @Cacheable(cacheNames = STUDENTS, key = "#studentId", sync = true)
    public Student getStudents(Integer studentId) {
        IMap<Integer, Student> map = hazelcastInstance.getMap(STUDENTS);
        return map.get(studentId);
    }

    @CachePut(cacheNames = STUDENTS)
    public void updateStudent(Student student,Integer studentId){
        IMap<Integer, Student> map = hazelcastInstance.getMap(STUDENTS);
        map.put(map.get(studentId).getId(),student);
    }

    @CachePut(cacheNames = STUDENTS, key = "#student.firstname")
    public void addStudent(Student student){
        IMap<Integer, Student> map = hazelcastInstance.getMap(STUDENTS);
        map.put(student.getId(),student);
    }


}
