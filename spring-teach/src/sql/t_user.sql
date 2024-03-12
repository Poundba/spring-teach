create table t_user
(
    id       varchar(100) not null
        primary key,
    username varchar(10)  null,
    password varchar(50)  null comment '密码',
    gender   char         not null,
    mobile   varchar(30)  null,
    address  varchar(50)  null
);

INSERT INTO `spring-teach`.t_user (id, username, password, gender, mobile, address) VALUES ('371e5d75-eb93-4d7c-9d63-d20ae797961a', 'Billy', '123456', '0', '12e', 'asdf');
INSERT INTO `spring-teach`.t_user (id, username, password, gender, mobile, address) VALUES ('4885f59f-e3ba-4e5a-b39b-0273a9d12739', 'Rorschach', '666666', '0', 'dasfa', 'GZ');
INSERT INTO `spring-teach`.t_user (id, username, password, gender, mobile, address) VALUES ('69fb7840-aace-40ac-ab1f-9db313b3ca8c', 'Betterman', '1231', '1', '123213', 'asdfasdf');
INSERT INTO `spring-teach`.t_user (id, username, password, gender, mobile, address) VALUES ('7941a085-a1f8-4897-9dd1-b6706ed48d42', 'Daniel', '111', '1', '911', 'CHINA');
