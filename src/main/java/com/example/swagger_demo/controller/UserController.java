// UserController.java
package com.example.swagger_demo.controller;

import com.example.swagger_demo.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/join")
    @Operation(
        summary = "회원가입",
        description = "사용자 회원가입 API",
        requestBody = @RequestBody(
            description = "회원가입 요청 데이터",
            required = true,
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = UserDto.class),
                examples = @ExampleObject(
                    name = "회원가입 예제",
                    summary = "회원가입 요청 샘플",
                    value = """
                    {
                      "common": {
                        "name": "홍길동",
                        "age": 30
                      },
                      "detail": {
                        "email": "hong@example.com",
                        "job": "개발자"
                      }
                    }
                    """
                )
            )
        )
    )
    public ResponseEntity<String> joinUser(@RequestBody UserDto userDto) {
        // 실제 가입 처리 로직은 생략
        return ResponseEntity.ok("가입 완료");
    }
}
