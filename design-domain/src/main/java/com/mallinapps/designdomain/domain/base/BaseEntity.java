package com.mallinapps.designdomain.domain.base;

import javax.persistence.MappedSuperclass;
import java.util.Objects;
import java.util.UUID;

import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;

@NoArgsConstructor
@SuperBuilder
@MappedSuperclass
public abstract class BaseEntity {
    public abstract UUID getId();

    public abstract void setId(final UUID id);

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != Hibernate.getClass(o)) {
            return false;
        }
        final BaseEntity that = (BaseEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public enum TaskDifficultLevel {
        ONE, TWO, THREE, FOUR, FIVE
    }

    public enum ParamType {
       SINGLE, ARRAY
    }
}
