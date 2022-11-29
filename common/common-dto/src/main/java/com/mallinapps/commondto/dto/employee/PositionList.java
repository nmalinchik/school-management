package com.mallinapps.commondto.dto.employee;

import java.util.List;

import com.mallinapps.commondto.dto.common.CommonPageResource;

public record PositionList(List<Position> positions, CommonPageResource page) {}
