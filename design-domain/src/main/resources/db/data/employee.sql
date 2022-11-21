--liquibase formatted sql
--changeSet nmalinchik:employee-01 logicalFilePath:db/data
INSERT INTO employee.position(id, title, created_by, creation_date, last_updated_by, last_update_date)
VALUES
    ('ec101b88-86f4-42db-93e7-d2235e01f379', 'Педагог (учитель начальных классов)', 'admin', now(), 'admin', now()),
    ('bb5158ba-a327-4e7a-81c1-806dd88dc7c5', 'Педагог (учитель средней школы)', 'admin', now(), 'admin', now()),
    ('d9698ac2-f7dd-472a-ba00-5347b7f0c402', 'Педагог (учитель математики)', 'admin', now(), 'admin', now()),
    ('74f896a5-dc3f-4594-95b8-efd9097c132b', 'Педагог (учитель русского языка и литературы)', 'admin', now(), 'admin', now()),
    ('e7325b1c-6467-46cd-aa45-8a75ecc6b857', 'Педагог - психолог', 'admin', now(), 'admin', now()),
    ('c964c687-5f9e-4c8f-bf98-e3e45cbd2dd3', 'Педагог - организатор', 'admin', now(), 'admin', now()),
    ('3486d97a-3ea5-4ebe-8a87-2d9ef34ba9eb', 'Педагог - библиотекарь', 'admin', now(), 'admin', now()),
    ('aceb10c5-4b50-4767-973e-b28cb93982b9', 'Социальный педагог', 'admin', now(), 'admin', now()),
    ('9bcb795d-a327-4c68-8f52-137844b68b77', 'Делопроизводитель', 'admin', now(), 'admin', now()),
    ('6add5f90-006b-4b80-b870-43f72f5d4d93', 'Лаборант', 'admin', now(), 'admin', now()),
    ('9147ac55-dc9f-4796-b081-81280f18d983', 'Преподаватель ОБЖ', 'admin', now(), 'admin', now()),
    ('0c13752c-c8d1-44a1-ba95-5a10ad6acb7b', 'Заведующая хозяйством', 'admin', now(), 'admin', now()),
    ('6ec54a3d-5c2a-44e1-8eb1-c74a4fee127d', 'Гардеробщик', 'admin', now(), 'admin', now()),
    ('c5aa5a00-718a-4198-af9d-adccaa77e9f6', 'Рабочий по комплексному обслуживанию зданий', 'admin', now(), 'admin', now()),
    ('b9109411-84fe-4632-9869-c5e22c997810', 'Уборщик служебных помещений', 'admin', now(), 'admin', now()),
    ('05d130e8-3a14-47ab-96f2-09ad6df08175', 'Сторож', 'admin', now(), 'admin', now()),
    ('29f77ff0-a1a5-4a9e-8b95-dd4074a3c868', 'Директор', 'admin', now(), 'admin', now()),
    ('d5edd21f-ed3f-47f7-9e16-69a4080e912b', 'Заместитель директора по УВР', 'admin', now(), 'admin', now()),
    ('2eb43f28-8e2f-4155-be61-d5aef8062703', 'Заместитель директора по ВР', 'admin', now(), 'admin', now());

INSERT INTO employee.employee(id, first_name, last_name, middle_name, date_of_birth, position_id, extra_position_id, created_by, creation_date, last_updated_by, last_update_date, object_version_number)
VALUES
    ('c01e3f2d-a78b-489d-bd43-7be0d455b235', 'Милана', 'Калашникова', 'Сергеевна', '1995-08-22', 'ec101b88-86f4-42db-93e7-d2235e01f379', null, 'admin', now(), 'admin', now(), '0'),
    ('d8635281-3635-4ee3-ad51-bdc5d87c3977', 'Ксения', 'Демидова', 'Никитична', '1989-06-02', 'bb5158ba-a327-4e7a-81c1-806dd88dc7c5', null, 'admin', now(), 'admin', now(), '0'),
    ('f3f05411-a360-494d-9b92-eb0c459774fe', 'Али', 'Никитин', 'Демидович', '1995-02-15', 'd9698ac2-f7dd-472a-ba00-5347b7f0c402', null, 'admin', now(), 'admin', now(), '0'),
    ('2ef651e4-336b-41c3-ac6f-eafc8a6905e1', 'Вячеслав', 'Орлов', 'Максимович', '1980-09-09', '74f896a5-dc3f-4594-95b8-efd9097c132b', null, 'admin', now(), 'admin', now(), '0'),
    ('bfba0722-7f59-4afb-a366-60f74bcc678c', 'Давид', 'Верещагин', 'Михайлович', '1992-08-30', 'e7325b1c-6467-46cd-aa45-8a75ecc6b857', null, 'admin', now(), 'admin', now(), '0'),
    ('4dfc1ddc-4b9a-4665-a2b8-9ac8b20c49ec', 'Данил', 'Колосов', 'Андреевич', '1983-03-07', 'c964c687-5f9e-4c8f-bf98-e3e45cbd2dd3', null, 'admin', now(), 'admin', now(), '0'),
    ('8049dd18-bba6-4893-b94e-4e7e1104cc04', 'Роберт', 'Попов', 'Дмитриевич', '1999-03-29', '3486d97a-3ea5-4ebe-8a87-2d9ef34ba9eb', null, 'admin', now(), 'admin', now(), '0'),
    ('64888fdd-911b-4770-b1c1-2ad1a0a145e4', 'Эмилия', 'Кузнецова', 'Никитична', '1999-08-31', 'aceb10c5-4b50-4767-973e-b28cb93982b9', null, 'admin', now(), 'admin', now(), '0'),
    ('dd48d6b1-b8f8-46f7-9ddb-1421578e4299', 'Эмилия', 'Позднякова', 'Арсентьевна', '1984-12-25', '9bcb795d-a327-4c68-8f52-137844b68b77', null, 'admin', now(), 'admin', now(), '0'),
    ('78ee982e-c291-4e37-ad3c-18b4e50f01de', 'Анна', 'Юдина', 'Ильинична', '1982-05-10', '6add5f90-006b-4b80-b870-43f72f5d4d93', null, 'admin', now(), 'admin', now(), '0'),
    ('0fa60cb4-2fb9-4251-8107-3800f0feb82f', 'Тимофей', 'Федоров', 'Максимович', '1982-12-05', '9147ac55-dc9f-4796-b081-81280f18d983', null, 'admin', now(), 'admin', now(), '0'),
    ('1b78da40-26ab-44fd-91e8-32ed044db19e', 'Кира', 'Хомякова', 'Владимировна', '2000-04-28', '0c13752c-c8d1-44a1-ba95-5a10ad6acb7b', null, 'admin', now(), 'admin', now(), '0'),
    ('3f1069a3-6917-471a-ac4c-acfd1aa3d081', 'Маргарита', 'Никитина', 'Николаевна', '1997-09-19', '6ec54a3d-5c2a-44e1-8eb1-c74a4fee127d', null, 'admin', now(), 'admin', now(), '0'),
    ('781937c2-a212-4ab4-b79c-ac10bc272537', 'Ангелина', 'Коршунова', 'Матвеевна', '1981-07-28', 'c5aa5a00-718a-4198-af9d-adccaa77e9f6', null, 'admin', now(), 'admin', now(), '0'),
    ('f1e90c01-fae4-4568-83b0-9a63158eb2f9', 'София', 'Исакова', 'Тимофеевна', '1984-12-01', 'b9109411-84fe-4632-9869-c5e22c997810', null, 'admin', now(), 'admin', now(), '0'),
    ('523bca78-1375-4a01-9950-82941c489887', 'Данис', 'Зорин', 'Максимович', '1990-09-17', '05d130e8-3a14-47ab-96f2-09ad6df08175', null, 'admin', now(), 'admin', now(), '0'),
    ('fcf4c976-7b52-4ad4-8adf-ad9bb63a26c0', 'Милана', 'Софронова', 'Максимовна', '1994-10-14', '29f77ff0-a1a5-4a9e-8b95-dd4074a3c868', null, 'admin', now(), 'admin', now(), '0'),
    ('40a2c600-518d-4710-8f03-bf72bfeeddeb', 'Алина', 'Соколова', 'Владиславовна', '1997-08-05', 'd5edd21f-ed3f-47f7-9e16-69a4080e912b', null, 'admin', now(), 'admin', now(), '0'),
    ('13bd166c-a8c2-4501-ad47-51b50d2ace66', 'Анна', 'Жукова', 'Матвеевна', '1990-11-02', '2eb43f28-8e2f-4155-be61-d5aef8062703', null, 'admin', now(), 'admin', now(), '0');
