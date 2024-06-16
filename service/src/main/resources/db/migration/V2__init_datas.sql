INSERT INTO class.users( email, name, phone_number, password, user_type, usable, created_at, updated_at) VALUES('student1@naver.com', '학생1', '01011112222', '$2a$10$csOy//TlRGH4Cn.dZwIGQuv3dx0Hc/1yt6on8gzS3Wc84edXMY9G.', 'STUDENT', 1, now(),now());
INSERT INTO class.users( email, name, phone_number, password, user_type, usable, created_at, updated_at) VALUES('student2@naver.com', '학생2', '01011112222', '$2a$10$6KOXP7pdNDmTgbck34lRaOKzeNkKbnPGXXFOjIjcqd3kXYyf31IBa', 'STUDENT', 1, now(),now());
INSERT INTO class.users( email, name, phone_number, password, user_type, usable, created_at, updated_at) VALUES('student3@naver.com', '학생3', '01011112222', '$2a$10$H9B63q8zfFTk7egjbPyHYeJwxvoyVzlw/sDHjLjmygMHGb1Kyyjte', 'STUDENT', 1, now(),now());
INSERT INTO class.users( email, name, phone_number, password, user_type, usable, created_at, updated_at) VALUES('instructor1@naver.com', '강사1', '01011112222', '$2a$10$qUsK61zsrIxWemlHE68sDevQN7zKqz./yMI.ljaMGs2YVRN.sQ7hG', 'INSTRUCTOR', 1, now(),now());
INSERT INTO class.users( email, name, phone_number, password, user_type, usable, created_at, updated_at) VALUES('instructor2@naver.com', '강사2', '01011112222', '$2a$10$jFuXWgYxJrzPXJifsA2iSOJcNGCBk5qaX1LT8ya1C.hwi0cwhrUhe', 'INSTRUCTOR', 1, now(),now());
INSERT INTO class.users( email, name, phone_number, password, user_type, usable, created_at, updated_at) VALUES('instructor3@naver.com', '강사3', '01011112222', '$2a$10$/zgfJ.1JcngToxAiAcIckeM1mr53D8rmCjwW0nSDj/06/2klIPm6u', 'INSTRUCTOR', 1, now(),now());

INSERT INTO class.lectures(name, status, price, enrolment_limit_count, enrolment_count, user_id, usable, created_at, updated_at)VALUES('[강사1]첫강의!!!', 'OPEN', 10, 3, 1, 4, 1, now(),now());
INSERT INTO class.lectures(name, status, price, enrolment_limit_count, enrolment_count, user_id, usable, created_at, updated_at)VALUES('[강사1]두번째강의!!!', 'OPEN', 10, 3, 0, 4, 1, now(),now());
INSERT INTO class.lectures(name, status, price, enrolment_limit_count, enrolment_count, user_id, usable, created_at, updated_at)VALUES('[강사1]세번째강의!!!', 'OPEN', 10, 3, 1, 4, 1, now(),now());
INSERT INTO class.lectures(name, status, price, enrolment_limit_count, enrolment_count, user_id, usable, created_at, updated_at)VALUES('[강사1]네번째강의!!!', 'OPEN', 10, 3, 0, 4, 1, now(),now());
INSERT INTO class.lectures(name, status, price, enrolment_limit_count, enrolment_count, user_id, usable, created_at, updated_at)VALUES('[강사1]다섯번째강의!!!', 'OPEN', 10, 3, 1, 4, 1, now(),now());
INSERT INTO class.lectures(name, status, price, enrolment_limit_count, enrolment_count, user_id, usable, created_at, updated_at)VALUES('[강사1]특강!!!', 'OPEN', 10, 3, 0, 4, 1, now(),now());
INSERT INTO class.lectures(name, status, price, enrolment_limit_count, enrolment_count, user_id, usable, created_at, updated_at)VALUES('[강사1]스페셜강의!!', 'OPEN', 10, 3, 1, 4, 1, now(),now());

INSERT INTO class.lectures(name, status, price, enrolment_limit_count, enrolment_count, user_id, usable, created_at, updated_at)VALUES('[강사2]나만의강의!!!', 'OPEN', 10, 5, 0, 5, 1, now(),now());
INSERT INTO class.lectures(name, status, price, enrolment_limit_count, enrolment_count, user_id, usable, created_at, updated_at)VALUES('[강사2]너를위한강의!!!', 'OPEN', 10, 4, 0, 5, 1, now(),now());
INSERT INTO class.lectures(name, status, price, enrolment_limit_count, enrolment_count, user_id, usable, created_at, updated_at)VALUES('[강사2]모두를위한강의!!!', 'OPEN', 10, 4, 0, 5, 1, now(),now());
INSERT INTO class.lectures(name, status, price, enrolment_limit_count, enrolment_count, user_id, usable, created_at, updated_at)VALUES('[강사2]폐강위기강의!!!', 'OPEN', 10, 4, 0, 5, 1, now(),now());
INSERT INTO class.lectures(name, status, price, enrolment_limit_count, enrolment_count, user_id, usable, created_at, updated_at)VALUES('[강사2]취업잘되는강의!!!', 'OPEN', 10, 10, 0, 5, 1, now(),now());
INSERT INTO class.lectures(name, status, price, enrolment_limit_count, enrolment_count, user_id, usable, created_at, updated_at)VALUES('[강사2]취업안되는강의!!!', 'OPEN', 10, 20, 0, 5, 1, now(),now());

INSERT INTO class.lectures(name, status, price, enrolment_limit_count, enrolment_count, user_id, usable, created_at, updated_at)VALUES('[강사3] 비밀강의 시리즈 1', 'OPEN', 10, 10, 0, 6, 1,now(),now());
INSERT INTO class.lectures(name, status, price, enrolment_limit_count, enrolment_count, user_id, usable, created_at, updated_at)VALUES('[강사3] 비밀강의 시리즈 2', 'OPEN', 10, 9, 2, 6, 1, now(),now());
INSERT INTO class.lectures(name, status, price, enrolment_limit_count, enrolment_count, user_id, usable, created_at, updated_at)VALUES('[강사3] 비밀강의 시리즈 3', 'OPEN', 10, 8, 1, 6, 1, now(),now());
INSERT INTO class.lectures(name, status, price, enrolment_limit_count, enrolment_count, user_id, usable, created_at, updated_at)VALUES('[강사3] 비밀강의 시리즈 4', 'OPEN', 10, 7, 0, 6, 1, now(),now());
INSERT INTO class.lectures(name, status, price, enrolment_limit_count, enrolment_count, user_id, usable, created_at, updated_at)VALUES('[강사3] 비밀강의 시리즈 5', 'OPEN', 10, 6, 1, 6, 1, now(),now());
INSERT INTO class.lectures(name, status, price, enrolment_limit_count, enrolment_count, user_id, usable, created_at, updated_at)VALUES('[강사3] 비밀강의 시리즈 6', 'OPEN', 10, 5, 0, 6, 1, now(),now());

INSERT INTO class.lectures(name, status, price, enrolment_limit_count, enrolment_count, user_id, usable, created_at, updated_at)VALUES('[강사3] 프리미엄 강의 시리즈 1', 'OPEN', 10, 10, 1, 6, 1,now(),now());
INSERT INTO class.lectures(name, status, price, enrolment_limit_count, enrolment_count, user_id, usable, created_at, updated_at)VALUES('[강사3] 프리미엄 강의 시리즈 2', 'OPEN', 10, 9, 0, 6, 1, now(),now());
INSERT INTO class.lectures(name, status, price, enrolment_limit_count, enrolment_count, user_id, usable, created_at, updated_at)VALUES('[강사3] 프리미엄 강의 시리즈 3', 'OPEN', 10, 8, 0, 6, 1, now(),now());
INSERT INTO class.lectures(name, status, price, enrolment_limit_count, enrolment_count, user_id, usable, created_at, updated_at)VALUES('[강사3] 프리미엄 강의 시리즈 4', 'OPEN', 10, 7, 0, 6, 1, now(),now());
INSERT INTO class.lectures(name, status, price, enrolment_limit_count, enrolment_count, user_id, usable, created_at, updated_at)VALUES('[강사3] 프리미엄 강의 시리즈 5', 'OPEN', 10, 6, 0, 6, 1, now(),now());
INSERT INTO class.lectures(name, status, price, enrolment_limit_count, enrolment_count, user_id, usable, created_at, updated_at)VALUES('[강사3] 프리미엄 강의 시리즈 6', 'OPEN', 10, 5, 0, 6, 1, now(),now());


INSERT INTO class.lecture_users(lecture_id, user_id, created_at, updated_at)VALUES(1, 1, now(),now());
INSERT INTO class.lecture_users(lecture_id, user_id, created_at, updated_at)VALUES(3, 2, now(),now());
INSERT INTO class.lecture_users(lecture_id, user_id, created_at, updated_at)VALUES(5, 1, now(),now());
INSERT INTO class.lecture_users(lecture_id, user_id, created_at, updated_at)VALUES(7, 1, now(),now());
INSERT INTO class.lecture_users(lecture_id, user_id, created_at, updated_at)VALUES(16, 2,now(),now());
INSERT INTO class.lecture_users(lecture_id, user_id, created_at, updated_at)VALUES(18, 2,now(),now());
INSERT INTO class.lecture_users(lecture_id, user_id, created_at, updated_at)VALUES(20, 3,now(),now());
INSERT INTO class.lecture_users(lecture_id, user_id, created_at, updated_at)VALUES(15, 1,now(),now());
INSERT INTO class.lecture_users(lecture_id, user_id, created_at, updated_at)VALUES(15, 3,now(),now());
