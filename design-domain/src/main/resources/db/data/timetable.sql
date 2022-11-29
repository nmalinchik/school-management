--liquibase formatted sql
--changeSet nmalinchik:timetable-01 logicalFilePath:db/data
INSERT INTO timetable.timetable_week(id, start_date, end_date, grade_id, created_by, creation_date, last_updated_by, last_update_date, object_version_number)
VALUES
    ('0d9f444f-9fef-4ce1-9160-74846a7c3e03', '2022-04-11', '2022-04-15', 'a77bf218-2fd9-4472-8a52-aa53809901e4', 'admin', now(), 'admin', now(), 0);

INSERT INTO timetable.timetable_day(id, week_id, day_date, created_by, creation_date, last_updated_by, last_update_date, object_version_number)
VALUES
    ('e13110a4-c075-4f98-a325-c1f951938821', '0d9f444f-9fef-4ce1-9160-74846a7c3e03', '2022-04-11', 'admin', now(), 'admin', now(), 0),
    ('edff9c1b-8f3b-4a15-93e7-d78a719fa692', '0d9f444f-9fef-4ce1-9160-74846a7c3e03', '2022-04-12', 'admin', now(), 'admin', now(), 0),
    ('08d3c5b0-a036-4b3e-b165-49cb89002abb', '0d9f444f-9fef-4ce1-9160-74846a7c3e03', '2022-04-13', 'admin', now(), 'admin', now(), 0),
    ('190a4e78-1bb8-4e57-926a-5a47aecb50aa', '0d9f444f-9fef-4ce1-9160-74846a7c3e03', '2022-04-14', 'admin', now(), 'admin', now(), 0),
    ('f805a149-84af-4671-9946-ea24e0d3e0cc', '0d9f444f-9fef-4ce1-9160-74846a7c3e03', '2022-04-15', 'admin', now(), 'admin', now(), 0);

INSERT INTO timetable.timetable_lesson(id, start_date, end_date, position, lesson_id, day_id, created_by, creation_date, last_updated_by, last_update_date, object_version_number)
VALUES
    ('c1302517-c48c-4434-b583-5a3eae2e2062', '2022-04-11 08:00:00', '2022-04-11 08:45:00', 'FIRST', '1ddc671b-a657-4f8b-a5a8-3ad9ca7305dd', 'e13110a4-c075-4f98-a325-c1f951938821', 'admin', now(), 'admin', now(), 0),
    ('da637308-3983-45d1-be1c-895acfdd2628', '2022-04-11 08:50:00', '2022-04-11 09:35:00', 'SECOND', '6bcc00c9-cc8b-4ed5-9ab9-fcc21206ee2a', 'e13110a4-c075-4f98-a325-c1f951938821', 'admin', now(), 'admin', now(), 0),
    ('a542fafe-0b54-458e-b022-2fd635cb9055', '2022-04-11 09:40:00', '2022-04-11 10:25:00', 'THIRD', '51604d4d-b0c4-4b9a-b74f-d4d062c18276', 'e13110a4-c075-4f98-a325-c1f951938821', 'admin', now(), 'admin', now(), 0),
    ('2d474d46-394b-4b70-a9c5-2834a58d32bc', '2022-04-11 10:35:00', '2022-04-11 11:20:00', 'FOURTH', '2dcf2adb-cef3-444e-98e8-6d77e4d81561', 'e13110a4-c075-4f98-a325-c1f951938821', 'admin', now(), 'admin', now(), 0),
    ('1b48be91-2b27-473a-9942-d9b39e02bdf2', '2022-04-11 11:25:00', '2022-04-11 12:10:00', 'FIFTH', 'c3c33fde-a1c8-442c-8182-9de618fe45f3', 'e13110a4-c075-4f98-a325-c1f951938821', 'admin', now(), 'admin', now(), 0),
    ('83a34c73-149e-4be6-b8d2-19ab4ba69122', '2022-04-11 12:25:00', '2022-04-11 13:10:00', 'SIXTH', '47f4f7f6-7a7d-4e97-a3bd-7d24a2548e4e', 'e13110a4-c075-4f98-a325-c1f951938821', 'admin', now(), 'admin', now(), 0),
    ('7656a5b5-8208-4c05-b96b-9750a6d150df', '2022-04-12 08:00:00', '2022-04-12 08:45:00', 'FIRST', '5dbe15a7-4dcb-4b0d-a2ca-752fb0b8b2f3', 'edff9c1b-8f3b-4a15-93e7-d78a719fa692', 'admin', now(), 'admin', now(), 0),
    ('95dd41f2-7c03-441a-afcf-d7874763af92', '2022-04-12 08:50:00', '2022-04-12 09:35:00', 'SECOND', '2d3f6abe-33c2-44f6-9df9-cc24c95e90eb', 'edff9c1b-8f3b-4a15-93e7-d78a719fa692', 'admin', now(), 'admin', now(), 0),
    ('44574687-9cab-4b21-b31e-7eb544dc1769', '2022-04-12 09:40:00', '2022-04-12 10:25:00', 'THIRD', 'e8e2c563-b56a-416a-bb6b-7b1f580e7246', 'edff9c1b-8f3b-4a15-93e7-d78a719fa692', 'admin', now(), 'admin', now(), 0),
    ('73b8fd5d-5adc-41ad-ac71-c09baa9659d7', '2022-04-12 10:35:00', '2022-04-12 11:20:00', 'FOURTH', '47f4f7f6-7a7d-4e97-a3bd-7d24a2548e4e', 'edff9c1b-8f3b-4a15-93e7-d78a719fa692', 'admin', now(), 'admin', now(), 0),
    ('fdddf1b0-4df3-43ac-99c4-9eb8f226528e', '2022-04-12 11:25:00', '2022-04-12 12:10:00', 'FIFTH', '24f17ccf-3898-4b44-b6b1-383d1e956095', 'edff9c1b-8f3b-4a15-93e7-d78a719fa692', 'admin', now(), 'admin', now(), 0),
    ('66d25329-cf65-49da-90c1-bda583343af4', '2022-04-12 12:25:00', '2022-04-12 13:10:00', 'SIXTH', 'bc716665-bafe-427f-a248-6eb92d95f198', 'edff9c1b-8f3b-4a15-93e7-d78a719fa692', 'admin', now(), 'admin', now(), 0),
    ('7df80a80-e146-40eb-b481-16b371bd0a7d', '2022-04-13 08:00:00', '2022-04-13 08:45:00', 'FIRST', '29fced50-0390-4045-916c-df06f18f1608', '08d3c5b0-a036-4b3e-b165-49cb89002abb', 'admin', now(), 'admin', now(), 0),
    ('b92ed798-132e-4789-9ddd-17178352fb04', '2022-04-13 08:50:00', '2022-04-13 09:35:00', 'SECOND', '9e667741-7d07-41ba-a856-a533050b2d98', '08d3c5b0-a036-4b3e-b165-49cb89002abb', 'admin', now(), 'admin', now(), 0),
    ('41221e2e-874d-4b90-b1e3-fda590692524', '2022-04-13 09:40:00', '2022-04-13 10:25:00', 'THIRD', 'fb398a78-19b2-4857-b83d-615a8351d92f', '08d3c5b0-a036-4b3e-b165-49cb89002abb', 'admin', now(), 'admin', now(), 0),
    ('90c2ad9a-c000-4108-8d3e-e7d5dc3e5925', '2022-04-13 10:35:00', '2022-04-13 11:20:00', 'FOURTH', '2d3f6abe-33c2-44f6-9df9-cc24c95e90eb', '08d3c5b0-a036-4b3e-b165-49cb89002abb', 'admin', now(), 'admin', now(), 0),
    ('8c734a76-19e6-4206-9780-d67759d6cc22', '2022-04-13 11:25:00', '2022-04-13 12:10:00', 'FIFTH', '51803e49-4954-44ca-a116-b56cb7fa9975', '08d3c5b0-a036-4b3e-b165-49cb89002abb', 'admin', now(), 'admin', now(), 0),
    ('718cb0c4-f507-4c1b-8acb-81c9f7c00cc6', '2022-04-13 12:25:00', '2022-04-13 13:10:00', 'SIXTH', '51604d4d-b0c4-4b9a-b74f-d4d062c18276', '08d3c5b0-a036-4b3e-b165-49cb89002abb', 'admin', now(), 'admin', now(), 0),
    ('3fee631d-9ca0-4ce7-ad91-749d3d964876', '2022-04-14 08:00:00', '2022-04-14 08:45:00', 'FIRST', 'da81a7f2-4796-4603-a749-2a7dceb9746f', '190a4e78-1bb8-4e57-926a-5a47aecb50aa', 'admin', now(), 'admin', now(), 0),
    ('ff955bdb-7778-4583-a261-d9b9a3d4a47a', '2022-04-14 08:50:00', '2022-04-14 09:35:00', 'SECOND', '850b26c8-d9ba-4b71-8666-85d216dde1eb', '190a4e78-1bb8-4e57-926a-5a47aecb50aa', 'admin', now(), 'admin', now(), 0),
    ('42b3b5b7-1f6c-4377-84ee-0adf727955b1', '2022-04-14 09:40:00', '2022-04-14 10:25:00', 'THIRD', 'ef15d1ff-213a-4618-94e9-a35cb7b1d3d7', '190a4e78-1bb8-4e57-926a-5a47aecb50aa', 'admin', now(), 'admin', now(), 0),
    ('50962800-9841-42f1-be85-7aa6fec5eacd', '2022-04-14 10:35:00', '2022-04-14 11:20:00', 'FOURTH', 'fb398a78-19b2-4857-b83d-615a8351d92f', '190a4e78-1bb8-4e57-926a-5a47aecb50aa', 'admin', now(), 'admin', now(), 0),
    ('abbd913e-7152-43a4-b2a4-1394dc1d928a', '2022-04-14 11:25:00', '2022-04-14 12:10:00', 'FIFTH', 'e004839d-46b5-4fe0-8528-427225afe8aa', '190a4e78-1bb8-4e57-926a-5a47aecb50aa', 'admin', now(), 'admin', now(), 0),
    ('c37e59fb-a3fe-44c7-8123-1251215edd34', '2022-04-14 12:25:00', '2022-04-14 13:10:00', 'SIXTH', '5a4c6777-eb64-4c0d-aa0c-887d4a11dac2', '190a4e78-1bb8-4e57-926a-5a47aecb50aa', 'admin', now(), 'admin', now(), 0),
    ('2823d180-e73e-429a-a858-90f416fc7a6b', '2022-04-15 08:00:00', '2022-04-15 08:45:00', 'FIRST', 'ef15d1ff-213a-4618-94e9-a35cb7b1d3d7', 'f805a149-84af-4671-9946-ea24e0d3e0cc', 'admin', now(), 'admin', now(), 0),
    ('ff5594c9-e574-4f69-a90b-ebc317062282', '2022-04-15 08:50:00', '2022-04-15 09:35:00', 'SECOND', '5a4c6777-eb64-4c0d-aa0c-887d4a11dac2', 'f805a149-84af-4671-9946-ea24e0d3e0cc', 'admin', now(), 'admin', now(), 0),
    ('88e5e634-c927-4d3c-bfa5-0a562230f3ed', '2022-04-15 09:40:00', '2022-04-15 10:25:00', 'THIRD', '53e668c8-e910-428a-9788-60a552da7236', 'f805a149-84af-4671-9946-ea24e0d3e0cc', 'admin', now(), 'admin', now(), 0),
    ('cac08f56-e4e6-482a-80be-d30b6470c0bb', '2022-04-15 10:35:00', '2022-04-15 11:20:00', 'FOURTH', '2dcf2adb-cef3-444e-98e8-6d77e4d81561', 'f805a149-84af-4671-9946-ea24e0d3e0cc', 'admin', now(), 'admin', now(), 0),
    ('1469b158-1b96-4b5f-96af-eb808954dc7b', '2022-04-15 11:25:00', '2022-04-15 12:10:00', 'FIFTH', 'da81a7f2-4796-4603-a749-2a7dceb9746f', 'f805a149-84af-4671-9946-ea24e0d3e0cc', 'admin', now(), 'admin', now(), 0),
    ('168185db-402d-448c-9f44-a528bf54f032', '2022-04-15 12:25:00', '2022-04-15 13:10:00', 'SIXTH', 'ef15d1ff-213a-4618-94e9-a35cb7b1d3d7', 'f805a149-84af-4671-9946-ea24e0d3e0cc', 'admin', now(), 'admin', now(), 0);
