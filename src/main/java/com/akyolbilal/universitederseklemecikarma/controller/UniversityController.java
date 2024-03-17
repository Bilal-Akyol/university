package com.akyolbilal.universitederseklemecikarma.controller;

import com.akyolbilal.universitederseklemecikarma.service.UniversityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lessons")
public class UniversityController {
    private UniversityService universityService;
    @GetMapping("/list")
    public List<String> getLesson(){
        return universityService.getLessons();
    }
    @PostMapping("/add")
    public void addLesson(@RequestParam String lesson){
        universityService.addLesson(lesson);
    }
    @PostMapping("/assign")
    public void assignLesson(@RequestParam Long teacherId,@RequestParam Long studentId,@RequestParam String lessonName)
    {
        universityService.assignLesson(teacherId,studentId,lessonName);
    }
    @PostMapping("/delete")
    public void deleteLesson(@RequestParam Long teacherId,@RequestParam Long studentId,@RequestParam String lessonName)
    {
        universityService.deleteLesson(teacherId,studentId,lessonName);
    }



}
