-- 创建nybikedb库
create database nybikedb;
-- 使用nybikedb库
use nybikedb;

create table tb_is(
sid int comment'站点id',
name varchar(50) comment'站点名称',
lat double comment'纬度',
lon double comment'经度'
);

create table tb_ss(
sid int comment '站点id',
nba int comment '可用车数量',
nbd int comment '不可用车数量',
nda int comment '可用桩数量',
ndd int comment '不可用桩数量'
);	


load data infile 'd:/status_sample.csv' 
into table tb_ss 
fields terminated by ',' 
lines terminated by '\r\n';

load data infile 'd:/info_sample.csv' 
into table tb_is 
fields terminated by ',' 
lines terminated by '\r\n';


-- tb_ss表中nba的最大值是多少
select max(nba) from tb_ss;

-- 纽约市可用车数量最多的站点的全部信息
-- 分析
-- 查哪些字段:*
-- 查哪些表:tb_ss
-- 查询条件:nba=68
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



//练习骑行
create table tb_trip_count(
   c_date int comment '日期',
   c_hour int comment '小时',
   c_number int comment '骑行数量'
);
load data infile 'd:/trip_count.csv' 
into table tb_trip_count
fields terminated by ',' 
lines terminated by '\n';



-- --------------------以下是hive操作
create table test(
id int,
name string,
score double
);

insert into test values(1,'a',98),(1,'b',96),(1,'c',100);


-- 创建tb_trip_0601
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
-- 导入hdfs上的数据
load data inpath 'hdfs://master:8020/201906.csv' overwrite into table tb_trip_06;

-- 需求：统计6.1骑行数据的男女各自人数
select gender, count(*) from tb_trip_0601 group by gender;

-- 需求:统计每个小时的骑行次数
select count(*),hour(starttime) from tb_trip_0601 group by hour(starttime);





create table tb_day_hour_count(
c_day int,
c_hour int,
c_count int
)ROW FORMAT DELIMITED FIELDS TERMINATED BY',';

-- 执行查询，结果插入结果表
insert into tb_day_hour_count 
select day(starttime), hour(starttime), count(*) 
from tb_trip_0601 
group by day(starttime),hour(starttime);