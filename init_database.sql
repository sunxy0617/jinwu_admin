create table if not exists jw_user_identify
(
	id int auto_increment
		primary key,
	user_id varchar(50) not null comment '用户自己设计的id，不许重复',
	password varchar(100) not null comment '加密后的密码',
	create_time datetime default CURRENT_TIMESTAMP not null,
	update_time datetime default CURRENT_TIMESTAMP not null,
	constraint jw_user_identify_user_id_uindex
		unique (user_id)
)
charset=utf8mb4
comment '用户登录校验';

create table if not exists jw_user_info
(
	id int unsigned auto_increment
		primary key,
	user_id varchar(24) not null comment '用户名，唯一',
	nickname varchar(24) null comment '用户昵称',
	avatar varchar(500) null comment '头像url',
	email varchar(100) null comment '邮箱',
	create_time datetime(3) default CURRENT_TIMESTAMP(3) not null,
	update_time datetime(3) default CURRENT_TIMESTAMP(3) not null on update CURRENT_TIMESTAMP(3),
	delete_time datetime(3) null,
	constraint email_del
		unique (email, delete_time),
	constraint jw_user_info_user_id_uindex
		unique (user_id),
	constraint username_del
		unique (user_id, delete_time)
)
charset=utf8mb4;

