package com.mallinapps.designdomain.domain.lesson;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.mallinapps.designdomain.domain.base.Versioned;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
@Table(schema = "lesson", name = "lesson")
public class LessonEntity extends Versioned {

    private String title;
    private String description;

}
