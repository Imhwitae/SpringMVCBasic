package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j  // private final Logger log = LoggerFactory.getLogger(getClass()); 를 자동으로 넣어줌(Lombok)
@RestController  // return 값이 http body에 그대로 반환된다. RestAPI 제작시 활용
public class LogTestController {

//    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        System.out.println("name = " + name);

//      아래처럼 해도 로그 출력은 되지만 이렇게 하면 안된다. 현재 로그 레벨이 debug부터라 trace는 보이지 않지만 아래 메서드를 이용하면 어떻게 될까?
//      자바가 동작할 때 아래 메서드를 실행하기 전에 + 연산을 먼저 실행한다. 이 연산을 실행하면서 해당 메서드는 log.trace("trace myLog = Spring"); 인 상태가 된다.
//      이 상태로 실행하면 trace 로그는 표시되지 않는데 + 연산이 일어나면서 쓸모없는 리소스를 사용하게 된다.
//      따라서 파라미터를 넘기는 방식인 log.trace("trace log = {}", name); 이 방식을 사용해야 한다.
        log.trace("trace myLog = " + name);

        // 로그가 출력되는 포맷
        // 시간, 로그 레벨, 프로세스 ID, 쓰레드 명, 클래스명, 로그 메시지
        // 로그 레벨: Trace > Debug > Info > Warn > Error
        // 개발 서버는 debug 출력, 운영 서버는 info 출력
        log.trace("trace log = {}", name);  //
        log.debug("debug log = {}", name);  // debug 할 때 보는 로그(개발 서버에서 보는 로그)
        log.info("info log = {}", name);  // 중요한 정보
        log.warn("warn log = {}", name);  // 경고
        log.error("error log = {}", name);  // 에러

        return "ok";
    }
}
