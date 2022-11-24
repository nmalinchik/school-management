package com.mallinapps.designdomain.controller.api.common;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

public class OpenApi {

    public static final class Descriptions {
        public static final String PAGE = "Page number";
        public static final String SIZE = "Size of each page";
        public static final String ID = "Uuid identify of entity";
        public static final String EMPLOYEE_CREATE = "Create a new employee";
        public static final String EMPLOYEE_UPDATE = "Update the employee";
        public static final String EMPLOYEE_FIND_ALL = "Get a list of employees";
        public static final String EMPLOYEE_FIND_BY_ID = "Find employee by id";
        public static final String EMPLOYEE_DELETE_BY_ID = "Delete employee by id";


    }

    public static final class Examples {
        public static final String ID = "a6b4c3c8-8b1b-4304-b875-2d243830db9b";
        public static final String PAGE = "1";
        public static final String SIZE = "20";
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static final class ProblemSchema {
        @NoArgsConstructor(access = AccessLevel.PRIVATE)
        public static final class StatusCode {
            public static final String OK = "200";
            public static final String CREATED = "201";
            public static final String NO_CONTENT = "204";
            public static final String BAD_REQUEST = "400";
            public static final String NOT_FOUND = "404";
            public static final String DEFAULT_ERROR = "500";
        }

        @NoArgsConstructor(access = AccessLevel.PRIVATE)
        static final class Descriptions {
            static final String I18N_TITLE = "Problem title in an i18n-internationalization format";
            static final String I18N_DETAIL = "Problem title in an i18n-internationalization format";
            static final String TITLE = "A short summary";
            static final String DETAIL = "A human readable and specific message";
            static final String STATUS = "The HTTP status code";
            static final String VIOLATIONS = "Optional list of constraint violations";
        }

        @NoArgsConstructor(access = AccessLevel.PRIVATE)
        public static final class AliasNames {
            public static final String PROBLEM_DEFAULT = "Internal Server Error";
            public static final String PROBLEM_NOT_FOUND = "Not-found-problem";
            public static final String PROBLEM_BAD_REQUEST = "Bad-request-problem";
            public static final String PROBLEM_BAD_REQUEST_WITH_CONSTRAINT_VALIDATION = "Bad-request-with-constraint-validation-problem";
            public static final String VIOLATION = "Violation";
        }

        @Schema(name = AliasNames.PROBLEM_DEFAULT)
        public interface DefaultProblemOpenApiDocumentation {

            @Schema(description = Descriptions.TITLE, example = "Something went wrong", required = true)
            String getTitle();

            @Schema(description = Descriptions.STATUS, example = StatusCode.DEFAULT_ERROR, required = true)
            int getStatus();

            @Schema(description = Descriptions.DETAIL, example = "Could not connect to the database", required = true)
            String getDetail();
        }

        @Schema(name = AliasNames.PROBLEM_BAD_REQUEST)
        public interface BadRequestProblemWithoutConstraintValidation {

            @Schema(description = Descriptions.TITLE, example = "Resource(s) could not be retrieved", required = true)
            String getTitle();

            @Schema(description = Descriptions.STATUS, example = StatusCode.BAD_REQUEST, required = true)
            int getStatus();

            @Schema(description = Descriptions.DETAIL, example = "The requested resource(s) could not be retrieved due to a bad request", required = true)
            String getDetail();

            @Schema(name = "title-i18n", description = Descriptions.I18N_TITLE, example = "PROBLEM.BAD_REQUEST.TITLE")
            String getTitleI18n();

            @Schema(name = "detail-i18n", description = Descriptions.I18N_DETAIL, example = "PROBLEM.BAD_REQUEST.DETAIL")
            String getDetailI18n();
        }

        @Schema(name = AliasNames.PROBLEM_BAD_REQUEST_WITH_CONSTRAINT_VALIDATION)
        public interface BadRequestProblemWithConstraintValidation {

            @Schema(description = Descriptions.TITLE, example = "Resource(s) could not be retrieved", required = true)
            String getTitle();

            @Schema(description = Descriptions.STATUS, example = StatusCode.BAD_REQUEST, required = true)
            int getStatus();

            @Schema(description = Descriptions.DETAIL, example = "The requested resource(s) could not be retrieved due to a bad request")
            String getDetail();

            @Schema(description = Descriptions.VIOLATIONS)
            List<ViolationOpenApiDocumentation> getViolations();
        }

        @Schema(name = AliasNames.VIOLATION)
        private interface ViolationOpenApiDocumentation {

            @Schema(description = "the field where the validation error occurred", example = "subject")
            String getField();

            @Schema(description = "a specific validation error message", example = "The subject cannot be null or blank.")
            String getMessage();
        }
    }
}
