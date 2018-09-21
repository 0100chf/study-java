DROP TABLE IF EXISTS `jdbctemplate_user`;
CREATE TABLE JDBCTEMPLATE_USER
    (
        id INT NOT NULL AUTO_INCREMENT,
        age INT NOT NULL,
        name VARCHAR(255) NOT NULL,
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8;
    
DROP TABLE IF EXISTS `jpa_user`;
CREATE TABLE JPA_USER
    (
        id INT NOT NULL AUTO_INCREMENT,
        age INT NOT NULL,
        name VARCHAR(255) NOT NULL,
        deleted BIT NOT NULL DEFAULT 0 ,
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8;
    
 DROP TABLE IF EXISTS `mybatis_role`;
 CREATE TABLE `mybatis_role` (
                 `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
                 `role_name` varchar(50) DEFAULT NULL COMMENT '角色名',
                 `enabled` int(11) DEFAULT NULL COMMENT '有效标志',
                 `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
                 `create_time` datetime DEFAULT NULL COMMENT '创建时间',
        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='角色表';
 
INSERT INTO `mybatis_role` VALUES ('1', '管理员', '1', '1', '2016-04-01 17:02:14');
INSERT INTO `mybatis_role` VALUES ('2', '普通用户', '1', '1', '2016-04-01 17:02:34');

DROP TABLE IF EXISTS `mybatis_user`;
CREATE TABLE mybatis_user
    (
        id INT NOT NULL AUTO_INCREMENT,
        age INT NOT NULL,
        name VARCHAR(255) NOT NULL,
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8;
    
INSERT INTO `mybatis_user` VALUES ('1',20, 'admin');
INSERT INTO `mybatis_user` VALUES ('1001',30, 'test');

DROP TABLE IF EXISTS `mybatis_user_role`;
CREATE TABLE `mybatis_user_role` (
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色关联表';

INSERT INTO `mybatis_user_role` VALUES ('1', '1');
INSERT INTO `mybatis_user_role` VALUES ('1', '2');
INSERT INTO `mybatis_user_role` VALUES ('1001', '2');

DROP TABLE IF EXISTS `mybatis_page`;
CREATE TABLE mybatis_page
    (
        id INT NOT NULL AUTO_INCREMENT,
        name VARCHAR(255) NOT NULL,
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8;
    
 INSERT INTO `mybatis_page`(name) VALUES ( 'aa');
 INSERT INTO `mybatis_page`(name) VALUES ( 'bb');
 INSERT INTO `mybatis_page`(name) VALUES ( 'cc');
 INSERT INTO `mybatis_page`(name) VALUES ( 'dd');
 INSERT INTO `mybatis_page`(name) VALUES ( 'ee');
 INSERT INTO `mybatis_page`(name) VALUES ( 'ff');
 INSERT INTO `mybatis_page`(name) VALUES ( 'gg');
 INSERT INTO `mybatis_page`(name) VALUES ( 'hh');
 INSERT INTO `mybatis_page`(name) VALUES ( 'ii');
 INSERT INTO `mybatis_page`(name) VALUES ( 'jj');
 INSERT INTO `mybatis_page`(name) VALUES ( 'kk');
 INSERT INTO `mybatis_page`(name) VALUES ( 'll');
 INSERT INTO `mybatis_page`(name) VALUES ( 'mm');
 INSERT INTO `mybatis_page`(name) VALUES ( 'nn');
 
 DROP TABLE IF EXISTS `MapperCountry`;
 CREATE TABLE `MapperCountry` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `countryname` varchar(255) DEFAULT NULL COMMENT '名称',
  `countrycode` varchar(255) DEFAULT NULL COMMENT '代码',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=10011 DEFAULT CHARSET=utf8 COMMENT='国家信息';

insert into `MapperCountry` (countryname,countrycode) values('中国','001');
insert into `MapperCountry` (countryname,countrycode) values('美国','002');
insert into `MapperCountry` (countryname,countrycode) values('法国','003');
insert into `MapperCountry` (countryname,countrycode) values('德国','004');
insert into `MapperCountry` (countryname,countrycode) values('英国','005');
insert into `MapperCountry` (countryname,countrycode) values('俄国','006');
insert into `MapperCountry` (countryname,countrycode) values('泰国','007');

DROP TABLE IF EXISTS `genid_user`;
create table genid_user (
  id   varchar(64) NOT NULL PRIMARY KEY,
  name varchar(32),
  code VARCHAR(32)
);

 DROP TABLE IF EXISTS `genid_user2`;
create table genid_user2 (
  id   bigint NOT NULL PRIMARY KEY,
  name varchar(32),
  code VARCHAR(32)
);

 DROP TABLE IF EXISTS `page_ext_order`;
 create table page_ext_order (
  po_id   varchar(32)  NOT NULL PRIMARY KEY
 );
 
  DROP TABLE IF EXISTS `page_ext_order_info`;
 create table page_ext_order_info (
  oi_id   varchar(32)  NOT NULL PRIMARY KEY,
  po_id   varchar(32)  ,
  info text
 );
 
 insert into page_ext_order values('po1');
 insert into page_ext_order values('po2');
 insert into page_ext_order values('po3');
 
 insert into page_ext_order_info(oi_id,po_id,info) values('oid1','po1','txt1');
 insert into page_ext_order_info(oi_id,po_id,info) values('oid2','po1','txt2');
 insert into page_ext_order_info(oi_id,po_id,info) values('oid3','po1','txt3');
 insert into page_ext_order_info(oi_id,po_id,info) values('oid4','po1','txt4');
 insert into page_ext_order_info(oi_id,po_id,info) values('oid5','po1','txt5'); 
 insert into page_ext_order_info(oi_id,po_id,info) values('oid6','po1','txt6');
 insert into page_ext_order_info(oi_id,po_id,info) values('oid7','po1','txt7');
 insert into page_ext_order_info(oi_id,po_id,info) values('oid8','po1','txt8');
 insert into page_ext_order_info(oi_id,po_id,info) values('oid9','po1','txt9');
 insert into page_ext_order_info(oi_id,po_id,info) values('oid10','po1','txt10'); 
 insert into page_ext_order_info(oi_id,po_id,info) values('oid11','po1','txt11');
 insert into page_ext_order_info(oi_id,po_id,info) values('oid12','po2','txt12');
 insert into page_ext_order_info(oi_id,po_id,info) values('oid13','po2','txt13');
 insert into page_ext_order_info(oi_id,po_id,info) values('oid14','po2','txt14');
 insert into page_ext_order_info(oi_id,po_id,info) values('oid15','po2','txt15'); 
 insert into page_ext_order_info(oi_id,po_id,info) values('oid16','po2','txt16');
 insert into page_ext_order_info(oi_id,po_id,info) values('oid17','po2','txt17');
 insert into page_ext_order_info(oi_id,po_id,info) values('oid18','po2','txt18');
 insert into page_ext_order_info(oi_id,po_id,info) values('oid19','po2','txt19');
 insert into page_ext_order_info(oi_id,po_id,info) values('oid20','po2','txt20'); 
 insert into page_ext_order_info(oi_id,po_id,info) values('oid21','po2','txt21');
 insert into page_ext_order_info(oi_id,po_id,info) values('oid22','po2','txt22');
 insert into page_ext_order_info(oi_id,po_id,info) values('oid23','po3','txt23');
 insert into page_ext_order_info(oi_id,po_id,info) values('oid24','po3','txt24');
 insert into page_ext_order_info(oi_id,po_id,info) values('oid25','po3','txt25'); 
 insert into page_ext_order_info(oi_id,po_id,info) values('oid26','po3','txt26');
 insert into page_ext_order_info(oi_id,po_id,info) values('oid27','po3','txt27');
 insert into page_ext_order_info(oi_id,po_id,info) values('oid28','po3','txt28');
 insert into page_ext_order_info(oi_id,po_id,info) values('oid29','po3','txt29');
 insert into page_ext_order_info(oi_id,po_id,info) values('oid30','po3','txt30'); 
 
 
