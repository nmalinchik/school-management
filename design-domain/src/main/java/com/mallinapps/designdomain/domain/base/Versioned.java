package com.mallinapps.designdomain.domain.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.OptimisticLockException;
import javax.persistence.Version;
import java.text.MessageFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@MappedSuperclass
public abstract class Versioned extends BusinessEntity {

    @Version
    @Column(name = "object_version_number", nullable = false)
    private Long version;

    public void applyVersion(Long version) {
        if (this.version == null) {
            return;
        }
        if (!this.version.equals(version)) {
            throw new OptimisticLockException(MessageFormat.format("Stale entity {0}: applied version {1}, but current version is {2}", this.getClass()
                    .getSimpleName(), version, this.version));
        }
        this.version = version;
    }
}
