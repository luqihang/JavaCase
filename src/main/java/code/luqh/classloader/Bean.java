package code.luqh.classloader;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Helper;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.util.HashMap;

/**
 * @author luqh
 * @date 2019/11/01
 **/



@Setter
@Getter
@Builder
public class Bean {

    private String field;

    private String value1;

    public void test() {
        val map = new HashMap<Integer, String>();
        System.out.println(map);
    }

}
