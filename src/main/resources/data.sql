
--ADD USER
INSERT INTO public."user"(id, account_expired, account_locked, credentials_expired, enabled, "password", username) VALUES(0, false, false, false, true, '$2a$10$lCgjmaV3o9zXyBJiIEiXiOWXjXxRC7T4LI0CSyTWCXotLa5kixo0i', 'admin');

--ADD ROLES
INSERT INTO public."role"(id, name) VALUES(1, 'ROLE_USER');
INSERT INTO public."role"(id, name) VALUES(2, 'ROLE_ADMIN');

--ADD PRIVILEGES
INSERT INTO public."privilege"(id, name) VALUES(1, 'ACCESS_ALL_USERS');

--SET THE ROLES IN THE USER
INSERT INTO public.users_roles(user_id, role_id) VALUES(0, 1);
INSERT INTO public.users_roles(user_id, role_id) VALUES(0, 2);


--SET THE PRIVILEGE OF ACCESS ALL THE USERS IN USER ADMIN
INSERT INTO public.roles_privileges(role_id, privilege_id) VALUES(2, 1);
