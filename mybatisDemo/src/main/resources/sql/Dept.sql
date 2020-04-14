
/*
    private Integer deptNo;
    private String deptName;
    private String location;
 */

CREATE TABLE t_dept(
    dept_no int primary key auto_increment,
    dept_name varchar(30),
    location varchar(30)
)engine = InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET = utf8;