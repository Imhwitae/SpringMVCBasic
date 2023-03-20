package hello.springmvc.basic.requestmapping;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping/users")
public class MappingClassController {
    /*
        회원 목록 조회: GET       /users
        회원 등록: POST         /users
        회원 조회: GET          /users/{userId}
        회원 수정: PATCH        /users/{userId}
        회원 삭제: DELETE       /users/{userId}
     */

    @GetMapping
    public String user() {
        return "Get Users";
    }

    @PostMapping
    public String addUser() {
        return "Post User";
    }

    @GetMapping("{userId}")
    public String findUser(@PathVariable String userId) {
        return "Get User ID = " + userId;
    }

    @PatchMapping("{userId}")
    public String updateUser(@PathVariable String userId) {
        return "Patch User ID = " + userId;
    }

    @DeleteMapping("{userId}")
    public String deleteUser(@PathVariable String userId) {
        return "Delete User ID = " + userId;
    }
}
