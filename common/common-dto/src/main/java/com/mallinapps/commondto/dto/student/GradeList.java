package com.mallinapps.commondto.dto.student;

import java.util.List;

import com.mallinapps.commondto.dto.common.CommonPageResource;

public record GradeList(List<Grade> grades, CommonPageResource page) {}
