--changeSet nmalinchik:employee-01 logicalFilePath:objects/employee
create table employee.employee
(
      id                                        uuid                        not null,
      first_name                                varchar(255)                not null,
      last_name                                 varchar(255)                not null,
      middle_name                               varchar(255)                not null,
      date_of_birth                             DATE                        not null,
      position_id                               uuid                        not null,
      extra_position_id                         uuid                        null,

      created_by                                varchar(255)                not null,
      creation_date                             timestamp without time zone not null,
      last_updated_by                           varchar(255)                not null,
      last_update_date                          timestamp without time zone not null,
      object_version_number                     bigint                      not null,

      constraint employee_pk                    primary key (id),
      constraint employee_position_fk           foreign key (position_id) references employee.position,
      constraint employee_extra_position_fk     foreign key (position_id) references employee.position
);

comment on table employee.employee is 'Employees';

comment on column employee.employee.id is 'Unique ID of entity';
comment on column employee.employee.first_name is 'First name of the employee';
comment on column employee.employee.first_name is 'Last name of the employee';
comment on column employee.employee.first_name is 'Middle name of the employee';
comment on column employee.employee.date_of_birth is 'Date of birth of the employee';
comment on column employee.employee.position_id is 'Id of the main position';
comment on column employee.employee.extra_position_id is 'Id of the extra position';

COMMENT ON column employee.employee.created_by IS 'User who create the entity';
COMMENT ON column employee.employee.creation_date IS 'Date when the entity was created';
COMMENT ON column employee.employee.last_updated_by IS 'User who update the entity';
COMMENT ON column employee.employee.last_update_date IS 'Date when the entity was updated';
COMMENT ON column employee.employee.object_version_number IS 'Version number of the entity';
