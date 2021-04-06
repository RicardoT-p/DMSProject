--  删除数据库
DROP DATABASE dmsdb;
--  创建数据库
CREATE DATABASE dmsdb;
-- 使用数据库
USE dmsdb;
-- 删除数据表
DROP TABLE document;
DROP TABLE action;
DROP TABLE admin;
DROP TABLE role_groups;
DROP TABLE role;
DROP TABLE groups;
DROP TABLE dept;
-- 创建数据表
--  1、部门表
CREATE TABLE dept(
   did                  INT     AUTO_INCREMENT,
   title                VARCHAR(50),
   note                 VARCHAR(200),
   CONSTRAINT pk_did PRIMARY KEY(did)
);

-- 2、角色表
CREATE TABLE role(
   rid                  INT    AUTO_INCREMENT,
   title                VARCHAR(50),
   note                 VARCHAR(100),
   CONSTRAINT pk_rid PRIMARY KEY(rid)
);

-- 3、权限组表
CREATE TABLE groups(
   gid                  INT       AUTO_INCREMENT,
   title                VARCHAR(50),
   icon                 VARCHAR(50),
   note                 VARCHAR(100),
   CONSTRAINT pk_rid PRIMARY KEY(gid)
);

-- 4、角色_权限组表
CREATE TABLE role_groups(
   rid                  INT,
   gid                  INT,
   CONSTRAINT fk_rid FOREIGN KEY(rid) REFERENCES role (rid) on delete cascade ,
   CONSTRAINT fk_gid FOREIGN KEY (gid) REFERENCES groups (gid) on delete cascade
);

-- 5、权限表
CREATE TABLE action(
   actid                INT AUTO_INCREMENT,
   gid                  INT,
   title                VARCHAR(50),
   icon                 VARCHAR(50),
   url                  VARCHAR(200),
   CONSTRAINT pk_actid PRIMARY KEY(actid),
   CONSTRAINT fk_gida FOREIGN KEY (gid) REFERENCES groups (gid) on delete set null
);

-- 6、用户信息表
CREATE TABLE admin(
   aid                  VARCHAR(50) NOT NULL ,
   rid                  INT,
   did                  INT,
   password             VARCHAR(32),
   photo                VARCHAR(50) DEFAULT 'user.png',
   lastdate             DATETIME,
   type                 INT,
   status               INT,
   CONSTRAINT pk_aid PRIMARY KEY(aid),
   CONSTRAINT fk_rida FOREIGN KEY (rid) REFERENCES role (rid) on delete set null,
   CONSTRAINT fk_did FOREIGN KEY (did) REFERENCES dept (did) on delete set null
);

-- 7、登录日志
CREATE TABLE logs(
   logid                INT AUTO_INCREMENT,
   aid                  VARCHAR(50),
   indate               DATETIME,
   ip                   VARCHAR(50),
   CONSTRAINT pk_logid PRIMARY KEY(logid),
   CONSTRAINT fk_aid FOREIGN KEY (aid) REFERENCES admin (aid) on delete cascade
);

-- 8、文档信息表
CREATE TABLE document(
  dcid                 INT AUTO_INCREMENT,
  did                  INT,
  aid                  VARCHAR(50),
  title                VARCHAR(50),
  filename             VARCHAR(150),
  credate              DATETIME,
  status               INT,
  CONSTRAINT pk_logs PRIMARY KEY(dcid),
  CONSTRAINT fk_dida FOREIGN KEY (did) REFERENCES dept (did) on delete cascade,
  CONSTRAINT fk_aida FOREIGN KEY (aid) REFERENCES admin (aid) on delete cascade
);

-- 测试数据
-- 1、角色信息
INSERT INTO role(title, note) VALUES ('超级管理员','----');
INSERT INTO role(title, note) VALUES ('部门经理','----');
INSERT INTO role(title, note) VALUES ('普通职员','----');

-- 2、 权限组信息
INSERT INTO groups(title, icon, note) VALUES ('权限管理','glyphicon glyphicon-home','----');
INSERT INTO groups(title, icon, note) VALUES ('员工管理','glyphicon glyphicon-leaf','----');
INSERT INTO groups(title, icon, note) VALUES ('文档管理','glyphicon glyphicon-fire','----');

-- 3、角色——权限组信息
INSERT INTO role_groups(rid, gid) VALUES (1,1);
INSERT INTO role_groups(rid, gid) VALUES (2,2);
INSERT INTO role_groups(rid, gid) VALUES (2,3);
INSERT INTO role_groups(rid, gid) VALUES (3,3);

-- 4、权限信息
INSERT INTO action(gid, title, icon, url) VALUES (1,'增加权限组','glyphicon glyphicon-arrow-right','/pages/back/admin/groups/GroupsBackServlet/insertPre');
INSERT INTO action(gid, title, icon, url) VALUES (1,'权限组列表','glyphicon glyphicon-arrow-right','/pages/back/admin/groups/GroupsBackServlet/list');
INSERT INTO action(gid, title, icon, url) VALUES (1,'增加角色','glyphicon glyphicon-arrow-right','/pages/back/admin/role/RoleBackServlet/insertPre');
INSERT INTO action(gid, title, icon, url) VALUES (1,'角色列表','glyphicon glyphicon-arrow-right','/pages/back/admin/role/RoleBackServlet/list');
INSERT INTO action(gid, title, icon, url) VALUES (1,'增加权限','glyphicon glyphicon-arrow-right','/pages/back/admin/action/ActionBackServlet/insertPre');
INSERT INTO action(gid, title, icon, url) VALUES (1,'权限列表','glyphicon glyphicon-arrow-right','/pages/back/admin/action/ActionBackServlet/list');
INSERT INTO action(gid, title, icon, url) VALUES (1,'增加部门经理','glyphicon glyphicon-arrow-right','/pages/back/admin/admin/AdminSuperBackServlet/insertPre');
INSERT INTO action(gid, title, icon, url) VALUES (1,'部门经理列表','glyphicon glyphicon-arrow-right','/pages/back/admin/admin/AdminSuperBackServlet/list');
INSERT INTO action(gid, title, icon, url) VALUES (1,'增加部门','glyphicon glyphicon-arrow-right','/pages/back/admin/dept/DeptBackServlet/insertPre');
INSERT INTO action(gid, title, icon, url) VALUES (1,'部门列表','glyphicon glyphicon-arrow-right','/pages/back/admin/dept/DeptBackServlet/list');
INSERT INTO action(gid, title, icon, url) VALUES (1,'日志列表','glyphicon glyphicon-arrow-right','/pages/back/admin/logs/LogsBackServlet/list');

INSERT INTO action(gid, title, icon, url) VALUES (2,'增加职员','glyphicon glyphicon-arrow-right','/pages/back/admin/admin/AdminFrontServlet/insertPre');
INSERT INTO action(gid, title, icon, url) VALUES (2,'职员列表','glyphicon glyphicon-arrow-right','/pages/back/admin/admin/AdminFrontServlet/list');
INSERT INTO action(gid, title, icon, url) VALUES (2,'文档审核','glyphicon glyphicon-arrow-right','/pages/back/admin/document/DocumentBackServlet/list');

INSERT INTO action(gid, title, icon, url) VALUES (3,'增加文档','glyphicon glyphicon-arrow-right','/pages/back/admin/document/DocumentBackServlet/insertPre');
INSERT INTO action(gid, title, icon, url) VALUES (3,'文档列表','glyphicon glyphicon-arrow-right','/pages/back/admin/document/DocumentBackServlet/listByAll');
INSERT INTO action(gid, title, icon, url) VALUES (3,'查看部门文档','glyphicon glyphicon-arrow-right','/pages/back/admin/document/DocumentBackServlet/listByDid');

-- 5、部门信息
INSERT INTO dept(title, note) VALUES ('开发部','--');
INSERT INTO dept(title, note) VALUES ('财务部','--');
INSERT INTO dept(title, note) VALUES ('人事部','--');

-- 6、用户信息表
-- admin 12345678
INSERT INTO admin(aid, rid, password,lastdate, type, status) VALUES ('admin',1,'75896DE193D77C9D1577931DC4F1790E','2017-12-03',1,1);
INSERT INTO admin(aid, rid, did, password,lastdate, type, status) VALUES ('ylcto01',2,1,'75896DE193D77C9D1577931DC4F1790E','2017-12-01',2,1);
INSERT INTO admin(aid, rid,did, password,lastdate, type, status) VALUES ('ylcto01001',3,1,'75896DE193D77C9D1577931DC4F1790E','2017-12-03',0,1);
INSERT INTO admin(aid, rid, did, password,lastdate, type, status) VALUES ('ylcto02',2,2,'75896DE193D77C9D1577931DC4F1790E','2017-12-01',2,1);
INSERT INTO admin(aid, rid,did, password,lastdate, type, status) VALUES ('ylcto02001',3,2,'75896DE193D77C9D1577931DC4F1790E','2017-12-03',0,1);
INSERT INTO admin(aid, rid, did, password,lastdate, type, status) VALUES ('ylcto03',2,3,'75896DE193D77C9D1577931DC4F1790E','2017-12-01',2,1);
INSERT INTO admin(aid, rid,did, password,lastdate, type, status) VALUES ('ylcto03001',3,3,'75896DE193D77C9D1577931DC4F1790E','2017-12-03',0,1);

-- 提交数据
COMMIT ;

