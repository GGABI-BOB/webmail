package kr.co.ggabi.springboot.domain.mail;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MailAttachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String sender;

    @Column(nullable = false)
    int webMailPrimaryId;

    // @ElementCollection(fetch = FetchType.LAZY)
    // List<MultipartFile> attach = new ArrayList<>();

    @Column
    String password;

    public MailAttachment(String sender, int webMailPrimaryId, String password) {
        this.sender = sender;
        this.webMailPrimaryId = webMailPrimaryId;
        this.password = password;
    }

}
