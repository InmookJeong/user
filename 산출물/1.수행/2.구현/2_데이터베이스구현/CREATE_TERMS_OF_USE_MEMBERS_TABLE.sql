-- DROP TABLE TERMS_OF_USE_MEMBERS;

CREATE TABLE TERMS_OF_USE_MEMBERS (
	termsOfUseId bigint comment '약관 아이디',
    memberId bigint comment '회원 아이디',
    isAgree tinyint NOT NULL DEFAULT '0' comment '동의 여부',
    createMemberId bigint not null comment '등록한 회원 아이디',
    createDate datetime not null comment '등록일자',
    updateMemberId bigint comment '수정한 회원 아이디',
    updateDate datetime comment '수정일자',
    CONSTRAINT terms_of_use_members_PK PRIMARY KEY(termsOfUseId, memberId),
    CONSTRAINT terms_of_use_id_FK FOREIGN KEY (termsOfUseId) REFERENCES TERMS_OF_USE (id),
    CONSTRAINT member_id_FK FOREIGN KEY (memberId) REFERENCES MEMBER (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='약관 테이블';

COMMIT;