-- DROP TABLE MEMBER;

CREATE TABLE MEMBER (
	id bigint comment '아이디',
    userId VARCHAR(50) NOT NULL UNIQUE comment '사용자 아이디',
    password VARCHAR(200) NOT NULL comment '비밀번호',
    name VARCHAR(1000) NOT NULL comment '이름',
    birth VARCHAR(10) NOT NULL comment '생년월일',
    gender VARCHAR(10) NOT NULL comment '성별',
    phone VARCHAR(20) NOT NULL UNIQUE comment '휴대전화번호',
    email VARCHAR(100) NOT NULL UNIQUE comment '이메일',
    nation VARCHAR(10) NOT NULL comment '국가',
    postNumber VARCHAR(20) comment '우편번호',
    address VARCHAR(1000) comment '주소',
    addressDetail VARCHAR(2000) comment '상세주소',
    createMemberId bigint comment '등록한 회원 아이디',
    createDate datetime comment '등록일자',
    updateMemberId bigint comment '수정한 회원 아이디',
    updateDate datetime comment '수정일장',
    deleteMemberId bigint comment '삭제한 회원 아이디',
    deleteDate datetime comment '삭제일자',
    isActive tinyint NOT NULL DEFAULT '1' comment '활성화 여부',
    isTempPassword tinyint NOT NULL DEFAULT '0' comment '임시 비밀번호 여부',
    isAdmin tinyint DEFAULT '0' comment '관리자 여부',
    CONSTRAINT member_PK PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='회원 테이블';

COMMIT;