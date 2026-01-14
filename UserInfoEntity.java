package com.softsafe.sast.platform.domain.user.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.softsafe.sast.platform.domain.model.DeleteBaseEntity;
import com.softsafe.sast.platform.domain.model.enums.OauthSource;
import com.softsafe.sast.platform.domain.model.enums.RoleEnum;
import lombok.*;

import java.io.Serializable;

/**
 * 用户信息表实体类
 * 对应表名：user_info
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("user_info")
public class UserInfoEntity extends DeleteBaseEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 主键 ID
     * 对应 SQL: id bigserial primary key
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 系统登录名 (GitHub Login 或 内部账号)
     * 唯一索引
     */
    private String username;

    /**
     * 密码 hash (OAuth用户此字段为 NULL)
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 显示昵称 (OAuth display name)
     */
    private String nickname;

    /**
     * 头像链接
     * 对应 SQL: avatar_url
     */
    private String avatarUrl;

    /**
     * 角色: ROLE_USER, ROLE_ADMIN
     * 默认值建议在数据库层面处理，或在 Service 层初始化
     */
    private RoleEnum role;

    /**
     * 账户是否启用
     * 对应 SQL: enabled boolean default true
     */
    private Boolean enabled;

    /**
     * 来源: 'GITHUB', 'INTERNAL', 'GOOGLE'
     * 对应 SQL: oauth_source
     */
    private OauthSource oauthSource;

    /**
     * 第三方平台的唯一ID (如 GitHub id)
     * 对应 SQL: oauth_id
     */
    private String oauthId;

    /**
     * 仓库源配置 ID
     */
    private Long repoSourceConfigId;

}