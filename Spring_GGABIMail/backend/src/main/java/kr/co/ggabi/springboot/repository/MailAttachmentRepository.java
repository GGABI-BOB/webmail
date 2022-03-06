package kr.co.ggabi.springboot.repository;

import kr.co.ggabi.springboot.domain.mail.MailAttachment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MailAttachmentRepository extends JpaRepository<MailAttachment, Long> {

    MailAttachment findBySenderAndWebMailPrimaryId(String sender, int webMailPrimaryId);

}