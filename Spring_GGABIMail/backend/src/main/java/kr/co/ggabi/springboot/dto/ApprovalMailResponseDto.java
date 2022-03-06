package kr.co.ggabi.springboot.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Getter
@NoArgsConstructor
public class ApprovalMailResponseDto {
    public String subject;
    public String nickname;
    public String from;
    public List<String> to;
    public List<String> cc;
    public Date date;
    public String contentType;
    public String content;
    public Map<String, AttachmentResponseDto> file;
    public int flag;
    public boolean dangerURL = false;
    public boolean haveToApproval;
    public Boolean isAcceptApproval;
    public List<AcceptMemberDto> acceptMember;

}
