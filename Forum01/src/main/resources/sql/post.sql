<!--topic表-->
CREATE TABLE t_post(
    post_id int primary key auto_increment,
    board_id int,
    topic_id int,
    user_id int,
    post_type tinyint(4),
    post_title varchar(50),
    post_text text,
    create_time date
)engine = InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET = utf8;