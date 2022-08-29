package com.mlewguntur.cs.courseschedule.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "course")
public class CourseSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id ;
    @Column(name= "course_name")
    private String courseName;
    @Column(name = "instructor")
    private String instructor;
    @Column(name = "scheduled_date")
    private Date scheduledDate;
    @Column(name = "topic_name")
    private String topicName;
}
