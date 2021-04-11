package com.cbrl.spring.cloud.domain.user;

import lombok.Builder;
import lombok.Data;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class UserServiceApplicationTests {

    @Test
    void contextLoads() {
        List<Dto> dtos = Arrays.asList(Dto.builder().no(1L).name("aaa").build(),
                Dto.builder().no(4L).name("bbbb").build(),
                Dto.builder().no(77L).name("ccc").build(),
                Dto.builder().no(22L).name("ddd").build(),
                Dto.builder().no(2L).name("eeee").build());

        LinkedHashMap<Long, Dto> collect = dtos.stream().collect(Collectors.toMap(Dto::getNo, Function.identity(), (e1, e2) -> e2, LinkedHashMap::new));
        System.out.println(collect);

        Map<Long, Dto> hashm = dtos.stream().collect(Collectors.toMap(Dto::getNo, Function.identity()));
        System.out.println(hashm);
    }


}

@Data
@Builder
class Dto {
    private String name;
    private Long no;

}