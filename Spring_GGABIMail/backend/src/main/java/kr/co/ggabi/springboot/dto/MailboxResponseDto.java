package kr.co.ggabi.springboot.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class MailboxResponseDto {
    public String subject;
    public String nickname;
    public String from;
    public String to;
    public Date date;
    public Boolean read;
    public int spamFlag;
    public double danger = -1;

    @Builder
    public MailboxResponseDto(String subject, String nickname, String from, String to,
                              Date date, Boolean read, int spamFlag, double danger){
        this.subject = subject;
        this.nickname = nickname;
        this.from = from;
        this.to = to;
        this.date = date;
        this.read = read;
        this.spamFlag = spamFlag;
        this.danger = danger;
    }
}
