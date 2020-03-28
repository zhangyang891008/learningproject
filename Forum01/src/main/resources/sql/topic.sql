<!--topic表-->
CREATE TABLE t_topic(
    topic_id int primary key auto_increment,
    board_id int,
    topic_title varchar(100),
    user_id int,
    create_time date,
    last_post date,
    topic_views int,
    topic_replies int,
    digest int
)engine = InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET = utf8;