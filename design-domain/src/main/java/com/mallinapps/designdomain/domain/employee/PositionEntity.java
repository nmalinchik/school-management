package com.mallinapps.designdomain.domain.employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.mallinapps.designdomain.domain.base.BusinessEntity;
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
@Table(schema = "employee", name = "position")
public class PositionEntity extends BusinessEntity {

    @Column(name = "title", unique = true)
    private String title;

}
