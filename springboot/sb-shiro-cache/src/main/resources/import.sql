

DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE
    sys_role
    (
        id INT NOT NULL AUTO_INCREMENT,
        available bit,
        description VARCHAR(255),
        role VARCHAR(255),
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8;
   
 DROP TABLE IF EXISTS `user_info`;
CREATE TABLE
    user_info
    (
        uid VARCHAR(30) NOT NULL,
        name VARCHAR(255),
        password VARCHAR(255),
        salt VARCHAR(255),
        state TINYINT NOT NULL,
        username VARCHAR(255),
        PRIMARY KEY (uid),
        CONSTRAINT UK_f2ksd6h8hsjtd57ipfq9myr64 UNIQUE (username)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8;
     
 DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE
    sys_permission
    (
        id INT NOT NULL AUTO_INCREMENT,
        available bit,
        name VARCHAR(255),
        parent_id bigint,
        parent_ids VARCHAR(255),
        permission VARCHAR(255),
        resource_type enum('menu','button'),
        url VARCHAR(255),
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8;
    
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE
    sys_role_permission
    (
        permission_id INT NOT NULL,
        role_id INT NOT NULL
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8;
 DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE
    sys_user_role
    (
        role_id INT NOT NULL,
        uid INT NOT NULL
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8;
    
 INSERT INTO `user_info` (`uid`,`username`,`name`,`password`,`salt`,`state`) VALUES ('1', 'admin', '管理员', 'd3c59d25033dbf980d29554025c23a75', '8d78869f470951332959580424d4bf4f', 0);
  INSERT INTO `user_info` (`uid`,`username`,`name`,`password`,`salt`,`state`) VALUES ('2', 'vip', 'vip用户', 'd3c59d25033dbf980d29554025c23a75', '8d78869f470951332959580424d4bf4f', 0);
INSERT INTO `sys_permission` (`id`,`available`,`name`,`parent_id`,`parent_ids`,`permission`,`resource_type`,`url`) VALUES (1,0,'用户管理',0,'0/','userInfo:view','menu','userInfo/userList');
INSERT INTO `sys_permission` (`id`,`available`,`name`,`parent_id`,`parent_ids`,`permission`,`resource_type`,`url`) VALUES (2,0,'用户添加',1,'0/1','userInfo:add','button','userInfo/userAdd');
INSERT INTO `sys_permission` (`id`,`available`,`name`,`parent_id`,`parent_ids`,`permission`,`resource_type`,`url`) VALUES (3,0,'用户删除',1,'0/1','userInfo:del','button','userInfo/userDel');
INSERT INTO `sys_role` (`id`,`available`,`description`,`role`) VALUES (1,0,'管理员','admin');
INSERT INTO `sys_role` (`id`,`available`,`description`,`role`) VALUES (2,0,'VIP会员','vip');
INSERT INTO `sys_role` (`id`,`available`,`description`,`role`) VALUES (3,1,'test','test');
INSERT INTO `sys_role_permission` (`permission_id`,`role_id`) VALUES (1,1);
INSERT INTO `sys_role_permission` (`permission_id`,`role_id`) VALUES (2,1);
INSERT INTO `sys_role_permission` (`permission_id`,`role_id`) VALUES (3,2);
INSERT INTO `sys_user_role` (`role_id`,`uid`) VALUES (1,1);
INSERT INTO `sys_user_role` (`role_id`,`uid`) VALUES (2,2);
    
    