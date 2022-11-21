--liquibase formatted sql
--changeSet nmalinchik:grade-01 logicalFilePath:db/data
INSERT INTO student.grade(id, grade, letter, created_by, creation_date, last_updated_by, last_update_date) 
VALUES
    ('e72a52d2-56ea-4e2e-a493-ffa40c701ff2', 'FIRST', 'А', 'admin', now(), 'admin', now()),
    ('7591f313-e6b9-4e03-acab-70b201544055', 'FIRST', 'Б', 'admin', now(), 'admin', now()),
    ('ff6b9c1c-af31-489c-ad95-7de4f65cd83a', 'FIRST', 'В', 'admin', now(), 'admin', now()),
    ('997d1c35-ae2b-4dd3-b2cb-e6a3971f05ef', 'SECOND', 'А', 'admin', now(), 'admin', now()),
    ('3bd03171-dec5-4872-8455-d060fec1a28d', 'THIRD', 'А', 'admin', now(), 'admin', now()),
    ('97d8ba64-7fc7-415b-b7cf-b484ac5948ff', 'FOURTH', 'А', 'admin', now(), 'admin', now()),
    ('c8664094-7d94-4a6a-977d-3a51cc1c13bb', 'FOURTH', 'Б', 'admin', now(), 'admin', now()),
    ('03879e9d-bd86-4bab-8f87-7c13cea4e7e4', 'FIFTH', 'А', 'admin', now(), 'admin', now()),
    ('1c67eed4-1c46-4c36-8caa-aabd6fde1fb4', 'SIXTH', 'А', 'admin', now(), 'admin', now()),
    ('2b66783e-f28b-49c8-ad01-149c44d87d2b', 'SEVENTH', 'А', 'admin', now(), 'admin', now()),
    ('7364d5d1-2854-4387-a006-46c18f20ca76', 'SEVENTH', 'Б', 'admin', now(), 'admin', now()),
    ('5fe26624-ceba-48bd-bbae-d6a9c0030753', 'EIGHTH', 'А', 'admin', now(), 'admin', now()),
    ('e9ea1091-9c49-4b4a-888d-897aab662337', 'EIGHTH', 'Б', 'admin', now(), 'admin', now()),
    ('a33c0010-ca3b-4c19-8f85-f3a690d5d358', 'NINTH', 'А', 'admin', now(), 'admin', now()),
    ('a77bf218-2fd9-4472-8a52-aa53809901e4', 'NINTH', 'Б', 'admin', now(), 'admin', now()),
    ('44e43720-60d3-4587-919c-b958285fa9c0', 'TENS', 'А', 'admin', now(), 'admin', now()),
    ('54f7b500-d976-4318-989b-822e5204d6d9', 'TENS', 'Б', 'admin', now(), 'admin', now()),
    ('fd263676-99ee-42a5-b6f5-fcaa09340185', 'ELEVENTH', 'А', 'admin', now(), 'admin', now());
