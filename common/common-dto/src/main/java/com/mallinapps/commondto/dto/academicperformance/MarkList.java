package com.mallinapps.commondto.dto.academicperformance;

import java.util.List;

import com.mallinapps.commondto.dto.common.CommonPageResource;

public record MarkList(List<Mark> marks, CommonPageResource page) {}
