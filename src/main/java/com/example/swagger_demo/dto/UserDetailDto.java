// UserDetailDto.java
package com.example.swagger_demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(
    description = "사용자 개별 정보 DTO",
    example = """
         { 
            "email": "UserDetailDto@example.com",
            "job": "UserDetailDto개발자"    
        }
    """
)
public class UserDetailDto {

    private String email;

    private String job;
}
