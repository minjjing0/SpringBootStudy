package minjjing.springboot.blog_study.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserRequest {
    public String email;
    public String password;
}
