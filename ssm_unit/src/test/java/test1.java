import com.itzbh.config.SpringConfig;
import com.itzbh.domain.Brand;
import com.itzbh.service.BrandService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class test1 {
    @Autowired
    private BrandService brandService;

    @Test
    public void testgetbyid(){
        Brand brand= brandService.selectbyid(19);
        System.out.println(brand);
    }
}
