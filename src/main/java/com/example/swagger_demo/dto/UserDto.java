// UserDto.java
package com.example.swagger_demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "사용자 전체 정보 DTO")
public class UserDto {

    @Schema(description = "공통 사용자 정보")
    private CommonDto common;

    @Schema(description = "개별 사용자 정보")
    private UserDetailDto detail;
}
