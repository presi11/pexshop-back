insert into tbl_role values (1, 'owner'),
                            (2, 'principal'),
                            (3, 'professor');

insert into tbl_user(id, username, email, password, role_id) values(1, 'chorro', 'chorro@chorro.chorro', 'chorro', 1),
                           (2, 'admin', 'principal@proof.co', 'principal_admin', 2),
                          (3, 'profe', 'proffesor@proof.co', 'proffesor', 3);