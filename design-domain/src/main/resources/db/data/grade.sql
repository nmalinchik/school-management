--liquibase formatted sql
--changeSet nmalinchik:grade-01 logicalFilePath:db/data
INSERT INTO student.grade(id, grade, letter, created_by, creation_date, last_updated_by, last_update_date) 
VALUES
    (gen_random_uuid(), 'FIRST', 'А', 'admin', now(), 'admin', now()),
    (gen_random_uuid(), 'FIRST', 'Б', 'admin', now(), 'admin', now()),
    (gen_random_uuid(), 'FIRST', 'В', 'admin', now(), 'admin', now()),
    (gen_random_uuid(), 'SECOND', 'А', 'admin', now(), 'admin', now()),
    (gen_random_uuid(), 'THIRD', 'А', 'admin', now(), 'admin', now()),
    ('97d8ba64-7fc7-415b-b7cf-b484ac5948ff', 'FOURTH', 'А', 'admin', now(), 'admin', now()),
    (gen_random_uuid(), 'FOURTH', 'Б', 'admin', now(), 'admin', now()),
    (gen_random_uuid(), 'FIFTH', 'А', 'admin', now(), 'admin', now()),
    (gen_random_uuid(), 'SIXTH', 'А', 'admin', now(), 'admin', now()),
    ('2b66783e-f28b-49c8-ad01-149c44d87d2b', 'SEVENTH', 'А', 'admin', now(), 'admin', now()),
    ('7364d5d1-2854-4387-a006-46c18f20ca76', 'SEVENTH', 'Б', 'admin', now(), 'admin', now()),
    (gen_random_uuid(), 'EIGHTH', 'А', 'admin', now(), 'admin', now()),
    (gen_random_uuid(), 'EIGHTH', 'Б', 'admin', now(), 'admin', now()),
    (gen_random_uuid(), 'NINTH', 'А', 'admin', now(), 'admin', now()),
    ('a77bf218-2fd9-4472-8a52-aa53809901e4', 'NINTH', 'Б', 'admin', now(), 'admin', now()),
    (gen_random_uuid(), 'TENS', 'А', 'admin', now(), 'admin', now()),
    ('54f7b500-d976-4318-989b-822e5204d6d9', 'TENS', 'Б', 'admin', now(), 'admin', now()),
    ('fd263676-99ee-42a5-b6f5-fcaa09340185', 'ELEVENTH', 'А', 'admin', now(), 'admin', now());
