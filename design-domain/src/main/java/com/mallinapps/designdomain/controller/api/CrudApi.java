package com.mallinapps.designdomain.controller.api;

import javax.validation.constraints.Min;
import java.util.UUID;

import com.mallinapps.commondto.dto.student.Grade;
import com.mallinapps.commondto.dto.student.GradeList;
import com.mallinapps.designdomain.controller.api.common.OpenApi;
import io.swagger.annotations.ApiParam;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface CrudApi<T,U> {

    @GetMapping
    T getList(
            @Min(0)
            @ApiParam(value = OpenApi.Descriptions.PAGE, example = OpenApi.Examples.PAGE, defaultValue = "0")
            @RequestParam(value = "page", defaultValue = "0")
            Integer page,

            @ApiParam(value = OpenApi.Descriptions.SIZE, example = OpenApi.Examples.SIZE, defaultValue = "10")
            @Range(min = 10, max = 100)
            @RequestParam(value = "size", defaultValue = "10")
            Integer size);

    @GetMapping("/{id}")
    U findById(@PathVariable UUID id);

    @PostMapping
    U create(@RequestBody U position);

    @PutMapping("/{id}")
    U update(@PathVariable UUID id, @RequestBody U position);

    @DeleteMapping("/{id}")
    void delete(@PathVariable UUID id);

}
