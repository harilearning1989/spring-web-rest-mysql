create table auth_mgmt.users (
    id bigint not null auto_increment,
    username varchar(20),
    email varchar(50),
    password varchar(120),
    primary key (id)
);

create table auth_mgmt.roles (
   id integer not null auto_increment,
   name enum ('ROLE_ADMIN','ROLE_MODERATOR','ROLE_USER'),
   primary key (id)
);

INSERT INTO auth_mgmt.roles(name) VALUES('ROLE_USER');
INSERT INTO auth_mgmt.roles(name) VALUES('ROLE_MODERATOR');
INSERT INTO auth_mgmt.roles(name) VALUES('ROLE_ADMIN');

create table auth_mgmt.user_roles (
   role_id integer not null,
   user_id bigint not null,
   primary key (role_id, user_id)
);

alter table auth_mgmt.users
    add constraint username_uc unique (username);

alter table auth_mgmt.users
    add constraint email_uc unique (email);

alter table auth_mgmt.user_roles
    add constraint role_id_fk
        foreign key (role_id)
            references auth_mgmt.roles (id);

alter table auth_mgmt.user_roles
    add constraint user_id_fk
        foreign key (user_id)
            references auth_mgmt.users (id);



