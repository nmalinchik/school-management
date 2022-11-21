package com.mallinapps.designdomain.domain.student;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.mallinapps.designdomain.domain.base.BusinessEntity;
import com.mallinapps.designdomain.domain.enums.Grade;
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
@Table(schema = "student", name = "grade")
public class GradeEntity extends BusinessEntity {

    @Enumerated(EnumType.STRING)
    private Grade grade;
    private String letter;

    //todo добавить классного руководителя

}
