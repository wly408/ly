--删除表空间
drop tablespace basetablespace including contents and datafiles;
--创建表空间
create tablespace basetablespace datafile 'd:\tablespace\oracel\basetablespace.dbf' size 2500m;
--创建用户
create user  base  identified by wly123456 default tablespace basetablespace temporary tablespace temp;
grant connect to base;
grant dba to base;

--创建表
