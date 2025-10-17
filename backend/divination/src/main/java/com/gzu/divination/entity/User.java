package com.gzu.divination.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * 用户实体类
 */
@Data
public class User {

    private Long id;                          // 主键ID
    private String username;                  // 登录用户名
    private String phone;                     // 脱敏手机号
    private String email;                     // 邮箱
    private String passwordHash;              // bcrypt 加密的密码哈希
    private String realName;                  // 真实姓名
    private Byte gender;                      // 性别（0-未知，1-男，2-女）
    private LocalDate birthday;               // 出生日期
    private LocalTime birthTime;              // 出生时辰
    private String birthPlace;                // 出生地点
    private String constellation;             // 星座
    private BigDecimal height;                // 身高（cm）
    private BigDecimal weight;                // 体重（kg）
    private String avatarUrl;                 // 头像 URL
    private Byte userStatus;                  // 用户状态（0-禁用，1-正常，2-冻结）
    private Byte privacyLevel;                // 隐私等级（1-公开，2-仅自己可见，3-部分可见）
    private LocalDateTime lastAiCallTime;     // AI Agent 最后服务时间
    private LocalDateTime createdAt;          // 创建时间
    private LocalDateTime updatedAt;          // 更新时间
}
