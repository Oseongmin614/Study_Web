-- 웹전용 게시판 테이블 생성
CREATE TABLE TBL_BOARD(
    NO  NUMBER(5) PRIMARY KEY
    , TITLE VARCHAR2(100) NOT NULL
    , WRITER VARCHAR2(50) NOT NULL
    , CONTENT VARCHAR2(1000) NOT NULL
    , VIEW_CNT NUMBER(5) DEFAULT 0
    , REG_DATE DATE DEFAULT SYSDATE
);

CREATE SEQUENCE SEQ_TBL_BOARD_NO NOCACHE;

insert into tbl_board(no, title, writer, content)
 values(seq_tbl_board_no.nextval, '제목입니다', '닌자', '내용입니다');
 
insert into tbl_board(no, title, writer, content)
 values(seq_tbl_board_no.nextval, '내일은??', '닌자2', 'YOLO날!!!!');
 
commit;

select * from tbl_board;