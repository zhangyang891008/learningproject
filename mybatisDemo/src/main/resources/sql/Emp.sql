/*
    private Integer empNo;
    private String empName;
    private String job;
    private Integer mgr;
    private Date hireDate;
    private Double sal;
    private Double common;
    private Dept dept;
*/

CREATE TABLE t_emp(
    empNo int primary key auto_increment,
    emp_name varchar(30),
    job varchar(30),
    mgr int,
    hire_date date,
    sal decimal(6,2),
    common decimal(6,2),
    dep_no int
)engine = InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET = utf8;