-- Create table
create table GP_INFO
(
  code        VARCHAR2(64),
  short_name  VARCHAR2(200),
  name        VARCHAR2(200),
  stype       VARCHAR2(2),
  state       VARCHAR2(2),
  remark      VARCHAR2(2000),
  create_date DATE
)
tablespace BASETABLESPACE
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table GP_INFO
  is '股票基本信息';
