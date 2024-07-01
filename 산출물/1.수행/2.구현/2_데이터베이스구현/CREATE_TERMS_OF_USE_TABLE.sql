-- DROP TABLE TERMS_OF_USE;

CREATE TABLE TERMS_OF_USE (
	id bigint auto_increment comment '아이디',
    orderNumber bigint UNIQUE comment '출력 순번',
    useYn tinyint NOT NULL DEFAULT '0' comment '사용여부',
    isEssential tinyint NOT NULL DEFAULT '1' comment '필수여부',
    title VARCHAR(4000) NOT NULL comment '약관 타이틀',
    content_text longtext NOT NULL comment '약관 내용_text',
    content_html longtext comment '약관 내용_html',
    content_md longtext comment '약관 내용_markdown',
    createMemberId bigint not null comment '등록한 회원 아이디',
    createDate datetime not null comment '등록일자',
    updateMemberId bigint comment '수정한 회원 아이디',
    updateDate datetime comment '수정일자',
    CONSTRAINT terms_of_use_PK PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='약관 테이블';

COMMIT;