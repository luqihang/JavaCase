package code.luqh.soap;

import com.woniu.sncp.webservice.usercenter.query.QueryImprestInfoByDate;
import com.woniu.sncp.webservice.usercenter.query.QueryWebService;
import com.woniu.sncp.webservice.usercenter.query.QueryWebServicePortType;

/**
 * @author luqh
 * @date 2019/12/30
 **/
public class Test {

    public static void main(String[] args) {
//        QueryImprestInfoByDate query = new QueryImprestInfoByDate();

        QueryWebService webService = new QueryWebService();
        QueryWebServicePortType webServiceHttpPort = webService.getQueryWebServiceHttpPort();

    }
}
