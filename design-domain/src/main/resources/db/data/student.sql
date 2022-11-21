--liquibase formatted sql
--changeSet nmalinchik:student-01 logicalFilePath:db/data
INSERT INTO student.student(id, first_name, last_name, middle_name, date_of_birth, grade_id, created_by, creation_date, last_updated_by, last_update_date, object_version_number)
VALUES
    ('82ee67b7-d7dc-42d0-b801-99c4e67b8a2f', 'Иван', 'Иванов', 'Иванович', '2012-05-22', '7364d5d1-2854-4387-a006-46c18f20ca76', 'admin', now(), 'admin', now(), 0),
    ('a65e1955-4ffa-4e7d-887d-f90afa0cec39', 'Аверьян', 'Зуев', 'Павлович', '2013-04-13', '2b66783e-f28b-49c8-ad01-149c44d87d2b', 'admin', now(), 'admin', now(), 0),
    ('f5aee3ec-067b-4a9a-a20a-b256826c6cb0', 'Власова', 'Эшли', 'Владиславовна', '2010-11-11', 'a77bf218-2fd9-4472-8a52-aa53809901e4', 'admin', now(), 'admin', now(), 0),
    ('5e418a70-b993-447d-b723-a31b7205356b', 'Варвара', 'Рогова', 'Николаевна', '2013-03-01', 'a77bf218-2fd9-4472-8a52-aa53809901e4', 'admin', now(), 'admin', now(), 0),
    ('51b1117c-bf47-44b8-976b-6049882bf605', 'Архип', 'Никонов', 'Макарович', '2015-08-22', '54f7b500-d976-4318-989b-822e5204d6d9', 'admin', now(), 'admin', now(), 0),
    ('87e6d092-19f2-452d-80d1-9a71031e9c60', 'Яков', 'Горбунов', 'Петрович', '2015-03-23', '54f7b500-d976-4318-989b-822e5204d6d9', 'admin', now(), 'admin', now(), 0),
    ('7b08d99b-e675-4e8e-88ab-a82f4df1c0cf', 'Устинья', 'Фролова', 'Христофоровна', '2014-02-12', 'fd263676-99ee-42a5-b6f5-fcaa09340185', 'admin', now(), 'admin', now(), 0),
    ('86964045-99d1-4800-8f5b-c2c0a323007c', 'Владлен', 'Горбачёв', 'Иванович', '2013-01-11', 'fd263676-99ee-42a5-b6f5-fcaa09340185', 'admin', now(), 'admin', now(), 0),
    ('7ca8ee2e-947d-4dd8-a2fd-301555203aef', 'Арсен', 'Юдин', 'Всеволодович', '2010-05-15', '97d8ba64-7fc7-415b-b7cf-b484ac5948ff', 'admin', now(), 'admin', now(), 0);
