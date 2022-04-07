package com.mctlhg.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IndexControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void load_MainHTMLpage(){
        //when
        String body=this.restTemplate.getForObject("/", String.class);

        // 아래를 확인하면 잘 가져온다.
        //System.out.println("****************************************************************");
        //System.out.println(body);
        //System.out.println("****************************************************************");

        //then
        // contains() 함수에서 오류가 나는 거 같다.
        // 갑자기 잘 되네... 아무래도 글자의 encoding 형태로 문제가 생긴 거 같다.
        assertThat(body).contains("스프링부트로 시작하는 웹서비스");
    }

}
