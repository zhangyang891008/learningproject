
<!--user表-->
CREATE TABLE t_user(
    user_id int primary key auto_increment,
    user_name varchar(30),
    password varchar(30),
    user_type tinyint,
    locked tinyint,
    credit int
)engine = InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET = utf8;

select * from t_user;

insert into t_user values(1,'zhangsan','pw',1,1,234);

alter table t_user remove column last_visit datetime;
alter table t_user add column last_ip varchar(30);