CREATE TABLE `student` (
  `id`  INT(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '学号',
  `name` VARCHAR(50) NOT NULL COMMENT '学生姓名',
  `sex` TINYINT(4) NOT NULL DEFAULT 0 COMMENT '性别, 0未知， 1 男, 2 女',
  `age` SMALLINT(3) NOT NULL DEFAULT 0 COMMENT '年龄',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生表';



CREATE TABLE `course` (
  `id` INT(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '课程id',
  `name` varchar(50) NOT NULL COMMENT '课程名字',
  `teacher` INT(11) NOT NULL COMMENT '老师的id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程表';

CREATE TABLE `student_course` (
  `id` INT(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '课程id',
  `student_id` INT(11) NOT NULL COMMENT '学生id',
  `course` INT(11) NOT NULL COMMENT '课程id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='选课表';


