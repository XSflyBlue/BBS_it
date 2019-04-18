???prompt PL/SQL Developer import file
prompt Created on 2017年8月1日 by zyy
set feedback off
set define off
prompt Creating B_DISTRICTS...
create table B_DISTRICTS
(
  district_id     NUMBER(11) not null,
  district_name   VARCHAR2(50),
  district_descri VARCHAR2(100)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column B_DISTRICTS.district_id
  is '分区ID';
comment on column B_DISTRICTS.district_name
  is '分区名';
comment on column B_DISTRICTS.district_descri
  is '分区描述';
alter table B_DISTRICTS
  add primary key (DISTRICT_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating B_SECTION...
create table B_SECTION
(
  section_id     NUMBER(11) not null,
  section_name   VARCHAR2(50),
  is_show        NUMBER(2),
  district_id    NUMBER(11),
  section_descri VARCHAR2(100)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column B_SECTION.section_id
  is '版块ID';
comment on column B_SECTION.section_name
  is '版块名';
comment on column B_SECTION.is_show
  is '是否显示';
comment on column B_SECTION.district_id
  is '分区ID';
comment on column B_SECTION.section_descri
  is '版块描述';
alter table B_SECTION
  add primary key (SECTION_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table B_SECTION
  add constraint SECTION_DISTRICT_ID_FK foreign key (DISTRICT_ID)
  references B_DISTRICTS (DISTRICT_ID) on delete cascade;

prompt Creating B_USER_BASE...
create table B_USER_BASE
(
  user_id         NUMBER(11) not null,
  username        VARCHAR2(50),
  email           VARCHAR2(50),
  password        VARCHAR2(50),
  last_login_time DATE,
  last_login_ip   VARCHAR2(20),
  power           NUMBER(2),
  regist_time     DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column B_USER_BASE.user_id
  is 'ID';
comment on column B_USER_BASE.username
  is '用户名';
comment on column B_USER_BASE.email
  is '邮箱';
comment on column B_USER_BASE.password
  is '密码';
comment on column B_USER_BASE.last_login_time
  is '上次登录时间';
comment on column B_USER_BASE.last_login_ip
  is '上次登录IP';
comment on column B_USER_BASE.power
  is '权限';
comment on column B_USER_BASE.regist_time
  is '注册时间';
alter table B_USER_BASE
  add primary key (USER_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating B_POST...
create table B_POST
(
  post_id           NUMBER(11) not null,
  user_id           NUMBER(11),
  section_id        NUMBER(11),
  post_type         NUMBER(2),
  theme_content     VARCHAR2(2000),
  issue_time        DATE,
  issue_ip          VARCHAR2(20),
  hit_num           NUMBER(10),
  answer_sum        NUMBER(10),
  is_highlight      NUMBER(2),
  highlight_user_id NUMBER(11),
  title_color       VARCHAR2(10),
  is_overhead       NUMBER(2),
  overhead_user_id  NUMBER(11),
  overhead_cause    VARCHAR2(100),
  is_close          NUMBER(2),
  switch_user_id    NUMBER(11),
  switch_cause      VARCHAR2(100),
  is_elite          NUMBER(2),
  recom_user_id     NUMBER(11),
  recom_validity    DATE,
  is_hidden         NUMBER(2),
  hidden_cause      VARCHAR2(100),
  hidden_user_id    NUMBER(11),
  is_accessory      NUMBER(2),
  edit_user_id      NUMBER(11),
  edit_time         DATE,
  post_title        VARCHAR2(100)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column B_POST.post_id
  is '帖子ID';
comment on column B_POST.user_id
  is '用户ID';
comment on column B_POST.section_id
  is '版块ID';
comment on column B_POST.post_type
  is '帖子类型';
comment on column B_POST.theme_content
  is '主题内容';
comment on column B_POST.issue_time
  is '发布时间';
comment on column B_POST.issue_ip
  is '发布IP';
comment on column B_POST.hit_num
  is '阅读次数';
comment on column B_POST.answer_sum
  is '回复总数';
comment on column B_POST.is_highlight
  is '是否高亮显示';
comment on column B_POST.highlight_user_id
  is '高亮/取消用户ID';
comment on column B_POST.title_color
  is '标题颜色';
comment on column B_POST.is_overhead
  is '是否置顶';
comment on column B_POST.overhead_user_id
  is '置顶/取消用户ID';
comment on column B_POST.overhead_cause
  is '置顶/取消原因';
comment on column B_POST.is_close
  is '是否关闭';
comment on column B_POST.switch_user_id
  is '关闭/打开用户ID';
comment on column B_POST.switch_cause
  is '关闭/打开原因';
comment on column B_POST.is_elite
  is '是否为精华';
comment on column B_POST.recom_user_id
  is '推荐/取消精华用户ID';
comment on column B_POST.recom_validity
  is '推荐/取消精华有效期';
comment on column B_POST.is_hidden
  is '是否隐藏';
comment on column B_POST.hidden_cause
  is '隐藏原因';
comment on column B_POST.hidden_user_id
  is '隐藏用户ID';
comment on column B_POST.is_accessory
  is '是否有附件';
comment on column B_POST.edit_user_id
  is '编辑用户ID';
comment on column B_POST.edit_time
  is '编辑时间';
alter table B_POST
  add primary key (POST_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table B_POST
  add foreign key (SECTION_ID)
  references B_SECTION (SECTION_ID) on delete cascade;
alter table B_POST
  add foreign key (USER_ID)
  references B_USER_BASE (USER_ID) on delete cascade;

prompt Creating B_ACCESSORY...
create table B_ACCESSORY
(
  accessory_id     NUMBER(11) not null,
  post_id          NUMBER(11),
  file_name        VARCHAR2(50),
  path             VARCHAR2(50),
  author           VARCHAR2(20),
  upload_time      DATE,
  accessory_descri VARCHAR2(100),
  file_size        NUMBER(10),
  download_num     NUMBER(10),
  cost_coin        NUMBER(10)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column B_ACCESSORY.accessory_id
  is '附件ID';
comment on column B_ACCESSORY.post_id
  is '帖子ID';
comment on column B_ACCESSORY.file_name
  is '文件名';
comment on column B_ACCESSORY.path
  is '路径';
comment on column B_ACCESSORY.author
  is '作者';
comment on column B_ACCESSORY.upload_time
  is '上传时间';
comment on column B_ACCESSORY.accessory_descri
  is '附件描述';
comment on column B_ACCESSORY.file_size
  is '大小';
comment on column B_ACCESSORY.download_num
  is '下载次数';
comment on column B_ACCESSORY.cost_coin
  is '所需消耗金币';
alter table B_ACCESSORY
  add primary key (ACCESSORY_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table B_ACCESSORY
  add constraint ACCESSORY_POST_ID_FK foreign key (POST_ID)
  references B_POST (POST_ID) on delete cascade;

prompt Creating B_COIN...
create table B_COIN
(
  user_id  NUMBER(11),
  coin_id  NUMBER(11) not null,
  coin_num NUMBER(10)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column B_COIN.user_id
  is '用户ID';
comment on column B_COIN.coin_id
  is '金币ID';
comment on column B_COIN.coin_num
  is '金币数';
alter table B_COIN
  add primary key (COIN_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table B_COIN
  add constraint COIN_USER_ID foreign key (USER_ID)
  references B_USER_BASE (USER_ID) on delete cascade;

prompt Creating B_COIN_RECORD...
create table B_COIN_RECORD
(
  coin_record_id NUMBER(11) not null,
  coin_id        NUMBER(10) not null,
  coin_cause     VARCHAR2(100),
  coin_get_num   NUMBER(10),
  coin_get_time  DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column B_COIN_RECORD.coin_record_id
  is '金币记录ID';
comment on column B_COIN_RECORD.coin_id
  is '金币ID';
comment on column B_COIN_RECORD.coin_cause
  is '获取原因';
comment on column B_COIN_RECORD.coin_get_num
  is '获取金币数';
comment on column B_COIN_RECORD.coin_get_time
  is '获取时间';
alter table B_COIN_RECORD
  add primary key (COIN_RECORD_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table B_COIN_RECORD
  add constraint COIN_RECORD_COIN_ID_FK foreign key (COIN_ID)
  references B_COIN (COIN_ID) on delete cascade;

prompt Creating B_COLLECTION...
create table B_COLLECTION
(
  user_id      NUMBER(11),
  post_id      NUMBER(11),
  collect_time DATE,
  collect_id   NUMBER(11) not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column B_COLLECTION.user_id
  is '用户ID';
comment on column B_COLLECTION.post_id
  is '帖子ID';
comment on column B_COLLECTION.collect_time
  is '收藏时间';
alter table B_COLLECTION
  add primary key (COLLECT_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table B_COLLECTION
  add constraint COLLECTION_POST_ID_FK foreign key (POST_ID)
  references B_POST (POST_ID) on delete cascade;
alter table B_COLLECTION
  add constraint COLLECTION_USER_ID_FK foreign key (USER_ID)
  references B_USER_BASE (USER_ID) on delete cascade;

prompt Creating B_MODERATOR...
create table B_MODERATOR
(
  moderator_id   NUMBER(11) not null,
  area_id        NUMBER(2),
  moderator_type NUMBER(2),
  user_id        NUMBER(11)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column B_MODERATOR.moderator_id
  is '版主记录ID';
comment on column B_MODERATOR.area_id
  is '版块ID';
comment on column B_MODERATOR.moderator_type
  is '类型';
alter table B_MODERATOR
  add primary key (MODERATOR_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table B_MODERATOR
  add constraint MODERATOR_USER_ID_FK foreign key (USER_ID)
  references B_USER_BASE (USER_ID) on delete cascade;

prompt Creating B_COMMENT...
create table B_COMMENT
(
  comment_id      NUMBER(11) not null,
  post_id         NUMBER(11),
  comment_user_id NUMBER(11),
  comment_time    DATE,
  comment_content VARCHAR2(2000),
  is_hidden       NUMBER(2),
  hidden_cause    VARCHAR2(100),
  hidden_user_id  NUMBER(11),
  comment_ip      VARCHAR2(20)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column B_COMMENT.comment_id
  is '跟帖ID';
comment on column B_COMMENT.post_id
  is '帖子ID';
comment on column B_COMMENT.comment_user_id
  is '跟帖用户ID';
comment on column B_COMMENT.comment_time
  is '跟帖时间';
comment on column B_COMMENT.comment_content
  is '跟帖内容';
comment on column B_COMMENT.is_hidden
  is '是否隐藏';
comment on column B_COMMENT.hidden_cause
  is '隐藏原因';
comment on column B_COMMENT.hidden_user_id
  is '隐藏用户ID';
comment on column B_COMMENT.comment_ip
  is '跟帖IP';
alter table B_COMMENT
  add primary key (COMMENT_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table B_COMMENT
  add constraint COMMENT_COMMENT_USER_ID foreign key (COMMENT_USER_ID)
  references B_USER_BASE (USER_ID) on delete cascade;
alter table B_COMMENT
  add constraint COMMENT_HIDDEN_USER_ID foreign key (HIDDEN_USER_ID)
  references B_MODERATOR (MODERATOR_ID) on delete cascade;
alter table B_COMMENT
  add constraint COMMENT_POST_ID_FK foreign key (POST_ID)
  references B_POST (POST_ID) on delete cascade
  disable
  novalidate;

prompt Creating B_LEVEL...
create table B_LEVEL
(
  level_id   NUMBER(11) not null,
  level_name VARCHAR2(20),
  exp_value  NUMBER(10)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column B_LEVEL.level_id
  is '等级ID';
comment on column B_LEVEL.level_name
  is '等级名称';
comment on column B_LEVEL.exp_value
  is '经验值';
alter table B_LEVEL
  add primary key (LEVEL_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating B_EXP...
create table B_EXP
(
  user_id  NUMBER(11),
  exp_id   NUMBER(11) not null,
  exp_num  NUMBER(10),
  level_id NUMBER(11)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column B_EXP.user_id
  is '用户ID';
comment on column B_EXP.exp_id
  is '经验ID';
comment on column B_EXP.exp_num
  is '经验数';
comment on column B_EXP.level_id
  is '等级ID';
alter table B_EXP
  add primary key (EXP_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table B_EXP
  add constraint EXP_LEVEL_ID_FK foreign key (LEVEL_ID)
  references B_LEVEL (LEVEL_ID) on delete cascade;
alter table B_EXP
  add constraint EXP_USER_ID_FK foreign key (USER_ID)
  references B_USER_BASE (USER_ID) on delete cascade;

prompt Creating B_EXP_RECORD...
create table B_EXP_RECORD
(
  exp_record_id NUMBER(11) not null,
  exp_id        NUMBER(11),
  exp_get_num   NUMBER(11),
  exp_get_cause VARCHAR2(100),
  exp_get_time  DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column B_EXP_RECORD.exp_record_id
  is '经验记录ID';
comment on column B_EXP_RECORD.exp_id
  is '经验ID';
comment on column B_EXP_RECORD.exp_get_num
  is '获取经验数';
comment on column B_EXP_RECORD.exp_get_cause
  is '获取原因';
comment on column B_EXP_RECORD.exp_get_time
  is '经验获取时间';
alter table B_EXP_RECORD
  add primary key (EXP_RECORD_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table B_EXP_RECORD
  add constraint EXP_RECORD_EXP_ID_FK foreign key (EXP_ID)
  references B_EXP (EXP_ID) on delete cascade;

prompt Creating B_FOLLOW...
create table B_FOLLOW
(
  follow_id      NUMBER(11) not null,
  user_id        NUMBER(11),
  note           VARCHAR2(50),
  follow_user_id NUMBER(11)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column B_FOLLOW.follow_id
  is '关注ID';
comment on column B_FOLLOW.user_id
  is '用户ID';
comment on column B_FOLLOW.note
  is '备注';
comment on column B_FOLLOW.follow_user_id
  is '关注用户ID';
alter table B_FOLLOW
  add primary key (FOLLOW_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table B_FOLLOW
  add constraint FOLLOW_USER_ID_FK foreign key (USER_ID)
  references B_USER_BASE (USER_ID) on delete cascade;

prompt Creating B_HELP_TYPE...
create table B_HELP_TYPE
(
  help_type_id   NUMBER(11) not null,
  help_type_name VARCHAR2(50)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column B_HELP_TYPE.help_type_id
  is '分类ID';
comment on column B_HELP_TYPE.help_type_name
  is '分类名称';
alter table B_HELP_TYPE
  add primary key (HELP_TYPE_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating B_HELP_THEME...
create table B_HELP_THEME
(
  help_theme_id   NUMBER(11) not null,
  help_theme_name VARCHAR2(50),
  help_type_id    NUMBER(11),
  help_content    VARCHAR2(2000)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column B_HELP_THEME.help_theme_id
  is '帮助主题ID';
comment on column B_HELP_THEME.help_theme_name
  is '帮助主题名称';
comment on column B_HELP_THEME.help_type_id
  is '所属分类ID';
comment on column B_HELP_THEME.help_content
  is '帮助内容';
alter table B_HELP_THEME
  add primary key (HELP_THEME_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table B_HELP_THEME
  add constraint HELP_THEME_HELP_TYPE_ID_FK foreign key (HELP_TYPE_ID)
  references B_HELP_TYPE (HELP_TYPE_ID) on delete cascade;

prompt Creating B_REPORT...
create table B_REPORT
(
  report_id      NUMBER(11) not null,
  report_user_id NUMBER(11),
  report_cause   VARCHAR2(100),
  report_time    DATE,
  moderator_id   NUMBER(11),
  report_post_id NUMBER(11)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column B_REPORT.report_id
  is '举报记录ID';
comment on column B_REPORT.report_user_id
  is '举报人ID';
comment on column B_REPORT.report_cause
  is '原因';
comment on column B_REPORT.report_time
  is '举报时间';
comment on column B_REPORT.moderator_id
  is '版主ID';
comment on column B_REPORT.report_post_id
  is '被举报帖子的ID';
alter table B_REPORT
  add primary key (REPORT_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table B_REPORT
  add constraint REPORT_MODERATOR_FK foreign key (MODERATOR_ID)
  references B_MODERATOR (MODERATOR_ID) on delete cascade;
alter table B_REPORT
  add constraint REPORT_POST_ID_FK foreign key (REPORT_POST_ID)
  references B_POST (POST_ID) on delete cascade;
alter table B_REPORT
  add constraint REPORT_REPORT_USER_ID foreign key (REPORT_USER_ID)
  references B_USER_BASE (USER_ID) on delete cascade;

prompt Creating B_USER_DETAIL...
create table B_USER_DETAIL
(
  user_id   NUMBER(11) not null,
  icon      VARCHAR2(50),
  sex       NUMBER(2),
  signature VARCHAR2(50),
  intro     VARCHAR2(200),
  birthday  DATE,
  region    VARCHAR2(20),
  website   VARCHAR2(30),
  qq        VARCHAR2(15)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column B_USER_DETAIL.user_id
  is 'ID';
comment on column B_USER_DETAIL.icon
  is '头像';
comment on column B_USER_DETAIL.sex
  is '性别';
comment on column B_USER_DETAIL.signature
  is '个性签名';
comment on column B_USER_DETAIL.intro
  is '自我介绍';
comment on column B_USER_DETAIL.birthday
  is '生日';
comment on column B_USER_DETAIL.region
  is '籍贯';
comment on column B_USER_DETAIL.website
  is '个人网站';
comment on column B_USER_DETAIL.qq
  is 'QQ';
alter table B_USER_DETAIL
  add primary key (USER_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table B_USER_DETAIL
  add constraint USER_DETAIL_USER_ID_FK foreign key (USER_ID)
  references B_USER_BASE (USER_ID);

prompt Disabling triggers for B_DISTRICTS...
alter table B_DISTRICTS disable all triggers;
prompt Disabling triggers for B_SECTION...
alter table B_SECTION disable all triggers;
prompt Disabling triggers for B_USER_BASE...
alter table B_USER_BASE disable all triggers;
prompt Disabling triggers for B_POST...
alter table B_POST disable all triggers;
prompt Disabling triggers for B_ACCESSORY...
alter table B_ACCESSORY disable all triggers;
prompt Disabling triggers for B_COIN...
alter table B_COIN disable all triggers;
prompt Disabling triggers for B_COIN_RECORD...
alter table B_COIN_RECORD disable all triggers;
prompt Disabling triggers for B_COLLECTION...
alter table B_COLLECTION disable all triggers;
prompt Disabling triggers for B_MODERATOR...
alter table B_MODERATOR disable all triggers;
prompt Disabling triggers for B_COMMENT...
alter table B_COMMENT disable all triggers;
prompt Disabling triggers for B_LEVEL...
alter table B_LEVEL disable all triggers;
prompt Disabling triggers for B_EXP...
alter table B_EXP disable all triggers;
prompt Disabling triggers for B_EXP_RECORD...
alter table B_EXP_RECORD disable all triggers;
prompt Disabling triggers for B_FOLLOW...
alter table B_FOLLOW disable all triggers;
prompt Disabling triggers for B_HELP_TYPE...
alter table B_HELP_TYPE disable all triggers;
prompt Disabling triggers for B_HELP_THEME...
alter table B_HELP_THEME disable all triggers;
prompt Disabling triggers for B_REPORT...
alter table B_REPORT disable all triggers;
prompt Disabling triggers for B_USER_DETAIL...
alter table B_USER_DETAIL disable all triggers;
prompt Deleting B_USER_DETAIL...
delete from B_USER_DETAIL;
commit;
prompt Deleting B_REPORT...
delete from B_REPORT;
commit;
prompt Deleting B_HELP_THEME...
delete from B_HELP_THEME;
commit;
prompt Deleting B_HELP_TYPE...
delete from B_HELP_TYPE;
commit;
prompt Deleting B_FOLLOW...
delete from B_FOLLOW;
commit;
prompt Deleting B_EXP_RECORD...
delete from B_EXP_RECORD;
commit;
prompt Deleting B_EXP...
delete from B_EXP;
commit;
prompt Deleting B_LEVEL...
delete from B_LEVEL;
commit;
prompt Deleting B_COMMENT...
delete from B_COMMENT;
commit;
prompt Deleting B_MODERATOR...
delete from B_MODERATOR;
commit;
prompt Deleting B_COLLECTION...
delete from B_COLLECTION;
commit;
prompt Deleting B_COIN_RECORD...
delete from B_COIN_RECORD;
commit;
prompt Deleting B_COIN...
delete from B_COIN;
commit;
prompt Deleting B_ACCESSORY...
delete from B_ACCESSORY;
commit;
prompt Deleting B_POST...
delete from B_POST;
commit;
prompt Deleting B_USER_BASE...
delete from B_USER_BASE;
commit;
prompt Deleting B_SECTION...
delete from B_SECTION;
commit;
prompt Deleting B_DISTRICTS...
delete from B_DISTRICTS;
commit;
prompt Loading B_DISTRICTS...
insert into B_DISTRICTS (district_id, district_name, district_descri)
values (1, '移动开发', '讨论互联网移动相关话题');
insert into B_DISTRICTS (district_id, district_name, district_descri)
values (2, '云计算', '云计算领域相关讨论');
insert into B_DISTRICTS (district_id, district_name, district_descri)
values (3, 'Java技术', '讨论Java相关技术');
insert into B_DISTRICTS (district_id, district_name, district_descri)
values (4, '.NET技术', '讨论.NET相关技术');
insert into B_DISTRICTS (district_id, district_name, district_descri)
values (5, 'Web开发', '讨论Web开发相关技术');
insert into B_DISTRICTS (district_id, district_name, district_descri)
values (6, '开发语言/框架', '开发语言/框架相关讨论');
insert into B_DISTRICTS (district_id, district_name, district_descri)
values (7, '数据库开发', '讨论数据库开发相关技术');
insert into B_DISTRICTS (district_id, district_name, district_descri)
values (8, '硬件/嵌入式开发', '讨论硬件/嵌入开发相关技术');
insert into B_DISTRICTS (district_id, district_name, district_descri)
values (9, 'Linux/Unix社区', '讨论Linux/Unix相关技术');
commit;
prompt 9 records loaded
prompt Loading B_SECTION...
insert into B_SECTION (section_id, section_name, is_show, district_id, section_descri)
values (1, 'IOS', 1, 1, '主要讨论与ios相关的软件和技术。');
insert into B_SECTION (section_id, section_name, is_show, district_id, section_descri)
values (2, 'Android', 1, 1, '移动平台Android。');
insert into B_SECTION (section_id, section_name, is_show, district_id, section_descri)
values (3, 'Qt', 1, 1, 'Qt是一个跨平台应用程序框架。');
insert into B_SECTION (section_id, section_name, is_show, district_id, section_descri)
values (4, 'WP', 1, 1, 'Windows Phone是微软发布的一款手机操作系统。');
insert into B_SECTION (section_id, section_name, is_show, district_id, section_descri)
values (5, 'AWS', 1, 2, 'AWS');
insert into B_SECTION (section_id, section_name, is_show, district_id, section_descri)
values (6, 'Pass/SaaS', 1, 2, 'Cloud Foundry');
insert into B_SECTION (section_id, section_name, is_show, district_id, section_descri)
values (7, '分布式计算/Hadoop', 1, 2, '分布式计算/Hadoop/Cassandra/Storm/Spark/大数据');
insert into B_SECTION (section_id, section_name, is_show, district_id, section_descri)
values (8, 'Java SE', 1, 3, 'Java 2 Standard Edition');
insert into B_SECTION (section_id, section_name, is_show, district_id, section_descri)
values (9, 'Java Web开发', 1, 3, 'Java Web开发');
insert into B_SECTION (section_id, section_name, is_show, district_id, section_descri)
values (10, 'Java EE', 1, 3, 'Java 2 Platform Enterprise Edition');
insert into B_SECTION (section_id, section_name, is_show, district_id, section_descri)
values (11, 'Java其他相关', 1, 3, 'Java相关');
insert into B_SECTION (section_id, section_name, is_show, district_id, section_descri)
values (12, '.NET Framework', 1, 4, '.NET技术 .NET Framework');
insert into B_SECTION (section_id, section_name, is_show, district_id, section_descri)
values (13, 'C#', 1, 4, '.NET技术 C#');
insert into B_SECTION (section_id, section_name, is_show, district_id, section_descri)
values (14, '.NET分析与设计', 1, 4, '.NET技术 分析与设计');
insert into B_SECTION (section_id, section_name, is_show, district_id, section_descri)
values (15, 'ASP.NET', 1, 4, '.NET技术 ASP.NET');
insert into B_SECTION (section_id, section_name, is_show, district_id, section_descri)
values (16, 'VB.NET', 1, 4, '.NET技术 VB.NET');
insert into B_SECTION (section_id, section_name, is_show, district_id, section_descri)
values (17, 'PHP', 1, 5, '讨论PHP相关技术');
insert into B_SECTION (section_id, section_name, is_show, district_id, section_descri)
values (18, 'JavaScript', 1, 5, 'Web开发 JavaScript');
insert into B_SECTION (section_id, section_name, is_show, district_id, section_descri)
values (19, 'ASP', 1, 5, 'Web开发ASP');
insert into B_SECTION (section_id, section_name, is_show, district_id, section_descri)
values (20, 'HTML(CSS)', 1, 5, 'Web开发 HTML(CSS)');
insert into B_SECTION (section_id, section_name, is_show, district_id, section_descri)
values (21, 'HTML5', 1, 5, 'HTML5');
insert into B_SECTION (section_id, section_name, is_show, district_id, section_descri)
values (22, 'Apache', 1, 5, 'Web开发 Apache');
insert into B_SECTION (section_id, section_name, is_show, district_id, section_descri)
values (23, 'Delphi', 1, 6, '讨论Delphi相关技术');
insert into B_SECTION (section_id, section_name, is_show, district_id, section_descri)
values (24, 'VC/MFC', 1, 6, '讨论VC/MFC相关技术');
insert into B_SECTION (section_id, section_name, is_show, district_id, section_descri)
values (25, 'C/C++', 1, 6, '讨论C/C++相关技术');
insert into B_SECTION (section_id, section_name, is_show, district_id, section_descri)
values (26, 'C++ Builder', 1, 6, '讨论C++ Builder相关技术');
insert into B_SECTION (section_id, section_name, is_show, district_id, section_descri)
values (27, '其他开发语言', 1, 6, '其他开发语言');
insert into B_SECTION (section_id, section_name, is_show, district_id, section_descri)
values (28, 'MS-SQL Server', 1, 7, '讨论MS-SQL Server相关技术');
insert into B_SECTION (section_id, section_name, is_show, district_id, section_descri)
values (29, 'Oracle', 1, 7, '讨论Oracle相关技术');
insert into B_SECTION (section_id, section_name, is_show, district_id, section_descri)
values (30, 'PowerBuilder', 1, 7, '讨论PowerBuilder相关技术');
insert into B_SECTION (section_id, section_name, is_show, district_id, section_descri)
values (31, 'Informatica', 1, 7, '讨论information相关技术');
insert into B_SECTION (section_id, section_name, is_show, district_id, section_descri)
values (32, '其他数据库开发', 1, 7, '讨论其他数据库开发相关技术');
insert into B_SECTION (section_id, section_name, is_show, district_id, section_descri)
values (33, '嵌入开发（WinCE）', 1, 8, '硬件/嵌入开发 嵌入开发（Win CE）');
insert into B_SECTION (section_id, section_name, is_show, district_id, section_descri)
values (34, '驱动开发/核心开发', 1, 8, '硬件/嵌入开发 驱动开发/核心开发');
insert into B_SECTION (section_id, section_name, is_show, district_id, section_descri)
values (35, '硬件设计', 1, 8, '硬件/嵌入设计 硬件设计');
insert into B_SECTION (section_id, section_name, is_show, district_id, section_descri)
values (36, '单片机/工控', 1, 8, '硬件/嵌入开发 单片机/工控');
insert into B_SECTION (section_id, section_name, is_show, district_id, section_descri)
values (37, '汇编语言', 1, 8, '其他开发语言 汇编语言');
insert into B_SECTION (section_id, section_name, is_show, district_id, section_descri)
values (38, 'VxWorks开发', 1, 8, '硬件/嵌入开发 VxWorks开发');
insert into B_SECTION (section_id, section_name, is_show, district_id, section_descri)
values (39, '系统维护与使用区', 1, 9, '系统使用、管理、维护问题。可以是Ubuntu,Fedora,Unix等');
insert into B_SECTION (section_id, section_name, is_show, district_id, section_descri)
values (40, '应用程序开发区', 1, 9, 'Linux/Unix社区 应用程序开发区');
insert into B_SECTION (section_id, section_name, is_show, district_id, section_descri)
values (41, '内核源代码研究区', 1, 9, 'Linux/Unix社区 内核源代码研究区');
insert into B_SECTION (section_id, section_name, is_show, district_id, section_descri)
values (42, '驱动程序开发区', 1, 9, '主要是开发驱动技术');
insert into B_SECTION (section_id, section_name, is_show, district_id, section_descri)
values (43, 'CPU和硬件区论坛', 1, 9, 'Linux/Unix kernel支持不同的硬件体系，X86,ARM,MIPS等等');
commit;
prompt 43 records loaded
prompt Loading B_USER_BASE...
insert into B_USER_BASE (user_id, username, email, password, last_login_time, last_login_ip, power, regist_time)
values (2, '李易峰', '19870504@qq.com', '0504', to_date('01-08-2017 09:06:09', 'dd-mm-yyyy hh24:mi:ss'), '10.123.14.89', null, to_date('20-07-2017 09:07:09', 'dd-mm-yyyy hh24:mi:ss'));
insert into B_USER_BASE (user_id, username, email, password, last_login_time, last_login_ip, power, regist_time)
values (3, '陈伟霆', '19871121@xinlang.com', '1121', to_date('01-08-2017 09:10:14', 'dd-mm-yyyy hh24:mi:ss'), '10.121.01.11', null, to_date('20-07-2017 09:10:31', 'dd-mm-yyyy hh24:mi:ss'));
insert into B_USER_BASE (user_id, username, email, password, last_login_time, last_login_ip, power, regist_time)
values (4, '吴亦凡', '19901106@162.com', '1106', to_date('01-08-2017 13:51:45', 'dd-mm-yyyy hh24:mi:ss'), '12.19.71.111', null, to_date('25-07-2017 13:52:06', 'dd-mm-yyyy hh24:mi:ss'));
insert into B_USER_BASE (user_id, username, email, password, last_login_time, last_login_ip, power, regist_time)
values (5, '马思纯', '19880314@qq.com', '0314', to_date('01-08-2017 13:56:39', 'dd-mm-yyyy hh24:mi:ss'), '10.21.191.12', null, to_date('27-07-2017 13:56:57', 'dd-mm-yyyy hh24:mi:ss'));
insert into B_USER_BASE (user_id, username, email, password, last_login_time, last_login_ip, power, regist_time)
values (6, '鹿晗', '19900420@qq.com', '0420', to_date('01-08-2017 13:58:12', 'dd-mm-yyyy hh24:mi:ss'), '11.10.192.11', null, to_date('28-07-2017 13:58:24', 'dd-mm-yyyy hh24:mi:ss'));
insert into B_USER_BASE (user_id, username, email, password, last_login_time, last_login_ip, power, regist_time)
values (7, '王俊凯', '19990921@cq.com', '0921', to_date('01-08-2017 13:59:12', 'dd-mm-yyyy hh24:mi:ss'), '10.12.198.21', null, to_date('28-07-2017 13:59:27', 'dd-mm-yyyy hh24:mi:ss'));
insert into B_USER_BASE (user_id, username, email, password, last_login_time, last_login_ip, power, regist_time)
values (8, '王源', '20001108@cq.com', '1108', to_date('01-08-2017 14:00:43', 'dd-mm-yyyy hh24:mi:ss'), '11.21.110.32', null, to_date('28-07-2017 14:00:54', 'dd-mm-yyyy hh24:mi:ss'));
insert into B_USER_BASE (user_id, username, email, password, last_login_time, last_login_ip, power, regist_time)
values (9, '迪丽热巴', '19920603@163.com', '0603', to_date('01-08-2017 14:02:47', 'dd-mm-yyyy hh24:mi:ss'), '11.23.14.110', null, to_date('26-07-2017 14:03:03', 'dd-mm-yyyy hh24:mi:ss'));
insert into B_USER_BASE (user_id, username, email, password, last_login_time, last_login_ip, power, regist_time)
values (10, '吴磊', '19991226@wulei.com', '1226', to_date('01-08-2017 14:03:53', 'dd-mm-yyyy hh24:mi:ss'), '18.20.110.19', null, to_date('27-07-2017 14:04:06', 'dd-mm-yyyy hh24:mi:ss'));
insert into B_USER_BASE (user_id, username, email, password, last_login_time, last_login_ip, power, regist_time)
values (1, '赵丽颖', '19871016@163.com', '1016', to_date('31-07-2017 19:05:43', 'dd-mm-yyyy hh24:mi:ss'), '10.123.13.18', null, to_date('19-07-2017 19:09:03', 'dd-mm-yyyy hh24:mi:ss'));
commit;
prompt 10 records loaded
prompt Loading B_POST...
prompt Table is empty
prompt Loading B_ACCESSORY...
prompt Table is empty
prompt Loading B_COIN...
insert into B_COIN (user_id, coin_id, coin_num)
values (1, 1, 9999999999);
insert into B_COIN (user_id, coin_id, coin_num)
values (2, 2, 999999999);
insert into B_COIN (user_id, coin_id, coin_num)
values (3, 3, 888888888);
insert into B_COIN (user_id, coin_id, coin_num)
values (4, 4, 66666);
insert into B_COIN (user_id, coin_id, coin_num)
values (5, 5, 19823411);
insert into B_COIN (user_id, coin_id, coin_num)
values (6, 6, 1111111111);
insert into B_COIN (user_id, coin_id, coin_num)
values (7, 7, 121122222);
insert into B_COIN (user_id, coin_id, coin_num)
values (8, 8, 888888888);
insert into B_COIN (user_id, coin_id, coin_num)
values (9, 9, 99996799);
insert into B_COIN (user_id, coin_id, coin_num)
values (10, 10, 10000001);
commit;
prompt 10 records loaded
prompt Loading B_COIN_RECORD...
insert into B_COIN_RECORD (coin_record_id, coin_id, coin_cause, coin_get_num, coin_get_time)
values (1, 1, '上传资源', 10, to_date('01-08-2017 14:27:02', 'dd-mm-yyyy hh24:mi:ss'));
insert into B_COIN_RECORD (coin_record_id, coin_id, coin_cause, coin_get_num, coin_get_time)
values (2, 8, '下载资源', -20, to_date('01-08-2017 14:27:26', 'dd-mm-yyyy hh24:mi:ss'));
commit;
prompt 2 records loaded
prompt Loading B_COLLECTION...
prompt Table is empty
prompt Loading B_MODERATOR...
insert into B_MODERATOR (moderator_id, area_id, moderator_type, user_id)
values (2, 1, 1, 2);
insert into B_MODERATOR (moderator_id, area_id, moderator_type, user_id)
values (1, null, 3, 1);
insert into B_MODERATOR (moderator_id, area_id, moderator_type, user_id)
values (3, 2, 1, 3);
insert into B_MODERATOR (moderator_id, area_id, moderator_type, user_id)
values (4, 3, 1, 4);
insert into B_MODERATOR (moderator_id, area_id, moderator_type, user_id)
values (5, 4, 1, 5);
insert into B_MODERATOR (moderator_id, area_id, moderator_type, user_id)
values (6, 5, 1, 6);
insert into B_MODERATOR (moderator_id, area_id, moderator_type, user_id)
values (7, 6, 1, 7);
insert into B_MODERATOR (moderator_id, area_id, moderator_type, user_id)
values (8, 7, 1, 8);
insert into B_MODERATOR (moderator_id, area_id, moderator_type, user_id)
values (9, 8, 1, 9);
insert into B_MODERATOR (moderator_id, area_id, moderator_type, user_id)
values (10, 9, 1, 10);
commit;
prompt 10 records loaded
prompt Loading B_COMMENT...
prompt Table is empty
prompt Loading B_LEVEL...
insert into B_LEVEL (level_id, level_name, exp_value)
values (0, '0', 0);
insert into B_LEVEL (level_id, level_name, exp_value)
values (1, '1', 5);
insert into B_LEVEL (level_id, level_name, exp_value)
values (2, '2', 20);
insert into B_LEVEL (level_id, level_name, exp_value)
values (3, '3', 50);
insert into B_LEVEL (level_id, level_name, exp_value)
values (4, '4', 100);
insert into B_LEVEL (level_id, level_name, exp_value)
values (5, '5', 200);
insert into B_LEVEL (level_id, level_name, exp_value)
values (6, '6', 400);
insert into B_LEVEL (level_id, level_name, exp_value)
values (7, '7', 700);
insert into B_LEVEL (level_id, level_name, exp_value)
values (8, '8', 1200);
insert into B_LEVEL (level_id, level_name, exp_value)
values (9, '9', 1800);
insert into B_LEVEL (level_id, level_name, exp_value)
values (10, '10', 9999999999);
commit;
prompt 11 records loaded
prompt Loading B_EXP...
insert into B_EXP (user_id, exp_id, exp_num, level_id)
values (1, 1, 99999, 10);
insert into B_EXP (user_id, exp_id, exp_num, level_id)
values (2, 2, 9999, 10);
insert into B_EXP (user_id, exp_id, exp_num, level_id)
values (3, 3, 8888, 10);
insert into B_EXP (user_id, exp_id, exp_num, level_id)
values (4, 4, 1788, 9);
insert into B_EXP (user_id, exp_id, exp_num, level_id)
values (5, 5, 1744, 9);
insert into B_EXP (user_id, exp_id, exp_num, level_id)
values (6, 6, 1666, 9);
insert into B_EXP (user_id, exp_id, exp_num, level_id)
values (7, 7, 1111, 8);
insert into B_EXP (user_id, exp_id, exp_num, level_id)
values (8, 8, 1001, 8);
insert into B_EXP (user_id, exp_id, exp_num, level_id)
values (9, 9, 666, 7);
insert into B_EXP (user_id, exp_id, exp_num, level_id)
values (10, 10, 555, 7);
commit;
prompt 10 records loaded
prompt Loading B_EXP_RECORD...
insert into B_EXP_RECORD (exp_record_id, exp_id, exp_get_num, exp_get_cause, exp_get_time)
values (1, 1, 2, '发布主题帖', to_date('01-08-2017 16:59:45', 'dd-mm-yyyy hh24:mi:ss'));
insert into B_EXP_RECORD (exp_record_id, exp_id, exp_get_num, exp_get_cause, exp_get_time)
values (2, 5, 1, '回复帖子', to_date('01-08-2017 17:00:14', 'dd-mm-yyyy hh24:mi:ss'));
commit;
prompt 2 records loaded
prompt Loading B_FOLLOW...
insert into B_FOLLOW (follow_id, user_id, note, follow_user_id)
values (1, 2, '碧瑶', 1);
insert into B_FOLLOW (follow_id, user_id, note, follow_user_id)
values (2, 3, '新月', 1);
insert into B_FOLLOW (follow_id, user_id, note, follow_user_id)
values (3, 6, '吃货热巴', 9);
insert into B_FOLLOW (follow_id, user_id, note, follow_user_id)
values (4, 4, '磊磊', 10);
insert into B_FOLLOW (follow_id, user_id, note, follow_user_id)
values (5, 10, '凡哥', 4);
insert into B_FOLLOW (follow_id, user_id, note, follow_user_id)
values (6, 6, '俊凯', 7);
insert into B_FOLLOW (follow_id, user_id, note, follow_user_id)
values (7, 7, '王源', 8);
insert into B_FOLLOW (follow_id, user_id, note, follow_user_id)
values (8, 5, '伟霆', 3);
commit;
prompt 8 records loaded
prompt Loading B_HELP_TYPE...
prompt Table is empty
prompt Loading B_HELP_THEME...
prompt Table is empty
prompt Loading B_REPORT...
prompt Table is empty
prompt Loading B_USER_DETAIL...
insert into B_USER_DETAIL (user_id, icon, sex, signature, intro, birthday, region, website, qq)
values (1, null, 0, '荆棘之上仰望的人，会看透风尘。', '哈哈，我是楚乔', to_date('16-10-1987', 'dd-mm-yyyy'), '河北', 'www.zly.xinlang', '19871016');
insert into B_USER_DETAIL (user_id, icon, sex, signature, intro, birthday, region, website, qq)
values (2, null, 1, '年少有你。', '你好，我是喋喋', to_date('04-05-1987', 'dd-mm-yyyy'), '四川', 'www.lyf.baidu', '19870504');
insert into B_USER_DETAIL (user_id, icon, sex, signature, intro, birthday, region, website, qq)
values (3, null, 1, '佛爷在此！', '我是饱饱', to_date('21-11-1987', 'dd-mm-yyyy'), '香港', 'www.cwt.youku', '19871121');
insert into B_USER_DETAIL (user_id, icon, sex, signature, intro, birthday, region, website, qq)
values (4, null, 1, '你有freestyle吗?', '我是忽悠王。', to_date('06-11-1990', 'dd-mm-yyyy'), '广东', 'www.freestyle.com', '19901106');
insert into B_USER_DETAIL (user_id, icon, sex, signature, intro, birthday, region, website, qq)
values (5, null, 0, '七月与安生', '我是七月', to_date('14-03-1988', 'dd-mm-yyyy'), '安徽', 'www.msc.com', '19880314');
insert into B_USER_DETAIL (user_id, icon, sex, signature, intro, birthday, region, website, qq)
values (6, null, 1, '我们的明天', '我是狍子，哈哈', to_date('20-04-1990', 'dd-mm-yyyy'), '北京', 'www.luhan.com', '19900420');
insert into B_USER_DETAIL (user_id, icon, sex, signature, intro, birthday, region, website, qq)
values (7, null, 1, '我只想对你对你宠爱', '我叫凯凯！', to_date('21-09-1999', 'dd-mm-yyyy'), '重庆', 'www.wjk.com', '19990921');
insert into B_USER_DETAIL (user_id, icon, sex, signature, intro, birthday, region, website, qq)
values (8, null, 1, '跟着我左手右手一个慢动作', '我是汤圆。', to_date('08-11-2000', 'dd-mm-yyyy'), '重庆', 'www.wy.com', '20001108');
insert into B_USER_DETAIL (user_id, icon, sex, signature, intro, birthday, region, website, qq)
values (9, null, 0, '我们一起来转圈吧', '我是新疆菇凉', to_date('03-06-1992', 'dd-mm-yyyy'), '新疆', 'www.dlrb.com', '19920603');
insert into B_USER_DETAIL (user_id, icon, sex, signature, intro, birthday, region, website, qq)
values (10, null, 1, '凡哥，我们“大象”', '我是磊磊', to_date('26-12-1999', 'dd-mm-yyyy'), '上海', 'www.wl.com', '19911226');
commit;
prompt 10 records loaded
prompt Enabling triggers for B_DISTRICTS...
alter table B_DISTRICTS enable all triggers;
prompt Enabling triggers for B_SECTION...
alter table B_SECTION enable all triggers;
prompt Enabling triggers for B_USER_BASE...
alter table B_USER_BASE enable all triggers;
prompt Enabling triggers for B_POST...
alter table B_POST enable all triggers;
prompt Enabling triggers for B_ACCESSORY...
alter table B_ACCESSORY enable all triggers;
prompt Enabling triggers for B_COIN...
alter table B_COIN enable all triggers;
prompt Enabling triggers for B_COIN_RECORD...
alter table B_COIN_RECORD enable all triggers;
prompt Enabling triggers for B_COLLECTION...
alter table B_COLLECTION enable all triggers;
prompt Enabling triggers for B_MODERATOR...
alter table B_MODERATOR enable all triggers;
prompt Enabling triggers for B_COMMENT...
alter table B_COMMENT enable all triggers;
prompt Enabling triggers for B_LEVEL...
alter table B_LEVEL enable all triggers;
prompt Enabling triggers for B_EXP...
alter table B_EXP enable all triggers;
prompt Enabling triggers for B_EXP_RECORD...
alter table B_EXP_RECORD enable all triggers;
prompt Enabling triggers for B_FOLLOW...
alter table B_FOLLOW enable all triggers;
prompt Enabling triggers for B_HELP_TYPE...
alter table B_HELP_TYPE enable all triggers;
prompt Enabling triggers for B_HELP_THEME...
alter table B_HELP_THEME enable all triggers;
prompt Enabling triggers for B_REPORT...
alter table B_REPORT enable all triggers;
prompt Enabling triggers for B_USER_DETAIL...
alter table B_USER_DETAIL enable all triggers;
set feedback on
set define on
prompt Done.
