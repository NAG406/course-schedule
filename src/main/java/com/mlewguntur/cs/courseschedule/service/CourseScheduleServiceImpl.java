package com.mlewguntur.cs.courseschedule.service;

import com.mlewguntur.cs.courseschedule.model.CourseSchedule;
import com.mlewguntur.cs.courseschedule.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CourseScheduleServiceImpl implements CourseScheduleService {

    @Autowired
    CourseRepository courseRepository;

    public CourseSchedule getCourseScheduleByCourseAndTopic(String courseName, String topicName) {
        return courseRepository.findByCourseNameAndTopicName(courseName, topicName);
    }

    public List<CourseSchedule> getCourseSchedules(){
        return courseRepository.findAll();
    }

    public List<CourseSchedule> saveCourses(List<CourseSchedule> courseScheduleList){
        return courseRepository.saveAll(courseScheduleList);
    }

    public List<CourseSchedule> courseReschedule(CourseSchedule courseSchedule) {
        Date rescheduleDate = courseSchedule.getScheduledDate();
        List<CourseSchedule> courseSchedules = courseRepository.findAll();
        List<CourseSchedule> rescheduleList = courseSchedules.stream()
                .filter(x -> !x.getScheduledDate().before(rescheduleDate))
                .collect(Collectors.toList());
        for (CourseSchedule rescheduleCourse: rescheduleList) {
            rescheduleCourse.setScheduledDate(Date.from(rescheduleCourse.getScheduledDate().toInstant().plusSeconds(24*3600)));
        }

        return courseRepository.saveAll(rescheduleList);
    }

    public void deleteCourseSchedules(){
        courseRepository.deleteAll();
    }

}
