DROP TABLE book CASCADE CONSTRAINTS;
CREATE TABLE book
(
    Book_No    NUMBER Primary key,
    Book_Name    VARCHAR2(100) NOT NULL,
    Book_Writer    VARCHAR2(50) NOT NULL,
    Book_Price    NUMBER NOT NULL,
    publisher    VARCHAR2(30) NOT NULL,
    genre    VARCHAR2(30) NOT NULL
);
COMMENT ON COLUMN book.Book_No IS 'å��ȣ';
COMMENT ON COLUMN book.Book_Name IS '����';
COMMENT ON COLUMN book.Book_Writer IS '�۾���';
COMMENT ON COLUMN book.Book_Price IS '����';
COMMENT ON COLUMN book.publisher IS '���ǻ�';
COMMENT ON COLUMN book.genre IS '�帣';
COMMENT ON TABLE book IS 'å';


DROP TABLE customer CASCADE CONSTRAINTS;
CREATE TABLE customer
(
    user_No    NUMBER NOT NULL,
    User_Id    VARCHAR2(20) PRIMARY KEY,
    user_Name    VARCHAR2(20) NOT NULL,
    user_Age    NUMBER NOT NULL,
    Addr    VARCHAR2(100) NOT NULL,
    Gender    CHAR(1) CHECK(GENDER IN('M','F')),
    Enroll_Date    DATE DEFAULT SYSDATE
);

COMMENT ON COLUMN customer.user_No IS '����ȣ';
COMMENT ON COLUMN customer.User_Id IS '�����̵�';
COMMENT ON COLUMN customer.user_Name IS '�̸�';
COMMENT ON COLUMN customer.user_Age IS '����';
COMMENT ON COLUMN customer.Addr IS '�ּ�';
COMMENT ON COLUMN customer.Gender IS '����';
COMMENT ON COLUMN customer.Enroll_Date IS '������';
COMMENT ON TABLE customer IS '��';

DROP TABLE library CASCADE CONSTRAINTS;
CREATE TABLE library
(
    Lease_No    NUMBER Primary key,
    Book_No    NUMBER NOT NULL,
    User_Id    VARCHAR2(20) NOT NULL,
    Lease_date    DATE DEFAULT SYSDATE,
    Return_date    DATE NOT NULL,
    FOREIGN KEY (Book_NO) REFERENCES book (Book_NO) ON DELETE CASCADE,
    FOREIGN KEY (User_Id) REFERENCES customer (User_Id) ON DELETE CASCADE
);
COMMENT ON COLUMN library.Lease_No IS '�뿩��ȣ';
COMMENT ON COLUMN library.Book_No IS 'å��ȣ';
COMMENT ON COLUMN library.Lease_date IS '�뿩��';
COMMENT ON COLUMN library.Return_date IS '�ݳ���';
COMMENT ON COLUMN library.User_Id IS '�����̵�';
COMMENT ON TABLE library IS '������';



INSERT INTO book VALUES (1,'���̷���','����ȣ',4500,'���﹮ȭ��','�ڹ�/����');
INSERT INTO book VALUES (2,'���� ��Ű��','�����ø� ���繫',4500,'�ڹ����ǻ�','�ڹ�');
INSERT INTO book VALUES (3,'�����ϰ� ������ �ʴ� ��ȭ��','������ �������',12800,'ȫ�����ǻ�','�ɸ����');
INSERT INTO book VALUES (4,'������ȣ','������',4500,'���������','����');
INSERT INTO book VALUES (5,'��Ʈ�ٵϿ�','ī�̾� ��',5000,'����','���');

INSERT INTO customer VALUES (1,'user11','ȫ�浿',20,'����Ư���� ���Ǳ� ���Ƿ� 145(��õ��) 123-33 1��','M','15/01/27');
INSERT INTO customer VALUES (2,'khlove','���ȣ',30,'��õ������ ������ ������ 29(������) 23-4 205ȣ','F','12/03/11');
INSERT INTO customer VALUES (3,'hakgugu','���б�',40,'��⵵ ��õ�� ���ַ� 210(�ߵ�) 99-1 101ȣ','M','16/03/24');
INSERT INTO customer VALUES (4,'javakim','���ڹ�',53,'����Ư���� ���α� û�ʹ�� 1 49-4 602ȣ','F','17/02/25');
INSERT INTO customer VALUES (5,'dbmaster','õ���',19,'����� ������ ���Ϸ� 267 52-33 4��','M','18/03/01');

DELETE FROM LIBRARY;
DROP SEQUENCE SEQ_LEASE_NO;
CREATE SEQUENCE SEQ_LEASE_NO NOCYCLE NOCACHE;
INSERT INTO library VALUES(SEQ_LEASE_NO.NEXTVAL,2,'user11','18/04/01','18/04/03');
INSERT INTO library VALUES(SEQ_LEASE_NO.NEXTVAL,3,'khlove','18/04/02','18/04/04');
INSERT INTO library VALUES(SEQ_LEASE_NO.NEXTVAL,4,'javakim','18/04/05','18/04/07');
INSERT INTO library VALUES(SEQ_LEASE_NO.NEXTVAL,1,'dbmaster','18/04/07','18/04/09');

DECLARE
    V_BOOKNAME VARCHAR2(100);
BEGIN
    FOR N IN 6..300
    LOOP
        V_BOOKNAME := N||'å';
        INSERT INTO BOOK VALUES(N, V_BOOKNAME, '�۰�', 1000, '���ǻ�', '�帣');
    END LOOP;
END;
/

DECLARE
    V_USERID VARCHAR2(100);
    V_USERNAME VARCHAR2(100);
BEGIN
    FOR N IN 6..300
    LOOP
        V_USERID := N||'user';
        V_USERNAME := N||'����';
        INSERT INTO CUSTOMER VALUES(N, V_USERID, V_USERNAME, 20, '����', 'F', DEFAULT);
    END LOOP;
END;
/

BEGIN
    FOR N IN 1..187
    LOOP
        INSERT INTO LIBRARY VALUES(SEQ_LEASE_NO.NEXTVAL
        , 1, 'user11', DEFAULT, SYSDATE+2);
    END LOOP;
END;
/

COMMIT;


DESC book;
DESC customer;
DESC library;


SELECT * FROM book;
SELECT * FROM customer;
SELECT * FROM library;

