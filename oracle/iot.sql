/*
select 문
*/

--bwriter가 홍길동인 모든컬럼의 값을 가져오시오.
select *
from board
where bwriter='홍길동';

--bwriter가 홍길동인 bno, btitle, bwriter를 가져오시오
select bno, btitle, bwriter
from board
where bwriter='홍길동';

--bno가 1에서 10사이에 게시물을 가져오시오   and
select bno, btitle, bwriter
from board
where bno>=1 and bno<=10;

select bno, btitle, bwriter
from board
where bno between 1 and 10;    --between and 연산자 위의 and보다 빠른 처리 왜냐면between and는 하나의 연산자므로

--bwriter가 '홍'으로 시작하는 게시물의 bno, btitle, bwriter를 가져오시오
select bno, btitle, bwriter
from board
where bwriter like '%홍%';

--게시물의 제목중에 '자바'가 포함되어 있는 게시물의 번호, 제목, 글쓴이를 가져오시오
select bno, btitle, bwriter
from board
where btitle like '%자바%';

--게시물의 제목, 내용중에 '자바'가 포함되어 있는 게시물의 번호, 제목, 글쓴이, 내용를 가져오시오   or
select bno, btitle, bwriter, bcontent
from board
where btitle like '%자바%' or bcontent like '%자바%';


--글쓴이가 '감자바', '김길동', '라즈베리'인 게시물의 번호, 제목, 글쓴이를 가져오시오
select bno, btitle, bwriter
from board
where bwriter='감자바' or bwriter='김길동' or bwriter='라즈베리';

select bno, btitle, bwriter
from board
where bwriter in ('감자바','김길동','라즈베리');  -- 위의 or연산자와 같은 것임.

--첨부파일이 없는 게시물을 가져오시오.
select *
from board
where boriginalfilename is null;

--첨부파일  있는 게시물을 가져오시오
select *
from board
where boriginalfilename is not null;   

--게시물을 작성한 사람의 이름을 가져오시오(중복제거하고)
select bwriter from board;  -- (중복제거 안된상태)
select distinct bwriter from board;  -- (중복을 제거하고 가져옴)

--게시글을 쓴 날짜가 2016년인 게시글을 가져오시오.
select bdate 
from board 
where '2016.01.01'<=bdate and bdate<='2016.12.31' ;

select bdate 
from board 
where bdate between '2016.01.01' and '2016.12.31' ;

--bno->번호, btitle->제목, bwriter->글쓴이 로 컬럼 이름을 변경해서 가져오시오
select bno as 번호, btitle as 제목, bwriter  글쓴이   --실제 컬럼이 바뀌는게 아닌 결과셋에서만 컬럼이름이 다르다.
from board;

/*
정렬
*/
--게시물의 번호를 기준으로 올림차순으로 가져오시오
select *
from board
order by bno asc; --생략해도 기본적으로 asc

--2017년도에 작성한 게시물의 번호를 기준으로 내림차순으로 가져오시오
select *
from board
where bdate between '2017.1.1' and '2017.12.31'
order by bno desc;

--글쓴이를 기준으로 1차 정렬(올림)하고 쓴 날짜를 기준으로 2차정렬(내림)하시오
select *
from board
order by bwriter asc, bdate desc;

/*
페이징 처리
*/
--저장되어 있는 순서대로 행 번호 매기기
select rownum, bno, btitle, bwriter, bdate, bhitcount
from board;

--정렬후, 행 번호 매기기
from (select bno, btitle, bwriter, bdate, bhitcount from board order by bno desc);

where rownum<=10;

--특정 행번호 이하만 가져오기(Top N을 가져오기)
select rownum, bno, btitle, bwriter, bdate, bhitcount
from (select bno, btitle, bwriter, bdate, bhitcount from board order by bno desc);










