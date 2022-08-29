package com.mlewguntur.cs.courseschedule.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class CourseTopic {
    @Column(name = "scheduled_date")
    private Date scheduledDate;
    @Column(name = "topic_name")
    private String topicName;
}
