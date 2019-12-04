-- ����nybikedb��
create database nybikedb;
-- ʹ��nybikedb��
use nybikedb;

create table tb_is(
sid int comment'վ��id',
name varchar(50) comment'վ������',
lat double comment'γ��',
lon double comment'����'
);

create table tb_ss(
sid int comment 'վ��id',
nba int comment '���ó�����',
nbd int comment '�����ó�����',
nda int comment '����׮����',
ndd int comment '������׮����'
);	


load data infile 'd:/status_sample.csv' 
into table tb_ss 
fields terminated by ',' 
lines terminated by '\r\n';

load data infile 'd:/info_sample.csv' 
into table tb_is 
fields terminated by ',' 
lines terminated by '\r\n';


-- tb_ss����nba�����ֵ�Ƕ���
select max(nba) from tb_ss;

-- ŦԼ�п��ó���������վ���ȫ����Ϣ
-- ����
-- ����Щ�ֶ�:*
-- ����Щ��:tb_ss
-- ��ѯ����:nba=68
select
*
from
tb_ss
where
nba=(select max(nba) from tb_ss);

select t1.name,t2.nba
from tb_is t1,tb_ss t2
where
 t1.sid=t2.sid
 and
 t1.sid=445;

select
t1.name,t2.nba
from
tb_is t1,tb_ss t2
where
t1.sid=t2.sid
and
t2.nba=(select max(nba) from tb_ss);

select
*
from
tb_ss
where
nba=0;

select (select count(*) from tb_ss where nba=0)/count(*) from tb_ss;



//��ϰ����
create table tb_trip_count(
   c_date int comment '����',
   c_hour int comment 'Сʱ',
   c_number int comment '��������'
);
load data infile 'd:/trip_count.csv' 
into table tb_trip_count
fields terminated by ',' 
lines terminated by '\n';



-- --------------------������hive����
create table test(
id int,
name string,
score double
);

insert into test values(1,'a',98),(1,'b',96),(1,'c',100);


-- ����tb_trip_0601
create table tb_trip_06(
tripduration int,
starttime string,
stoptime string,
start_station_id int,
start_station_name string,
start_station_latitude double,
start_station_longitude double,
end_station_id int,
end_station_name string,
end_station_latitude double,
end_station_longitude double,
bikeid int,
usertype string,
birth_year int,
gender int
)ROW FORMAT DELIMITED FIELDS TERMINATED BY ',';

hdfs dfs -put hello /
-- ����hdfs�ϵ�����
load data inpath 'hdfs://master:8020/201906.csv' overwrite into table tb_trip_06;

-- ����ͳ��6.1�������ݵ���Ů��������
select gender, count(*) from tb_trip_0601 group by gender;

-- ����:ͳ��ÿ��Сʱ�����д���
select count(*),hour(starttime) from tb_trip_0601 group by hour(starttime);





create table tb_day_hour_count(
c_day int,
c_hour int,
c_count int
)ROW FORMAT DELIMITED FIELDS TERMINATED BY',';

-- ִ�в�ѯ�������������
insert into tb_day_hour_count 
select day(starttime), hour(starttime), count(*) 
from tb_trip_0601 
group by day(starttime),hour(starttime);