package com.harigroup.hypermarket.mail;

import org.thymeleaf.context.Context;

import com.harigroup.hypermarket.pojo.Mail;

/**
 * 邮件发送接口
 * 此处仅存在账户激活邮件发送方法，需要其他方法后续进行添加
 *
 * @author Yue Wu
 * @since 2020/10/9
 */
public interface MailService {

    Mail prepareMail(Context context, String sendTo);

    /**
     * 发送激活邮件验证
     *
     * @param mail 发送邮件需要的基本参数，具体参照Mail定义
     */
    void sendActiveMail(Mail mail);
}
