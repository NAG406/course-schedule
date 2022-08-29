package com.mlewguntur.cs.courseschedule.controller;

import com.mlewguntur.cs.courseschedule.model.CourseSchedule;
import com.mlewguntur.cs.courseschedule.service.CourseScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/course")
public class CourseScheduleController {

    @Autowired
    CourseScheduleService courseScheduleService;

    @GetMapping()
    public CourseSchedule getCourseSchedule(@RequestParam("course") String courseName,
                                                  @RequestParam("topic") String topic) {
        return courseScheduleService.getCourseScheduleByCourseAndTopic(courseName, topic);
    }

    @GetMapping(value = "/courses")
    public List<CourseSchedule> getCourseSchedules() {
        return courseScheduleService.getCourseSchedules();
    }


    @PostMapping(value = "/save-courses", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public List<CourseSchedule> saveCourseSchedule(@RequestBody List<CourseSchedule> courseScheduleList) {
        return courseScheduleService.saveCourses(courseScheduleList);
    }

    @PostMapping(value = "/topic-reschedule", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public List<CourseSchedule> courseReSchedule(@RequestBody CourseSchedule courseSchedule) {
       return courseScheduleService.courseReschedule(courseSchedule);
    }

    @DeleteMapping(value = "/courses")
    public void deleteCourseSchedules() {
         courseScheduleService.deleteCourseSchedules();
    }


}
