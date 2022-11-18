--changeSet nmalinchik:timetable_lesson-01 logicalFilePath:objects/timetable_lesson
create table timetable.timetable_week_day
(
    timetable_week_id                       uuid not null,
    timetable_day_id                        uuid not null,

    constraint timetable_week_day_pk        primary key (timetable_week_id, timetable_day_id),
    constraint timetable_week_day_week_fk   foreign key (timetable_week_id) references timetable.timetable_week,
    constraint timetable_week_day_day_fk    foreign key (timetable_day_id) references timetable.timetable_day
);

comment on table timetable.timetable_week_day is 'Many to many table between timetable week and day';
