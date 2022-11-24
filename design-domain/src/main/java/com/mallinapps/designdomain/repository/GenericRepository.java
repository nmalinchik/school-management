package com.mallinapps.designdomain.repository;

import java.util.UUID;

import com.mallinapps.designdomain.domain.base.BusinessEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericRepository<T extends BusinessEntity> extends JpaRepository<T, UUID> {}
