package com.example.swagger_demo.controller;

import com.example.swagger_demo.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/join")
    @Operation(
        summary = "회원가입 API",
        description = "사용자가 회원가입을 위해 필요한 정보를 입력하여 가입하는 API입니다.",
        requestBody = @RequestBody(
            description = "회원가입 요청 데이터(JSON 형식)",
            required = true,
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = UserDto.class),
                examples = {
                    @ExampleObject(
                        name = "기본 정보 예제",
                        summary = "이름과 나이만 포함된 간단한 회원가입 정보",
                        value = """
                            {
                              "common": {
                                "name": "홍길동",
                                "age": 30
                              }
                            }
                            """
                    ),
                    @ExampleObject(
                        name = "상세 정보 예제",
                        summary = "기본 정보에 이메일, 직업 등 상세 정보가 포함된 예제",
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
                }
            )
        )
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "회원가입 성공 시 반환되는 사용자 정보",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = UserDto.class),
                examples = @ExampleObject(
                    name = "회원가입 성공 예제",
                    summary = "가입 완료 후 반환되는 사용자 데이터 예시",
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
    })
    public ResponseEntity<UserDto> joinUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/login")
    @Operation(
        summary = "사용자 로그인 API",
        description = "사용자가 로그인할 때 아이디, 비밀번호 등 정보를 전달하는 API입니다."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "로그인 성공 시 사용자 정보를 반환합니다.",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = UserDto.class)
            )
        )
    })
    public ResponseEntity<UserDto> loginUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userDto);
    }
}
