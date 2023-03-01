-- auto Generated on 2023-02-28
-- DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`
(
    create_at DATETIME     NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT '创建时间',
    update_at DATETIME     NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT '更新时间',
    version   INT(11)      NOT NULL DEFAULT 1 COMMENT '数据版本，乐观锁使用',
    id        INT(11)      NOT NULL AUTO_INCREMENT COMMENT '角色编码',
    title     VARCHAR(50)  NOT NULL DEFAULT '' COMMENT '角色名称',
    remark    VARCHAR(255) NOT NULL DEFAULT '' COMMENT '备注',
    deleted   INT(11)      NOT NULL DEFAULT 0 COMMENT '是否删除（用于逻辑删除使用）',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT '角色表';
-- auto Generated on 2023-02-28
-- DROP TABLE IF EXISTS role_menu;
CREATE TABLE role_menu
(
    create_at DATETIME   NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT '创建时间',
    update_at DATETIME   NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT '更新时间',
    version   INT(11)    NOT NULL DEFAULT 1 COMMENT '数据版本，乐观锁使用',
    id        BIGINT(15) NOT NULL AUTO_INCREMENT COMMENT '自动生成的自增编号',
    role_id   INT(11)    NOT NULL DEFAULT -1 COMMENT '角色编码',
    menu_id   INT(11)    NOT NULL DEFAULT -1 COMMENT '用户ID',
    deleted   INT(11)    NOT NULL DEFAULT -1 COMMENT '是否删除（用于逻辑删除插件过滤掉已被逻辑删除的数据）',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT '角色-权限表';
-- auto Generated on 2023-02-28
-- DROP TABLE IF EXISTS role_user;
CREATE TABLE role_user
(
    create_at DATETIME   NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT '创建时间',
    update_at DATETIME   NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT '更新时间',
    version   INT(11)    NOT NULL DEFAULT -1 COMMENT '数据版本，乐观锁使用',
    id        BIGINT(15) NOT NULL AUTO_INCREMENT COMMENT '自动生成的自增长编号',
    user_i_d  BIGINT(15) NOT NULL DEFAULT -1 COMMENT '用户Id',
    role_id   INT(11)    NOT NULL DEFAULT -1 COMMENT '角色Id',
    deleted   INT(11)    NOT NULL DEFAULT -1 COMMENT '是否删除（用于逻辑删除过滤已被逻辑删除的数据',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT '角色-用户表';
