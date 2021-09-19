insert into tbl_role values (1, 'owner'),
                            (2, 'principal'),
                            (3, 'professor');

insert into tbl_user(id, username, email, password, role_id) values(1, 'chorro', 'chorro@chorro.chorro', 'chorro', 1),
                           (2, 'admin', 'principal@proof.co', 'principal_admin', 2),
                          (3, 'profe', 'proffesor@proof.co', 'proffesor', 3);

insert into tbl_race values (1, 'Chiwawa'),
                            (2, 'Pastor Berga'),
                            (3, 'Lobo toelhijueputa');

insert into tbl_pet values (1, 1, 'roberto', 1, 2, 2),
                            (2, 1, 'firulais',1, 2, 2),
                            (3, 1, 'marujo', 1, 2, 2);