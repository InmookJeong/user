CREATE TABLE _USER (
	uid VARCHAR(50) comment '사용자 UID',
    ip VARCHAR(100) comment '사용자 IP 주소',
    accessDate DATETIME not null comment '접속시간',
    device VARCHAR(10) not null comment '사용기기',
    CONSTRAINT user_PK PRIMARY KEY(uid, ip)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='사용자 테이블';

COMMIT;