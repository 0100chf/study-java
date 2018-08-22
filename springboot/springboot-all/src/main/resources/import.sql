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