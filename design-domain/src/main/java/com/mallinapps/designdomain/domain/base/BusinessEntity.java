package com.mallinapps.designdomain.domain.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.util.TimeZone;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.util.StringUtils;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@MappedSuperclass
public abstract class BusinessEntity extends UuidBaseEntity {

//    public final String DEFAULT_USER = "admin";

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "last_updated_by")
    private String lastUpdatedBy;

    @Column(name = "last_update_date")
    private LocalDateTime lastUpdateDate;

    @PrePersist
    public void prePersist() {
        this.creationDate = LocalDateTime.now(TimeZone.getTimeZone("UTC").toZoneId());
        this.lastUpdateDate = this.creationDate;

        if (!StringUtils.hasLength(this.createdBy)) {
            this.createdBy = findCurrentUser();
        }
        this.lastUpdatedBy = this.createdBy;
    }

    @PreUpdate
    public void preUpdate() {
        this.lastUpdateDate = LocalDateTime.now(TimeZone.getTimeZone("UTC").toZoneId());
        this.lastUpdatedBy = findCurrentUser();
    }

    private String findCurrentUser() {
        //todo add after security will add
//        String user = null;
//        if (SecurityContextHolder.getContext().getAuthentication() != null) {
//            UserDetails userDetails = null;
//            if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof UserDetails) {
//                userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//            }
//            user = userDetails != null ? userDetails.getUsername() : null;
//        }
//        return user == null ? DEFAULT_USER : user;
        return "admin";
    }

}
