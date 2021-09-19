insert into tbl_role
values (1, 'owner'),
       (2, 'principal'),
       (3, 'professor');

insert into tbl_permission
values (1, 'create pet'),
       (2, 'remove pet'),
       (3, 'edit pet'),
       (4, 'accept pet');


insert into tbl_user(id, username, email, password, authentication_type, log_in_code, role_id)
values (1, 'chorro', 'chorro@chorro.chorro', '$2a$10$h/gDY6yO3kJWU1kYcjNSeOB7Ak0hB2Ed9eWmd8u/UIO4cLDw9jRtG',  'google', '$2a$10$h/gDY6yO3kJWU1kYcjNSeOB7Ak0hB2Ed9eWmd8u/UIO4cLDw9jRtG', 1),
       (2, 'admin', 'principal@proof.co', '$2a$10$t7hLU7kK05YQVbFdxvZhQO0/r1GDxxfK1Wk3UsrmvPkmYwp7DoC9e','google', '2222sss', 2),
       (3, 'profe', 'proffesor@proof.co', '$2a$10$h/gDY6yO3kJWU1kYcjNSeOB7Ak0hB2Ed9eWmd8u/UIO4cLDw9jRtG', 'google', 'krypikrypikrypi', 3);

insert into tbl_race
values (1, 'Chiwawa'),
       (2, 'Pastor Berga'),
       (3, 'Lobo toelhijueputa');

insert into tbl_pet values (1, 1, 'bañar en azufre', 'roberto', 1, 'moderna', 2, 2),
                            (2, 1, 'tirar en paracaidas', 'firulais',1, 'pfizer', 2, 2),
                            (3, 1, 'calvear', 'marujo', 1, 'astrazeneca', 2, 2);

insert into tbl_permission_role values (1, 1, 1);
