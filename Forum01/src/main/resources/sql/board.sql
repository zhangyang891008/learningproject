<!--board表-->
CREATE TABLE t_board(
    board_id int primary key auto_increment,
    board_name varchar(150),
    board_desc varchar(255),
    topic_num int
)engine = InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET = utf8;