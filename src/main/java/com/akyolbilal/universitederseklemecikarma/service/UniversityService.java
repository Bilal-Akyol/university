package com.akyolbilal.universitederseklemecikarma.service;

import com.akyolbilal.universitederseklemecikarma.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniversityService {
    private List<String>lessons=new ArrayList<>();
    private Map<Long, User> students = new HashMap<>();
    private Map<Long, User> teachers = new HashMap<>();

    public UniversityService()
    {
        lessons.add("Matematik");
        lessons.add("Nesnenin İnterneti");
        lessons.add("Veri yapıları");
        teachers.put(1L, new User(1L,"Serkan","Özaydın","TEACHER"));
        teachers.put(2L, new User(2L,"Turgut","Uyar","TEACHER"));
        students.put(7L,new User(7L,"Bilal","Akyol","STUDENT"));
        students.put(10L,new User(10L,"Anton","Çehov","STUDENT"));
    }
    public List<String> getLessons()
    {
        return lessons;
    }
    public void addLesson(String lesson)
    {
        lessons.add(lesson);
    }
    public void assignLesson(Long teacherId,Long studentId, String lessonsName)
    {
        User teacher = teachers.get(teacherId);
        User student = students.get(studentId);
        if (teacher != null && student != null && teacher.getRole().equals("TEACHER") && student.getRole().equals("STUDENT")) {
            System.out.println(teacher.getName()+" Öğretmen "+student.getId()+" Numaralı öğrencisine "+lessonsName+
                    " Adlı dersi atamıştır");
        } else {
            System.out.println("Öğretmen veya öğrenci bulunamadı veya yetkisiz işlem.");
        }
    }
    public void deleteLesson(Long teacherId, Long studentId, String lessonsName)
    {
        User teacher= teachers.get(teacherId);
        User student= students.get(studentId);
        if ((teacher!=null && student!=null && teacher.getRole().equals("TEACHER")&&
                student.getRole().equals("STUDENT")))
        {
            System.out.println(teacher.getName()+" Öğretmen "+student.getId()+" Numaralı öğrencisinden "+lessonsName+
                    " Adlı dersi silmiştir");
        }else
        {
            System.out.println("Öğretmen veya öğrenci bulunamadı veya yetkisiz işlem.");
        }
    }

    }

