--liquibase formatted sql
--changeSet nmalinchik:student-01 logicalFilePath:db/data
INSERT INTO student.student(id, first_name, last_name, middle_name, date_of_birth, grade_id, created_by, creation_date, last_updated_by, last_update_date, object_version_number)
VALUES
        (gen_random_uuid(), 'Иван', 'Иванов', 'Иванович', '2012-05-22', '7364d5d1-2854-4387-a006-46c18f20ca76', 'admin', now(), 'admin', now(), 0),
        (gen_random_uuid(), 'Аверьян', 'Зуев', 'Павлович', '2013-04-13', '2b66783e-f28b-49c8-ad01-149c44d87d2b', 'admin', now(), 'admin', now(), 0),
        (gen_random_uuid(), 'Власова', 'Эшли', 'Владиславовна', '2010-11-11', 'a77bf218-2fd9-4472-8a52-aa53809901e4', 'admin', now(), 'admin', now(), 0),
        (gen_random_uuid(), 'Варвара', 'Рогова', 'Николаевна', '2013-03-01', 'a77bf218-2fd9-4472-8a52-aa53809901e4', 'admin', now(), 'admin', now(), 0),
        (gen_random_uuid(), 'Архип', 'Никонов', 'Макарович', '2015-08-22', '54f7b500-d976-4318-989b-822e5204d6d9', 'admin', now(), 'admin', now(), 0),
        (gen_random_uuid(), 'Яков', 'Горбунов', 'Петрович', '2015-03-23', '54f7b500-d976-4318-989b-822e5204d6d9', 'admin', now(), 'admin', now(), 0),
        (gen_random_uuid(), 'Устинья', 'Фролова', 'Христофоровна', '2014-02-12', 'fd263676-99ee-42a5-b6f5-fcaa09340185', 'admin', now(), 'admin', now(), 0),
        (gen_random_uuid(), 'Владлен', 'Горбачёв', 'Иванович', '2013-01-11', 'fd263676-99ee-42a5-b6f5-fcaa09340185', 'admin', now(), 'admin', now(), 0),
        (gen_random_uuid(), 'Арсен', 'Юдин', 'Всеволодович', '2010-05-15', '97d8ba64-7fc7-415b-b7cf-b484ac5948ff', 'admin', now(), 'admin', now(), 0);
