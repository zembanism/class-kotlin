create table users
(
    id            bigint      not null auto_increment comment 'ID',
    email         varchar(100) not null comment '이메일(Login ID)',
    name          varchar(50) not null comment '이름',
    phone_number  varchar(50) not null comment '전화번호',
    password      varchar(500) not null comment '비밀번호',
    user_type     varchar(50) not null comment '회원유형',
    usable        tinyint(1) default true not null comment '사용여부',
    created_at    datetime(6) not null comment '생성일시',
    updated_at    datetime(6) not null comment '수정일시',
    primary key (id),
    index         email(email),
    index         user_type(user_type),
    index         usable(usable),
    index         created_at(created_at),
    index         updated_at(updated_at)
) comment '회원정보';

create table lectures
(
    id            bigint      not null auto_increment comment 'ID',
    version       bigint      not null default 0 comment 'version',
    name          varchar(50) not null comment '강의명',
    status        varchar(50) not null comment '강의명 상태',
    price         bigint      not null comment '가격',
    enrolment_limit_count int not null comment '최대수강인원',
    enrolment_count int not null comment '수강신청인원수',
    user_id       bigint not null comment '강의 소유자',
    usable        tinyint(1)  default true not null comment '사용여부',
    created_at    datetime(6) not null comment '생성일시',
    updated_at    datetime(6) not null comment '수정일시',
    primary key (id),
    index         name(name),
    index         enrolment_limit_count(enrolment_limit_count),
    index         enrolment_count(enrolment_count),
    index         user_id(user_id),
    index         usable(usable),
    index         created_at(created_at),
    index         updated_at(updated_at)
) comment '강의정보';

create table lecture_users
(
    id            bigint      not null auto_increment comment 'ID',
    lecture_id      bigint not null comment '강의ID',
    user_id      bigint not null comment '사용자ID',
    created_at    datetime(6) not null comment '생성일시',
    updated_at    datetime(6) not null comment '수정일시',
    primary key (id),
    index         lecture_id(lecture_id),
    index         user_id(user_id),
    index         created_at(created_at),
    index         updated_at(updated_at)
) comment '수강생 강의 신청내역';

