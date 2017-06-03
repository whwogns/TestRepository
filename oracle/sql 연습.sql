/*
select ��
*/

--bwriter�� ȫ�浿�� ����÷��� ���� �������ÿ�.
select *
from board
where bwriter='ȫ�浿';

--bwriter�� ȫ�浿�� bno, btitle, bwriter�� �������ÿ�
select bno, btitle, bwriter
from board
where bwriter='ȫ�浿';

--bno�� 1���� 10���̿� �Խù��� �������ÿ�   and
select bno, btitle, bwriter
from board
where bno>=1 and bno<=10;

select bno, btitle, bwriter
from board
where bno between 1 and 10;    --between and ������ ���� and���� ���� ó�� �ֳĸ�between and�� �ϳ��� �����ڹǷ�

--bwriter�� 'ȫ'���� �����ϴ� �Խù��� bno, btitle, bwriter�� �������ÿ�
select bno, btitle, bwriter
from board
where bwriter like '%ȫ%';

--�Խù��� �����߿� '�ڹ�'�� ���ԵǾ� �ִ� �Խù��� ��ȣ, ����, �۾��̸� �������ÿ�
select bno, btitle, bwriter
from board
where btitle like '%�ڹ�%';

--�Խù��� ����, �����߿� '�ڹ�'�� ���ԵǾ� �ִ� �Խù��� ��ȣ, ����, �۾���, ���븦 �������ÿ�   or
select bno, btitle, bwriter, bcontent
from board
where btitle like '%�ڹ�%' or bcontent like '%�ڹ�%';


--�۾��̰� '���ڹ�', '��浿', '�����'�� �Խù��� ��ȣ, ����, �۾��̸� �������ÿ�
select bno, btitle, bwriter
from board
where bwriter='���ڹ�' or bwriter='��浿' or bwriter='�����';

select bno, btitle, bwriter
from board
where bwriter in ('���ڹ�','��浿','�����');  -- ���� or�����ڿ� ���� ����.

--÷�������� ���� �Խù��� �������ÿ�.
select *
from board
where boriginalfilename is null;

--÷������  �ִ� �Խù��� �������ÿ�
select *
from board
where boriginalfilename is not null;   

--�Խù��� �ۼ��� ����� �̸��� �������ÿ�(�ߺ������ϰ�)
select bwriter from board;  -- (�ߺ����� �ȵȻ���)
select distinct bwriter from board;  -- (�ߺ��� �����ϰ� ������)

--�Խñ��� �� ��¥�� 2016���� �Խñ��� �������ÿ�.
select bdate 
from board 
where '2016.01.01'<=bdate and bdate<='2016.12.31' ;

select bdate 
from board 
where bdate between '2016.01.01' and '2016.12.31' ;

--bno->��ȣ, btitle->����, bwriter->�۾��� �� �÷� �̸��� �����ؼ� �������ÿ�
select bno as ��ȣ, btitle as ����, bwriter  �۾���   --���� �÷��� �ٲ�°� �ƴ� ����¿����� �÷��̸��� �ٸ���.
from board;

/*
����
*/
--�Խù��� ��ȣ�� �������� �ø��������� �������ÿ�
select *
from board
order by bno asc; --�����ص� �⺻������ asc

--2017�⵵�� �ۼ��� �Խù��� ��ȣ�� �������� ������������ �������ÿ�
select *
from board
where bdate between '2017.1.1' and '2017.12.31'
order by bno desc;

--�۾��̸� �������� 1�� ����(�ø�)�ϰ� �� ��¥�� �������� 2������(����)�Ͻÿ�
select *
from board
order by bwriter asc, bdate desc;

/*
����¡ ó��
*/
--����Ǿ� �ִ� ������� �� ��ȣ �ű��
select rownum, bno, btitle, bwriter, bdate, bhitcount
from board;

--������, �� ��ȣ �ű��
select rownum, bno, btitle, bwriter, bdate, bhitcount
from (select bno, btitle, bwriter, bdate, bhitcount from board order by bno desc);


--Ư�� ���ȣ ���ϸ� ��������(Top N�� ��������)
select rownum, bno, btitle, bwriter, bdate, bhitcount
from (select bno, btitle, bwriter, bdate, bhitcount from board order by bno desc);
where rownum<=10;

--���� ���ȣ�� �� ���ȣ ������ �Խù� ��������
select r, bno, btitle, bwriter, bdate, bhitcount
from(
select rownum as r, bno, btitle, bwriter, bdate, bhitcount
from(
select bno, btitle, bwriter, bdate, bhitcount from board order by bno desc
)
where rownum<=20
)
where r>=11;

--��ü ��� ���ϱ�
select count(*) from board;
select count(bno) from board;
select count(boriginalfilename) from board;

--Ư�� ���ǿ� �´� ��� ���ϱ�
select count(*) from board where bwriter <> 'ȫ�浿';



CREATE TABLE IOTUSER.BOARD
(
    bno number primary key,
    btitle varchar2(200) not null,
    bcontent varchar2(4000),
    bwriter varchar2(20) not null,
    bdate date not null,
    bpassword varchar(20),
    bhitcount number default 0 not null,
    boriginalfilename varchar2(200),
    bsavedfilename varchar2(200),
    bfilecontent varchar2(20)
)

