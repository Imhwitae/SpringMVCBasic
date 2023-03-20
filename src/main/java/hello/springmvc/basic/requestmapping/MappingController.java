package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping({"/hello-basic", "/hello-go"})  // 배열로 여러 개 가능
    public String helloBasic() {
        log.info("helloBasic");
        return "OK";
    }

    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1() {
        log.info("helloBasic");
        return "OK";
    }


    @GetMapping(value = "mapping-get-v2")
    public String mappingGetV2() {
        log.info("helloBasic");
        return "OK";
    }

    @GetMapping("/mapping/{userId}")
//  변수 명을 맞추고 싶다면
//  (@PathVariavle String userId)로 해도 된다.
    public String mappingPath(@PathVariable("userId") String data) {
        log.info("mappingPath userId = {}", data);
        return "OK";
    }

//   PathVariavle 다중 사용
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPathMulti(@PathVariable String userId, @PathVariable Long orderId) {
        log.info("userId = {}, orderId = {}", userId, orderId);
        return "OK";
    }

/*
    파라미터로 추가 매핑
    params="mode"
    params="!mode"
    params="mode=debug"
    params="mode!=debug"
    params={"mode=debug", "data=good"}
 */
//    특정 파라미터 정보가 있어야만 호출
    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam() {
        log.info("MappingParam");
        return "OK";
    }

    /*
        특정 헤더로 추가 매핑
        headers="mode"
        headers="!mode"
        headers="mode=debug"
        headers="mode!=debug"
     */
    @GetMapping(value = "/mapping-header", params = "mode=debug")
    public String mappingHeader() {
        log.info("MappingHeader");
        return "OK";
    }

    /*
       Content-Type 헤더 기반 추가 매핑 Media Type
       consumes="application/json"
       consumes="!application/json"
       consumes="application/*"
       consumes="*\/*"
       MediaType.APPLICATION_JSON_VALUE
    */
//    consumes: 내가 소비하는 것. 요청의 컨텐트 타입 정보를 소비함
    @PostMapping(value = "/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE)  // consumes = "application/json"
    public String mappingConsumes() {
        log.info("MappingConsumes");
        return "OK";
    }

    /*
       Accept 헤더 기반 Media Type
       produces="text/html"
       produces="!text/html"
       produces="text/*"
       produces="*\/*"
    */
//    Accept: 어떠한 미디어 타입을 받아 들일 수 있다는 클라이언트 요청 정보
//    produces: 생산해내는 것
    @PostMapping(value = "/mapping-produce", produces = MediaType.TEXT_HTML_VALUE)  // produces = "text/html"
    public String mappingProduces() {
        log.info("MappingProduces");
        return "OK";
    }
}
