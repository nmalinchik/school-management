--changeSet nmalinchik:timetable_lesson-01 logicalFilePath:objects/timetable_lesson
create table timetable.timetable_day_lesson
(
    timetable_day_id                              uuid not null,
    timetable_lesson_id                           uuid not null,

    constraint timetable_day_lesson_pk            primary key (timetable_day_id, timetable_lesson_id),
    constraint timetable_day_lesson_day_fk        foreign key (timetable_day_id) references timetable.timetable_day,
    constraint timetable_day_lesson_lesson_fk     foreign key (timetable_lesson_id) references timetable.timetable_lesson
);

comment on table timetable.timetable_day_lesson is 'Many to many table between timetable day and lesson';
