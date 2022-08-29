package com.mlewguntur.cs.courseschedule.repository;

import com.mlewguntur.cs.courseschedule.model.CourseSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<CourseSchedule, Integer> {

    @Query(value = "SELECT courseSchedule FROM CourseSchedule courseSchedule where courseSchedule.courseName = ?1 " +
            "and courseSchedule.topicName = ?2")
    CourseSchedule findByCourseNameAndTopicName(String courseName, String topicName);

}
