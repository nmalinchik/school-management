package com.mallinapps.designdomain.controller;

import java.util.UUID;

import com.mallinapps.commondto.dto.employee.Employee;
import com.mallinapps.commondto.dto.employee.EmployeeList;
import com.mallinapps.commondto.dto.employee.EmployeeShort;
import com.mallinapps.designdomain.controller.api.CrudApi;
import com.mallinapps.designdomain.controller.api.EmployeeApi;
import com.mallinapps.designdomain.controller.api.common.ErrorResponse;
import com.mallinapps.designdomain.controller.api.common.OpenApi;
import com.mallinapps.designdomain.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ApiResponses(value = {
        @ApiResponse(responseCode = OpenApi.ProblemSchema.StatusCode.DEFAULT_ERROR, description = OpenApi.ProblemSchema.AliasNames.PROBLEM_DEFAULT,
                content = @Content(mediaType = MediaType.APPLICATION_PROBLEM_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = OpenApi.ProblemSchema.StatusCode.BAD_REQUEST, description = OpenApi.ProblemSchema.AliasNames.PROBLEM_BAD_REQUEST,
                content = @Content(mediaType = MediaType.APPLICATION_PROBLEM_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = OpenApi.ProblemSchema.StatusCode.NOT_FOUND, description = OpenApi.ProblemSchema.AliasNames.PROBLEM_NOT_FOUND,
                content = @Content(mediaType = MediaType.APPLICATION_PROBLEM_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))),
})
@Tag(name = "Employee operations", description = "Crud operations with employee")
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/employee")
public class EmployeeController implements EmployeeApi {

    private final EmployeeService employeeService;

    @Override
    @ApiResponse(responseCode = OpenApi.ProblemSchema.StatusCode.OK, description = OpenApi.Descriptions.EMPLOYEE_FIND_BY_ID,
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Employee.class)))
    @Operation(summary = "Find an employees by id")
    public ResponseEntity<Employee> findById(final UUID id) {
        return ResponseEntity.ok().body(employeeService.findById(id));
    }

    @Override
    @ApiResponse(responseCode = OpenApi.ProblemSchema.StatusCode.OK, description = OpenApi.Descriptions.EMPLOYEE_FIND_ALL,
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = EmployeeList.class)))
    @Operation(summary = "Find all employees")
    public ResponseEntity<EmployeeList> getList(final Integer page, final Integer size) {
        return ResponseEntity.ok().body(employeeService.getList(page, size));
    }

    @Override
    @ApiResponse(responseCode = OpenApi.ProblemSchema.StatusCode.OK, description = OpenApi.Descriptions.EMPLOYEE_CREATE,
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Employee.class)))
    @Operation(summary = "Create new employee")
    public ResponseEntity<Employee> create(final EmployeeShort employee) {
        return ResponseEntity.ok().body(employeeService.create(employee));
    }

    @Override
    @ApiResponse(responseCode = OpenApi.ProblemSchema.StatusCode.OK, description = OpenApi.Descriptions.EMPLOYEE_UPDATE,
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Employee.class)))
    @Operation(summary = "Update the employee")
    public ResponseEntity<Employee> update(final UUID id, final EmployeeShort employee) {
        return ResponseEntity.ok().body(employeeService.update(id, employee));
    }

    @Override
    @ApiResponse(responseCode = OpenApi.ProblemSchema.StatusCode.OK, description = OpenApi.Descriptions.EMPLOYEE_DELETE_BY_ID,
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    @Operation(summary = "Find an employees by id")
    public void delete(final UUID id) {
        employeeService.delete(id);
    }
}
