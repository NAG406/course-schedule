package com.mlewguntur.cs.courseschedule.service;

import com.mlewguntur.cs.courseschedule.model.CourseSchedule;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseScheduleService {
    CourseSchedule getCourseScheduleByCourseAndTopic(String courseName, String topicName);

    List<CourseSchedule> saveCourses(List<CourseSchedule> courseScheduleList);

    List<CourseSchedule> getCourseSchedules();

    List<CourseSchedule> courseReschedule(CourseSchedule courseScheduleList);

    void deleteCourseSchedules();
}
