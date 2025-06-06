// UserDetailDto.java
package com.example.swagger_demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "사용자 개별 정보 DTO")
public class UserDetailDto {

    @Schema(description = "사용자 이메일", example = "hong@example.com")
    private String email;

    @Schema(description = "사용자 직업", example = "개발자")
    private String job;
}
